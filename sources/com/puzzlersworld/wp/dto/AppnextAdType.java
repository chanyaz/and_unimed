package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum AppnextAdType {
    INTERSTITIAL_VIDEO,
    FULL_SCREEN_VIDEO;

    @JsonCreator
    public static AppnextAdType fromValue(String str) {
        for (AppnextAdType appnextAdType : values()) {
            if (appnextAdType.name().equals(str)) {
                return appnextAdType;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for AppnextAdType " + str);
        return INTERSTITIAL_VIDEO;
    }
}
