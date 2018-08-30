package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class akv extends afa implements zzla {
    akv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public final void onAppEvent(String str, String str2) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        b(1, a);
    }
}
