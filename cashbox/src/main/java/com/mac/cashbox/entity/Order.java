package com.mac.cashbox.entity;


import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class Order {
    private Timestamp orderTime;
    private List<Item> items;
    private boolean done;
}

