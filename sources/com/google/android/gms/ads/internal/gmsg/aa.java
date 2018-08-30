package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;

final class aa implements zzv<zzaqw> {
    aa() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        if (((Boolean) akc.f().a(amn.bt)).booleanValue()) {
            zzaqw.zzaj(!Boolean.parseBoolean((String) map.get("disabled")));
        }
    }
}
