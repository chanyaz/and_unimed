package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.k;

final class awt implements Runnable {
    private final /* synthetic */ AdOverlayInfoParcel a;
    private final /* synthetic */ zzzv b;

    awt(zzzv zzzv, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.b = zzzv;
        this.a = adOverlayInfoParcel;
    }

    public final void run() {
        au.c();
        k.a(this.b.a, this.a, true);
    }
}
