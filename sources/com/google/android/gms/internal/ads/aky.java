package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class aky extends afb implements zzlg {
    public aky() {
        super("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        long value = getValue();
        parcel2.writeNoException();
        parcel2.writeLong(value);
        return true;
    }
}
