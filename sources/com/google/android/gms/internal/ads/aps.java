package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class aps extends afa implements zzri {
    aps(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    public final void zza(zzks zzks, IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) zzks);
        afc.a(a, (IInterface) iObjectWrapper);
        b(1, a);
    }
}
