package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzadh;
import java.util.List;

@zzadh
@VisibleForTesting
final class d {
    private final String a;
    private final int b;
    private final List<a> c;
    private final String d;

    d(String str, int i, List<a> list, String str2) {
        this.a = str;
        this.b = i;
        this.c = list;
        this.d = str2;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final Iterable<a> c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }
}
