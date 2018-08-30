package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.anv;
import com.google.android.gms.internal.ads.kk;

final class ah implements Runnable {
    private final /* synthetic */ anv a;
    private final /* synthetic */ ac b;

    ah(ac acVar, anv anv) {
        this.b = acVar;
        this.a = anv;
    }

    public final void run() {
        try {
            if (this.b.e.t != null) {
                this.b.e.t.zza(this.a);
                this.b.a(this.a.zzka());
            }
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
