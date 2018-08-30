package com.puzzlersworld.wp.dto;

import java.util.Map;

public class ShippingAddress extends Address {
    public static ShippingAddress fromBillingAddress(BillingAddress billingAddress) {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setAddress_1(billingAddress.getAddress_1());
        shippingAddress.setAddress_2(billingAddress.getAddress_2());
        shippingAddress.setCity(billingAddress.getCity());
        shippingAddress.setCountry(billingAddress.getCountry());
        shippingAddress.setFirst_name(billingAddress.getFirst_name());
        shippingAddress.setLast_name(billingAddress.getLast_name());
        shippingAddress.setPostcode(billingAddress.getPostcode());
        shippingAddress.setState(billingAddress.getState());
        return shippingAddress;
    }

    public String toString(Map<String, String> map, Map<String, String> map2) {
        StringBuffer stringBuffer = new StringBuffer();
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
        return stringBuffer.toString();
    }
}
