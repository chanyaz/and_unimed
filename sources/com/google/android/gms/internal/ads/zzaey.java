package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@Class(creator = "NonagonRequestParcelCreator")
@ParametersAreNonnullByDefault
public final class zzaey extends AbstractSafeParcelable {
    public static final Creator<zzaey> CREATOR = new db();
    @Field(id = 1)
    private final Bundle a;
    @Field(id = 2)
    private final zzang b;
    @Field(id = 3)
    private final ApplicationInfo c;
    @Field(id = 4)
    private final String d;
    @Field(id = 5)
    private final List<String> e;
    @Field(id = 6)
    @Nullable
    private final PackageInfo f;
    @Field(id = 7)
    private final String g;
    @Field(id = 8)
    private final boolean h;
    @Field(id = 9)
    private final String i;

    @Constructor
    public zzaey(@Param(id = 1) Bundle bundle, @Param(id = 2) zzang zzang, @Param(id = 3) ApplicationInfo applicationInfo, @Param(id = 4) String str, @Param(id = 5) List<String> list, @Param(id = 6) @Nullable PackageInfo packageInfo, @Param(id = 7) String str2, @Param(id = 8) boolean z, @Param(id = 9) String str3) {
        this.a = bundle;
        this.b = zzang;
        this.d = str;
        this.c = applicationInfo;
        this.e = list;
        this.f = packageInfo;
        this.g = str2;
        this.h = z;
        this.i = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a, false);
        a.a(parcel, 2, this.b, i, false);
        a.a(parcel, 3, this.c, i, false);
        a.a(parcel, 4, this.d, false);
        a.b(parcel, 5, this.e, false);
        a.a(parcel, 6, this.f, i, false);
        a.a(parcel, 7, this.g, false);
        a.a(parcel, 8, this.h);
        a.a(parcel, 9, this.i, false);
        a.a(parcel, a);
    }
}
