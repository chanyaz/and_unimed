package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class apo extends afa implements zzrc {
    apo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zzb(zzqs zzqs, String str) {
        Parcel a = a();
        afc.a(a, (IInterface) zzqs);
        a.writeString(str);
        b(1, a);
    }
}
