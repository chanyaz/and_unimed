package com.mopub.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public enum CreativeOrientation {
    PORTRAIT,
    LANDSCAPE,
    UNDEFINED;

    @NonNull
    public static CreativeOrientation fromHeader(@Nullable String str) {
        return "l".equalsIgnoreCase(str) ? LANDSCAPE : "p".equalsIgnoreCase(str) ? PORTRAIT : UNDEFINED;
    }
}
