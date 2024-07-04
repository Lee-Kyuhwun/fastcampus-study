package dev.be.onlinecoffeeorder.domain;


import lombok.Getter;

import java.util.Map;

@Getter
public class CreateOrder {

    private int customerId;
    private Map<Integer, Integer> quantityByProduct; /// ['productId', 'quantity']
}
