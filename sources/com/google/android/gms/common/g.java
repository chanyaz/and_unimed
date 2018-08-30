package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.internal.x;
import com.google.android.gms.common.util.VisibleForTesting;

public class g {
    private static final g a = new g();
    public static final int b = k.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    g() {
    }

    public static g b() {
        return a;
    }

    @VisibleForTesting
    private static String b(@Nullable Context context, @Nullable String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(b);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(c.b(context).b(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public int a(Context context) {
        return b(context, b);
    }

    @Nullable
    public PendingIntent a(Context context, int i, int i2) {
        return a(context, i, i2, null);
    }

    @Nullable
    public PendingIntent a(Context context, int i, int i2, @Nullable String str) {
        Intent b = b(context, i, str);
        return b == null ? null : PendingIntent.getActivity(context, i2, b, 134217728);
    }

    public boolean a(int i) {
        return k.isUserRecoverableError(i);
    }

    public boolean a(Context context, String str) {
        return k.isUninstalledAppPossiblyUpdating(context, str);
    }

    public int b(Context context) {
        return k.getApkVersion(context);
    }

    public int b(Context context, int i) {
        int isGooglePlayServicesAvailable = k.isGooglePlayServicesAvailable(context, i);
        return k.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable) ? 18 : isGooglePlayServicesAvailable;
    }

    @Nullable
    @Deprecated
    public Intent b(int i) {
        return b(null, i, null);
    }

    @Nullable
    public Intent b(Context context, int i, @Nullable String str) {
        switch (i) {
            case 1:
            case 2:
                return (context == null || !com.google.android.gms.common.util.g.b(context)) ? x.a("com.google.android.gms", b(context, str)) : x.a();
            case 3:
                return x.a("com.google.android.gms");
            default:
                return null;
        }
    }

    public String c(int i) {
        return k.getErrorString(i);
    }

    public boolean c(Context context, int i) {
        return k.isPlayServicesPossiblyUpdating(context, i);
    }

    public void d(Context context) {
        k.cancelAvailabilityErrorNotifications(context);
    }
}
