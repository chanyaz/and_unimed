package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class apv extends afa implements zzro {
    apv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    public final void onUnconfirmedClickCancelled() {
        b(2, a());
    }

    public final void onUnconfirmedClickReceived(String str) {
        Parcel a = a();
        a.writeString(str);
        b(1, a);
    }
}
