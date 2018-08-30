package com.puzzlersworld.wp.dto;

public class Customer {
    private BillingAddress billing_address;
    private String email;
    private String first_name;
    private Long id;
    private String last_name;
    private ShippingAddress shipping_address;
    private String username;

    public BillingAddress getBilling_address() {
        return this.billing_address;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public Long getId() {
        return this.id;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public ShippingAddress getShipping_address() {
        return this.shipping_address;
    }

    public String getUsername() {
        return this.username;
    }

    public void setBilling_address(BillingAddress billingAddress) {
        this.billing_address = billingAddress;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFirst_name(String str) {
        this.first_name = str;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setLast_name(String str) {
        this.last_name = str;
    }

    public void setShipping_address(ShippingAddress shippingAddress) {
        this.shipping_address = shippingAddress;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
