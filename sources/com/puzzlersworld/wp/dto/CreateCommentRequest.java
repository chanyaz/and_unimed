package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class CreateCommentRequest implements Serializable {
    private String author;
    @JsonProperty("author_mail")
    private String authorMail;
    @JsonProperty("author_url")
    private String authorUrl;
    private String content;
    private Long parent;

    public CreateCommentRequest(String str, String str2, String str3, String str4, Long l) {
        this.author = str;
        this.authorMail = str2;
        this.authorUrl = str3;
        this.content = str4;
        this.parent = l;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getAuthorMail() {
        return this.authorMail;
    }

    public String getAuthorUrl() {
        return this.authorUrl;
    }

    public String getContent() {
        return this.content;
    }

    public Long getParent() {
        return this.parent;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setAuthorMail(String str) {
        this.authorMail = str;
    }

    public void setAuthorUrl(String str) {
        this.authorUrl = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setParent(Long l) {
        this.parent = l;
    }
}
