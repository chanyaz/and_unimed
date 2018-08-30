package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class aku extends afb implements zzla {
    public aku() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static zzla a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        return queryLocalInterface instanceof zzla ? (zzla) queryLocalInterface : new akv(iBinder);
    }

    protected final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        onAppEvent(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
