package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class CouponLine implements Serializable {
    private Double amount;
    private String code;
    private Long id;

    public Double getAmount() {
        return this.amount;
    }

    public String getCode() {
        return this.code;
    }

    public Long getId() {
        return this.id;
    }

    public void setAmount(Double d) {
        this.amount = d;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setId(Long l) {
        this.id = l;
    }
}
