package com.possessor.plate;

import com.possessor.plate.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${statistics.kafka.topic}")
    String kafkaTopic;

    public void send(Order payload) {
        Message<Order> message = MessageBuilder
                .withPayload(payload)
                .setHeader(KafkaHeaders.TOPIC, kafkaTopic)
                .build();
        kafkaTemplate.send(message);
    }
}
