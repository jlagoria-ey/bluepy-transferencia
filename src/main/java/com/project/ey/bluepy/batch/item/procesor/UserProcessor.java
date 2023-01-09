package com.project.ey.bluepy.batch.item.procesor;

import com.project.ey.bluepy.dtos.UserDTO;
import com.project.ey.bluepy.entities.User;
import org.springframework.batch.item.ItemProcessor;

public class UserProcessor implements ItemProcessor<UserDTO, User> {
    @Override
    public User process(UserDTO userDTO) throws Exception {

        return  new User(
                userDTO.getName(),
                userDTO.getLastName(),
                userDTO.getId_persona(),
                userDTO.getActiva()
        );
    }
}
