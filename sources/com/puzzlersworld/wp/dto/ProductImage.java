package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class ProductImage implements Serializable {
    @JsonProperty("src")
    private String source;
    private String title;
}
