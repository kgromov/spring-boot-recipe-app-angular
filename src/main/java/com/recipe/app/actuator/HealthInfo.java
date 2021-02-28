package com.recipe.app.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthInfo {
    private double temperature;
    private double pressure;
    private int height;
    private int weight;
}
