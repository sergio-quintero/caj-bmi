package com.mauricio.bmi.service;

import com.mauricio.bmi.domain.BmiEntity;
import com.mauricio.bmi.domain.UserEntity;
import com.mauricio.bmi.mapper.BmiMapper;
import com.mauricio.bmi.repository.BmiRepository;
import com.mauricio.bmi.repository.UserRepository;
import com.mauricio.bmi.resource.Bmi;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BmiService {

    private final BmiRepository bmiRepository;
    private final UserRepository userRepository;
    private final BmiMapper bmiMapper;

    public Bmi getBmiById(String id) throws ChangeSetPersister.NotFoundException {
        BmiEntity bmiEntity = bmiRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        return bmiMapper.toResource(bmiEntity);
    }

    public List<Bmi> getBmisByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return bmiRepository
                .findAllByUserUuid(userEntity.getUserUuid())
                .stream()
                .map(bmiMapper::toResource)
                .collect(Collectors.toList());
    }

    public Bmi addBmi(String username, Bmi bmi) {
        UserEntity userEntity = userRepository.findByUsername(username);
        bmi.setUserUuid(userEntity.getUserUuid());
        BmiEntity bmiEntity = bmiMapper.toEntity(bmi);
        BmiEntity savedEntity = bmiRepository.save(bmiEntity);
        return bmiMapper.toResource(savedEntity);
    }

}
