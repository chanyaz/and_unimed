package com.google.android.gms.internal.measurement;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public abstract class kd {
    private static volatile boolean d = false;
    int a;
    private int b;
    private boolean c;

    private kd() {
        this.a = 100;
        this.b = MoPubClientPositioning.NO_REPEAT;
        this.c = false;
    }

    /* synthetic */ kd(ke keVar) {
        this();
    }

    static kd a(byte[] bArr, int i, int i2, boolean z) {
        kd kfVar = new kf(bArr, i, i2, false, null);
        try {
            kfVar.a(i2);
            return kfVar;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int a();
}
