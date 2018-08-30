package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "NetworkLocationStatusCreator")
public final class zzaj extends AbstractSafeParcelable {
    public static final Creator<zzaj> CREATOR = new r();
    @Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 1)
    private final int a;
    @Field(defaultValueUnchecked = "LocationAvailability.STATUS_UNKNOWN", id = 2)
    private final int b;
    @Field(defaultValueUnchecked = "NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id = 3)
    private final long c;
    @Field(defaultValueUnchecked = "NetworkLocationStatus.STATUS_INVALID_TIMESTAMP", id = 4)
    private final long d;

    @Constructor
    zzaj(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) long j, @Param(id = 4) long j2) {
        this.a = i;
        this.b = i2;
        this.c = j;
        this.d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzaj zzaj = (zzaj) obj;
        return this.a == zzaj.a && this.b == zzaj.b && this.c == zzaj.c && this.d == zzaj.d;
    }

    public final int hashCode() {
        return ap.a(Integer.valueOf(this.b), Integer.valueOf(this.a), Long.valueOf(this.d), Long.valueOf(this.c));
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("NetworkLocationStatus:");
        stringBuilder.append(" Wifi status: ").append(this.a).append(" Cell status: ").append(this.b).append(" elapsed time NS: ").append(this.d).append(" system time ms: ").append(this.c);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b);
        a.a(parcel, 3, this.c);
        a.a(parcel, 4, this.d);
        a.a(parcel, a);
    }
}
