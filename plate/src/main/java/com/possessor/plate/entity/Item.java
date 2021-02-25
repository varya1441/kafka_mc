package com.possessor.plate.entity;


import lombok.Data;

@Data
public class Item {
    private Double cost;
    private String name;
    private Size size;
    private boolean done = false;
}
