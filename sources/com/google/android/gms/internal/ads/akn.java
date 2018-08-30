package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class akn extends afa implements zzkq {
    akn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
    }

    public final IBinder zza(IObjectWrapper iObjectWrapper, String str, zzxn zzxn, int i) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeString(str);
        afc.a(a, (IInterface) zzxn);
        a.writeInt(12451000);
        a = a(1, a);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
