package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Creator<Status> CREATOR = new o();
    @KeepForSdk
    @VisibleForTesting
    public static final Status a = new Status(0);
    @KeepForSdk
    public static final Status b = new Status(14);
    @KeepForSdk
    public static final Status c = new Status(8);
    @KeepForSdk
    public static final Status d = new Status(15);
    @KeepForSdk
    public static final Status e = new Status(16);
    @KeepForSdk
    public static final Status f = new Status(18);
    private static final Status g = new Status(17);
    @VersionField(id = 1000)
    private final int h;
    @Field(getter = "getStatusCode", id = 1)
    private final int i;
    @Nullable
    @Field(getter = "getStatusMessage", id = 2)
    private final String j;
    @Nullable
    @Field(getter = "getPendingIntent", id = 3)
    private final PendingIntent k;

    @KeepForSdk
    public Status(int i) {
        this(i, null);
    }

    @Constructor
    @KeepForSdk
    Status(@Param(id = 1000) int i, @Param(id = 1) int i2, @Nullable @Param(id = 2) String str, @Nullable @Param(id = 3) PendingIntent pendingIntent) {
        this.h = i;
        this.i = i2;
        this.j = str;
        this.k = pendingIntent;
    }

    @KeepForSdk
    public Status(int i, @Nullable String str) {
        this(1, i, str, null);
    }

    @KeepForSdk
    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    @Nullable
    public final String a() {
        return this.j;
    }

    @VisibleForTesting
    public final boolean b() {
        return this.k != null;
    }

    public final boolean c() {
        return this.i <= 0;
    }

    public final int d() {
        return this.i;
    }

    public final String e() {
        return this.j != null ? this.j : g.a(this.i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.h == status.h && this.i == status.i && ap.a(this.j, status.j) && ap.a(this.k, status.k);
    }

    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return ap.a(Integer.valueOf(this.h), Integer.valueOf(this.i), this.j, this.k);
    }

    public final String toString() {
        return ap.a((Object) this).a("statusCode", e()).a("resolution", this.k).toString();
    }

    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, d());
        a.a(parcel, 2, a(), false);
        a.a(parcel, 3, this.k, i, false);
        a.a(parcel, 1000, this.h);
        a.a(parcel, a);
    }
}
