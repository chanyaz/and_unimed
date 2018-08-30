package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.RequiresPermission;
import com.appnext.base.b.c;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.stats.WakeLock;

public final class cb<T extends Context & zzcy> {
    private static Boolean c;
    private final Handler a = new Handler();
    private final T b;

    public cb(T t) {
        ar.a((Object) t);
        this.b = t;
    }

    private final void a(Runnable runnable) {
        ah.a(this.b).h().a(new ce(this, runnable));
    }

    public static boolean a(Context context) {
        ar.a((Object) context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean a = cj.a(context, "com.google.android.gms.analytics.AnalyticsService");
        c = Boolean.valueOf(a);
        return a;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int a(Intent intent, int i, int i2) {
        try {
            synchronized (ca.a) {
                WakeLock wakeLock = ca.b;
                if (wakeLock != null && wakeLock.b()) {
                    wakeLock.a();
                }
            }
        } catch (SecurityException e) {
        }
        ae e2 = ah.a(this.b).e();
        if (intent == null) {
            e2.e("AnalyticsService started with null intent");
        } else {
            String action = intent.getAction();
            e2.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
                a(new cc(this, i2, e2));
            }
        }
        return 2;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void a() {
        ah.a(this.b).e().b("Local AnalyticsService is starting up");
    }

    @TargetApi(24)
    public final boolean a(JobParameters jobParameters) {
        ae e = ah.a(this.b).e();
        String string = jobParameters.getExtras().getString(c.jD);
        e.a("Local AnalyticsJobService called. action", string);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            a(new cd(this, e, jobParameters));
        }
        return true;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void b() {
        ah.a(this.b).e().b("Local AnalyticsService is shutting down");
    }
}
