package com.google.android.gms.internal.measurement;

final /* synthetic */ class cc implements Runnable {
    private final cb a;
    private final int b;
    private final bt c;

    cc(cb cbVar, int i, bt btVar) {
        this.a = cbVar;
        this.b = i;
        this.c = btVar;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
