package com.google.android.gms.ads.formats;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.m;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
public final class NativeAdOptions {
    private final boolean a;
    private final int b;
    private final boolean c;
    private final int d;
    private final m e;

    public @interface AdChoicesPlacement {
    }

    private NativeAdOptions(d dVar) {
        this.a = dVar.a;
        this.b = dVar.b;
        this.c = dVar.c;
        this.d = dVar.e;
        this.e = dVar.d;
    }

    /* synthetic */ NativeAdOptions(d dVar, f fVar) {
        this(dVar);
    }

    public final boolean a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    @Nullable
    public final m e() {
        return this.e;
    }
}
