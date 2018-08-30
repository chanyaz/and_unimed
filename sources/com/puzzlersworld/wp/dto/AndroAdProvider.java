package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum AndroAdProvider {
    ADMOB,
    APPNEXT,
    MOPUB;

    @JsonCreator
    public static AndroAdProvider fromValue(String str) {
        for (AndroAdProvider androAdProvider : values()) {
            if (androAdProvider.name().equals(str)) {
                return androAdProvider;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for AndroAdProvider " + str);
        return null;
    }
}
