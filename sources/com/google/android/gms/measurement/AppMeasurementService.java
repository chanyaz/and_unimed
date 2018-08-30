package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.MainThread;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.measurement.hi;
import com.google.android.gms.internal.measurement.zzjg;

public final class AppMeasurementService extends Service implements zzjg {
    private hi<AppMeasurementService> a;

    private final hi<AppMeasurementService> a() {
        if (this.a == null) {
            this.a = new hi(this);
        }
        return this.a;
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return a().a(intent);
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        a().a();
    }

    @MainThread
    public final void onDestroy() {
        a().b();
        super.onDestroy();
    }

    @MainThread
    public final void onRebind(Intent intent) {
        a().c(intent);
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return a().a(intent, i, i2);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return a().b(intent);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zzb(Intent intent) {
        WakefulBroadcastReceiver.a(intent);
    }
}
