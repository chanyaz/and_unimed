package com.google.android.gms.internal.ads;

final class anr implements Runnable {
    private final /* synthetic */ anq a;

    anr(anq anq) {
        this.a = anq;
    }

    public final void run() {
        if (this.a.n != null) {
            this.a.n.zzkq();
            this.a.n.zzkp();
            this.a.n.zzcs();
        }
        this.a.n = null;
    }
}
