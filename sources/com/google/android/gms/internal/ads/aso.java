package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final /* synthetic */ class aso implements Runnable {
    private final asn a;
    private final zzv b;
    private final Map c;

    aso(asn asn, zzv zzv, Map map) {
        this.a = asn;
        this.b = zzv;
        this.c = map;
    }

    public final void run() {
        asn asn = this.a;
        this.b.zza(asn.f(), this.c);
    }
}
