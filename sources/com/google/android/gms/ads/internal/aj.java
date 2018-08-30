package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.ans;
import com.google.android.gms.internal.ads.gr;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzrf;

final class aj implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ gr b;
    private final /* synthetic */ ac c;

    aj(ac acVar, String str, gr grVar) {
        this.c = acVar;
        this.a = str;
        this.b = grVar;
    }

    public final void run() {
        try {
            ((zzrf) this.c.e.v.get(this.a)).zzb((ans) this.b.C);
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
