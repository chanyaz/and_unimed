package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;

final class ad implements Runnable {
    private final /* synthetic */ gs a;
    private final /* synthetic */ ac b;

    ad(ac acVar, gs gsVar) {
        this.b = acVar;
        this.a = gsVar;
    }

    public final void run() {
        this.b.zzb(new gr(this.a, null, null, null, null, null, null, null));
    }
}
