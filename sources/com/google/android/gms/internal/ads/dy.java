package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class dy implements zzv<Object> {
    private final /* synthetic */ dv a;

    dy(dv dvVar) {
        this.a = dvVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.a.b) {
            if (this.a.e.isDone()) {
                return;
            }
            ea eaVar = new ea(-2, map);
            if (this.a.c.equals(eaVar.h())) {
                this.a.e.b(eaVar);
                return;
            }
        }
    }
}
