package com.project.ey.bluepy.services;

import com.project.ey.bluepy.dtos.UserDTO;
import com.project.ey.bluepy.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAllUsers();

    List<UserDTO> findAllUsersFromAPI();

    Optional<User> findUserById(Long id);

    Optional<User> findUserByIdPersona(Long id_persona);

    User saveUser (User user);

}
