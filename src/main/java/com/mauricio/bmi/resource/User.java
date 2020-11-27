package com.mauricio.bmi.resource;

import com.mauricio.bmi.constant.Sex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {

    private UUID id;
    private String name;
    private int age;
    private Sex sex;
    private float height;
    private String username;
    private String password;
}
