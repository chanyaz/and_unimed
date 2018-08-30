package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.gmsg.zzv;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.internal.ads.kk;
import com.google.android.gms.internal.ads.zzaqw;
import com.google.android.gms.internal.ads.zzxz;
import com.google.android.gms.internal.ads.zzyc;
import java.util.Map;

final class w implements zzv<zzaqw> {
    private final /* synthetic */ zzxz a;
    private final /* synthetic */ d b;
    private final /* synthetic */ zzyc c;

    w(zzxz zzxz, d dVar, zzyc zzyc) {
        this.a = zzxz;
        this.b = dVar;
        this.c = zzyc;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzaqw zzaqw = (zzaqw) obj;
        Object view = zzaqw.getView();
        if (view != null) {
            try {
                if (this.a != null) {
                    if (this.a.getOverrideClickHandling()) {
                        r.b(zzaqw);
                        return;
                    }
                    this.a.zzj(c.a(view));
                    this.b.a.onAdClicked();
                } else if (this.c == null) {
                } else {
                    if (this.c.getOverrideClickHandling()) {
                        r.b(zzaqw);
                        return;
                    }
                    this.c.zzj(c.a(view));
                    this.b.a.onAdClicked();
                }
            } catch (Throwable e) {
                kk.c("Unable to call handleClick on mapper", e);
            }
        }
    }
}
