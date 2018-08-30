package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.puzzlersworld.android.util.w;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Product extends Post implements Serializable {
    private static DecimalFormat df = new DecimalFormat("#.00");
    private Map<String, String> androapp_meta;
    private List<ProductAttribute> attributes;
    private String button_text;
    @JsonProperty("description")
    private String description;
    @JsonProperty("featured_src")
    private String featured_source;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("images")
    private List<ProductImage> images;
    @JsonProperty("in_stock")
    private boolean inStock;
    @JsonProperty("regular_price")
    private Double mrp;
    @JsonProperty("permalink")
    private String permalink;
    private String product_url;
    @JsonProperty("sale_price")
    private Double sellingPrice;
    @JsonProperty("sku")
    private String sku;
    @JsonProperty("stock_quantity")
    private Integer stockQuantity;
    @JsonProperty("type")
    private ProductType type;
    private List<Variation> variations;
    @JsonProperty("weight")
    private Double weight;

    public Map<String, String> getAndroapp_meta() {
        return this.androapp_meta;
    }

    public List<ProductAttribute> getAttributes() {
        return this.attributes;
    }

    public String getButton_text() {
        return this.button_text;
    }

    public String getDescription() {
        return this.description;
    }

    public String getExcerpt() {
        return this.description;
    }

    public String getFeaturedImage() {
        return this.featured_source;
    }

    public String getFeatured_source() {
        return this.featured_source;
    }

    public Long getID() {
        return this.id;
    }

    public Long getId() {
        return this.id;
    }

    public List<ProductImage> getImages() {
        return this.images;
    }

    public String getLink() {
        return this.permalink;
    }

    public Double getMrp() {
        return this.mrp;
    }

    public String getMrpPriceText() {
        Double d = this.mrp;
        Double d2 = this.mrp;
        if (this.variations != null && this.variations.size() > 0) {
            Object obj;
            String obj2;
            Double d3;
            if (d == null || d.compareTo(Double.valueOf(0.0d)) != 0) {
                obj2 = d;
            } else {
                obj2 = null;
            }
            if (d2 != null && d2.compareTo(Double.valueOf(0.0d)) == 0) {
                d2 = null;
            }
            Iterator it = this.variations.iterator();
            while (true) {
                d = obj2;
                d3 = d2;
                if (!it.hasNext()) {
                    break;
                }
                Variation variation = (Variation) it.next();
                if (variation.getRegular_price() != null) {
                    if (d == null) {
                        d = variation.getRegular_price();
                    }
                    if (d3 == null) {
                        d3 = variation.getRegular_price();
                    }
                    d = Double.valueOf(Math.min(d.doubleValue(), variation.getRegular_price().doubleValue()));
                    d2 = Double.valueOf(Math.max(d3.doubleValue(), variation.getRegular_price().doubleValue()));
                } else {
                    d2 = d3;
                }
                obj2 = d;
            }
            d2 = d3;
        }
        return d != null ? d.compareTo(d2) == 0 ? "" + df.format(d2) : df.format(d) + " - " + df.format(d2) : null;
    }

    public String getPermalink() {
        return this.permalink;
    }

    public String getProduct_url() {
        return this.product_url;
    }

    public Double getSellingPrice() {
        return this.sellingPrice;
    }

    public String getSellingPriceText() {
        Double d = this.sellingPrice;
        Double d2 = this.sellingPrice;
        if (this.variations != null && this.variations.size() > 0) {
            Double d3;
            Iterator it = this.variations.iterator();
            while (true) {
                d3 = d;
                d = d2;
                if (!it.hasNext()) {
                    break;
                }
                Variation variation = (Variation) it.next();
                if (variation.getSale_price() != null) {
                    if (d3 == null) {
                        d3 = variation.getSale_price();
                    }
                    if (d == null) {
                        d = variation.getSale_price();
                    }
                    d3 = Double.valueOf(Math.min(d3.doubleValue(), variation.getSale_price().doubleValue()));
                    d2 = Double.valueOf(Math.max(d.doubleValue(), variation.getSale_price().doubleValue()));
                } else {
                    d2 = d;
                }
                d = d3;
            }
            d2 = d;
            d = d3;
        }
        return d != null ? d.compareTo(d2) == 0 ? df.format(d2) : df.format(d) + " - " + df.format(d2) : null;
    }

    public String getSku() {
        return this.sku;
    }

    public Integer getStockQuantity() {
        return this.stockQuantity;
    }

    public ProductType getType() {
        return this.type;
    }

    public List<Variation> getVariations() {
        return this.variations;
    }

    public Double getWeight() {
        return this.weight;
    }

    public boolean isInStock() {
        return this.inStock;
    }

    public void setAndroapp_meta(Map<String, String> map) {
        this.androapp_meta = map;
    }

    public void setAttributes(List<ProductAttribute> list) {
        this.attributes = list;
    }

    public void setButton_text(String str) {
        this.button_text = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setFeatured_source(String str) {
        this.featured_source = w.h(str);
    }

    public void setId(Long l) {
        this.id = l;
    }

    public void setImages(List<ProductImage> list) {
        this.images = list;
    }

    public void setInStock(boolean z) {
        this.inStock = z;
    }

    public void setMrp(Double d) {
        this.mrp = d;
    }

    public void setPermalink(String str) {
        this.permalink = str;
    }

    public void setProduct_url(String str) {
        this.product_url = str;
    }

    public void setSellingPrice(Double d) {
        this.sellingPrice = d;
    }

    public void setSku(String str) {
        this.sku = str;
    }

    public void setStockQuantity(Integer num) {
        this.stockQuantity = num;
    }

    public void setType(ProductType productType) {
        this.type = productType;
    }

    public void setVariations(List<Variation> list) {
        this.variations = list;
    }

    public void setWeight(Double d) {
        this.weight = d;
    }
}
