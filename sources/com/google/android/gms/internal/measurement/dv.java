package com.google.android.gms.internal.measurement;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.ar;
import java.util.List;
import java.util.Map;

@WorkerThread
final class dv implements Runnable {
    private final zzfm a;
    private final int b;
    private final Throwable c;
    private final byte[] d;
    private final String e;
    private final Map<String, List<String>> f;

    private dv(String str, zzfm zzfm, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        ar.a((Object) zzfm);
        this.a = zzfm;
        this.b = i;
        this.c = th;
        this.d = bArr;
        this.e = str;
        this.f = map;
    }

    public final void run() {
        this.a.zza(this.e, this.b, this.c, this.d, this.f);
    }
}
