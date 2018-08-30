package com.google.android.gms.internal.measurement;

import android.content.Intent;

final /* synthetic */ class hj implements Runnable {
    private final hi a;
    private final int b;
    private final dp c;
    private final Intent d;

    hj(hi hiVar, int i, dp dpVar, Intent intent) {
        this.a = hiVar;
        this.b = i;
        this.c = dpVar;
        this.d = intent;
    }

    public final void run() {
        this.a.a(this.b, this.c, this.d);
    }
}
