package com.google.android.gms.common.api.internal;

final class bc implements Runnable {
    private final /* synthetic */ bb a;

    bc(bb bbVar) {
        this.a = bbVar;
    }

    public final void run() {
        this.a.a.c.disconnect();
    }
}
