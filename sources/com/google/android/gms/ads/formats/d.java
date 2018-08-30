package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.formats.NativeAdOptions.AdChoicesPlacement;
import com.google.android.gms.ads.m;

public final class d {
    private boolean a = false;
    private int b = -1;
    private boolean c = false;
    private m d;
    private int e = 1;

    public final NativeAdOptions a() {
        return new NativeAdOptions(this, null);
    }

    public final d a(int i) {
        this.b = i;
        return this;
    }

    public final d a(m mVar) {
        this.d = mVar;
        return this;
    }

    public final d a(boolean z) {
        this.a = z;
        return this;
    }

    public final d b(@AdChoicesPlacement int i) {
        this.e = i;
        return this;
    }

    public final d b(boolean z) {
        this.c = z;
        return this;
    }
}
