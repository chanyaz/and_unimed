package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class ahu extends afa implements zzho {
    ahu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzhi zza(zzhl zzhl) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzhl);
        Parcel a2 = a(1, a);
        zzhi zzhi = (zzhi) afc.a(a2, zzhi.CREATOR);
        a2.recycle();
        return zzhi;
    }
}
