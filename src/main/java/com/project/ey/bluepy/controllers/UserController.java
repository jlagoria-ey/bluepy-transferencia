package com.project.ey.bluepy.controllers;

import com.project.ey.bluepy.entities.User;
import com.project.ey.bluepy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.ey.bluepy.dtos.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("usersFromAPI")
    public List<UserDTO> getAllUsersFromAPI() {

        return userService.findAllUsersFromAPI();
    }

    @GetMapping("users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

}
