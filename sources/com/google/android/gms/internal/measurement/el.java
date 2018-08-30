package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class el implements Runnable {
    private final /* synthetic */ es a;
    private final /* synthetic */ long b;
    private final /* synthetic */ Bundle c;
    private final /* synthetic */ Context d;
    private final /* synthetic */ dp e;
    private final /* synthetic */ PendingResult f;

    el(ej ejVar, es esVar, long j, Bundle bundle, Context context, dp dpVar, PendingResult pendingResult) {
        this.a = esVar;
        this.b = j;
        this.c = bundle;
        this.d = context;
        this.e = dpVar;
        this.f = pendingResult;
    }

    public final void run() {
        long a = this.a.c().h.a();
        long j = this.b;
        if (a > 0 && (j >= a || j <= 0)) {
            j = a - 1;
        }
        if (j > 0) {
            this.c.putLong("click_timestamp", j);
        }
        this.c.putString("_cis", "referrer broadcast");
        AppMeasurement.getInstance(this.d).logEventInternal("auto", "_cmp", this.c);
        this.e.y().a("Install campaign recorded");
        if (this.f != null) {
            this.f.finish();
        }
    }
}
