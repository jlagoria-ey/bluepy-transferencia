package com.project.ey.bluepy.batch.item;

import com.project.ey.bluepy.batch.listener.JobListener;
import com.project.ey.bluepy.entities.User;
import com.project.ey.bluepy.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.logging.Logger;

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
