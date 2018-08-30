package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum CommentType {
    comment,
    trackback,
    pingback,
    token;

    @JsonCreator
    public static CommentType fromValue(String str) {
        for (CommentType commentType : values()) {
            if (commentType.name().equals(str)) {
                return commentType;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for CommentType " + str);
        return comment;
    }
}
