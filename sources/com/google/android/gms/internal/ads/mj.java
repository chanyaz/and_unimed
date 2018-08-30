package com.google.android.gms.internal.ads;

final class mj implements Runnable {
    private final /* synthetic */ mg a;

    mj(mg mgVar) {
        this.a = mgVar;
    }

    public final void run() {
        this.a.a("surfaceDestroyed", new String[0]);
    }
}
