package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;

final class gy extends hg {
    private final /* synthetic */ gw a;

    gy(gw gwVar) {
        this.a = gwVar;
    }

    public final void a() {
        amp amp = new amp(this.a.f, this.a.g.a);
        synchronized (this.a.a) {
            try {
                au.n();
                ams.a(this.a.h, amp);
            } catch (Throwable e) {
                kk.c("Cannot config CSI reporter.", e);
            }
        }
    }

    public final void b() {
    }
}
