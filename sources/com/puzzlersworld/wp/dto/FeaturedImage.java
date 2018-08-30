package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class FeaturedImage implements Serializable {
    @JsonProperty("ID")
    private Long ID;
    private String excerpt;
    private String source;
    private String title;

    public String getExcerpt() {
        return this.excerpt;
    }

    public Long getID() {
        return this.ID;
    }

    public String getSource() {
        return this.source;
    }

    public String getTitle() {
        return this.title;
    }

    public void setExcerpt(String str) {
        this.excerpt = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
