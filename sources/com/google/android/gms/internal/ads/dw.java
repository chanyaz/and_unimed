package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class dw implements zzv<Object> {
    private final /* synthetic */ dv a;

    dw(dv dvVar) {
        this.a = dvVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.a.b) {
            if (this.a.e.isDone()) {
            } else if (this.a.c.equals(map.get("request_id"))) {
                ea eaVar = new ea(1, map);
                String f = eaVar.f();
                String valueOf = String.valueOf(eaVar.b());
                kk.e(new StringBuilder((String.valueOf(f).length() + 24) + String.valueOf(valueOf).length()).append("Invalid ").append(f).append(" request error: ").append(valueOf).toString());
                this.a.e.b(eaVar);
            }
        }
    }
}
