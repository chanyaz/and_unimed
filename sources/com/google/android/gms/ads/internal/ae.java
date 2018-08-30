package com.google.android.gms.ads.internal;

import android.os.Bundle;
import com.google.android.gms.internal.ads.ana;
import com.google.android.gms.internal.ads.cp;
import com.google.android.gms.internal.ads.gs;
import com.google.android.gms.internal.ads.kq;
import com.google.android.gms.internal.ads.zzaef;
import com.google.android.gms.internal.ads.zzjj;
import com.google.android.gms.internal.ads.zzpb;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

final class ae implements Callable<zzpb> {
    private final /* synthetic */ int a;
    private final /* synthetic */ JSONArray b;
    private final /* synthetic */ int c;
    private final /* synthetic */ gs d;
    private final /* synthetic */ ac e;

    ae(ac acVar, int i, JSONArray jSONArray, int i2, gs gsVar) {
        this.e = acVar;
        this.a = i;
        this.b = jSONArray;
        this.c = i2;
        this.d = gsVar;
    }

    public final /* synthetic */ Object call() {
        if (this.a >= this.b.length()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.b.get(this.a));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ads", jSONArray);
        a acVar = new ac(this.e.e.c, this.e.i, this.e.e.i, this.e.e.b, this.e.j, this.e.e.e, true);
        ac.a(this.e.e, acVar.e);
        acVar.k();
        acVar.a(this.e.b);
        ana ana = acVar.a;
        int i = this.a;
        ana.a("num_ads_requested", String.valueOf(this.c));
        ana.a("ad_index", String.valueOf(i));
        zzaef zzaef = this.d.a;
        String jSONObject2 = jSONObject.toString();
        Bundle bundle = zzaef.c.c != null ? new Bundle(zzaef.c.c) : new Bundle();
        bundle.putString("_ad", jSONObject2);
        acVar.a(new cp(zzaef.b, new zzjj(zzaef.c.a, zzaef.c.b, bundle, zzaef.c.d, zzaef.c.e, zzaef.c.f, zzaef.c.g, zzaef.c.h, zzaef.c.i, zzaef.c.j, zzaef.c.k, zzaef.c.l, zzaef.c.m, zzaef.c.n, zzaef.c.o, zzaef.c.p, zzaef.c.q, zzaef.c.r), zzaef.d, zzaef.e, zzaef.f, zzaef.g, zzaef.i, zzaef.j, zzaef.k, zzaef.l, zzaef.n, zzaef.z, zzaef.o, zzaef.p, zzaef.q, zzaef.r, zzaef.s, zzaef.t, zzaef.u, zzaef.v, zzaef.w, zzaef.x, zzaef.y, zzaef.B, zzaef.C, zzaef.I, zzaef.D, zzaef.E, zzaef.F, zzaef.G, kq.a(zzaef.H), zzaef.J, zzaef.K, zzaef.L, zzaef.M, zzaef.N, zzaef.O, zzaef.P, zzaef.Q, zzaef.U, kq.a(zzaef.h), zzaef.V, zzaef.W, zzaef.X, 1, zzaef.Z, zzaef.aa, zzaef.ab, zzaef.ac), acVar.a);
        return (zzpb) acVar.m().get();
    }
}
