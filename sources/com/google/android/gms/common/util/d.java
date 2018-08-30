package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.a.c;
import com.google.android.gms.common.k;

public class d {
    private d() {
    }

    public static int a(Context context, String str) {
        return a(b(context, str));
    }

    public static int a(PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return -1;
        }
        Bundle bundle = packageInfo.applicationInfo.metaData;
        return bundle != null ? bundle.getInt(k.KEY_METADATA_GOOGLE_PLAY_SERVICES_VERSION, -1) : -1;
    }

    public static boolean a() {
        return false;
    }

    @Nullable
    public static PackageInfo b(Context context, String str) {
        try {
            return c.b(context).b(str, 128);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static boolean c(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            return (c.b(context).a(str, 0).flags & 2097152) != 0;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
