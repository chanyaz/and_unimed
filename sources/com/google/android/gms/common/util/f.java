package com.google.android.gms.common.util;

import android.os.SystemClock;

public class f implements Clock {
    private static final f a = new f();

    private f() {
    }

    public static Clock a() {
        return a;
    }

    public long currentThreadTimeMillis() {
        return SystemClock.currentThreadTimeMillis();
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
