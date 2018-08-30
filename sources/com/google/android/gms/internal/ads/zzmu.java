package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;

@zzadh
@Class(creator = "VideoOptionsParcelCreator")
@Reserved({1})
public final class zzmu extends AbstractSafeParcelable {
    public static final Creator<zzmu> CREATOR = new aly();
    @Field(id = 2)
    public final boolean a;
    @Field(id = 3)
    public final boolean b;
    @Field(id = 4)
    public final boolean c;

    public zzmu(m mVar) {
        this(mVar.a(), mVar.b(), mVar.c());
    }

    @Constructor
    public zzmu(@Param(id = 2) boolean z, @Param(id = 3) boolean z2, @Param(id = 4) boolean z3) {
        this.a = z;
        this.b = z2;
        this.c = z3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a);
        a.a(parcel, 3, this.b);
        a.a(parcel, 4, this.c);
        a.a(parcel, a);
    }
}
