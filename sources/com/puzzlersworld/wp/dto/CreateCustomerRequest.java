package com.puzzlersworld.wp.dto;

public class CreateCustomerRequest {
    private Customer customer;
    private String password;

    public Customer getCustomer() {
        return this.customer;
    }

    public String getPassword() {
        return this.password;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPassword(String str) {
        this.password = str;
    }
}
