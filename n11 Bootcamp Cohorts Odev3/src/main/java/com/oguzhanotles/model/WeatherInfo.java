package com.oguzhanotles.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class WeatherInfo {
    private String cityName;
    private double temp;
    private double pressure;
    private int humidity;
    private String weatherDesc; // ex. cloudy
    private LocalDateTime localDateTime;
}
