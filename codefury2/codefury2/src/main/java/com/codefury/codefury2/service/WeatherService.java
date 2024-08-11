package com.codefury.codefury2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

    @Service
    public class WeatherService {

        @Value("${weather.api.key}")
        private String apiKey;

        private final RestTemplate restTemplate = new RestTemplate();

        public String getWeather(String city) {
            String url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            return restTemplate.getForObject(url, String.class);
        }
    }


