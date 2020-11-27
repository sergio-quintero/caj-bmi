package com.mauricio.bmi.service;

import com.mauricio.bmi.domain.CustomUserDetails;
import com.mauricio.bmi.domain.UserEntity;
import com.mauricio.bmi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("here");
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserEntity tempUser = new UserEntity();
        BeanUtils.copyProperties(user, tempUser);
        return new CustomUserDetails(tempUser);
    }
}