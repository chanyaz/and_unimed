package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;

public final class e extends a implements zze {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String getId() {
        Parcel a = a(1, a());
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    public final boolean zzb(boolean z) {
        Parcel a = a();
        c.a(a, true);
        a = a(2, a);
        boolean a2 = c.a(a);
        a.recycle();
        return a2;
    }

    public final boolean zzc() {
        Parcel a = a(6, a());
        boolean a2 = c.a(a);
        a.recycle();
        return a2;
    }
}
