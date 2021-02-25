package com.mac.cashbox.controller;

import com.mac.cashbox.entity.Order;
import com.mac.cashbox.service.impl.Cook;
import com.mac.cashbox.service.impl.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class OrderController {
    private final OrderService orderService;
    private final Cook cook;

    public OrderController(OrderService orderService, Cook cook) {
        this.orderService = orderService;
        this.cook = cook;
    }

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order) throws ExecutionException, InterruptedException {
        orderService.workWithOrder(order);
        order.setItems(cook.completeOrders());
        return order;
    }
}
