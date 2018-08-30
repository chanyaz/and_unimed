package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.internal.measurement.cb;
import com.google.android.gms.internal.measurement.zzcy;

@TargetApi(24)
public final class AnalyticsJobService extends JobService implements zzcy {
    private cb<AnalyticsJobService> a;

    private final cb<AnalyticsJobService> a() {
        if (this.a == null) {
            this.a = new cb(this);
        }
        return this.a;
    }

    public final boolean callServiceStopSelfResult(int i) {
        return stopSelfResult(i);
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        a().a();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        a().b();
        super.onDestroy();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        return a().a(intent, i, i2);
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        return a().a(jobParameters);
    }

    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @TargetApi(24)
    public final void zza(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }
}
