package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum CommentStatus {
    hold,
    approved,
    spam,
    trash,
    token;

    @JsonCreator
    public static CommentStatus fromValue(String str) {
        for (CommentStatus commentStatus : values()) {
            if (commentStatus.name().equals(str)) {
                return commentStatus;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for CommentStatus " + str);
        return hold;
    }
}
