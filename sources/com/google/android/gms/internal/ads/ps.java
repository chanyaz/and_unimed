package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class ps extends afa implements zzatx {
    ps(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzatv zza(zzatt zzatt) {
        Parcel a = a();
        afc.a(a, (Parcelable) zzatt);
        Parcel a2 = a(1, a);
        zzatv zzatv = (zzatv) afc.a(a2, zzatv.CREATOR);
        a2.recycle();
        return zzatv;
    }
}
