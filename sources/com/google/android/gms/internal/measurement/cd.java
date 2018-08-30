package com.google.android.gms.internal.measurement;

import android.app.job.JobParameters;

final /* synthetic */ class cd implements Runnable {
    private final cb a;
    private final bt b;
    private final JobParameters c;

    cd(cb cbVar, bt btVar, JobParameters jobParameters) {
        this.a = cbVar;
        this.b = btVar;
        this.c = jobParameters;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
