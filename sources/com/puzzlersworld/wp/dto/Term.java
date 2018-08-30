package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Term implements Serializable {
    @JsonProperty("term_id")
    private Long ID;
    private String name;
    private String slug;
    private String taxonomy;

    public Long getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getTaxonomy() {
        return this.taxonomy;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSlug(String str) {
        this.slug = str;
    }

    public void setTaxonomy(String str) {
        this.taxonomy = str;
    }
}
