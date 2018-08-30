package com.google.android.exoplayer.util;

public final class e {
    private e() {
    }

    public static String a(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }

    public static boolean b(String str) {
        return a(str).equals("audio");
    }

    public static boolean c(String str) {
        return a(str).equals("video");
    }

    public static int d(String str) {
        return "audio/ac3".equals(str) ? 5 : "audio/eac3".equals(str) ? 6 : b(str) ? 2 : 0;
    }

    public static boolean e(String str) {
        return "audio/ac3".equals(str) || "audio/eac3".equals(str);
    }
}
