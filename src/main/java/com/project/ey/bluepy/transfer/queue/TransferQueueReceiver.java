package com.project.ey.bluepy.transfer.queue;

import com.project.ey.bluepy.transfer.entities.User;
import com.project.ey.bluepy.transfer.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransferQueueReceiver {

    Logger logger = LoggerFactory.getLogger(TransferQueueReceiver.class);
    @Autowired
    UserService userService;

    @RabbitListener(queues = "${bluepy.queue.name}",autoStartup = "false")
    public void receive(@Payload User user) {
        Optional<User> userFind = userService.findUserByIdPersona(user.getPersonaNumber());

        if(userFind.isPresent()){
            user.setId(userFind.get().getId());
        }
        userService.saveUser(user);

        logger.info("User with persona Number: "+user.getPersonaNumber()+" Saved.");
    }
}
