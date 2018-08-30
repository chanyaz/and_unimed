package com.google.android.gms.internal.ads;

import org.json.JSONObject;

final class dg implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ String b;
    private final /* synthetic */ de c;

    dg(de deVar, JSONObject jSONObject, String str) {
        this.c = deVar;
        this.a = jSONObject;
        this.b = str;
    }

    public final void run() {
        this.c.l = de.d.b(null);
        this.c.l.zza(new dh(this), new di(this));
    }
}
