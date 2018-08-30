package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@Class(creator = "AdResponseParcelCreator")
@ParametersAreNonnullByDefault
public final class zzaej extends AbstractSafeParcelable {
    public static final Creator<zzaej> CREATOR = new cs();
    @Nullable
    @Field(id = 33)
    public final zzaig A;
    @Nullable
    @Field(id = 34)
    public final List<String> B;
    @Nullable
    @Field(id = 35)
    public final List<String> C;
    @Field(id = 36)
    public final boolean D;
    @Nullable
    @Field(id = 37)
    public final zzael E;
    @Field(id = 38)
    public final boolean F;
    @Nullable
    @Field(id = 39)
    public String G;
    @Field(id = 40)
    public final List<String> H;
    @Field(id = 42)
    public final boolean I;
    @Nullable
    @Field(id = 43)
    public final String J;
    @Nullable
    @Field(id = 44)
    public final zzaiq K;
    @Nullable
    @Field(id = 45)
    public final String L;
    @Field(id = 46)
    public final boolean M;
    @Field(id = 47)
    public final boolean N;
    @Field(id = 49)
    public final boolean O;
    @Field(id = 50)
    public final int P;
    @Field(id = 51)
    public final boolean Q;
    @Field(id = 52)
    public final List<String> R;
    @Field(id = 53)
    public final boolean S;
    @Nullable
    @Field(id = 54)
    public final String T;
    private zzaef U;
    @Field(id = 1)
    private final int V;
    @Field(id = 28)
    private zzaev W;
    @Field(id = 48)
    private Bundle X;
    @Field(id = 2)
    public final String a;
    @Field(id = 3)
    public String b;
    @Field(id = 4)
    public final List<String> c;
    @Field(id = 5)
    public final int d;
    @Field(id = 6)
    public final List<String> e;
    @Field(id = 7)
    public final long f;
    @Field(id = 8)
    public final boolean g;
    @Field(id = 9)
    public final long h;
    @Field(id = 10)
    public final List<String> i;
    @Field(id = 11)
    public final long j;
    @Field(id = 12)
    public final int k;
    @Field(id = 13)
    public final String l;
    @Field(id = 14)
    public final long m;
    @Field(id = 15)
    public final String n;
    @Field(id = 18)
    public final boolean o;
    @Field(id = 19)
    public final String p;
    @Field(id = 21)
    public final String q;
    @Field(id = 22)
    public final boolean r;
    @Field(id = 23)
    public final boolean s;
    @Field(id = 24)
    public final boolean t;
    @Field(id = 25)
    public final boolean u;
    @Field(id = 26)
    public final boolean v;
    @Field(id = 29)
    public String w;
    @Field(id = 30)
    public final String x;
    @Field(id = 31)
    public final boolean y;
    @Field(id = 32)
    public final boolean z;

    public zzaej(int i) {
        this(19, null, null, null, i, null, -1, false, -1, null, -1, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null);
    }

    public zzaej(int i, long j) {
        this(19, null, null, null, i, null, -1, false, -1, null, j, -1, null, -1, null, false, null, null, false, false, false, true, false, null, null, null, false, false, null, null, null, false, null, false, null, null, false, null, null, null, true, false, null, false, 0, false, null, false, null);
    }

    @Constructor
    zzaej(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) List<String> list, @Param(id = 5) int i2, @Param(id = 6) List<String> list2, @Param(id = 7) long j, @Param(id = 8) boolean z, @Param(id = 9) long j2, @Param(id = 10) List<String> list3, @Param(id = 11) long j3, @Param(id = 12) int i3, @Param(id = 13) String str3, @Param(id = 14) long j4, @Param(id = 15) String str4, @Param(id = 18) boolean z2, @Param(id = 19) String str5, @Param(id = 21) String str6, @Param(id = 22) boolean z3, @Param(id = 23) boolean z4, @Param(id = 24) boolean z5, @Param(id = 25) boolean z6, @Param(id = 26) boolean z7, @Param(id = 28) zzaev zzaev, @Param(id = 29) String str7, @Param(id = 30) String str8, @Param(id = 31) boolean z8, @Param(id = 32) boolean z9, @Param(id = 33) zzaig zzaig, @Param(id = 34) List<String> list4, @Param(id = 35) List<String> list5, @Param(id = 36) boolean z10, @Param(id = 37) zzael zzael, @Param(id = 38) boolean z11, @Param(id = 39) String str9, @Param(id = 40) List<String> list6, @Param(id = 42) boolean z12, @Param(id = 43) String str10, @Param(id = 44) zzaiq zzaiq, @Param(id = 45) String str11, @Param(id = 46) boolean z13, @Param(id = 47) boolean z14, @Param(id = 48) Bundle bundle, @Param(id = 49) boolean z15, @Param(id = 50) int i4, @Param(id = 51) boolean z16, @Param(id = 52) List<String> list7, @Param(id = 53) boolean z17, @Param(id = 54) String str12) {
        this.V = i;
        this.a = str;
        this.b = str2;
        this.c = list != null ? Collections.unmodifiableList(list) : null;
        this.d = i2;
        this.e = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.f = j;
        this.g = z;
        this.h = j2;
        this.i = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.j = j3;
        this.k = i3;
        this.l = str3;
        this.m = j4;
        this.n = str4;
        this.o = z2;
        this.p = str5;
        this.q = str6;
        this.r = z3;
        this.s = z4;
        this.t = z5;
        this.u = z6;
        this.M = z13;
        this.v = z7;
        this.W = zzaev;
        this.w = str7;
        this.x = str8;
        if (this.b == null && this.W != null) {
            zzafj zzafj = (zzafj) this.W.a(zzafj.CREATOR);
            if (!(zzafj == null || TextUtils.isEmpty(zzafj.a))) {
                this.b = zzafj.a;
            }
        }
        this.y = z8;
        this.z = z9;
        this.A = zzaig;
        this.B = list4;
        this.C = list5;
        this.D = z10;
        this.E = zzael;
        this.F = z11;
        this.G = str9;
        this.H = list6;
        this.I = z12;
        this.J = str10;
        this.K = zzaiq;
        this.L = str11;
        this.N = z14;
        this.X = bundle;
        this.O = z15;
        this.P = i4;
        this.Q = z16;
        this.R = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.S = z17;
        this.T = str12;
    }

    public zzaej(zzaef zzaef, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, zzaig zzaig, List<String> list4, List<String> list5, boolean z9, zzael zzael, boolean z10, String str7, List<String> list6, boolean z11, String str8, zzaiq zzaiq, String str9, boolean z12, boolean z13, boolean z14, int i2, boolean z15, List<String> list7, boolean z16, String str10) {
        this(19, str, str2, list, -2, list2, j, z, -1, list3, j3, i, str3, j4, str4, false, null, str5, z2, z3, z4, z5, false, null, null, str6, z7, z8, zzaig, list4, list5, z9, zzael, z10, str7, list6, z11, str8, zzaiq, str9, z12, z13, null, z14, i2, z15, list7, z16, str10);
        this.U = zzaef;
    }

    public zzaej(zzaef zzaef, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, zzaig zzaig, List<String> list4, List<String> list5, boolean z10, zzael zzael, boolean z11, String str8, List<String> list6, boolean z12, String str9, zzaiq zzaiq, String str10, boolean z13, boolean z14, boolean z15, int i2, boolean z16, List<String> list7, boolean z17, String str11) {
        this(19, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, null, null, str7, z8, z9, zzaig, list4, list5, z10, zzael, z11, str8, list6, z12, str9, zzaiq, str10, z13, z14, null, z15, 0, z16, list7, z17, str11);
        this.U = zzaef;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        if (!(this.U == null || this.U.a < 9 || TextUtils.isEmpty(this.b))) {
            this.W = new zzaev(new zzafj(this.b));
            this.b = null;
        }
        int a = a.a(parcel);
        a.a(parcel, 1, this.V);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b, false);
        a.b(parcel, 4, this.c, false);
        a.a(parcel, 5, this.d);
        a.b(parcel, 6, this.e, false);
        a.a(parcel, 7, this.f);
        a.a(parcel, 8, this.g);
        a.a(parcel, 9, this.h);
        a.b(parcel, 10, this.i, false);
        a.a(parcel, 11, this.j);
        a.a(parcel, 12, this.k);
        a.a(parcel, 13, this.l, false);
        a.a(parcel, 14, this.m);
        a.a(parcel, 15, this.n, false);
        a.a(parcel, 18, this.o);
        a.a(parcel, 19, this.p, false);
        a.a(parcel, 21, this.q, false);
        a.a(parcel, 22, this.r);
        a.a(parcel, 23, this.s);
        a.a(parcel, 24, this.t);
        a.a(parcel, 25, this.u);
        a.a(parcel, 26, this.v);
        a.a(parcel, 28, this.W, i, false);
        a.a(parcel, 29, this.w, false);
        a.a(parcel, 30, this.x, false);
        a.a(parcel, 31, this.y);
        a.a(parcel, 32, this.z);
        a.a(parcel, 33, this.A, i, false);
        a.b(parcel, 34, this.B, false);
        a.b(parcel, 35, this.C, false);
        a.a(parcel, 36, this.D);
        a.a(parcel, 37, this.E, i, false);
        a.a(parcel, 38, this.F);
        a.a(parcel, 39, this.G, false);
        a.b(parcel, 40, this.H, false);
        a.a(parcel, 42, this.I);
        a.a(parcel, 43, this.J, false);
        a.a(parcel, 44, this.K, i, false);
        a.a(parcel, 45, this.L, false);
        a.a(parcel, 46, this.M);
        a.a(parcel, 47, this.N);
        a.a(parcel, 48, this.X, false);
        a.a(parcel, 49, this.O);
        a.a(parcel, 50, this.P);
        a.a(parcel, 51, this.Q);
        a.b(parcel, 52, this.R, false);
        a.a(parcel, 53, this.S);
        a.a(parcel, 54, this.T, false);
        a.a(parcel, a);
    }
}
