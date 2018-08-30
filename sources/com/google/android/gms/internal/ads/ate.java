package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class ate implements zzv<zzwb> {
    private final /* synthetic */ ada a;
    private final /* synthetic */ zzuu b;
    private final /* synthetic */ jr c;
    private final /* synthetic */ asy d;

    ate(asy asy, ada ada, zzuu zzuu, jr jrVar) {
        this.d = asy;
        this.a = ada;
        this.b = zzuu;
        this.c = jrVar;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        synchronized (this.d.a) {
            kk.d("JS Engine is requesting an update");
            if (this.d.h == 0) {
                kk.d("Starting reload.");
                this.d.h = 2;
                this.d.a(this.a);
            }
            this.b.zzb("/requestReload", (zzv) this.c.a());
        }
    }
}
