package com.oguzhanotles.controller;

import com.oguzhanotles.model.WeatherInfo;
import com.oguzhanotles.service.WeatherApiService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/forecast")
public class WeatherController {
    private final WeatherApiService weatherApiService;

    public WeatherController(WeatherApiService weatherApiService) {
        this.weatherApiService = weatherApiService;
    }

    @GetMapping("/{city}")
    public List<WeatherInfo> getWeather(@PathVariable String city) {
        return weatherApiService.getWeatherForecast(city);
    }
}
