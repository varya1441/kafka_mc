package com.mac.cashbox.service.impl;

import com.mac.cashbox.entity.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


@Service
@Slf4j
public class Cook {
    private final List<Item> items = new ArrayList<>();

    private static final int maxSmallCounter = 3;
    private static final int minSmallCounter = 0;
    private static int countUsed = 0;

    public synchronized void cookItem(final Item item) {
        try {

            var itemSize = switch (item.getSize()) {
                case S -> 1;
                case M -> 2;
                case L -> 3;
            };

            if (itemSize > maxSmallCounter - countUsed) {
                log.info(countUsed + "> There is no place for a order for cook: " + Thread.currentThread().getName());
                log.info("wait");
                sleep(1000);
            }

            countUsed += itemSize;
            sleep(itemSize * 100);
            log.info("count: {}", countUsed);
            log.info("{} - {}\n", Thread.currentThread().getName(), countUsed);
            item.setDone(true);
            log.info("item" + item);

            items.add(item);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public synchronized List<Item> completeOrders() {
        List<Item> cookedItems = List.copyOf(items);
        items.clear();

        countUsed = 0;
        return cookedItems;
    }


}
