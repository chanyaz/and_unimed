package com.google.android.exoplayer.util;

import android.annotation.TargetApi;
import android.os.Trace;

public final class k {
    private k() {
    }

    public static void a() {
        if (m.a >= 18) {
            b();
        }
    }

    public static void a(String str) {
        if (m.a >= 18) {
            b(str);
        }
    }

    @TargetApi(18)
    private static void b() {
        Trace.endSection();
    }

    @TargetApi(18)
    private static void b(String str) {
        Trace.beginSection(str);
    }
}
