package com.google.android.gms.common.util;

import android.os.Build.VERSION;
import android.support.v4.os.a;

@VisibleForTesting
public final class p {
    private p() {
    }

    public static boolean a() {
        return true;
    }

    public static boolean b() {
        return true;
    }

    public static boolean c() {
        return VERSION.SDK_INT >= 15;
    }

    public static boolean d() {
        return VERSION.SDK_INT >= 16;
    }

    public static boolean e() {
        return VERSION.SDK_INT >= 17;
    }

    public static boolean f() {
        return VERSION.SDK_INT >= 18;
    }

    public static boolean g() {
        return VERSION.SDK_INT >= 19;
    }

    public static boolean h() {
        return VERSION.SDK_INT >= 20;
    }

    public static boolean i() {
        return VERSION.SDK_INT >= 21;
    }

    public static boolean j() {
        return VERSION.SDK_INT >= 23;
    }

    public static boolean k() {
        return VERSION.SDK_INT >= 24;
    }

    public static boolean l() {
        return VERSION.SDK_INT >= 26;
    }

    public static boolean m() {
        return a.b();
    }
}
