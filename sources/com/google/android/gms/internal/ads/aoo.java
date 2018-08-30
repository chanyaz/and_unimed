package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

public final class aoo extends afa implements zzps {
    aoo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String getText() {
        Parcel a = a(2, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final List<zzpw> zzjr() {
        Parcel a = a(3, a());
        List b = afc.b(a);
        a.recycle();
        return b;
    }
}
