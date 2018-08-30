package com.google.android.gms.internal.ads;

final /* synthetic */ class an implements Runnable {
    private final am a;
    private final lk b;
    private final String c;

    an(am amVar, lk lkVar, String str) {
        this.a = amVar;
        this.b = lkVar;
        this.c = str;
    }

    public final void run() {
        this.a.a(this.b, this.c);
    }
}
