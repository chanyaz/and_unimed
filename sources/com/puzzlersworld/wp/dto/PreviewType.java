package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum PreviewType {
    seo_meta_desc,
    excerpt,
    none;

    @JsonCreator
    public static PreviewType fromValue(String str) {
        for (PreviewType previewType : values()) {
            if (previewType.name().equals(str)) {
                return previewType;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for PreviewType " + str);
        return excerpt;
    }
}
