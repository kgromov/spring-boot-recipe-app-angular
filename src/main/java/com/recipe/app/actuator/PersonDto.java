package com.recipe.app.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
final class PersonDto {
    private final String id = UUID.randomUUID().toString();
    private String firstName;
    private String lastName;
    private HealthInfo healthInfo;
}
