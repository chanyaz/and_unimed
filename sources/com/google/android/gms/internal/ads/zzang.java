package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;

@zzadh
@Class(creator = "VersionInfoParcelCreator")
@Reserved({1})
public final class zzang extends AbstractSafeParcelable {
    public static final Creator<zzang> CREATOR = new km();
    @Field(id = 2)
    public String a;
    @Field(id = 3)
    public int b;
    @Field(id = 4)
    public int c;
    @Field(id = 5)
    public boolean d;
    @Field(id = 6)
    public boolean e;

    public zzang(int i, int i2, boolean z) {
        this(i, i2, z, false, false);
    }

    public zzang(int i, int i2, boolean z, boolean z2) {
        this(12451000, i2, true, false, z2);
    }

    private zzang(int i, int i2, boolean z, boolean z2, boolean z3) {
        String str = z ? "0" : "1";
        String stringBuilder = new StringBuilder(String.valueOf(str).length() + 36).append("afma-sdk-a-v").append(i).append(".").append(i2).append(".").append(str).toString();
        this(stringBuilder, i, i2, z, z3);
    }

    @Constructor
    zzang(@Param(id = 2) String str, @Param(id = 3) int i, @Param(id = 4) int i2, @Param(id = 5) boolean z, @Param(id = 6) boolean z2) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public static zzang a() {
        return new zzang(12451009, 12451009, true);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b);
        a.a(parcel, 4, this.c);
        a.a(parcel, 5, this.d);
        a.a(parcel, 6, this.e);
        a.a(parcel, a);
    }
}
