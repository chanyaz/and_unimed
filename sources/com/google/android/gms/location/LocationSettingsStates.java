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

@Class(creator = "LocationSettingsStatesCreator")
@Reserved({1000})
public final class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Creator<LocationSettingsStates> CREATOR = new q();
    @Field(getter = "isGpsUsable", id = 1)
    private final boolean a;
    @Field(getter = "isNetworkLocationUsable", id = 2)
    private final boolean b;
    @Field(getter = "isBleUsable", id = 3)
    private final boolean c;
    @Field(getter = "isGpsPresent", id = 4)
    private final boolean d;
    @Field(getter = "isNetworkLocationPresent", id = 5)
    private final boolean e;
    @Field(getter = "isBlePresent", id = 6)
    private final boolean f;

    @Constructor
    public LocationSettingsStates(@Param(id = 1) boolean z, @Param(id = 2) boolean z2, @Param(id = 3) boolean z3, @Param(id = 4) boolean z4, @Param(id = 5) boolean z5, @Param(id = 6) boolean z6) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
        this.e = z5;
        this.f = z6;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean c() {
        return this.b;
    }

    public final boolean d() {
        return this.e;
    }

    public final boolean e() {
        return this.c;
    }

    public final boolean f() {
        return this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, a());
        a.a(parcel, 2, c());
        a.a(parcel, 3, e());
        a.a(parcel, 4, b());
        a.a(parcel, 5, d());
        a.a(parcel, 6, f());
        a.a(parcel, a);
    }
}
