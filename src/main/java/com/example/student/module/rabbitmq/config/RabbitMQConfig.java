package com.example.student.module.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

//    @Value("${rabbitmq.exchange-name}")
//    private String exchange;
//
//  @Value("${rabbitmq.queue-name}")
//    private String queue;
//
//    @Value("${rabbitmq.routing-key-name}")
//    private String routingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.host}")
    private String host;
//    @Bean
//    public Queue queue(){
//    return new Queue("Students");
//}


@Bean
     public  Queue queue(){
        return new Queue("Students",true);

}

//    @Bean
//    public DirectExchange exchange() {
//        return new DirectExchange("StudentsExchange");
//    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("StudentsExchange");
    }
   @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with("StudentsRoutingKey");
    }
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(host);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        return connectionFactory;
    }
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
