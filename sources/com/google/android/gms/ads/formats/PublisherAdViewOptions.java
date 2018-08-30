package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.internal.ads.aku;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzla;

@zzadh
@Class(creator = "PublisherAdViewOptionsCreator")
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Creator<PublisherAdViewOptions> CREATOR = new g();
    @Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean a;
    @Nullable
    @Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")
    private final zzla b;

    @Constructor
    PublisherAdViewOptions(@Param(id = 1) boolean z, @Nullable @Param(id = 2) IBinder iBinder) {
        this.a = z;
        this.b = iBinder != null ? aku.a(iBinder) : null;
    }

    public final boolean a() {
        return this.a;
    }

    @Nullable
    public final zzla b() {
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 1, a());
        a.a(parcel, 2, this.b == null ? null : this.b.asBinder(), false);
        a.a(parcel, a);
    }
}
