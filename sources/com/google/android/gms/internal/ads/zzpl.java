package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;

@zzadh
@Class(creator = "NativeAdOptionsParcelCreator")
public final class zzpl extends AbstractSafeParcelable {
    public static final Creator<zzpl> CREATOR = new aoh();
    @Field(id = 1)
    public final int a;
    @Field(id = 2)
    public final boolean b;
    @Field(id = 3)
    public final int c;
    @Field(id = 4)
    public final boolean d;
    @Field(id = 5)
    public final int e;
    @Nullable
    @Field(id = 6)
    public final zzmu f;

    @Constructor
    public zzpl(@Param(id = 1) int i, @Param(id = 2) boolean z, @Param(id = 3) int i2, @Param(id = 4) boolean z2, @Param(id = 5) int i3, @Param(id = 6) zzmu zzmu) {
        this.a = i;
        this.b = z;
        this.c = i2;
        this.d = z2;
        this.e = i3;
        this.f = zzmu;
    }

    public zzpl(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.a(), nativeAdOptions.b(), nativeAdOptions.c(), nativeAdOptions.d(), nativeAdOptions.e() != null ? new zzmu(nativeAdOptions.e()) : null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, this.a);
        a.a(parcel, 2, this.b);
        a.a(parcel, 3, this.c);
        a.a(parcel, 4, this.d);
        a.a(parcel, 5, this.e);
        a.a(parcel, 6, this.f, i, false);
        a.a(parcel, a);
    }
}
