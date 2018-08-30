package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzaqw;
import java.util.Map;

final class w implements zzv<zzaqw> {
    w() {
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        c zzub = zzaqw.zzub();
        if (zzub != null) {
            zzub.a();
            return;
        }
        zzub = zzaqw.zzuc();
        if (zzub != null) {
            zzub.a();
        } else {
            kk.e("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
