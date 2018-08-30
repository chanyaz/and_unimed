package com.google.android.gms.internal.ads;

final class bt implements Runnable {
    private final /* synthetic */ kl a;
    private final /* synthetic */ String b;

    bt(bq bqVar, kl klVar, String str) {
        this.a = klVar;
        this.b = str;
    }

    public final void run() {
        this.a.zzcz(this.b);
    }
}
