package com.google.android.gms.internal.measurement;

import com.google.android.gms.measurement.AppMeasurement.ConditionalUserProperty;

final class fy implements Runnable {
    private final /* synthetic */ ConditionalUserProperty a;
    private final /* synthetic */ fq b;

    fy(fq fqVar, ConditionalUserProperty conditionalUserProperty) {
        this.b = fqVar;
        this.a = conditionalUserProperty;
    }

    public final void run() {
        this.b.e(this.a);
    }
}
