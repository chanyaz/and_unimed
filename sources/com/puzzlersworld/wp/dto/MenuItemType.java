package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;

public enum MenuItemType implements Serializable {
    category,
    post,
    page,
    custom,
    home,
    tag,
    author,
    product_cat,
    log_out,
    search,
    product_tag,
    save_for_later,
    custom_taxonomy,
    custom_post_type;

    @JsonCreator
    public static MenuItemType fromValue(String str) {
        for (MenuItemType menuItemType : values()) {
            if (menuItemType.name().equals(str)) {
                return menuItemType;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for MenuItemType " + str);
        return category;
    }

    public static MenuItemType fromValue2(String str) {
        if ("product-cat".equals(str)) {
            return product_cat;
        }
        if ("product-tag".equals(str)) {
            return product_tag;
        }
        for (MenuItemType menuItemType : values()) {
            if (menuItemType.name().equals(str)) {
                return menuItemType;
            }
        }
        return null;
    }
}
