package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;

@zzadh
public final class na extends hg {
    final zzapw a;
    final nd b;
    private final String c;

    na(zzapw zzapw, nd ndVar, String str) {
        this.a = zzapw;
        this.b = ndVar;
        this.c = str;
        au.z().a(this);
    }

    public final void a() {
        try {
            this.b.a(this.c);
        } finally {
            ht.a.post(new nb(this));
        }
    }

    public final void b() {
        this.b.a();
    }
}
