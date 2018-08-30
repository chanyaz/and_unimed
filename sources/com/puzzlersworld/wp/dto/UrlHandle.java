package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlHandle {
    @JsonProperty("product_category_base")
    private String productCategoryHandle = "product-category";
    @JsonProperty("product_tag_base")
    private String productTagHandle = "product-tag";

    public String getProductCategoryHandle() {
        return this.productCategoryHandle;
    }

    public String getProductTagHandle() {
        return this.productTagHandle;
    }

    public void setProductCategoryHandle(String str) {
        this.productCategoryHandle = str;
    }

    public void setProductTagHandle(String str) {
        this.productTagHandle = str;
    }
}
