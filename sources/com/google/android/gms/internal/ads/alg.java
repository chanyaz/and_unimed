package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;

public final class alg extends afa implements zzlr {
    alg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void onVideoEnd() {
        b(4, a());
    }

    public final void onVideoMute(boolean z) {
        Parcel a = a();
        afc.a(a, z);
        b(5, a);
    }

    public final void onVideoPause() {
        b(3, a());
    }

    public final void onVideoPlay() {
        b(2, a());
    }

    public final void onVideoStart() {
        b(1, a());
    }
}
