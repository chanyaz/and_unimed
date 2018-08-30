package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class aoe implements zzv<Object> {
    private final /* synthetic */ zzacm a;
    private final /* synthetic */ aob b;

    aoe(aob aob, zzacm zzacm) {
        this.b = aob;
        this.a = zzacm;
    }

    public final void zza(Object obj, Map<String, String> map) {
        zzaqw zzaqw = (zzaqw) this.b.a.get();
        if (zzaqw == null) {
            this.a.zzb("/showOverlay", this);
        } else {
            zzaqw.getView().setVisibility(0);
        }
    }
}
