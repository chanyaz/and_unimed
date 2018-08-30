package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.anv;
import com.google.android.gms.internal.ads.kk;

final class bn implements Runnable {
    private final /* synthetic */ anv a;
    private final /* synthetic */ bl b;

    bn(bl blVar, anv anv) {
        this.b = blVar;
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
