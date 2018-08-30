package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.internal.ads.hg;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
final class o extends hg {
    final /* synthetic */ l a;
    private final int b;

    public o(l lVar, int i) {
        this.a = lVar;
        this.b = i;
    }

    public final void a() {
        zzaq zzaq = new zzaq(this.a.e.J, this.a.j(), this.a.m, this.a.n, this.a.e.J ? this.b : -1, this.a.o, this.a.e.j.L, this.a.e.j.O);
        int requestedOrientation = this.a.e.j.b.getRequestedOrientation();
        if (requestedOrientation == -1) {
            requestedOrientation = this.a.e.j.h;
        }
        ht.a.post(new p(this, new AdOverlayInfoParcel(this.a, this.a, this.a, this.a.e.j.b, requestedOrientation, this.a.e.e, this.a.e.j.A, zzaq)));
    }

    public final void b() {
    }
}
