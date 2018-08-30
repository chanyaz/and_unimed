package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class akr extends afb implements zzkx {
    public akr() {
        super("com.google.android.gms.ads.internal.client.IAdMetadataListener");
    }

    public static zzkx a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
        return queryLocalInterface instanceof zzkx ? (zzkx) queryLocalInterface : new aks(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        zzt();
        parcel2.writeNoException();
        return true;
    }
}
