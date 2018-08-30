package com.google.android.gms.common.util;

import android.support.annotation.Nullable;
import java.util.regex.Pattern;

@VisibleForTesting
public class r {
    private static final Pattern a = Pattern.compile("\\$\\{(.*?)\\}");

    private r() {
    }

    public static String a(@Nullable String str) {
        return str == null ? "" : str;
    }

    public static boolean b(@Nullable String str) {
        return str == null || str.trim().isEmpty();
    }
}
