package com.project.ey.bluepy.transfer.batch.item;

import com.project.ey.bluepy.transfer.entities.User;
import com.project.ey.bluepy.transfer.services.UserService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserWriter implements ItemWriter<User> {

    //private static final Logger LOG = (Logger) LoggerFactory.getLogger(UserWriter.class);


    @Autowired
    UserService userService;

    @Override
    public void write(List<? extends User> list) throws Exception {

        list.forEach(user -> {

            if (!userService.findUserByIdPersona(user.getPersonaNumber()).isPresent()) {
                userService.saveUser(user);
            }
        });

    }
}
