package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class aov extends afa implements zzqd {
    aov(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
    }

    public final IBinder zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) iObjectWrapper2);
        afc.a(a, (IInterface) iObjectWrapper3);
        a.writeInt(12451000);
        a = a(1, a);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
