package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class aki extends afa implements zzkh {
    aki(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void onAdClicked() {
        b(6, a());
    }

    public final void onAdClosed() {
        b(1, a());
    }

    public final void onAdFailedToLoad(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(2, a);
    }

    public final void onAdImpression() {
        b(7, a());
    }

    public final void onAdLeftApplication() {
        b(3, a());
    }

    public final void onAdLoaded() {
        b(4, a());
    }

    public final void onAdOpened() {
        b(5, a());
    }
}
