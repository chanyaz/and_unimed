package com.mopub.common.util;

import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class Utils {
    private static final AtomicLong a = new AtomicLong(1);

    public static boolean bitMaskContainsFlag(int i, int i2) {
        return (i & i2) != 0;
    }

    public static long generateUniqueId() {
        long j;
        long j2;
        do {
            j = a.get();
            j2 = j + 1;
            if (j2 > 9223372036854775806L) {
                j2 = 1;
            }
        } while (!a.compareAndSet(j, j2));
        return j;
    }

    public static String sha1(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            int length = instance.digest().length;
            for (int i = 0; i < length; i++) {
                stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(r2[i])}));
            }
            return stringBuilder.toString().toLowerCase(Locale.US);
        } catch (Exception e) {
            return "";
        }
    }
}
