package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class CustomerWrapper implements Serializable {
    private Customer customer;

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
