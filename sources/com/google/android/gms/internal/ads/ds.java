package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;

final class ds implements Runnable {
    private final /* synthetic */ zzaef a;
    private final /* synthetic */ zzaeq b;
    private final /* synthetic */ dq c;

    ds(dq dqVar, zzaef zzaef, zzaeq zzaeq) {
        this.c = dqVar;
        this.a = zzaef;
        this.b = zzaeq;
    }

    public final void run() {
        zzaej zzb;
        try {
            zzb = this.c.zzb(this.a);
        } catch (Throwable e) {
            au.i().a(e, "AdRequestServiceImpl.loadAdAsync");
            kk.c("Could not fetch ad response due to an Exception.", e);
            zzb = null;
        }
        if (zzb == null) {
            zzb = new zzaej(0);
        }
        try {
            this.b.zza(zzb);
        } catch (Throwable e2) {
            kk.c("Fail to forward ad response.", e2);
        }
    }
}
