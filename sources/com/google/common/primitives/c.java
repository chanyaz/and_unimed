package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public final class c {
    private c() {
    }

    public static int a(long j) {
        return (int) ((j >>> 32) ^ j);
    }

    public static int a(long j, long j2) {
        return j < j2 ? -1 : j > j2 ? 1 : 0;
    }
}
