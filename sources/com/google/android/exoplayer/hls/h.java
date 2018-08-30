package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.ParserException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class h {
    private h() {
    }

    public static String a(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1) : null;
    }

    public static String a(String str, Pattern pattern, String str2) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.find() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        throw new ParserException("Couldn't match " + str2 + " tag in " + str);
    }

    public static Pattern a(String str) {
        return Pattern.compile(str + "=(" + "YES" + "|" + "NO" + ")");
    }

    public static int b(String str, Pattern pattern, String str2) {
        return Integer.parseInt(a(str, pattern, str2));
    }

    public static boolean b(String str, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? "YES".equals(matcher.group(1)) : false;
    }

    public static double c(String str, Pattern pattern, String str2) {
        return Double.parseDouble(a(str, pattern, str2));
    }
}
