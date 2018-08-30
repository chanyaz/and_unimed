package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import java.lang.Thread.UncaughtExceptionHandler;

final class ep implements UncaughtExceptionHandler {
    private final String a;
    private final /* synthetic */ en b;

    public ep(en enVar, String str) {
        this.b = enVar;
        ar.a((Object) str);
        this.a = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.b.zzge().r().a(this.a, th);
    }
}
