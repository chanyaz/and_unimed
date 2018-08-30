package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.gs;

final class bf implements Runnable {
    private final /* synthetic */ gs a;
    private final /* synthetic */ bd b;

    bf(bd bdVar, gs gsVar) {
        this.b = bdVar;
        this.a = gsVar;
    }

    public final void run() {
        this.b.zzb(new gr(this.a, null, null, null, null, null, null, null));
    }
}
