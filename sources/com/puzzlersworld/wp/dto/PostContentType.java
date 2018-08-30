package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum PostContentType {
    preprocessed,
    postprocessed,
    loadurl,
    loadimages;

    @JsonCreator
    public static PostContentType fromValue(String str) {
        for (PostContentType postContentType : values()) {
            if (postContentType.name().equals(str)) {
                return postContentType;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for PostContentType " + str);
        return postprocessed;
    }
}
