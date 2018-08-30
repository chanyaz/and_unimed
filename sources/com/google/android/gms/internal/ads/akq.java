package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class akq extends afa implements zzkv {
    akq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zza(IObjectWrapper iObjectWrapper, zzjn zzjn, String str, zzxn zzxn, int i, int i2) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (Parcelable) zzjn);
        a.writeString(str);
        afc.a(a, (IInterface) zzxn);
        a.writeInt(12451000);
        a.writeInt(i2);
        a = a(2, a);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
