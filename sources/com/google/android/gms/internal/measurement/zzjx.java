package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;

@Class(creator = "UserAttributeParcelCreator")
public final class zzjx extends AbstractSafeParcelable {
    public static final Creator<zzjx> CREATOR = new ic();
    @Field(id = 2)
    public final String a;
    @Field(id = 3)
    public final long b;
    @Field(id = 7)
    public final String c;
    @Field(id = 1)
    private final int d;
    @Field(id = 4)
    private final Long e;
    @Field(id = 5)
    private final Float f;
    @Field(id = 6)
    private final String g;
    @Field(id = 8)
    private final Double h;

    @Constructor
    zzjx(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) long j, @Param(id = 4) Long l, @Param(id = 5) Float f, @Param(id = 6) String str2, @Param(id = 7) String str3, @Param(id = 8) Double d) {
        Double d2 = null;
        this.d = i;
        this.a = str;
        this.b = j;
        this.e = l;
        this.f = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.h = d2;
        } else {
            this.h = d;
        }
        this.g = str2;
        this.c = str3;
    }

    zzjx(id idVar) {
        this(idVar.c, idVar.d, idVar.e, idVar.b);
    }

    zzjx(String str, long j, Object obj, String str2) {
        ar.a(str);
        this.d = 2;
        this.a = str;
        this.b = j;
        this.c = str2;
        if (obj == null) {
            this.e = null;
            this.f = null;
            this.h = null;
            this.g = null;
        } else if (obj instanceof Long) {
            this.e = (Long) obj;
            this.f = null;
            this.h = null;
            this.g = null;
        } else if (obj instanceof String) {
            this.e = null;
            this.f = null;
            this.h = null;
            this.g = (String) obj;
        } else if (obj instanceof Double) {
            this.e = null;
            this.f = null;
            this.h = (Double) obj;
            this.g = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object a() {
        return this.e != null ? this.e : this.h != null ? this.h : this.g != null ? this.g : null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.d);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b);
        a.a(parcel, 4, this.e, false);
        a.a(parcel, 5, null, false);
        a.a(parcel, 6, this.g, false);
        a.a(parcel, 7, this.c, false);
        a.a(parcel, 8, this.h, false);
        a.a(parcel, a);
    }
}
