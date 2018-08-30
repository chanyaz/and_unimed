package com.google.common.hash;

import com.google.common.annotations.Beta;

@Beta
public final class i {
    private static final int a = ((int) System.currentTimeMillis());

    private i() {
    }

    public static HashFunction a() {
        return j.a;
    }

    public static HashFunction a(int i) {
        return new k(i);
    }
}
