package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.b;
import com.google.android.gms.internal.stable.c;

public abstract class ae extends b implements IGmsCallbacks {
    public ae() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public static IGmsCallbacks a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
        return queryLocalInterface instanceof IGmsCallbacks ? (IGmsCallbacks) queryLocalInterface : new af(iBinder);
    }

    protected boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) c.a(parcel, Bundle.CREATOR));
                break;
            case 2:
                onAccountValidationComplete(parcel.readInt(), (Bundle) c.a(parcel, Bundle.CREATOR));
                break;
            case 3:
                onPostInitCompleteWithConnectionInfo(parcel.readInt(), parcel.readStrongBinder(), (ConnectionInfo) c.a(parcel, ConnectionInfo.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
