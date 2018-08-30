package com.google.android.gms.internal.measurement;

final /* synthetic */ class jm implements zzxb {
    private final String a;
    private final boolean b = false;

    jm(String str, boolean z) {
        this.a = str;
    }

    public final Object zzsc() {
        return Boolean.valueOf(jf.a(jj.c.getContentResolver(), this.a, this.b));
    }
}
