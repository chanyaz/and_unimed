package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class PostImage implements Serializable {
    private String description;
    private int height;
    private String src;
    private int width;

    public String getDescription() {
        return this.description;
    }

    public int getHeight() {
        return this.height;
    }

    public String getSrc() {
        return this.src;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setSrc(String str) {
        this.src = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
