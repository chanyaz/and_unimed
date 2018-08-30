package com.google.android.gms.internal.measurement;

final class hl implements Runnable {
    private final /* synthetic */ hw a;
    private final /* synthetic */ Runnable b;

    hl(hi hiVar, hw hwVar, Runnable runnable) {
        this.a = hwVar;
        this.b = runnable;
    }

    public final void run() {
        this.a.D();
        this.a.a(this.b);
        this.a.C();
    }
}
