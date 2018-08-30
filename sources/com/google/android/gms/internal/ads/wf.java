package com.google.android.gms.internal.ads;

final class wf {
    public static boolean a() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
