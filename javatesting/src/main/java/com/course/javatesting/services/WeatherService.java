package com.course.javatesting.services;

import com.course.javatesting.models.Weather;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    public Weather getWeather() {
        Weather weather = new Weather();
        weather.setStatus("Sunny");
        weather.setMinTem(20);
        weather.setMaxTem(30);

        return weather;
    }
}
