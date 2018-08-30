package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class akf extends afb implements zzke {
    public akf() {
        super("com.google.android.gms.ads.internal.client.IAdClickListener");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        onAdClicked();
        parcel2.writeNoException();
        return true;
    }
}
