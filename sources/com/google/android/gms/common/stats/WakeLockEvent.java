package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
import javax.annotation.Nullable;

@Class(creator = "WakeLockEventCreator")
public final class WakeLockEvent extends StatsEvent {
    public static final Creator<WakeLockEvent> CREATOR = new e();
    @VersionField(id = 1)
    private final int a;
    @Field(getter = "getTimeMillis", id = 2)
    private final long b;
    @Field(getter = "getEventType", id = 11)
    private int c;
    @Field(getter = "getWakeLockName", id = 4)
    private final String d;
    @Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String e;
    @Field(getter = "getCodePackage", id = 17)
    private final String f;
    @Field(getter = "getWakeLockType", id = 5)
    private final int g;
    @Field(getter = "getCallingPackages", id = 6)
    private final List<String> h;
    @Field(getter = "getEventKey", id = 12)
    private final String i;
    @Field(getter = "getElapsedRealtime", id = 8)
    private final long j;
    @Field(getter = "getDeviceState", id = 14)
    private int k;
    @Field(getter = "getHostPackage", id = 13)
    private final String l;
    @Field(getter = "getBeginPowerPercentage", id = 15)
    private final float m;
    @Field(getter = "getTimeout", id = 16)
    private final long n;
    private long o;

    @Constructor
    WakeLockEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 11) int i2, @Param(id = 4) String str, @Param(id = 5) int i3, @Param(id = 6) List<String> list, @Param(id = 12) String str2, @Param(id = 8) long j2, @Param(id = 14) int i4, @Param(id = 10) String str3, @Param(id = 13) String str4, @Param(id = 15) float f, @Param(id = 16) long j3, @Param(id = 17) String str5) {
        this.a = i;
        this.b = j;
        this.c = i2;
        this.d = str;
        this.e = str3;
        this.f = str5;
        this.g = i3;
        this.o = -1;
        this.h = list;
        this.i = str2;
        this.j = j2;
        this.k = i4;
        this.l = str4;
        this.m = f;
        this.n = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
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

    public final int f() {
        return this.g;
    }

    @Nullable
    public final List<String> g() {
        return this.h;
    }

    public final String h() {
        return this.i;
    }

    public final long i() {
        return this.o;
    }

    public final int j() {
        return this.k;
    }

    public final long k() {
        return this.j;
    }

    public final long l() {
        return this.n;
    }

    public final String m() {
        String c = c();
        int f = f();
        String join = g() == null ? "" : TextUtils.join(",", g());
        int j = j();
        String d = d() == null ? "" : d();
        String n = n() == null ? "" : n();
        float o = o();
        String e = e() == null ? "" : e();
        return new StringBuilder(((((String.valueOf(c).length() + 45) + String.valueOf(join).length()) + String.valueOf(d).length()) + String.valueOf(n).length()) + String.valueOf(e).length()).append("\t").append(c).append("\t").append(f).append("\t").append(join).append("\t").append(j).append("\t").append(d).append("\t").append(n).append("\t").append(o).append("\t").append(e).toString();
    }

    public final String n() {
        return this.l;
    }

    public final float o() {
        return this.m;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, a());
        a.a(parcel, 4, c(), false);
        a.a(parcel, 5, f());
        a.b(parcel, 6, g(), false);
        a.a(parcel, 8, k());
        a.a(parcel, 10, d(), false);
        a.a(parcel, 11, b());
        a.a(parcel, 12, h(), false);
        a.a(parcel, 13, n(), false);
        a.a(parcel, 14, j());
        a.a(parcel, 15, o());
        a.a(parcel, 16, l());
        a.a(parcel, 17, e(), false);
        a.a(parcel, a);
    }
}
