package com.example.student.module.rabbitmq;


//import com.example.student.module.orders.order.Order;
import com.example.student.module.enroll.EnrollDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Autowired
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);


    public void sendMessage(EnrollDto enroll){

        rabbitTemplate.convertAndSend("droppedCourseExchange","droppedCourseKey",enroll);

    }

}

