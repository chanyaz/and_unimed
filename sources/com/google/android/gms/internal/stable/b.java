package com.google.android.gms.internal.stable;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class b extends Binder implements IInterface {
    private static zzd a = null;

    protected b(String str) {
        attachInterface(this, str);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        return false;
    }

    public IBinder asBinder() {
        return this;
    }

    protected boolean b(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i > 16777215) {
            return super.onTransact(i, parcel, parcel2, i2);
        }
        parcel.enforceInterface(getInterfaceDescriptor());
        return false;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        return b(i, parcel, parcel2, i2) ? true : a(i, parcel, parcel2, i2);
    }
}
