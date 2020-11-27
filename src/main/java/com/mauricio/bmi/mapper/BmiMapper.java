package com.mauricio.bmi.mapper;

import com.mauricio.bmi.domain.BmiEntity;
import com.mauricio.bmi.resource.Bmi;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BmiMapper {

    @Mapping(source = "bmiUuid", target = "bmiUuid")
    @Mapping(source = "userUuid", target = "userUuid")
    @Mapping(source = "value", target = "value")
    Bmi toResource(BmiEntity bmiEntity);

    @Mapping(source = "bmiUuid", target = "bmiUuid")
    @Mapping(source = "userUuid", target = "userUuid")
    @Mapping(source = "value", target = "value")
    BmiEntity toEntity(Bmi bmi);
}
