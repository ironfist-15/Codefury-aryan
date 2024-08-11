package com.codefury.codefury2.service;

import com.codefury.codefury2.dbkelsa.User;
import com.codefury.codefury2.UserDto; // Import the UserDto class

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto); // Use UserDto directly

    User findUserByEmail(String email);

    List<UserDto> findAllUsers(); // Use UserDto directly
}

