package com.puzzlersworld.wp.dto;

import java.io.Serializable;
import java.util.Map;

public class LineItem implements Serializable {
    private String name;
    private Long product_id;
    private Integer quantity;
    private Double total;
    private Long variation_id;
    private Map<String, String> variations;

    public static LineItem fromCartItem(CartItem cartItem) {
        LineItem lineItem = new LineItem();
        lineItem.setProduct_id(cartItem.getProductId());
        lineItem.setQuantity(cartItem.getQuantity());
        lineItem.setVariation_id(cartItem.getVariation_id());
        lineItem.setVariations(cartItem.getVariation());
        lineItem.setName(cartItem.getTitle());
        return lineItem;
    }

    public String getName() {
        return this.name;
    }

    public Long getProduct_id() {
        return this.product_id;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getTotal() {
        return this.total;
    }

    public Long getVariation_id() {
        return this.variation_id;
    }

    public Map<String, String> getVariations() {
        return this.variations;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProduct_id(Long l) {
        this.product_id = l;
    }

    public void setQuantity(Integer num) {
        this.quantity = num;
    }

    public void setTotal(Double d) {
        this.total = d;
    }

    public void setVariation_id(Long l) {
        this.variation_id = l;
    }

    public void setVariations(Map<String, String> map) {
        this.variations = map;
    }
}
