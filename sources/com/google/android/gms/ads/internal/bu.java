package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.zzasg;

final /* synthetic */ class bu implements zzasg {
    private final gr a;
    private final Runnable b;

    bu(gr grVar, Runnable runnable) {
        this.a = grVar;
        this.b = runnable;
    }

    public final void zzda() {
        gr grVar = this.a;
        Runnable runnable = this.b;
        if (!grVar.m) {
            au.e();
            ht.a(runnable);
        }
    }
}
