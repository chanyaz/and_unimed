package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class cw extends afb implements zzaeq {
    public cw() {
        super("com.google.android.gms.ads.internal.request.IAdResponseListener");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zza((zzaej) afc.a(parcel, zzaej.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
