package com.example.student.module.rabbitmq.publisher;

import com.example.student.module.rabbitmq.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Value("${rabbitmq.exchange-name}")
    private String exchange;

    @Value("${rabbitmq.routing-key-name}")
    private String routingKey;

    public void sendMessage(User user){
        LOGGER.info(String.format("message sent -> %s", user.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,user);
    }

}
