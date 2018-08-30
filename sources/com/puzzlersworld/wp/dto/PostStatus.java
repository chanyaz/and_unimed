package com.puzzlersworld.wp.dto;

import android.util.Log;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum PostStatus {
    publish,
    draft;

    @JsonCreator
    public static PostStatus fromValue(String str) {
        for (PostStatus postStatus : values()) {
            if (postStatus.name().equals(str)) {
                return postStatus;
            }
        }
        if (str == null || str.isEmpty()) {
            return null;
        }
        Log.e("ANDROAPP", "Unkown value for poststatus " + str);
        return publish;
    }
}
