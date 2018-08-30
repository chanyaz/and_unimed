package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
public final class zzaef extends AbstractSafeParcelable {
    public static final Creator<zzaef> CREATOR = new cq();
    @Field(id = 31)
    public final long A;
    @Field(id = 33)
    public final String B;
    @Field(id = 34)
    public final float C;
    @Field(id = 35)
    public final int D;
    @Field(id = 36)
    public final int E;
    @Field(id = 37)
    public final boolean F;
    @Field(id = 38)
    public final boolean G;
    @Field(id = 39)
    public final String H;
    @Field(id = 40)
    public final boolean I;
    @Field(id = 41)
    public final String J;
    @Field(id = 42)
    public final boolean K;
    @Field(id = 43)
    public final int L;
    @Field(id = 44)
    public final Bundle M;
    @Field(id = 45)
    public final String N;
    @Nullable
    @Field(id = 46)
    public final zzlu O;
    @Field(id = 47)
    public final boolean P;
    @Field(id = 48)
    public final Bundle Q;
    @Nullable
    @Field(id = 49)
    public final String R;
    @Nullable
    @Field(id = 50)
    public final String S;
    @Nullable
    @Field(id = 51)
    public final String T;
    @Field(id = 52)
    public final boolean U;
    @Field(id = 53)
    public final List<Integer> V;
    @Field(id = 54)
    public final String W;
    @Field(id = 55)
    public final List<String> X;
    @Field(id = 56)
    public final int Y;
    @Field(id = 57)
    public final boolean Z;
    @Field(id = 1)
    public final int a;
    @Field(id = 58)
    public final boolean aa;
    @Field(id = 59)
    public final boolean ab;
    @Field(id = 60)
    public final ArrayList<String> ac;
    @Nullable
    @Field(id = 2)
    public final Bundle b;
    @Field(id = 3)
    public final zzjj c;
    @Field(id = 4)
    public final zzjn d;
    @Field(id = 5)
    public final String e;
    @Field(id = 6)
    public final ApplicationInfo f;
    @Nullable
    @Field(id = 7)
    public final PackageInfo g;
    @Field(id = 8)
    public final String h;
    @Field(id = 9)
    public final String i;
    @Field(id = 10)
    public final String j;
    @Field(id = 11)
    public final zzang k;
    @Field(id = 12)
    public final Bundle l;
    @Field(id = 13)
    public final int m;
    @Field(id = 14)
    public final List<String> n;
    @Field(id = 15)
    public final Bundle o;
    @Field(id = 16)
    public final boolean p;
    @Field(id = 18)
    public final int q;
    @Field(id = 19)
    public final int r;
    @Field(id = 20)
    public final float s;
    @Field(id = 21)
    public final String t;
    @Field(id = 25)
    public final long u;
    @Field(id = 26)
    public final String v;
    @Nullable
    @Field(id = 27)
    public final List<String> w;
    @Field(id = 28)
    public final String x;
    @Field(id = 29)
    public final zzpl y;
    @Field(id = 30)
    public final List<String> z;

    @Constructor
    zzaef(@Param(id = 1) int i, @Param(id = 2) Bundle bundle, @Param(id = 3) zzjj zzjj, @Param(id = 4) zzjn zzjn, @Param(id = 5) String str, @Param(id = 6) ApplicationInfo applicationInfo, @Param(id = 7) PackageInfo packageInfo, @Param(id = 8) String str2, @Param(id = 9) String str3, @Param(id = 10) String str4, @Param(id = 11) zzang zzang, @Param(id = 12) Bundle bundle2, @Param(id = 13) int i2, @Param(id = 14) List<String> list, @Param(id = 15) Bundle bundle3, @Param(id = 16) boolean z, @Param(id = 18) int i3, @Param(id = 19) int i4, @Param(id = 20) float f, @Param(id = 21) String str5, @Param(id = 25) long j, @Param(id = 26) String str6, @Param(id = 27) List<String> list2, @Param(id = 28) String str7, @Param(id = 29) zzpl zzpl, @Param(id = 30) List<String> list3, @Param(id = 31) long j2, @Param(id = 33) String str8, @Param(id = 34) float f2, @Param(id = 40) boolean z2, @Param(id = 35) int i5, @Param(id = 36) int i6, @Param(id = 37) boolean z3, @Param(id = 38) boolean z4, @Param(id = 39) String str9, @Param(id = 41) String str10, @Param(id = 42) boolean z5, @Param(id = 43) int i7, @Param(id = 44) Bundle bundle4, @Param(id = 45) String str11, @Param(id = 46) zzlu zzlu, @Param(id = 47) boolean z6, @Param(id = 48) Bundle bundle5, @Param(id = 49) String str12, @Param(id = 50) String str13, @Param(id = 51) String str14, @Param(id = 52) boolean z7, @Param(id = 53) List<Integer> list4, @Param(id = 54) String str15, @Param(id = 55) List<String> list5, @Param(id = 56) int i8, @Param(id = 57) boolean z8, @Param(id = 58) boolean z9, @Param(id = 59) boolean z10, @Param(id = 60) ArrayList<String> arrayList) {
        this.a = i;
        this.b = bundle;
        this.c = zzjj;
        this.d = zzjn;
        this.e = str;
        this.f = applicationInfo;
        this.g = packageInfo;
        this.h = str2;
        this.i = str3;
        this.j = str4;
        this.k = zzang;
        this.l = bundle2;
        this.m = i2;
        this.n = list;
        this.z = list3 == null ? Collections.emptyList() : Collections.unmodifiableList(list3);
        this.o = bundle3;
        this.p = z;
        this.q = i3;
        this.r = i4;
        this.s = f;
        this.t = str5;
        this.u = j;
        this.v = str6;
        this.w = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.x = str7;
        this.y = zzpl;
        this.A = j2;
        this.B = str8;
        this.C = f2;
        this.I = z2;
        this.D = i5;
        this.E = i6;
        this.F = z3;
        this.G = z4;
        this.H = str9;
        this.J = str10;
        this.K = z5;
        this.L = i7;
        this.M = bundle4;
        this.N = str11;
        this.O = zzlu;
        this.P = z6;
        this.Q = bundle5;
        this.R = str12;
        this.S = str13;
        this.T = str14;
        this.U = z7;
        this.V = list4;
        this.W = str15;
        this.X = list5;
        this.Y = i8;
        this.Z = z8;
        this.aa = z9;
        this.ab = z10;
        this.ac = arrayList;
    }

    private zzaef(@Nullable Bundle bundle, zzjj zzjj, zzjn zzjn, String str, ApplicationInfo applicationInfo, @Nullable PackageInfo packageInfo, String str2, String str3, String str4, zzang zzang, Bundle bundle2, int i, List<String> list, List<String> list2, Bundle bundle3, boolean z, int i2, int i3, float f, String str5, long j, String str6, @Nullable List<String> list3, String str7, zzpl zzpl, long j2, String str8, float f2, boolean z2, int i4, int i5, boolean z3, boolean z4, String str9, String str10, boolean z5, int i6, Bundle bundle4, String str11, @Nullable zzlu zzlu, boolean z6, Bundle bundle5, String str12, String str13, String str14, boolean z7, List<Integer> list4, String str15, List<String> list5, int i7, boolean z8, boolean z9, boolean z10, ArrayList<String> arrayList) {
        this(24, bundle, zzjj, zzjn, str, applicationInfo, packageInfo, str2, str3, str4, zzang, bundle2, i, list, bundle3, z, i2, i3, f, str5, j, str6, list3, str7, zzpl, list2, j2, str8, f2, z2, i4, i5, z3, z4, str9, str10, z5, i6, bundle4, str11, zzlu, z6, bundle5, str12, str13, str14, z7, list4, str15, list5, i7, z8, z9, z10, arrayList);
    }

    public zzaef(cp cpVar, long j, String str, String str2, String str3) {
        this(cpVar.a, cpVar.b, cpVar.c, cpVar.d, cpVar.e, cpVar.f, (String) kq.a(cpVar.Q, (Object) ""), cpVar.g, cpVar.h, cpVar.j, cpVar.i, cpVar.k, cpVar.l, cpVar.m, cpVar.o, cpVar.p, cpVar.q, cpVar.r, cpVar.s, cpVar.t, cpVar.u, cpVar.v, cpVar.w, cpVar.x, cpVar.y, j, cpVar.z, cpVar.A, cpVar.B, cpVar.C, cpVar.D, cpVar.E, cpVar.F, (String) kq.a(cpVar.G, (Object) "", 1, TimeUnit.SECONDS), cpVar.H, cpVar.I, cpVar.J, cpVar.K, cpVar.L, cpVar.M, cpVar.N, cpVar.O, str, str2, str3, cpVar.P, cpVar.R, cpVar.S, cpVar.n, cpVar.T, cpVar.U, cpVar.V, cpVar.W, cpVar.X);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b, false);
        a.a(parcel, 3, this.c, i, false);
        a.a(parcel, 4, this.d, i, false);
        a.a(parcel, 5, this.e, false);
        a.a(parcel, 6, this.f, i, false);
        a.a(parcel, 7, this.g, i, false);
        a.a(parcel, 8, this.h, false);
        a.a(parcel, 9, this.i, false);
        a.a(parcel, 10, this.j, false);
        a.a(parcel, 11, this.k, i, false);
        a.a(parcel, 12, this.l, false);
        a.a(parcel, 13, this.m);
        a.b(parcel, 14, this.n, false);
        a.a(parcel, 15, this.o, false);
        a.a(parcel, 16, this.p);
        a.a(parcel, 18, this.q);
        a.a(parcel, 19, this.r);
        a.a(parcel, 20, this.s);
        a.a(parcel, 21, this.t, false);
        a.a(parcel, 25, this.u);
        a.a(parcel, 26, this.v, false);
        a.b(parcel, 27, this.w, false);
        a.a(parcel, 28, this.x, false);
        a.a(parcel, 29, this.y, i, false);
        a.b(parcel, 30, this.z, false);
        a.a(parcel, 31, this.A);
        a.a(parcel, 33, this.B, false);
        a.a(parcel, 34, this.C);
        a.a(parcel, 35, this.D);
        a.a(parcel, 36, this.E);
        a.a(parcel, 37, this.F);
        a.a(parcel, 38, this.G);
        a.a(parcel, 39, this.H, false);
        a.a(parcel, 40, this.I);
        a.a(parcel, 41, this.J, false);
        a.a(parcel, 42, this.K);
        a.a(parcel, 43, this.L);
        a.a(parcel, 44, this.M, false);
        a.a(parcel, 45, this.N, false);
        a.a(parcel, 46, this.O, i, false);
        a.a(parcel, 47, this.P);
        a.a(parcel, 48, this.Q, false);
        a.a(parcel, 49, this.R, false);
        a.a(parcel, 50, this.S, false);
        a.a(parcel, 51, this.T, false);
        a.a(parcel, 52, this.U);
        a.a(parcel, 53, this.V, false);
        a.a(parcel, 54, this.W, false);
        a.b(parcel, 55, this.X, false);
        a.a(parcel, 56, this.Y);
        a.a(parcel, 57, this.Z);
        a.a(parcel, 58, this.aa);
        a.a(parcel, 59, this.ab);
        a.b(parcel, 60, this.ac, false);
        a.a(parcel, a);
    }
}
