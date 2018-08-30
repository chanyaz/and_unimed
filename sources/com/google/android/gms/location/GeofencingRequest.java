package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.location.zzbh;
import java.util.List;

@Class(creator = "GeofencingRequestCreator")
@Reserved({1000})
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Creator<GeofencingRequest> CREATOR = new ac();
    @Field(getter = "getParcelableGeofences", id = 1)
    private final List<zzbh> a;
    @Field(getter = "getInitialTrigger", id = 2)
    private final int b;
    @Field(defaultValue = "", getter = "getTag", id = 3)
    private final String c;

    @Constructor
    GeofencingRequest(@Param(id = 1) List<zzbh> list, @Param(id = 2) int i, @Param(id = 3) String str) {
        this.a = list;
        this.b = i;
        this.c = str;
    }

    public int a() {
        return this.b;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GeofencingRequest[");
        stringBuilder.append("geofences=");
        stringBuilder.append(this.a);
        stringBuilder.append(", initialTrigger=" + this.b + ", ");
        String str = "tag=";
        String valueOf = String.valueOf(this.c);
        stringBuilder.append(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.c(parcel, 1, this.a, false);
        a.a(parcel, 2, a());
        a.a(parcel, 3, this.c, false);
        a.a(parcel, a);
    }
}
