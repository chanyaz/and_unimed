package com.google.android.gms.internal.measurement;

final class ac implements Runnable {
    private final /* synthetic */ zzca a;
    private final /* synthetic */ y b;

    ac(y yVar, zzca zzca) {
        this.b = yVar;
        this.a = zzca;
    }

    public final void run() {
        this.b.a.a(this.a);
    }
}
