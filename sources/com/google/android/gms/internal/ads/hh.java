package com.google.android.gms.internal.ads;

final class hh implements Runnable {
    private final /* synthetic */ hg a;

    hh(hg hgVar) {
        this.a = hgVar;
    }

    public final void run() {
        this.a.b = Thread.currentThread();
        this.a.a();
    }
}
