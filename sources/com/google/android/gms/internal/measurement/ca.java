package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.stats.WakeLock;

public final class ca {
    static Object a = new Object();
    static WakeLock b;
    private static Boolean c;

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public static void a(Context context, Intent intent) {
        ae e = ah.a(context).e();
        if (intent == null) {
            e.e("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        e.a("Local AnalyticsReceiver got", action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean a = cb.a(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (a) {
                context.startService(intent2);
                if (a) {
                    try {
                        if (b == null) {
                            WakeLock wakeLock = new WakeLock(context, 1, "Analytics WakeLock");
                            b = wakeLock;
                            wakeLock.a(false);
                        }
                        b.a(1000);
                    } catch (SecurityException e2) {
                        e.e("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }

    public static boolean a(Context context) {
        ar.a((Object) context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean a = cj.a(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        c = Boolean.valueOf(a);
        return a;
    }
}
