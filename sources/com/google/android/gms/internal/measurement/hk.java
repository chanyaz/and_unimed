package com.google.android.gms.internal.measurement;

import android.app.job.JobParameters;

final /* synthetic */ class hk implements Runnable {
    private final hi a;
    private final dp b;
    private final JobParameters c;

    hk(hi hiVar, dp dpVar, JobParameters jobParameters) {
        this.a = hiVar;
        this.b = dpVar;
        this.c = jobParameters;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
