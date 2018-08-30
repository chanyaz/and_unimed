package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum Layout {
    cardview,
    compact;

    @JsonCreator
    public static Layout fromValue(String str) {
        for (Layout layout : values()) {
            if (layout.name().equals(str)) {
                return layout;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for Layout " + str);
        return cardview;
    }
}
