package com.google.android.gms.internal.ads;

final class aqe implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ long b;
    private final /* synthetic */ apk c;

    aqe(apk apk, String str, long j) {
        this.c = apk;
        this.a = str;
        this.b = j;
    }

    public final void run() {
        this.c.a.a(this.a, this.b);
        this.c.a.a(toString());
    }
}
