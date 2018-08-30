package com.google.android.gms.internal.measurement;

import android.os.Build.VERSION;

public final class bj {
    public static int a() {
        try {
            return Integer.parseInt(VERSION.SDK);
        } catch (NumberFormatException e) {
            bs.a("Invalid version number", VERSION.SDK);
            return 0;
        }
    }
}
