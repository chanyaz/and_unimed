package com.google.android.gms.internal.measurement;

final class hq implements Runnable {
    private final /* synthetic */ long a;
    private final /* synthetic */ hm b;

    hq(hm hmVar, long j) {
        this.b = hmVar;
        this.a = j;
    }

    public final void run() {
        this.b.b(this.a);
    }
}
