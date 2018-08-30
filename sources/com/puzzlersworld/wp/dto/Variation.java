package com.puzzlersworld.wp.dto;

import java.io.Serializable;
import java.util.List;

public class Variation implements Serializable {
    private List<ProductAttribute> attributes;
    private Long id;
    private Double regular_price;
    private Double sale_price;

    public List<ProductAttribute> getAttributes() {
        return this.attributes;
    }

    public Long getId() {
        return this.id;
    }

    public Double getRegular_price() {
        return this.regular_price;
    }

    public Double getSale_price() {
        return this.sale_price;
    }

    public void setAttributes(List<ProductAttribute> list) {
        this.attributes = list;
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setRegular_price(Double d) {
        this.regular_price = d;
    }

    public void setSale_price(Double d) {
        this.sale_price = d;
    }
}
