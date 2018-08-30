package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class avb extends afa implements zzxt {
    avb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void onAdClicked() {
        b(1, a());
    }

    public final void onAdClosed() {
        b(2, a());
    }

    public final void onAdFailedToLoad(int i) {
        Parcel a = a();
        a.writeInt(i);
        b(3, a);
    }

    public final void onAdImpression() {
        b(8, a());
    }

    public final void onAdLeftApplication() {
        b(4, a());
    }

    public final void onAdLoaded() {
        b(6, a());
    }

    public final void onAdOpened() {
        b(5, a());
    }

    public final void onAppEvent(String str, String str2) {
        Parcel a = a();
        a.writeString(str);
        a.writeString(str2);
        b(9, a);
    }

    public final void onVideoEnd() {
        b(11, a());
    }

    public final void zza(zzxw zzxw) {
        Parcel a = a();
        afc.a(a, (IInterface) zzxw);
        b(7, a);
    }

    public final void zzb(zzqs zzqs, String str) {
        Parcel a = a();
        afc.a(a, (IInterface) zzqs);
        a.writeString(str);
        b(10, a);
    }

    public final void zzbj(String str) {
        Parcel a = a();
        a.writeString(str);
        b(12, a);
    }
}
