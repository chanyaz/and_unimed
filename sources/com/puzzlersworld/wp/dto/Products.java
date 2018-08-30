package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class Products implements Serializable {
    @JsonProperty("products")
    List<Product> products;

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> list) {
        this.products = list;
    }
}
