package com.example.student.module.rabbitmq.user;

import com.example.student.module.rabbitmq.publisher.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/api/rabbitmq")
@RequiredArgsConstructor
public class UserController {

    private final RabbitMQProducer rabbitMQProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(User user){
        rabbitMQProducer.sendMessage(user);
        return ResponseEntity.ok("message sent");
    }

}


