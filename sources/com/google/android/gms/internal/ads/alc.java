package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class alc extends afa implements zzlm {
    alc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
    }

    public final IBinder zza(IObjectWrapper iObjectWrapper, int i) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeInt(12451000);
        a = a(1, a);
        IBinder readStrongBinder = a.readStrongBinder();
        a.recycle();
        return readStrongBinder;
    }
}
