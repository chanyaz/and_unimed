package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.MainThread;
import com.google.android.gms.internal.measurement.hi;
import com.google.android.gms.internal.measurement.zzjg;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzjg {
    private hi<AppMeasurementJobService> a;

    private final hi<AppMeasurementJobService> a() {
        if (this.a == null) {
            this.a = new hi(this);
        }
        return this.a;
    }

    public final boolean callServiceStopSelfResult(int i) {
        throw new UnsupportedOperationException();
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

    public final boolean onStartJob(JobParameters jobParameters) {
        return a().a(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return a().b(intent);
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    public final void zzb(Intent intent) {
    }
}
