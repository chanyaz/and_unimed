package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.lf;

final /* synthetic */ class y implements Runnable {
    private final x a;
    private final Runnable b;

    y(x xVar, Runnable runnable) {
        this.a = xVar;
        this.b = runnable;
    }

    public final void run() {
        lf.a.execute(new aa(this.a, this.b));
    }
}
