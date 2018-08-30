package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzadh;
import java.net.URL;
import java.util.ArrayList;

@zzadh
@VisibleForTesting
final class b {
    private final String a;
    private final URL b;
    private final ArrayList<a> c;
    private final String d;

    b(String str, URL url, ArrayList<a> arrayList, String str2) {
        this.a = str;
        this.b = url;
        this.c = arrayList;
        this.d = str2;
    }

    public final String a() {
        return this.a;
    }

    public final URL b() {
        return this.b;
    }

    public final ArrayList<a> c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }
}
