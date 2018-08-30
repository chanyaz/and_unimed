package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Class(creator = "LocationResultCreator")
@Reserved({1000})
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<LocationResult> CREATOR = new l();
    static final List<Location> a = Collections.emptyList();
    @Field(defaultValueUnchecked = "LocationResult.DEFAULT_LOCATIONS", getter = "getLocations", id = 1)
    private final List<Location> b;

    @Constructor
    LocationResult(@Param(id = 1) List<Location> list) {
        this.b = list;
    }

    @NonNull
    public final List<Location> a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.b.size() != this.b.size()) {
            return false;
        }
        Iterator it = this.b.iterator();
        for (Location time : locationResult.b) {
            if (((Location) it.next()).getTime() != time.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 17;
        Iterator it = this.b.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long time = ((Location) it.next()).getTime();
            i = ((int) (time ^ (time >>> 32))) + (i2 * 31);
        }
    }

    public final String toString() {
        String valueOf = String.valueOf(this.b);
        return new StringBuilder(String.valueOf(valueOf).length() + 27).append("LocationResult[locations: ").append(valueOf).append("]").toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.c(parcel, 1, a(), false);
        a.a(parcel, a);
    }
}
