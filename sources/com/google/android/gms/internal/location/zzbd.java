package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

@Class(creator = "LocationRequestInternalCreator")
@Reserved({1000, 2, 3, 4})
public final class zzbd extends AbstractSafeParcelable {
    public static final Creator<zzbd> CREATOR = new aa();
    static final List<ClientIdentity> a = Collections.emptyList();
    @Field(defaultValueUnchecked = "null", id = 1)
    private LocationRequest b;
    @Field(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_CLIENTS", id = 5)
    private List<ClientIdentity> c;
    @Nullable
    @Field(defaultValueUnchecked = "null", id = 6)
    private String d;
    @Field(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_HIDE_FROM_APP_OPS", id = 7)
    private boolean e;
    @Field(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_FORCE_COARSE_LOCATION", id = 8)
    private boolean f;
    @Field(defaultValueUnchecked = "LocationRequestInternal.DEFAULT_EXEMPT_FROM_THROTTLE", id = 9)
    private boolean g;
    @Nullable
    @Field(defaultValueUnchecked = "null", id = 10)
    private String h;
    private boolean i = true;

    @Constructor
    zzbd(@Param(id = 1) LocationRequest locationRequest, @Param(id = 5) List<ClientIdentity> list, @Nullable @Param(id = 6) String str, @Param(id = 7) boolean z, @Param(id = 8) boolean z2, @Param(id = 9) boolean z3, @Param(id = 10) String str2) {
        this.b = locationRequest;
        this.c = list;
        this.d = str;
        this.e = z;
        this.f = z2;
        this.g = z3;
        this.h = str2;
    }

    @Deprecated
    public static zzbd a(LocationRequest locationRequest) {
        return new zzbd(locationRequest, a, null, false, false, false, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbd = (zzbd) obj;
        return ap.a(this.b, zzbd.b) && ap.a(this.c, zzbd.c) && ap.a(this.d, zzbd.d) && this.e == zzbd.e && this.f == zzbd.f && this.g == zzbd.g && ap.a(this.h, zzbd.h);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        if (this.d != null) {
            stringBuilder.append(" tag=").append(this.d);
        }
        if (this.h != null) {
            stringBuilder.append(" moduleId=").append(this.h);
        }
        stringBuilder.append(" hideAppOps=").append(this.e);
        stringBuilder.append(" clients=").append(this.c);
        stringBuilder.append(" forceCoarseLocation=").append(this.f);
        if (this.g) {
            stringBuilder.append(" exemptFromBackgroundThrottle");
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.b, i, false);
        a.c(parcel, 5, this.c, false);
        a.a(parcel, 6, this.d, false);
        a.a(parcel, 7, this.e);
        a.a(parcel, 8, this.f);
        a.a(parcel, 9, this.g);
        a.a(parcel, 10, this.h, false);
        a.a(parcel, a);
    }
}
