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
@Class(creator = "IconAdOptionsParcelCreator")
@Reserved({1})
public final class zzlu extends AbstractSafeParcelable {
    public static final Creator<zzlu> CREATOR = new alh();
    @Field(id = 2)
    public final int a;

    @Constructor
    public zzlu(@Param(id = 2) int i) {
        this.a = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a);
        a.a(parcel, a);
    }
}
