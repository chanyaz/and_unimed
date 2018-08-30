package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Collections;
import java.util.List;

@Class(creator = "RemoveGeofencingRequestCreator")
@Reserved({1000})
public final class zzal extends AbstractSafeParcelable {
    public static final Creator<zzal> CREATOR = new s();
    @Field(getter = "getGeofenceIds", id = 1)
    private final List<String> a;
    @Field(getter = "getPendingIntent", id = 2)
    private final PendingIntent b;
    @Field(defaultValue = "", getter = "getTag", id = 3)
    private final String c;

    @Constructor
    zzal(@Nullable @Param(id = 1) List<String> list, @Nullable @Param(id = 2) PendingIntent pendingIntent, @Param(id = 3) String str) {
        this.a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.b = pendingIntent;
        this.c = str;
    }

    public static zzal a(PendingIntent pendingIntent) {
        ar.a((Object) pendingIntent, (Object) "PendingIntent can not be null.");
        return new zzal(null, pendingIntent, "");
    }

    public static zzal a(List<String> list) {
        ar.a((Object) list, (Object) "geofence can't be null.");
        ar.b(!list.isEmpty(), "Geofences must contains at least one id.");
        return new zzal(list, null, "");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.b(parcel, 1, this.a, false);
        a.a(parcel, 2, this.b, i, false);
        a.a(parcel, 3, this.c, false);
        a.a(parcel, a);
    }
}
