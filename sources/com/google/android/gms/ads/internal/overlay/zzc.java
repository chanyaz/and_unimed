package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
@Class(creator = "AdLauncherIntentInfoCreator")
@Reserved({1})
public final class zzc extends AbstractSafeParcelable {
    public static final Creator<zzc> CREATOR = new b();
    @Field(id = 3)
    public final String a;
    @Field(id = 4)
    public final String b;
    @Field(id = 5)
    public final String c;
    @Field(id = 6)
    public final String d;
    @Field(id = 7)
    public final String e;
    @Field(id = 9)
    public final Intent f;
    @Field(id = 2)
    private final String g;
    @Field(id = 8)
    private final String h;

    public zzc(Intent intent) {
        this(null, null, null, null, null, null, null, intent);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this(str, str2, str3, str4, str5, str6, str7, null);
    }

    @Constructor
    public zzc(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) String str5, @Param(id = 7) String str6, @Param(id = 8) String str7, @Param(id = 9) Intent intent) {
        this.g = str;
        this.a = str2;
        this.b = str3;
        this.c = str4;
        this.d = str5;
        this.e = str6;
        this.h = str7;
        this.f = intent;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.g, false);
        a.a(parcel, 3, this.a, false);
        a.a(parcel, 4, this.b, false);
        a.a(parcel, 5, this.c, false);
        a.a(parcel, 6, this.d, false);
        a.a(parcel, 7, this.e, false);
        a.a(parcel, 8, this.h, false);
        a.a(parcel, 9, this.f, i, false);
        a.a(parcel, a);
    }
}
