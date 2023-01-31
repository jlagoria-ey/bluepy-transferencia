package com.project.ey.bluepy.transfer.services;

import com.project.ey.bluepy.transfer.dtos.UserDTO;
import com.project.ey.bluepy.transfer.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<User> findAllUsers();

    List<UserDTO> findAllUsersFromAPI();

    Optional<User> findUserById(UUID id);

    Optional<User> findUserByIdPersona(Long id_persona);

    User saveUser (User user);

}
