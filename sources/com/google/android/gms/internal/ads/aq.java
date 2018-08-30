package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.gmsg.zzv;
import java.util.Map;

final class aq implements zzv<Object> {
    private final /* synthetic */ ans a;
    private final /* synthetic */ am b;

    aq(am amVar, ans ans) {
        this.b = amVar;
        this.a = ans;
    }

    public final void zza(Object obj, Map<String, String> map) {
        this.b.a(this.a, (String) map.get("asset"));
    }
}
