package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum PostCommentStatus {
    open,
    closed;

    @JsonCreator
    public static PostCommentStatus fromValue(String str) {
        for (PostCommentStatus postCommentStatus : values()) {
            if (postCommentStatus.name().equals(str)) {
                return postCommentStatus;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for PostCommentStatus " + str);
        return closed;
    }
}
