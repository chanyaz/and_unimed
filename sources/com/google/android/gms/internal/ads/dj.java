package com.google.android.gms.internal.ads;

final class dj implements Runnable {
    private final /* synthetic */ de a;

    dj(de deVar) {
        this.a = deVar;
    }

    public final void run() {
        if (this.a.l != null) {
            this.a.l.c();
            this.a.l = null;
        }
    }
}
