package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class w extends afb implements zzabc {
    public static zzabc a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        return queryLocalInterface instanceof zzabc ? (zzabc) queryLocalInterface : new x(iBinder);
    }
}
