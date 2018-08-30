package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class k extends a implements zzaj {
    k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public final void zza(zzad zzad) {
        Parcel a = a();
        ag.a(a, (Parcelable) zzad);
        c(1, a);
    }
}
