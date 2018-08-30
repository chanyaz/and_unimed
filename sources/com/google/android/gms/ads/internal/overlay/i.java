package com.google.android.gms.ads.internal.overlay;

import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.internal.ads.hg;
import com.google.android.gms.internal.ads.ht;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
final class i extends hg {
    final /* synthetic */ c a;

    private i(c cVar) {
        this.a = cVar;
    }

    /* synthetic */ i(c cVar, e eVar) {
        this(cVar);
    }

    public final void a() {
        Bitmap a = au.y().a(Integer.valueOf(this.a.b.o.e));
        if (a != null) {
            ht.a.post(new j(this, au.g().a(this.a.a, a, this.a.b.o.c, this.a.b.o.d)));
        }
    }

    public final void b() {
    }
}
