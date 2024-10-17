package com.itschool.rest_services.controllers;

import com.itschool.rest_services.models.WeatherInfo;
import com.itschool.rest_services.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WheatherController {

    @Autowired
    private WeatherService service;


    @GetMapping
    public ResponseEntity<WeatherInfo> getWeather(@RequestParam String city) throws IOException {
        WeatherInfo weather = service.getWeatherForCity(city);
        return ResponseEntity.ok(weather);
    }

}
