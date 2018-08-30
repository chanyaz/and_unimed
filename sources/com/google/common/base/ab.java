package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
public final class ab {
    private ab() {
    }

    public static boolean a(@Nullable String str) {
        return str == null || str.length() == 0;
    }
}
