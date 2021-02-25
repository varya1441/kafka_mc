package com.possessor.plate.controller;


import com.possessor.plate.KafkaProducer;
import com.possessor.plate.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final KafkaProducer producer;

    @Autowired
    KafkaController(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody Order message) {
        this.producer.send(message);
    }
}
