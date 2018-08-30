package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzn;

final class aws implements zzn {
    private final /* synthetic */ zzzv a;

    aws(zzzv zzzv) {
        this.a = zzzv;
    }

    public final void onPause() {
        kk.b("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        kk.b("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzcb() {
        kk.b("AdMobCustomTabsAdapter overlay is closed.");
        this.a.b.onAdClosed(this.a);
    }

    public final void zzcc() {
        kk.b("Opening AdMobCustomTabsAdapter overlay.");
        this.a.b.onAdOpened(this.a);
    }
}
