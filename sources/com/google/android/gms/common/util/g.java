package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.google.android.gms.common.k;

public final class g {
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;

    private g() {
    }

    public static boolean a() {
        return k.sIsTestMode ? k.sTestIsUserBuild : "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean a(Context context) {
        if (a == null) {
            boolean z = p.h() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            a = Boolean.valueOf(z);
        }
        return a.booleanValue();
    }

    @TargetApi(24)
    public static boolean b(Context context) {
        return (!p.k() || c(context)) && a(context);
    }

    @TargetApi(21)
    public static boolean c(Context context) {
        if (b == null) {
            boolean z = p.i() && context.getPackageManager().hasSystemFeature(k.FEATURE_SIDEWINDER);
            b = Boolean.valueOf(z);
        }
        return b.booleanValue();
    }

    public static boolean d(Context context) {
        if (c == null) {
            boolean z = context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded");
            c = Boolean.valueOf(z);
        }
        return c.booleanValue();
    }
}
