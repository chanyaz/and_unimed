package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class u extends afb implements zzaaz {
    public static zzaaz a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManager");
        return queryLocalInterface instanceof zzaaz ? (zzaaz) queryLocalInterface : new v(iBinder);
    }
}
