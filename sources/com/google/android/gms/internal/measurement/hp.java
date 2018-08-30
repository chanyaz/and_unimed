package com.google.android.gms.internal.measurement;

final class hp implements Runnable {
    private final /* synthetic */ long a;
    private final /* synthetic */ hm b;

    hp(hm hmVar, long j) {
        this.b = hmVar;
        this.a = j;
    }

    public final void run() {
        this.b.a(this.a);
    }
}
