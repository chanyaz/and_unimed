package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class ShippingLine implements Serializable {
    private String method_id;
    private String method_title;
    private Double total;

    public String getMethod_id() {
        return this.method_id;
    }

    public String getMethod_title() {
        return this.method_title;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setMethod_id(String str) {
        this.method_id = str;
    }

    public void setMethod_title(String str) {
        this.method_title = str;
    }

    public void setTotal(Double d) {
        this.total = d;
    }
}
