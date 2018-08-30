package com.puzzlersworld.wp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {
    private ArrayList<CartItem> cart_items;
    private ArrayList<CouponLine> coupon_lines;
    private Double discount_cart;
    private ArrayList<PaymentGateway> payment_gateways;
    private Map<String, String> shippable_countries;
    private ArrayList<ShippingLine> shipping_lines;
    private Double shipping_tax_total;
    private Double shipping_total;
    private Double subtotal_ex_tax;
    private Double tax_total;

    public ArrayList<CartItem> getCart_items() {
        return this.cart_items;
    }

    public ArrayList<CouponLine> getCoupon_lines() {
        return this.coupon_lines;
    }

    public Double getDiscount_cart() {
        return this.discount_cart;
    }

    public ArrayList<PaymentGateway> getPayment_gateways() {
        return this.payment_gateways;
    }

    public Map<String, String> getShippable_countries() {
        if (this.shippable_countries == null) {
            this.shippable_countries = new HashMap();
        }
        return this.shippable_countries;
    }

    public ArrayList<ShippingLine> getShipping_lines() {
        return this.shipping_lines;
    }

    public Double getShipping_tax_total() {
        return this.shipping_tax_total;
    }

    public Double getShipping_total() {
        return this.shipping_total;
    }

    public Double getSubtotal_ex_tax() {
        return this.subtotal_ex_tax;
    }

    public Double getTax_total() {
        return this.tax_total;
    }

    public void setCart_items(ArrayList<CartItem> arrayList) {
        this.cart_items = arrayList;
    }

    public void setCoupon_lines(ArrayList<CouponLine> arrayList) {
        this.coupon_lines = arrayList;
    }

    public void setDiscount_cart(Double d) {
        this.discount_cart = d;
    }

    public void setPayment_gateways(ArrayList<PaymentGateway> arrayList) {
        this.payment_gateways = arrayList;
    }

    public void setShippable_countries(Map<String, String> map) {
        this.shippable_countries = map;
    }

    public void setShipping_lines(ArrayList<ShippingLine> arrayList) {
        this.shipping_lines = arrayList;
    }

    public void setShipping_tax_total(Double d) {
        this.shipping_tax_total = d;
    }

    public void setShipping_total(Double d) {
        this.shipping_total = d;
    }

    public void setSubtotal_ex_tax(Double d) {
        this.subtotal_ex_tax = d;
    }

    public void setTax_total(Double d) {
        this.tax_total = d;
    }
}
