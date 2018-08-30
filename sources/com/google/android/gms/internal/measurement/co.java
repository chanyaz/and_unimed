package com.google.android.gms.internal.measurement;

final class co implements Runnable {
    private final /* synthetic */ long a;
    private final /* synthetic */ cl b;

    co(cl clVar, long j) {
        this.b = clVar;
        this.a = j;
    }

    public final void run() {
        this.b.b(this.a);
    }
}
