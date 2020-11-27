package com.mauricio.bmi.service;

import com.mauricio.bmi.domain.UserEntity;
import com.mauricio.bmi.mapper.UserMapper;
import com.mauricio.bmi.repository.UserRepository;
import com.mauricio.bmi.resource.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public List<User> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toResource).collect(Collectors.toList());
    }

    @Transactional
    public User registerUser(User user) {
        log.info("User in: {}", user);
        UserEntity userEntity = userMapper.toEntity(user);
        log.info("UserEntity: {}", userEntity);

        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

        UserEntity createdUser = userRepository.saveAndFlush(userEntity);

        return userMapper.toResource(createdUser);
    }
}
