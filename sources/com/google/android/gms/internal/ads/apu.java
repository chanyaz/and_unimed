package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class apu extends afa implements zzrl {
    apu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zza(zzrr zzrr) {
        Parcel a = a();
        afc.a(a, (IInterface) zzrr);
        b(1, a);
    }
}
