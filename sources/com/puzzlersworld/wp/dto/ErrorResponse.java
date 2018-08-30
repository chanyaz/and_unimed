package com.puzzlersworld.wp.dto;

public class ErrorResponse {
    String code;
    String message;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
