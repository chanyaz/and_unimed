package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzjj;

final class j implements Runnable {
    private final /* synthetic */ zzjj a;
    private final /* synthetic */ int b;
    private final /* synthetic */ h c;

    j(h hVar, zzjj zzjj, int i) {
        this.c = hVar;
        this.a = zzjj;
        this.b = i;
    }

    public final void run() {
        synchronized (this.c.s) {
            this.c.a(this.a, this.b);
        }
    }
}
