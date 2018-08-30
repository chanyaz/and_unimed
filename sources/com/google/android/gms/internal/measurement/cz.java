package com.google.android.gms.internal.measurement;

final class cz implements Runnable {
    private final /* synthetic */ zzhi a;
    private final /* synthetic */ cy b;

    cz(cy cyVar, zzhi zzhi) {
        this.b = cyVar;
        this.a = zzhi;
    }

    public final void run() {
        this.a.zzgd();
        if (en.r()) {
            this.a.zzgd().a((Runnable) this);
            return;
        }
        boolean b = this.b.b();
        this.b.d = 0;
        if (b) {
            this.b.a();
        }
    }
}
