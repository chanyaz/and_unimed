package com.google.android.gms.internal.ads;

final /* synthetic */ class mh implements Runnable {
    private final me a;

    private mh(me meVar) {
        this.a = meVar;
    }

    static Runnable a(me meVar) {
        return new mh(meVar);
    }

    public final void run() {
        this.a.b();
    }
}
