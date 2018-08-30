package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "GassRequestParcelCreator")
public final class zzatt extends AbstractSafeParcelable {
    public static final Creator<zzatt> CREATOR = new pq();
    @VersionField(id = 1)
    private final int a;
    @Field(id = 2)
    private final String b;
    @Field(id = 3)
    private final String c;

    @Constructor
    zzatt(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public zzatt(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b, false);
        a.a(parcel, 3, this.c, false);
        a.a(parcel, a);
    }
}
