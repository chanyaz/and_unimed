package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.a;

@zzadh
public final class zzms extends zzjn {
    public zzms(zzjn zzjn) {
        super(zzjn.a, zzjn.b, zzjn.c, zzjn.d, zzjn.e, zzjn.f, zzjn.g, zzjn.h, zzjn.i, zzjn.j);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int a = a.a(parcel);
        a.a(parcel, 2, this.a, false);
        a.a(parcel, 3, this.b);
        a.a(parcel, 6, this.e);
        a.a(parcel, a);
    }
}
