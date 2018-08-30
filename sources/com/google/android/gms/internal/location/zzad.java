package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "FusedLocationProviderResultCreator")
@Reserved({1000})
public final class zzad extends AbstractSafeParcelable implements Result {
    public static final Creator<zzad> CREATOR = new e();
    private static final zzad a = new zzad(Status.a);
    @Field(getter = "getStatus", id = 1)
    private final Status b;

    @Constructor
    public zzad(@Param(id = 1) Status status) {
        this.b = status;
    }

    public final Status getStatus() {
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, getStatus(), i, false);
        a.a(parcel, a);
    }
}
