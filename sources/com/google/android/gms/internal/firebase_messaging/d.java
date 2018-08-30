package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.IInterface;

public abstract class d extends b implements zze {
    public static zze a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.iid.IMessengerCompat");
        return queryLocalInterface instanceof zze ? (zze) queryLocalInterface : new e(iBinder);
    }
}
