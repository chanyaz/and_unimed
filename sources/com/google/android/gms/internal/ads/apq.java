package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class apq extends afa implements zzrf {
    apq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zzb(zzqs zzqs) {
        Parcel a = a();
        afc.a(a, (IInterface) zzqs);
        b(1, a);
    }
}
