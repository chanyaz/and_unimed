package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class dx implements zzv<Object> {
    private final /* synthetic */ dv a;

    dx(dv dvVar) {
        this.a = dvVar;
    }

    public final void zza(Object obj, Map<String, String> map) {
        synchronized (this.a.b) {
            if (this.a.e.isDone()) {
                return;
            }
            ea eaVar = new ea(-2, map);
            if (this.a.c.equals(eaVar.h())) {
                String e = eaVar.e();
                if (e == null) {
                    kk.e("URL missing in loadAdUrl GMSG.");
                    return;
                }
                if (e.contains("%40mediation_adapters%40")) {
                    String replaceAll = e.replaceAll("%40mediation_adapters%40", hf.a(this.a.a, (String) map.get("check_adapters"), this.a.d));
                    eaVar.a(replaceAll);
                    e = "Ad request URL modified to ";
                    replaceAll = String.valueOf(replaceAll);
                    hl.a(replaceAll.length() != 0 ? e.concat(replaceAll) : new String(e));
                }
                this.a.e.b(eaVar);
                return;
            }
        }
    }
}
