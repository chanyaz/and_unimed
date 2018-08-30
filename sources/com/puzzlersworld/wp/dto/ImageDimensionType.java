package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum ImageDimensionType {
    full,
    preview,
    noimage;

    @JsonCreator
    public static ImageDimensionType fromValue(String str) {
        for (ImageDimensionType imageDimensionType : values()) {
            if (imageDimensionType.name().equals(str)) {
                return imageDimensionType;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for ImageDimensionType " + str);
        return preview;
    }
}
