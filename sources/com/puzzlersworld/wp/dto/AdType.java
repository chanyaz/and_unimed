package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum AdType {
    BANNER,
    MEDIUM_RECTANGLE,
    LARGE_BANNER,
    FULL_BANNER,
    LEADERBOARD,
    WIDE_SKYSCRAPER,
    SMART_BANNER,
    FULL_WIDTH;

    @JsonCreator
    public static AdType fromValue(String str) {
        for (AdType adType : values()) {
            if (adType.name().equals(str)) {
                return adType;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for AdType " + str);
        return LARGE_BANNER;
    }
}
