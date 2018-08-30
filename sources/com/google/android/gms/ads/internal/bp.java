package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.anq;
import com.google.android.gms.internal.ads.kk;

final class bp implements Runnable {
    private final /* synthetic */ anq a;
    private final /* synthetic */ bl b;

    bp(bl blVar, anq anq) {
        this.b = blVar;
        this.a = anq;
    }

    public final void run() {
        try {
            if (this.b.e.s != null) {
                this.b.e.s.zza(this.a);
                this.b.a(this.a.zzka());
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
