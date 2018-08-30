package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import android.text.TextUtils;

final class amx extends amu {
    amx() {
    }

    @Nullable
    private static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        return length < i ? null : (i == 0 && length == str.length()) ? str : str.substring(i, length);
    }

    public final String a(@Nullable String str, String str2) {
        String a = a(str);
        String a2 = a(str2);
        return TextUtils.isEmpty(a) ? a2 : TextUtils.isEmpty(a2) ? a : new StringBuilder((String.valueOf(a).length() + 1) + String.valueOf(a2).length()).append(a).append(",").append(a2).toString();
    }
}
