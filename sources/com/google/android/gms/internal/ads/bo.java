package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final class bo implements zzanl<zzaqw> {
    private final /* synthetic */ String a;
    private final /* synthetic */ JSONObject b;

    bo(bf bfVar, String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    public final void zzb(Throwable th) {
    }

    public final /* synthetic */ void zzh(Object obj) {
        ((zzaqw) obj).zza(this.a, this.b);
    }
}
