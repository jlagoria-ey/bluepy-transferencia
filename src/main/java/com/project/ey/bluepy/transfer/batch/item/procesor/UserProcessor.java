package com.project.ey.bluepy.transfer.batch.item.procesor;

import com.project.ey.bluepy.transfer.dtos.UserDTO;
import com.project.ey.bluepy.transfer.entities.User;
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
