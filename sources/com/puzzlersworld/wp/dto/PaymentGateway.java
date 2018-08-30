package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class PaymentGateway implements Serializable {
    private String browser;
    private String description;
    private String instructions;
    private String method_id;
    private String method_title;

    public String getBrowser() {
        return this.browser;
    }

    public String getDescription() {
        return this.description;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public String getMethod_id() {
        return this.method_id;
    }

    public String getMethod_title() {
        return this.method_title;
    }

    public void setBrowser(String str) {
        this.browser = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setInstructions(String str) {
        this.instructions = str;
    }

    public void setMethod_id(String str) {
        this.method_id = str;
    }

    public void setMethod_title(String str) {
        this.method_title = str;
    }
}
