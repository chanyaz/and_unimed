package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.ano;
import com.google.android.gms.internal.ads.kk;

final class ag implements Runnable {
    private final /* synthetic */ ano a;
    private final /* synthetic */ ac b;

    ag(ac acVar, ano ano) {
        this.b = acVar;
        this.a = ano;
    }

    public final void run() {
        try {
            if (this.b.e.r != null) {
                this.b.e.r.zza(this.a);
                this.b.a(this.a.zzka());
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
