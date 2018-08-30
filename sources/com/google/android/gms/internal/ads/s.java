package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class s extends afb implements zzaaw {
    public static zzaaw a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        return queryLocalInterface instanceof zzaaw ? (zzaaw) queryLocalInterface : new t(iBinder);
    }
}
