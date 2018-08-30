package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzqs;
import com.google.android.gms.internal.ads.zzrf;

final class bq implements Runnable {
    private final /* synthetic */ zzqs a;
    private final /* synthetic */ bl b;

    bq(bl blVar, zzqs zzqs) {
        this.b = blVar;
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
