package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

@zzadh
public final class cr extends cw {
    private final WeakReference<zzadx> a;

    public cr(zzadx zzadx) {
        this.a = new WeakReference(zzadx);
    }

    public final void zza(zzaej zzaej) {
        zzadx zzadx = (zzadx) this.a.get();
        if (zzadx != null) {
            zzadx.zza(zzaej);
        }
    }
}
