package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class ane extends afa implements zzoa {
    ane(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.ICustomRenderedAd");
    }

    public final String getContent() {
        Parcel a = a(2, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final void recordClick() {
        b(4, a());
    }

    public final void recordImpression() {
        b(5, a());
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        Parcel a = a();
        afc.a(a, (IInterface) iObjectWrapper);
        b(3, a);
    }

    public final String zzjn() {
        Parcel a = a(1, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }
}
