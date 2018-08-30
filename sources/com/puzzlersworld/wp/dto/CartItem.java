package com.puzzlersworld.wp.dto;

import com.puzzlersworld.android.data.CartObjectType;
import java.io.Serializable;
import java.util.Map;

public class CartItem implements Serializable {
    private String cart_item_key;
    private String image;
    private CartObjectType itemType;
    private Double mrp;
    private Long productId;
    private Integer quantity;
    private Double sellingPrice;
    private String title;
    private String variant;
    private Map<String, String> variation;
    private Long variation_id;

    public String getCart_item_key() {
        return this.cart_item_key;
    }

    public String getImage() {
        return this.image;
    }

    public CartObjectType getItemType() {
        return this.itemType;
    }

    public Double getMrp() {
        return this.mrp;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getSellingPrice() {
        return this.sellingPrice;
    }

    public String getTitle() {
        return this.title;
    }

    public String getVariant() {
        return this.variant;
    }

    public Map<String, String> getVariation() {
        return this.variation;
    }

    public Long getVariation_id() {
        return this.variation_id;
    }

    public void setCart_item_key(String str) {
        this.cart_item_key = str;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setItemType(CartObjectType cartObjectType) {
        this.itemType = cartObjectType;
    }

    public void setMrp(Double d) {
        this.mrp = d;
    }

    public void setProductId(Long l) {
        this.productId = l;
    }

    public void setQuantity(Integer num) {
        this.quantity = num;
    }

    public void setSellingPrice(Double d) {
        this.sellingPrice = d;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setVariant(String str) {
        this.variant = str;
    }

    public void setVariation(Map<String, String> map) {
        this.variation = map;
    }

    public void setVariation_id(Long l) {
        this.variation_id = l;
    }
}
