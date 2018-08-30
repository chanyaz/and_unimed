package com.google.android.gms.ads.internal;

final /* synthetic */ class aa implements Runnable {
    private final x a;
    private final Runnable b;

    aa(x xVar, Runnable runnable) {
        this.a = xVar;
        this.b = runnable;
    }

    public final void run() {
        this.a.a(this.b);
    }
}
