package com.google.android.gms.common.util;

import android.os.Looper;

public class s {
    private s() {
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
