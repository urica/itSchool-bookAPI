package com.itschool.rest_services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo {
    private String city;
    private String description;
    private LocalDateTime lastUpdate;
}
