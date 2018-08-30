package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Author implements Serializable {
    @JsonProperty("ID")
    private Long ID;
    private String avatar;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String name;
    private String slug;
    private String username;

    public Author(int i) {
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Long getID() {
        return this.ID;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getName() {
        return this.name;
    }

    public String getSlug() {
        return this.slug;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFirstName(String str) {
        this.firstName = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLastName(String str) {
        this.lastName = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSlug(String str) {
        this.slug = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
