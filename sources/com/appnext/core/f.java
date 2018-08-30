package com.appnext.core;

import android.content.Context;
import com.appnext.core.h.a;
import com.mopub.common.GpsHelper;

public class f {
    public static final int lw = 0;
    private static String lx = "com.google.android.gms.common.GooglePlayServicesUtil";
    private static String ly = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

    static String a(Object obj, String str) {
        try {
            return (String) new a(obj, "getId").df();
        } catch (Throwable th) {
            return str;
        }
    }

    static boolean a(Object obj, boolean z) {
        try {
            Boolean bool = (Boolean) new a(obj, GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY).df();
            return bool != null ? bool.booleanValue() : z;
        } catch (Throwable th) {
            return z;
        }
    }

    static String b(Context context, boolean z) {
        String str = "";
        if (t(context)) {
            if (z && q(context)) {
                return "";
            }
            try {
                Object df = new a(null, "getAdvertisingIdInfo").b(Class.forName(ly)).a(Context.class, context).df();
                if (df != null) {
                    return a(df, null);
                }
            } catch (Throwable th) {
            }
        }
        return "";
    }

    @Deprecated
    public static void cY() {
        String str = "java.lang.Class";
        lx = str;
        ly = str;
    }

    public static boolean q(Context context) {
        if (!t(context)) {
            return false;
        }
        try {
            Object df = new a(null, "getAdvertisingIdInfo").b(Class.forName(ly)).a(Context.class, context).df();
            return df != null ? a(df, false) : false;
        } catch (Throwable th) {
            return false;
        }
    }

    static boolean t(Context context) {
        try {
            Object df = new a(null, "isGooglePlayServicesAvailable").b(Class.forName(lx)).a(Context.class, context).df();
            return df != null && ((Integer) df).intValue() == 0;
        } catch (Throwable th) {
            return false;
        }
    }
}
