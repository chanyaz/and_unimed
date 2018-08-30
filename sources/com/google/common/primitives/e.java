package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@Beta
public final class e {
    private e() {
    }

    static int a(int i) {
        return Integer.MIN_VALUE ^ i;
    }

    public static int a(int i, int i2) {
        return b.a(a(i), a(i2));
    }

    public static long b(int i) {
        return ((long) i) & 4294967295L;
    }

    public static String b(int i, int i2) {
        return Long.toString(((long) i) & 4294967295L, i2);
    }
}
