package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.common.util.VisibleForTesting;

@Deprecated
@VisibleForTesting
public final class bs {
    private static volatile Logger a = new be();

    @SuppressLint({"LogTagMismatch"})
    public static void a(String str) {
        ae b = bt.b();
        if (b != null) {
            b.b(str);
        } else if (a(0)) {
            Log.v((String) bk.b.a(), str);
        }
        Logger logger = a;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void a(String str, Object obj) {
        ae b = bt.b();
        if (b != null) {
            b.e(str, obj);
        } else if (a(3)) {
            String stringBuilder;
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                stringBuilder = new StringBuilder((String.valueOf(str).length() + 1) + String.valueOf(valueOf).length()).append(str).append(":").append(valueOf).toString();
            } else {
                stringBuilder = str;
            }
            Log.e((String) bk.b.a(), stringBuilder);
        }
        Logger logger = a;
        if (logger != null) {
            logger.error(str);
        }
    }

    private static boolean a(int i) {
        return a != null && a.getLogLevel() <= i;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void b(String str) {
        ae b = bt.b();
        if (b != null) {
            b.e(str);
        } else if (a(2)) {
            Log.w((String) bk.b.a(), str);
        }
        Logger logger = a;
        if (logger != null) {
            logger.warn(str);
        }
    }
}
