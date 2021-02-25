package com.mac.cashbox.service.impl;

import com.mac.cashbox.entity.Item;
import com.mac.cashbox.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final Cook cook;

    public OrderServiceImpl(Cook cook) {
        this.cook = cook;
    }

    @Override
    public Order workWithOrder(Order order) {
        Order newOrder = new Order();
        newOrder.setOrderTime(order.getOrderTime());


        Runnable task = () -> {
            for (final Item item : order.getItems()) {
                cook.cookItem(item);
            }
        };
        Thread thread = new Thread(task);
        thread.start();


        log.info("activeCount" + Thread.activeCount());
        newOrder.setDone(true);
        return newOrder;


    }
    @FileReader
    public void fileReader(String filename){

    }
}
