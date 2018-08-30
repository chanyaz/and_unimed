package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
    public static final Creator<Feature> CREATOR = new d();
    @Field(getter = "getName", id = 1)
    private final String a;
    @Field(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int b;
    @Field(defaultValue = "-1", getter = "getVersion", id = 3)
    private final long c;

    @Constructor
    public Feature(@Param(id = 1) String str, @Param(id = 2) int i, @Param(id = 3) long j) {
        this.a = str;
        this.b = i;
        this.c = j;
    }

    public String a() {
        return this.a;
    }

    public long b() {
        return this.c == -1 ? (long) this.b : this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) obj;
        return ((a() != null && a().equals(feature.a())) || (a() == null && feature.a() == null)) && b() == feature.b();
    }

    public int hashCode() {
        return ap.a(a(), Long.valueOf(b()));
    }

    public String toString() {
        return ap.a((Object) this).a("name", a()).a("version", Long.valueOf(b())).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, a(), false);
        a.a(parcel, 2, this.b);
        a.a(parcel, 3, b());
        a.a(parcel, a);
    }
}
