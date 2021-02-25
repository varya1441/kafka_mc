package com.mac.cashbox.service.impl;

import com.mac.cashbox.entity.Order;

import java.util.concurrent.ExecutionException;

public interface OrderService {
    Order workWithOrder(Order order);
}
