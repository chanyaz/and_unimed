package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class avc extends afb implements zzxw {
    public avc() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        int zzmm = zzmm();
        parcel2.writeNoException();
        parcel2.writeInt(zzmm);
        return true;
    }
}
