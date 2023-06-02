package com.course.javatesting.controllers;

import com.course.javatesting.models.Weather;
import com.course.javatesting.services.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private WeatherService weatherService;

    @GetMapping("/weather")
    public Weather getWeather() {
        return weatherService.getWeather();
    }

}
