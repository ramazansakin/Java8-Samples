package com.javainuse.service;

import com.javainuse.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${samplerabbitmq.rabbitmq.exchange}")
    private String exchange;

    @Value("${samplerabbitmq.rabbitmq.routingkey}")
    private String routingkey;

    String mqTopic = "sample_rabbitmq_topic";

    public void send(Employee company) {
        amqpTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);
    }
}