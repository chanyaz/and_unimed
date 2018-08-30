package com.google.android.gms.internal.measurement;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

final class kf extends kd {
    private final byte[] b;
    private final boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    private kf(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.h = MoPubClientPositioning.NO_REPEAT;
        this.b = bArr;
        this.d = i + i2;
        this.f = i;
        this.g = this.f;
        this.c = z;
    }

    /* synthetic */ kf(byte[] bArr, int i, int i2, boolean z, ke keVar) {
        this(bArr, i, i2, false);
    }

    private final void b() {
        this.d += this.e;
        int i = this.d - this.g;
        if (i > this.h) {
            this.e = i - this.h;
            this.d -= this.e;
            return;
        }
        this.e = 0;
    }

    public final int a() {
        return this.f - this.g;
    }

    public final int a(int i) {
        if (i < 0) {
            throw zzzt.b();
        }
        int a = a() + i;
        int i2 = this.h;
        if (a > i2) {
            throw zzzt.a();
        }
        this.h = a;
        b();
        return i2;
    }
}
