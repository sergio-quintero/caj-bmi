package com.mauricio.bmi.repository;

import com.mauricio.bmi.domain.BmiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface BmiRepository extends JpaRepository<BmiEntity, String> {

    List<BmiEntity> findAllByUserUuid(UUID userUuid);
}
