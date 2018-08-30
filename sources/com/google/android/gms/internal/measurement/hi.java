package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.appnext.base.b.c;
import com.google.android.gms.common.internal.ar;

public final class hi<T extends Context & zzjg> {
    private final T a;

    public hi(T t) {
        ar.a((Object) t);
        this.a = t;
    }

    private final void a(Runnable runnable) {
        hw a = es.a(this.a);
        a.zzgd().a(new hl(this, a, runnable));
    }

    public static boolean a(Context context, boolean z) {
        ar.a((Object) context);
        return VERSION.SDK_INT >= 24 ? ie.a(context, "com.google.android.gms.measurement.AppMeasurementJobService") : ie.a(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    private final dp c() {
        return es.a(this.a).zzge();
    }

    @MainThread
    public final int a(Intent intent, int i, int i2) {
        dp zzge = es.a(this.a).zzge();
        if (intent == null) {
            zzge.u().a("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            zzge.y().a("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                a(new hj(this, i2, zzge, intent));
            }
        }
        return 2;
    }

    @MainThread
    public final IBinder a(Intent intent) {
        if (intent == null) {
            c().r().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new eu(es.a(this.a));
        }
        c().u().a("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final void a() {
        es.a(this.a).zzge().y().a("Local AppMeasurementService is starting up");
    }

    @TargetApi(24)
    @MainThread
    public final boolean a(JobParameters jobParameters) {
        dp zzge = es.a(this.a).zzge();
        String string = jobParameters.getExtras().getString(c.jD);
        zzge.y().a("Local AppMeasurementJobService called. action", string);
        if ("com.google.android.gms.measurement.UPLOAD".equals(string)) {
            a(new hk(this, zzge, jobParameters));
        }
        return true;
    }

    @MainThread
    public final void b() {
        es.a(this.a).zzge().y().a("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final boolean b(Intent intent) {
        if (intent == null) {
            c().r().a("onUnbind called with null intent");
        } else {
            c().y().a("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    @MainThread
    public final void c(Intent intent) {
        if (intent == null) {
            c().r().a("onRebind called with null intent");
            return;
        }
        c().y().a("onRebind called. action", intent.getAction());
    }
}
