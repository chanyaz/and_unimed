package com.appnext.base.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;

public final class d {
    @SuppressLint({"StaticFieldLeak"})
    private static Context jQ;

    private d() {
    }

    public static void cx() {
        jQ = null;
    }

    public static AssetManager getAssets() {
        return getContext().getAssets();
    }

    public static Context getContext() {
        return jQ;
    }

    public static PackageManager getPackageManager() {
        return getContext().getPackageManager();
    }

    public static String getPackageName() {
        return getContext().getPackageName();
    }

    public static SharedPreferences getSharedPreferences(String str, int i) {
        return getContext().getSharedPreferences(str, i);
    }

    public static void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context shouldn't be null");
        }
        jQ = context.getApplicationContext();
    }
}
