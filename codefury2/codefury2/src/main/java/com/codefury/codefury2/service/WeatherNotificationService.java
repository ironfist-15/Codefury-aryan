package com.codefury.codefury2.service;

import com.codefury.codefury2.Repositories.UserRepository;
import com.codefury.codefury2.dbkelsa.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherNotificationService {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    public void sendWeatherNotificationsNow() {
        String city = "Bengaluru";
        String weather = weatherService.getWeather(city);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            emailService.sendEmail(user.getEmail(), "Weather Update", weather);
        }
    }
}
