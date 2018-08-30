package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.l;

public final class t {
    private t() {
    }

    public static boolean a(Context context, int i) {
        boolean z = false;
        if (!a(context, i, "com.google.android.gms")) {
            return z;
        }
        try {
            return l.a(context).a(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (NameNotFoundException e) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return z;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return z;
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i, String str) {
        return c.b(context).a(i, str);
    }
}
