package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.IInterface;

public abstract class d extends b implements zze {
    public static zze a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return queryLocalInterface instanceof zze ? (zze) queryLocalInterface : new e(iBinder);
    }
}
