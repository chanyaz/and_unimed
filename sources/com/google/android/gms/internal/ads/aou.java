package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;

public final class aou extends afa implements zzqa {
    aou(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final void destroy() {
        b(4, a());
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(3, a);
    }

    public final IObjectWrapper zzak(String str) {
        Parcel a = a();
        a.writeString(str);
        a = a(2, a);
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void zzb(IObjectWrapper iObjectWrapper, int i) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeInt(i);
        b(5, a);
    }

    public final void zzb(String str, IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        a.writeString(str);
        afc.a(a, (IInterface) iObjectWrapper);
        b(1, a);
    }

    public final void zzc(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(6, a);
    }
}
