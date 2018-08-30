package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.br;
import com.google.android.gms.ads.internal.l;
import com.google.android.gms.common.util.VisibleForTesting;

@zzadh
@VisibleForTesting
public final class aqr {
    private final Context a;
    private final zzxn b;
    private final zzang c;
    private final br d;

    aqr(Context context, zzxn zzxn, zzang zzang, br brVar) {
        this.a = context;
        this.b = zzxn;
        this.c = zzang;
        this.d = brVar;
    }

    @VisibleForTesting
    public final Context a() {
        return this.a.getApplicationContext();
    }

    @VisibleForTesting
    public final l a(String str) {
        return new l(this.a, new zzjn(), str, this.b, this.c, this.d);
    }

    @VisibleForTesting
    public final l b(String str) {
        return new l(this.a.getApplicationContext(), new zzjn(), str, this.b, this.c, this.d);
    }

    @VisibleForTesting
    public final aqr b() {
        return new aqr(this.a.getApplicationContext(), this.b, this.c, this.d);
    }
}
