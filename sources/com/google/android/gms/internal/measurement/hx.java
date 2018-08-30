package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

final class hx implements zzfm {
    private final /* synthetic */ String a;
    private final /* synthetic */ hw b;

    hx(hw hwVar, String str) {
        this.b = hwVar;
        this.a = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.b.a(i, th, bArr, this.a);
    }
}
