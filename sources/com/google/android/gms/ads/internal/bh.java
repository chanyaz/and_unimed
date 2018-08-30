package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.gr;

final class bh implements Runnable {
    private final /* synthetic */ bg a;

    bh(bg bgVar) {
        this.a = bgVar;
    }

    public final void run() {
        this.a.c.zzb(new gr(this.a.a, null, null, null, null, null, null, null));
    }
}
