package com.mopub.common.util;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.regex.Pattern;

public class Strings {
    private static Pattern a = Pattern.compile("((\\d{1,2})|(100))%");
    private static Pattern b = Pattern.compile("\\d{2}:\\d{2}:\\d{2}(.\\d{3})?");

    public static String fromStream(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] bArr = new byte[4096];
        int i = 0;
        while (i != -1) {
            stringBuilder.append(new String(bArr, 0, i));
            i = inputStream.read(bArr);
        }
        inputStream.close();
        return stringBuilder.toString();
    }

    public static boolean isAbsoluteTracker(String str) {
        return !TextUtils.isEmpty(str) && b.matcher(str).matches();
    }

    public static boolean isPercentageTracker(String str) {
        return !TextUtils.isEmpty(str) && a.matcher(str).matches();
    }

    @Nullable
    public static Integer parseAbsoluteOffset(@Nullable String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        return split.length == 3 ? Integer.valueOf(((((Integer.parseInt(split[0]) * 60) * 60) * 1000) + ((Integer.parseInt(split[1]) * 60) * 1000)) + ((int) (Float.parseFloat(split[2]) * 1000.0f))) : null;
    }
}
