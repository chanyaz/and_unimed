package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzqs;
import com.google.android.gms.internal.ads.zzrf;

final class ak implements Runnable {
    private final /* synthetic */ zzqs a;
    private final /* synthetic */ ac b;

    ak(ac acVar, zzqs zzqs) {
        this.b = acVar;
        this.a = zzqs;
    }

    public final void run() {
        try {
            ((zzrf) this.b.e.v.get(this.a.getCustomTemplateId())).zzb(this.a);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
