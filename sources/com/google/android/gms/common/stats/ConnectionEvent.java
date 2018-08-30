package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import javax.annotation.Nullable;

@Class(creator = "ConnectionEventCreator")
public final class ConnectionEvent extends StatsEvent {
    public static final Creator<ConnectionEvent> CREATOR = new a();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getTimeMillis", id = 2)
    private final long b;
    @Field(getter = "getEventType", id = 12)
    private int c;
    @Field(getter = "getCallingProcess", id = 4)
    private final String d;
    @Field(getter = "getCallingService", id = 5)
    private final String e;
    @Field(getter = "getTargetProcess", id = 6)
    private final String f;
    @Field(getter = "getTargetService", id = 7)
    private final String g;
    @Field(getter = "getStackTrace", id = 8)
    private final String h;
    @Field(getter = "getEventKey", id = 13)
    private final String i;
    @Field(getter = "getElapsedRealtime", id = 10)
    private final long j;
    @Field(getter = "getHeapAlloc", id = 11)
    private final long k;
    private long l = -1;

    @Constructor
    ConnectionEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 12) int i2, @Param(id = 4) String str, @Param(id = 5) String str2, @Param(id = 6) String str3, @Param(id = 7) String str4, @Param(id = 8) String str5, @Param(id = 13) String str6, @Param(id = 10) long j2, @Param(id = 11) long j3) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = str5;
        this.i = str6;
        this.j = j2;
        this.k = j3;
    }

    public final long a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.g;
    }

    @Nullable
    public final String g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public final long i() {
        return this.l;
    }

    public final long j() {
        return this.k;
    }

    public final long k() {
        return this.j;
    }

    public final long l() {
        return 0;
    }

    public final String m() {
        String c = c();
        String d = d();
        String e = e();
        String f = f();
        String str = this.h == null ? "" : this.h;
        return new StringBuilder(((((String.valueOf(c).length() + 26) + String.valueOf(d).length()) + String.valueOf(e).length()) + String.valueOf(f).length()) + String.valueOf(str).length()).append("\t").append(c).append("/").append(d).append("\t").append(e).append("/").append(f).append("\t").append(str).append("\t").append(j()).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a());
        a.a(parcel, 4, c(), false);
        a.a(parcel, 5, d(), false);
        a.a(parcel, 6, e(), false);
        a.a(parcel, 7, f(), false);
        a.a(parcel, 8, g(), false);
        a.a(parcel, 10, k());
        a.a(parcel, 11, j());
        a.a(parcel, 12, b());
        a.a(parcel, 13, h(), false);
        a.a(parcel, a);
    }
}
