package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.k;

final class p implements Runnable {
    private final /* synthetic */ AdOverlayInfoParcel a;
    private final /* synthetic */ o b;

    p(o oVar, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.b = oVar;
        this.a = adOverlayInfoParcel;
    }

    public final void run() {
        au.c();
        k.a(this.b.a.e.c, this.a, true);
    }
}
