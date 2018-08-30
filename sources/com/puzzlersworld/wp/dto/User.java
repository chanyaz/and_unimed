package com.puzzlersworld.wp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("ID")
    private Long ID;
    private String avatar;
    private String first_name;
    private String last_name;
    private String nickname;
    private String username;

    public String getAvatar() {
        return this.avatar;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public Long getID() {
        return this.ID;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setFirst_name(String str) {
        this.first_name = str;
    }

    public void setID(Long l) {
        this.ID = l;
    }

    public void setLast_name(String str) {
        this.last_name = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }
}
