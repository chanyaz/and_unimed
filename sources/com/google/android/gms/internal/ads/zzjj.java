package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;

@zzadh
@Class(creator = "AdRequestParcelCreator")
public final class zzjj extends AbstractSafeParcelable {
    public static final Creator<zzjj> CREATOR = new ajp();
    @Field(id = 1)
    public final int a;
    @Field(id = 2)
    public final long b;
    @Field(id = 3)
    public final Bundle c;
    @Field(id = 4)
    public final int d;
    @Field(id = 5)
    public final List<String> e;
    @Field(id = 6)
    public final boolean f;
    @Field(id = 7)
    public final int g;
    @Field(id = 8)
    public final boolean h;
    @Field(id = 9)
    public final String i;
    @Field(id = 10)
    public final zzmq j;
    @Field(id = 11)
    public final Location k;
    @Field(id = 12)
    public final String l;
    @Field(id = 13)
    public final Bundle m;
    @Field(id = 14)
    public final Bundle n;
    @Field(id = 15)
    public final List<String> o;
    @Field(id = 16)
    public final String p;
    @Field(id = 17)
    public final String q;
    @Field(id = 18)
    public final boolean r;

    @Constructor
    public zzjj(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 3) Bundle bundle, @Param(id = 4) int i2, @Param(id = 5) List<String> list, @Param(id = 6) boolean z, @Param(id = 7) int i3, @Param(id = 8) boolean z2, @Param(id = 9) String str, @Param(id = 10) zzmq zzmq, @Param(id = 11) Location location, @Param(id = 12) String str2, @Param(id = 13) Bundle bundle2, @Param(id = 14) Bundle bundle3, @Param(id = 15) List<String> list2, @Param(id = 16) String str3, @Param(id = 17) String str4, @Param(id = 18) boolean z3) {
        this.a = i;
        this.b = j;
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.c = bundle;
        this.d = i2;
        this.e = list;
        this.f = z;
        this.g = i3;
        this.h = z2;
        this.i = str;
        this.j = zzmq;
        this.k = location;
        this.l = str2;
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        this.m = bundle2;
        this.n = bundle3;
        this.o = list2;
        this.p = str3;
        this.q = str4;
        this.r = z3;
    }

    public final zzjj a() {
        Bundle bundle = this.m.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle == null) {
            bundle = this.c;
            this.m.putBundle("com.google.ads.mediation.admob.AdMobAdapter", this.c);
        }
        return new zzjj(this.a, this.b, bundle, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzjj)) {
            return false;
        }
        zzjj zzjj = (zzjj) obj;
        return this.a == zzjj.a && this.b == zzjj.b && ap.a(this.c, zzjj.c) && this.d == zzjj.d && ap.a(this.e, zzjj.e) && this.f == zzjj.f && this.g == zzjj.g && this.h == zzjj.h && ap.a(this.i, zzjj.i) && ap.a(this.j, zzjj.j) && ap.a(this.k, zzjj.k) && ap.a(this.l, zzjj.l) && ap.a(this.m, zzjj.m) && ap.a(this.n, zzjj.n) && ap.a(this.o, zzjj.o) && ap.a(this.p, zzjj.p) && ap.a(this.q, zzjj.q) && this.r == zzjj.r;
    }

    public final int hashCode() {
        return ap.a(Integer.valueOf(this.a), Long.valueOf(this.b), this.c, Integer.valueOf(this.d), this.e, Boolean.valueOf(this.f), Integer.valueOf(this.g), Boolean.valueOf(this.h), this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, Boolean.valueOf(this.r));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b);
        a.a(parcel, 3, this.c, false);
        a.a(parcel, 4, this.d);
        a.b(parcel, 5, this.e, false);
        a.a(parcel, 6, this.f);
        a.a(parcel, 7, this.g);
        a.a(parcel, 8, this.h);
        a.a(parcel, 9, this.i, false);
        a.a(parcel, 10, this.j, i, false);
        a.a(parcel, 11, this.k, i, false);
        a.a(parcel, 12, this.l, false);
        a.a(parcel, 13, this.m, false);
        a.a(parcel, 14, this.n, false);
        a.b(parcel, 15, this.o, false);
        a.a(parcel, 16, this.p, false);
        a.a(parcel, 17, this.q, false);
        a.a(parcel, 18, this.r);
        a.a(parcel, a);
    }
}
