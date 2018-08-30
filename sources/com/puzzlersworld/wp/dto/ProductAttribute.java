package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class ProductAttribute implements Serializable {
    private String name;
    private String option;

    public String getName() {
        return this.name;
    }

    public String getOption() {
        return this.option;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOption(String str) {
        this.option = str;
    }
}
