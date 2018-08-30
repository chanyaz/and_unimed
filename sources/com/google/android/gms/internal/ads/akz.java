package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class akz extends afa implements zzlg {
    akz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
    }

    public final long getValue() {
        Parcel a = a(1, a());
        long readLong = a.readLong();
        a.recycle();
        return readLong;
    }
}
