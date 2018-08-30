package com.google.android.gms.internal.ads;

import com.mopub.volley.DefaultRetryPolicy;

public final class ahi implements zzab {
    private int a;
    private int b;
    private final int c;
    private final float d;

    public ahi() {
        this(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    private ahi(int i, int i2, float f) {
        this.a = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
        this.c = 1;
        this.d = 1.0f;
    }

    public final void zza(zzae zzae) {
        this.b++;
        this.a = (int) (((float) this.a) + (((float) this.a) * this.d));
        if ((this.b <= this.c ? 1 : null) == null) {
            throw zzae;
        }
    }

    public final int zzc() {
        return this.a;
    }

    public final int zzd() {
        return this.b;
    }
}
