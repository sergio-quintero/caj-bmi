package com.mauricio.bmi.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Bmi {
    private UUID bmiUuid;
    private UUID userUuid;
    private double value;
}
