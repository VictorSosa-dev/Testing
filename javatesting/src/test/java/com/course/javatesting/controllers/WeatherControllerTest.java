package com.course.javatesting.controllers;

import com.course.javatesting.models.Weather;
import com.course.javatesting.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @InjectMocks
    private WeatherController weatherController;

    @Mock
    private WeatherService weatherService;

    @Test
    public void getWeatherTest() {
        Weather weatherMock = new Weather();
        weatherMock.setStatus("Sunny");
        weatherMock.setMinTem(25);
        weatherMock.setMaxTem(32);
        when(weatherService.getWeather()).thenReturn(weatherMock);

        weatherController.getWeather();

        verify(weatherService, times(1)).getWeather();
    }

}
