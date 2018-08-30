package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.a;

public final class pm extends afa implements zzatn {
    pm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    public final String getVersion() {
        Parcel a = a(6, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final IObjectWrapper zza(String str, IObjectWrapper iObjectWrapper, String str2, String str3, String str4) {
        Parcel a = a();
        a.writeString(str);
        afc.a(a, (IInterface) iObjectWrapper);
        a.writeString(str2);
        a.writeString(str3);
        a.writeString(str4);
        a = a(3, a);
        IObjectWrapper a2 = a.a(a.readStrongBinder());
        a.recycle();
        return a2;
    }

    public final void zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        afc.a(a, (IInterface) iObjectWrapper2);
        b(5, a);
    }

    public final void zzm(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(4, a);
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(7, a);
    }

    public final boolean zzy(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        a = a(2, a);
        boolean a2 = afc.a(a);
        a.recycle();
        return a2;
    }
}
