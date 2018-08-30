package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class CreateOrderRequest implements Serializable {
    Order order;

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
