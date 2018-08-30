package com.puzzlersworld.wp.dto;

import java.io.Serializable;
import java.util.List;

public class WpJson implements Serializable {
    private String name;
    private List<String> namespaces;

    public String getName() {
        return this.name;
    }

    public List<String> getNamespaces() {
        return this.namespaces;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNamespaces(List<String> list) {
        this.namespaces = list;
    }
}
