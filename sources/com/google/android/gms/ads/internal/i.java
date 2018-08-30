package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzjj;

final class i implements Runnable {
    private final /* synthetic */ zzjj a;
    private final /* synthetic */ h b;

    i(h hVar, zzjj zzjj) {
        this.b = hVar;
        this.a = zzjj;
    }

    public final void run() {
        synchronized (this.b.s) {
            if (this.b.a()) {
                this.b.a(this.a);
            } else {
                this.b.a(this.a, 1);
            }
        }
    }
}
