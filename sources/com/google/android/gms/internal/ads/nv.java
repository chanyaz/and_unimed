package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzn;

final class nv implements zzn {
    private zzaqw a;
    private zzn b;

    public nv(zzaqw zzaqw, zzn zzn) {
        this.a = zzaqw;
        this.b = zzn;
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zzcb() {
        this.b.zzcb();
        this.a.zzty();
    }

    public final void zzcc() {
        this.b.zzcc();
        this.a.zzno();
    }
}
