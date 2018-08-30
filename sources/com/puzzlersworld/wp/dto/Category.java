package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Category implements Serializable {
    @JsonProperty("ID")
    private Long ID;
    private String link;
    private String name;
    private Category parent;
    private Long parentCategoryId;
    private String slug;

    public Category(int i) {
    }

    public Long getID() {
        return this.ID;
    }

    public String getLink() {
        return this.link;
    }

    public String getName() {
        return this.name;
    }

    public Category getParent() {
        return this.parent;
    }

    public Long getParentCategoryId() {
        return this.parentCategoryId;
    }

    public String getSlug() {
        return this.slug;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setParent(Category category) {
        this.parent = category;
        if (category != null) {
            this.parentCategoryId = category.getID();
            this.parent = null;
        }
    }

    public void setParentCategoryId(Long l) {
        this.parentCategoryId = l;
    }

    public void setSlug(String str) {
        this.slug = str;
    }
}
