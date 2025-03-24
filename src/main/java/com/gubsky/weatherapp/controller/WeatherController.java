package com.gubsky.weatherapp.controller;

import com.gubsky.weatherapp.model.WeatherResponse;
import com.gubsky.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String getWeather(@RequestParam(name = "city", defaultValue = "Краснодар") String city, Model model) {
        WeatherResponse weatherResponse = weatherService.getWeather(city);
        model.addAttribute("city", city);
        model.addAttribute("temperature", weatherResponse.getTemperature());
        model.addAttribute("condition", weatherResponse.getCondition());
        model.addAttribute("windSpeed", weatherResponse.getWindSpeed());
        return "weather";
    }
}
