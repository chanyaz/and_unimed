package com.puzzlersworld.wp.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private BillingAddress billing_address = new BillingAddress();
    private ArrayList<CouponLine> coupon_lines = new ArrayList();
    private Long customer_id;
    private Long id;
    private ArrayList<LineItem> line_items;
    private String note;
    private PaymentDetails payment_details;
    private ShippingAddress shipping_address = new ShippingAddress();
    private ShippingLine[] shipping_lines;
    private String status;
    private Double subtotal;
    private Double total;
    private Double total_tax;

    public BillingAddress getBilling_address() {
        return this.billing_address;
    }

    public ArrayList<CouponLine> getCoupon_lines() {
        return this.coupon_lines;
    }

    public Long getCustomer_id() {
        return this.customer_id;
    }

    public Long getId() {
        return this.id;
    }

    public ArrayList<LineItem> getLine_items() {
        return this.line_items;
    }

    public String getNote() {
        return this.note;
    }

    public PaymentDetails getPayment_details() {
        return this.payment_details;
    }

    public ShippingAddress getShipping_address() {
        return this.shipping_address;
    }

    public ShippingLine[] getShipping_lines() {
        return this.shipping_lines;
    }

    public String getStatus() {
        return this.status;
    }

    public Double getSubtotal() {
        return this.subtotal;
    }

    public Double getTotal() {
        return this.total;
    }

    public Double getTotal_tax() {
        return this.total_tax;
    }

    public void setBilling_address(BillingAddress billingAddress) {
        this.billing_address = billingAddress;
    }

    public void setCoupon_lines(ArrayList<CouponLine> arrayList) {
        this.coupon_lines = arrayList;
    }

    public void setCustomer_id(Long l) {
        this.customer_id = l;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setLine_items(ArrayList<LineItem> arrayList) {
        this.line_items = arrayList;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setPayment_details(PaymentDetails paymentDetails) {
        this.payment_details = paymentDetails;
    }

    public void setShipping_address(ShippingAddress shippingAddress) {
        this.shipping_address = shippingAddress;
    }

    public void setShipping_lines(ShippingLine[] shippingLineArr) {
        this.shipping_lines = shippingLineArr;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSubtotal(Double d) {
        this.subtotal = d;
    }

    public void setTotal(Double d) {
        this.total = d;
    }

    public void setTotal_tax(Double d) {
        this.total_tax = d;
    }
}
