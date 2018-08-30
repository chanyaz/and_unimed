package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class cx extends afa implements zzaeq {
    cx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    public final void zza(zzaej zzaej) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzaej);
        b(1, a);
    }
}
