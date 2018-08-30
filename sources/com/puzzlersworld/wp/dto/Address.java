package com.puzzlersworld.wp.dto;

import java.io.Serializable;

public class Address implements Serializable {
    private String address_1;
    private String address_2;
    private String city;
    private String country;
    private String first_name;
    private String last_name;
    private String postcode;
    private String state;

    public String getAddress_1() {
        return this.address_1;
    }

    public String getAddress_2() {
        return this.address_2;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getFirst_name() {
        return this.first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getState() {
        return this.state;
    }

    public void setAddress_1(String str) {
        this.address_1 = str;
    }

    public void setAddress_2(String str) {
        this.address_2 = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setFirst_name(String str) {
        this.first_name = str;
    }

    public void setLast_name(String str) {
        this.last_name = str;
    }

    public void setPostcode(String str) {
        this.postcode = str;
    }

    public void setState(String str) {
        this.state = str;
    }
}
