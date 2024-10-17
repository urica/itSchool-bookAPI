package com.itschool.rest_services.configs;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

    @Bean
    public OkHttpClient httpClient(){
        return new OkHttpClient();
    }
}
