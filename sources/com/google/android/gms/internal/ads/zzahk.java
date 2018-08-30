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
@Class(creator = "RewardedVideoAdRequestParcelCreator")
@Reserved({1})
public final class zzahk extends AbstractSafeParcelable {
    public static final Creator<zzahk> CREATOR = new fg();
    @Field(id = 2)
    public final zzjj a;
    @Field(id = 3)
    public final String b;

    @Constructor
    public zzahk(@Param(id = 2) zzjj zzjj, @Param(id = 3) String str) {
        this.a = zzjj;
        this.b = str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, i, false);
        a.a(parcel, 3, this.b, false);
        a.a(parcel, a);
    }
}
