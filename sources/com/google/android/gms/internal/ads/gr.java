package com.google.android.gms.internal.ads;

import android.support.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@zzadh
@ParametersAreNonnullByDefault
public final class gr {
    public final String A;
    public final String B;
    @Nullable
    public final zzpb C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    @Nullable
    public final List<String> J;
    public final ahx K;
    public final boolean L;
    public final boolean M;
    public final boolean N;
    public final boolean O;
    private final zzael P;
    private final long Q;
    private final long R;
    private final String S;
    public final zzjj a;
    @Nullable
    public final zzaqw b;
    public final List<String> c;
    public final int d;
    public final List<String> e;
    public final List<String> f;
    public final List<String> g;
    public final int h;
    public final long i;
    public final String j;
    public final JSONObject k;
    public final boolean l;
    public boolean m;
    public final boolean n;
    @Nullable
    public final auh o;
    @Nullable
    public final zzxq p;
    @Nullable
    public final String q;
    public final aui r;
    @Nullable
    public final auk s;
    @Nullable
    public final String t;
    public final zzjn u;
    @Nullable
    public final zzaig v;
    @Nullable
    public final List<String> w;
    @Nullable
    public final List<String> x;
    public final long y;
    public final long z;

    public gr(gs gsVar, @Nullable zzaqw zzaqw, @Nullable auh auh, @Nullable zzxq zzxq, @Nullable String str, @Nullable auk auk, @Nullable zzpb zzpb, @Nullable String str2) {
        this(gsVar.a.c, null, gsVar.b.c, gsVar.e, gsVar.b.e, gsVar.b.i, gsVar.b.k, gsVar.b.j, gsVar.a.i, gsVar.b.g, null, null, null, gsVar.c, null, gsVar.b.h, gsVar.d, gsVar.b.f, gsVar.f, gsVar.g, gsVar.b.n, gsVar.h, null, gsVar.b.A, gsVar.b.B, gsVar.b.B, gsVar.b.D, gsVar.b.E, null, gsVar.b.H, gsVar.b.L, gsVar.i, gsVar.b.O, gsVar.j, gsVar.b.Q, gsVar.b.R, gsVar.b.S, gsVar.b.T);
    }

    public gr(zzjj zzjj, @Nullable zzaqw zzaqw, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable auh auh, @Nullable zzxq zzxq, @Nullable String str2, aui aui, @Nullable auk auk, long j2, zzjn zzjn, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable zzpb zzpb, zzaig zzaig, List<String> list4, List<String> list5, boolean z2, zzael zzael, @Nullable String str4, List<String> list6, String str5, ahx ahx, boolean z3, boolean z4, boolean z5, List<String> list7, boolean z6, String str6) {
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.a = zzjj;
        this.b = zzaqw;
        this.c = a(list);
        this.d = i;
        this.e = a(list2);
        this.g = a(list3);
        this.h = i2;
        this.i = j;
        this.j = str;
        this.n = z;
        this.o = auh;
        this.p = zzxq;
        this.q = str2;
        this.r = aui;
        this.s = auk;
        this.Q = j2;
        this.u = zzjn;
        this.R = j3;
        this.y = j4;
        this.z = j5;
        this.A = str3;
        this.k = jSONObject;
        this.C = zzpb;
        this.v = zzaig;
        this.w = a(list4);
        this.x = a(list5);
        this.l = z2;
        this.P = zzael;
        this.t = str4;
        this.J = a(list6);
        this.B = str5;
        this.K = ahx;
        this.L = z3;
        this.M = z4;
        this.N = z5;
        this.f = a(list7);
        this.O = z6;
        this.S = str6;
    }

    @Nullable
    private static <T> List<T> a(@Nullable List<T> list) {
        return list == null ? null : Collections.unmodifiableList(list);
    }

    public final boolean a() {
        return (this.b == null || this.b.zzuf() == null) ? false : this.b.zzuf().zzfz();
    }
}
