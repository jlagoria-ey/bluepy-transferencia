package com.project.ey.bluepy.transfer.config;

import com.project.ey.bluepy.transfer.queue.TransferQueueReceiver;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public TransferQueueReceiver receiver() {
        return new TransferQueueReceiver();
    }

}
