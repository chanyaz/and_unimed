package com.puzzlersworld.wp.dto;

import java.util.Map;

public class BillingAddress extends Address {
    private String email;
    private String phone;

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String toString(Map<String, String> map, Map<String, String> map2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<p>");
        stringBuffer.append(getFirst_name());
        stringBuffer.append(" ");
        stringBuffer.append(getLast_name());
        stringBuffer.append("<br/>");
        stringBuffer.append(getAddress_1());
        stringBuffer.append("<br>");
        if (!(getAddress_2() == null || getAddress_2().isEmpty())) {
            stringBuffer.append(getAddress_2());
            stringBuffer.append("<br/>");
        }
        stringBuffer.append(getCity());
        stringBuffer.append(" - ");
        stringBuffer.append(getPostcode());
        stringBuffer.append("<br/>");
        if (map2.get(getState()) != null) {
            stringBuffer.append((String) map2.get(getState()));
        } else {
            stringBuffer.append(getState());
        }
        stringBuffer.append("<br>");
        if (map.get(getCountry()) != null) {
            stringBuffer.append((String) map.get(getCountry()));
        } else {
            stringBuffer.append(getCountry());
        }
        stringBuffer.append("<br/>");
        stringBuffer.append(getEmail());
        stringBuffer.append("<br/>");
        stringBuffer.append(getPhone());
        stringBuffer.append("</p>");
        return stringBuffer.toString();
    }
}
