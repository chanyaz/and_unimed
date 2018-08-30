package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;

@zzadh
@Class(creator = "HttpResponseParcelCreator")
public final class zzsi extends AbstractSafeParcelable {
    public static final Creator<zzsi> CREATOR = new aqj();
    @Field(id = 1)
    public final boolean a;
    @Field(id = 2)
    public final String b;
    @Field(id = 3)
    public final int c;
    @Field(id = 4)
    public final byte[] d;
    @Field(id = 5)
    public final String[] e;
    @Field(id = 6)
    public final String[] f;
    @Field(id = 7)
    public final boolean g;
    @Field(id = 8)
    public final long h;

    @Constructor
    zzsi(@Param(id = 1) boolean z, @Param(id = 2) String str, @Param(id = 3) int i, @Param(id = 4) byte[] bArr, @Param(id = 5) String[] strArr, @Param(id = 6) String[] strArr2, @Param(id = 7) boolean z2, @Param(id = 8) long j) {
        this.a = z;
        this.b = str;
        this.c = i;
        this.d = bArr;
        this.e = strArr;
        this.f = strArr2;
        this.g = z2;
        this.h = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b, false);
        a.a(parcel, 3, this.c);
        a.a(parcel, 4, this.d, false);
        a.a(parcel, 5, this.e, false);
        a.a(parcel, 6, this.f, false);
        a.a(parcel, 7, this.g);
        a.a(parcel, 8, this.h);
        a.a(parcel, a);
    }
}
