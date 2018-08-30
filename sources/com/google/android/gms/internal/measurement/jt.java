package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class jt {
    private final String a;
    private final Uri b;
    private final String c;
    private final String d;
    private final boolean e;
    private final boolean f;

    public jt(Uri uri) {
        this(null, uri, "", "", false, false);
    }

    private jt(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
        this.a = null;
        this.b = uri;
        this.c = str2;
        this.d = str3;
        this.e = false;
        this.f = false;
    }

    public final jj<Double> a(String str, double d) {
        return jj.b(this, str, d);
    }

    public final jj<Integer> a(String str, int i) {
        return jj.b(this, str, i);
    }

    public final jj<Long> a(String str, long j) {
        return jj.b(this, str, j);
    }

    public final jj<String> a(String str, String str2) {
        return jj.b(this, str, str2);
    }

    public final jj<Boolean> a(String str, boolean z) {
        return jj.b(this, str, z);
    }
}
