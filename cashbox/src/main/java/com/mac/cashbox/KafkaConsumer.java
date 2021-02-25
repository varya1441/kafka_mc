package com.mac.cashbox;

import com.mac.cashbox.entity.Order;
import com.mac.cashbox.service.impl.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    private final OrderService orderService;

    public KafkaConsumer(OrderService orderService) {
        this.orderService = orderService;
    }


    @KafkaListener(topics = "${statistics.kafka.topic.create.entity}", groupId = "statistics-BusinessEntityManagementSystem-group")
    @KafkaHandler
    public void receiveCreatedEntity(@Payload Order data,
                                     @Headers MessageHeaders headers) {
        headers.keySet().forEach(key -> {
            log.info("{}: {}", key, headers.get(key));
        });

        orderService.workWithOrder(data);
    }
}
