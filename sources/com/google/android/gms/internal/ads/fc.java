package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class fc extends afa implements zzahe {
    fc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void onRewardedVideoAdClosed() {
        b(4, a());
    }

    public final void onRewardedVideoAdFailedToLoad(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(7, a);
    }

    public final void onRewardedVideoAdLeftApplication() {
        b(6, a());
    }

    public final void onRewardedVideoAdLoaded() {
        b(1, a());
    }

    public final void onRewardedVideoAdOpened() {
        b(2, a());
    }

    public final void onRewardedVideoCompleted() {
        b(8, a());
    }

    public final void onRewardedVideoStarted() {
        b(3, a());
    }

    public final void zza(zzagu zzagu) {
        Parcel a = a();
        afc.a(a, (IInterface) zzagu);
        b(5, a);
    }
}
