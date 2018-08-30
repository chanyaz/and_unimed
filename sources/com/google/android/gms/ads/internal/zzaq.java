package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
@Class(creator = "InterstitialAdParameterParcelCreator")
@Reserved({1})
public final class zzaq extends AbstractSafeParcelable {
    public static final Creator<zzaq> CREATOR = new q();
    @Field(id = 2)
    public final boolean a;
    @Field(id = 3)
    public final boolean b;
    @Field(id = 5)
    public final boolean c;
    @Field(id = 6)
    public final float d;
    @Field(id = 7)
    public final int e;
    @Field(id = 8)
    public final boolean f;
    @Field(id = 9)
    public final boolean g;
    @Field(id = 10)
    public final boolean h;
    @Field(id = 4)
    private final String i;

    @Constructor
    zzaq(@Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) String str, @Param(id = 5) boolean z3, @Param(id = 6) float f, @Param(id = 7) int i, @Param(id = 8) boolean z4, @Param(id = 9) boolean z5, @Param(id = 10) boolean z6) {
        this.a = z;
        this.b = z2;
        this.i = str;
        this.c = z3;
        this.d = f;
        this.e = i;
        this.f = z4;
        this.g = z5;
        this.h = z6;
    }

    public zzaq(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(z, z2, null, z3, f, i, z4, z5, z6);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a);
        a.a(parcel, 3, this.b);
        a.a(parcel, 4, this.i, false);
        a.a(parcel, 5, this.c);
        a.a(parcel, 6, this.d);
        a.a(parcel, 7, this.e);
        a.a(parcel, 8, this.f);
        a.a(parcel, 9, this.g);
        a.a(parcel, 10, this.h);
        a.a(parcel, a);
    }
}
