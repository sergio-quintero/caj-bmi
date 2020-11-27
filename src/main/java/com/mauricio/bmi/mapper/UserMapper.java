package com.mauricio.bmi.mapper;

import com.mauricio.bmi.domain.UserEntity;
import com.mauricio.bmi.resource.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "sex", target = "sex")
    @Mapping(source = "height", target = "height")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    User toResource(UserEntity userEntity);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "sex", target = "sex")
    @Mapping(source = "height", target = "height")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    UserEntity toEntity(User user);
}
