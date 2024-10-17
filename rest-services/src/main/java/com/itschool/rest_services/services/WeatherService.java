package com.itschool.rest_services.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itschool.rest_services.models.WeatherInfo;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class WeatherService {
    private final String API_KEY = "0cb587242842479c835202237241610";
    private final String API_URL = "http://api.weatherapi.com/v1/current.json";

    private final OkHttpClient httpClient;

    @Autowired
    public WeatherService(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public WeatherInfo getWeatherForCity(String city) throws IOException {
        HttpUrl url = HttpUrl.parse(API_URL)
                .newBuilder()
                .addQueryParameter("key", API_KEY)
                .addQueryParameter("q", city)
                .build();

        Request request = new Request.Builder().url(url).build();

        Response response = httpClient.newCall(request).execute();

        if (response.isSuccessful()) {
            String jsonResponse = response.body().string();
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime lastUpdate = LocalDateTime.parse(jsonNode.get("current").get("last_updated").asText(), formatter);

            WeatherInfo info = new WeatherInfo();
            info.setLastUpdate(lastUpdate);
            info.setCity(jsonNode.get("location").get("name").asText());
            info.setDescription(jsonNode.get("current").get("condition").get("text").asText());

            return info;
        } else
            System.out.println("Nasol");

        return new WeatherInfo();
    }
}
