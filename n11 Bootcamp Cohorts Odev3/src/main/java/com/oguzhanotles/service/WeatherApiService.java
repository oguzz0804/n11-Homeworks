package com.oguzhanotles.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oguzhanotles.model.WeatherInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherApiService {

    private final ObjectMapper objectMapper;
    private final String API_KEY = "YOUR_API_KEY";

    // units -> metric Celsius / imperial Fahrenheit / default Kelvin
    private final String FORECAST_URL = "https://api.openweathermap.org/data/2.5/forecast?q={city}&units=metric&appid={apiKey}";

    private final RestTemplate restTemplate;

    public WeatherApiService(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    // Call 5 day / 3 hours forecast data
    public List<WeatherInfo> getWeatherForecast(String city) {
        List<WeatherInfo> weatherInfos = new ArrayList<>();

        String url = FORECAST_URL.replace("{city}", city).replace("{apiKey}", API_KEY);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            JsonNode listNode = root.path("list");
            if (listNode.isArray()) {
                for (JsonNode node : listNode) {
                    WeatherInfo weatherInfo = new WeatherInfo();
                    weatherInfo.setCityName(city);
                    weatherInfo.setTemp(node.path("main").path("temp").asDouble());
                    weatherInfo.setPressure(node.path("main").path("pressure").asDouble());
                    weatherInfo.setHumidity(node.path("main").path("humidity").asInt());
                    weatherInfo.setWeatherDesc(node.path("weather").get(0).path("description").asText());
                    String dtTxt = node.path("dt_txt").asText(); // Take dt_txt = 2024-02-28 12:00:00 value as a text
                    LocalDateTime localDateTime = LocalDateTime.parse(dtTxt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // Change the dt_txt value to LocalDateTime
                    weatherInfo.setLocalDateTime(localDateTime);
                    weatherInfos.add(weatherInfo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherInfos;
    }
}
