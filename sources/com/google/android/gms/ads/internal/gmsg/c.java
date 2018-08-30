package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzadh;

@zzadh
@VisibleForTesting
final class c {
    private final d a;
    private final boolean b;
    private final String c;

    public c(HttpClient httpClient, boolean z, d dVar, String str) {
        this.b = z;
        this.a = dVar;
        this.c = str;
    }

    public final String a() {
        return this.c;
    }

    public final d b() {
        return this.a;
    }

    public final boolean c() {
        return this.b;
    }
}
