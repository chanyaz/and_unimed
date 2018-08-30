package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class PaymentDetails implements Serializable {
    private String method_id;
    private String method_title;
    private Boolean paid;

    public static PaymentDetails fromPaymentGateway(PaymentGateway paymentGateway) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setMethod_id(paymentGateway.getMethod_id());
        paymentDetails.setMethod_title(paymentGateway.getMethod_title());
        paymentDetails.setPaid(Boolean.valueOf(false));
        return paymentDetails;
    }

    public String getMethod_id() {
        return this.method_id;
    }

    public String getMethod_title() {
        return this.method_title;
    }

    public Boolean getPaid() {
        return this.paid;
    }

    public void setMethod_id(String str) {
        this.method_id = str;
    }

    public void setMethod_title(String str) {
        this.method_title = str;
    }

    public void setPaid(Boolean bool) {
        this.paid = bool;
    }
}
