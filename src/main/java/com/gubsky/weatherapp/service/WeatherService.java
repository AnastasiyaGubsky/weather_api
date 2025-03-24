package com.gubsky.weatherapp.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gubsky.weatherapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final WebClient webClient;


    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder
                .baseUrl("https://api.weather.yandex.ru/v2")
                .build();
    }

    public WeatherResponse getWeather(String city) {
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/forecast")
                        .queryParam("lat", "45.0355")
                        .queryParam("lon", "38.9753")
                        .build())
                .header("X-Yandex-Weather-Key", apiKey)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        WeatherResponse weatherResponse = new WeatherResponse();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(response);

            JsonNode fact = root.path("fact");

            double temp = fact.path("temp").asDouble();
            String condition = fact.path("condition").asText();
            double windSpeed = fact.path("windSpeed").asDouble();

            weatherResponse.setTemperature(temp);
            weatherResponse.setCondition(condition);
            weatherResponse.setWindSpeed(windSpeed);
        } catch (Exception e) {
            e.printStackTrace();
            weatherResponse.setTemperature(0.0);
            weatherResponse.setCondition("Ошибка получения данных");
        }
        return weatherResponse;
    }

}