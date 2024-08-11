/*package com.codefury.codefury2.controller;


import com.codefury.codefury2.service.WeatherNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/notifications")
public class kanguController {
    @Autowired
    private WeatherNotificationService weatherNotificationService;

    @PostMapping("/sendNow")
    public ResponseEntity<String> sendWeatherNotificationsNow() {
        try {
            weatherNotificationService.sendWeatherNotificationsNow();
            return ResponseEntity.ok("Weather notifications sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending notifications");
        }
    }


}
*/