package com.project.ey.bluepy.transfer.services.impl;

import com.project.ey.bluepy.transfer.dtos.UserDTO;
import com.project.ey.bluepy.transfer.entities.User;
import com.project.ey.bluepy.transfer.repositories.UserRepository;
import com.project.ey.bluepy.transfer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Value("${spring.external.service.base-url}")
    private String basePath;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<UserDTO> findAllUsersFromAPI() {
        UserDTO[] response = restTemplate.getForObject(basePath, UserDTO[].class);

        return Arrays.asList(response);
    }

    @Override
    public Optional<User> findUserById(UUID id) {
        return userRepository.findById(id);
    }


    @Override
    public Optional<User> findUserByIdPersona(Long id_persona) {
        return userRepository.findUserByPersonaNumber(id_persona);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
