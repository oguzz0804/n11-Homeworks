package com.oguzhanotles.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherRequest {

    @NotEmpty(message = "City name can't be empty!!!")
    private String city;
}
