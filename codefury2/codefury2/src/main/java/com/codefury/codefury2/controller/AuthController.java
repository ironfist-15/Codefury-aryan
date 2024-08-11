package com.codefury.codefury2.controller;

import org.springframework.context.annotation.Bean;


import com.codefury.codefury2.Location;
import com.codefury.codefury2.Repositories.UserRepository;
import com.codefury.codefury2.UserDto;
import com.codefury.codefury2.dbkelsa.User;
import com.codefury.codefury2.service.UserService;
import com.codefury.codefury2.service.WeatherNotificationService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private WeatherNotificationService weatherNotificationService;

    @Autowired
    private UserRepository userRepository;


    private Location location;

    // Handler method to handle home page request
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    // Handler method to show user registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // Handler method to handle user registration form submission
    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") UserDto userDto,
                               Model model,
                               RedirectAttributes redirectAttributes) {
        boolean hasErrors = false;

        // Manually perform validation
        if (userDto.getEmail() == null || userDto.getEmail().isEmpty()) {
            model.addAttribute("emailError", "Email should not be empty");
            hasErrors = true;
        } else if (!isValidEmail(userDto.getEmail())) {
            model.addAttribute("emailError", "Email should be valid");
            hasErrors = true;
        }

        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            model.addAttribute("passwordError", "Password should not be empty");
            hasErrors = true;
        }

        // Check if the user already exists
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            model.addAttribute("emailError", "There is already an account registered with the same email");
            hasErrors = true;
        }

        if (hasErrors) {
            return "register"; // Return to the registration page with errors
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    @GetMapping("/users")
    public String users(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // Return your hamburger menu page
    }

    // Handler method to handle login request
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/checkEmail")
    public String checkEmail( Model model) {

        return "checkEmail"; // Return a view to show the email existence status
    }



    @GetMapping("/location")
    public String location() {
        // Return the view name for location page
        return "location";
    }

    @PostMapping("/sendLocation")
    @CrossOrigin // This allows CORS for this endpoint, useful for development
    public ResponseEntity<String> sendLocation(@RequestBody Map<String, Double> location) {
        Double latitude = location.get("latitude");
        Double longitude = location.get("longitude");

        // Process the location data as needed
        System.out.println("Received location - Latitude: " + latitude + ", Longitude: " + longitude);

        return ResponseEntity.ok("Location received");
    }

    /*@PostMapping("/location")
    public ResponseEntity<Location> handleLocation(@RequestBody Location location) {
        System.out.println("Received location: Latitude = " + location.getLatitude() + ", Longitude = " + location.getLongitude());

        // Return the location data as JSON
        return ResponseEntity.ok(location);

    }*/
}



