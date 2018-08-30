package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class ac extends b implements ICertData {
    public ac() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static ICertData a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return queryLocalInterface instanceof ICertData ? (ICertData) queryLocalInterface : new ad(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                IInterface bytesWrapped = getBytesWrapped();
                parcel2.writeNoException();
                c.a(parcel2, bytesWrapped);
                break;
            case 2:
                int hashCode = getHashCode();
                parcel2.writeNoException();
                parcel2.writeInt(hashCode);
                break;
            default:
                return false;
        }
        return true;
    }
}
