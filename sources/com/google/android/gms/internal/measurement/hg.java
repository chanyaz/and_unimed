package com.google.android.gms.internal.measurement;

import android.content.ComponentName;

final class hg implements Runnable {
    private final /* synthetic */ hc a;

    hg(hc hcVar) {
        this.a = hcVar;
    }

    public final void run() {
        this.a.a.a(new ComponentName(this.a.a.getContext(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
