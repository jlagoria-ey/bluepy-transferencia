package com.project.ey.bluepy.transfer.controllers;

import com.project.ey.bluepy.transfer.csv.CSVProcessor;
import com.project.ey.bluepy.transfer.entities.User;
import com.project.ey.bluepy.transfer.services.UserService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.ey.bluepy.transfer.dtos.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("users")
    public List<User> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return users;
    }

    @GetMapping("usersFromAPI")
    public List<UserDTO> getAllUsersFromAPI() {

        return userService.findAllUsersFromAPI();
    }

    @GetMapping("users/{id}")
    public Optional<User> getUserById(@PathVariable UUID id) {
        return userService.findUserById(id);
    }

}
