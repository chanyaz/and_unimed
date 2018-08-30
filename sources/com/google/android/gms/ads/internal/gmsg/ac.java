package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;

final class ac implements zzv<zzaqw> {
    ac() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        if (map.keySet().contains("start")) {
            zzaqw.zzuf().zzva();
        } else if (map.keySet().contains("stop")) {
            zzaqw.zzuf().zzvb();
        } else if (map.keySet().contains("cancel")) {
            zzaqw.zzuf().zzvc();
        }
    }
}
