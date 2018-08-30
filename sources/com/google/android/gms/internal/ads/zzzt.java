package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@Class(creator = "RtbVersionInfoParcelCreator")
@ParametersAreNonnullByDefault
public final class zzzt extends AbstractSafeParcelable {
    public static final Creator<zzzt> CREATOR = new awr();
    @Field(id = 1)
    private final int a;
    @Field(id = 2)
    private final int b;
    @Field(id = 3)
    private final int c;

    @Constructor
    zzzt(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public static zzzt a(pk pkVar) {
        return new zzzt(pkVar.a, pkVar.b, pkVar.c);
    }

    public final String toString() {
        int i = this.a;
        int i2 = this.b;
        return i + "." + i2 + "." + this.c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b);
        a.a(parcel, 3, this.c);
        a.a(parcel, a);
    }
}
