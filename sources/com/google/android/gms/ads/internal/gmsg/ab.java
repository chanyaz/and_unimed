package com.google.android.gms.ads.internal.gmsg;

import com.appnext.base.b.c;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;

final class ab implements zzv<zzaqw> {
    ab() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        String str = (String) map.get(c.jD);
        if ("pause".equals(str)) {
            zzaqw.zzcl();
        } else if ("resume".equals(str)) {
            zzaqw.zzcm();
        }
    }
}
