package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class PostFormat implements Serializable {
    @JsonProperty("ID")
    private Long ID;
    private String link;
    private String name;

    public PostFormat(int i) {
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

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}
