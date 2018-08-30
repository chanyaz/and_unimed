package com.google.android.gms.internal.ads;

import java.lang.Thread.UncaughtExceptionHandler;

final class br implements UncaughtExceptionHandler {
    private final /* synthetic */ UncaughtExceptionHandler a;
    private final /* synthetic */ bq b;

    br(bq bqVar, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = bqVar;
        this.a = uncaughtExceptionHandler;
    }

    /* JADX WARNING: Failed to extract finally block: empty outs */
    public final void uncaughtException(java.lang.Thread r3, java.lang.Throwable r4) {
        /*
        r2 = this;
        r0 = r2.b;	 Catch:{ Throwable -> 0x000f }
        r0.a(r3, r4);	 Catch:{ Throwable -> 0x000f }
        r0 = r2.a;
        if (r0 == 0) goto L_0x000e;
    L_0x0009:
        r0 = r2.a;
        r0.uncaughtException(r3, r4);
    L_0x000e:
        return;
    L_0x000f:
        r0 = move-exception;
        r0 = "AdMob exception reporter failed reporting the exception.";
        com.google.android.gms.internal.ads.kk.c(r0);	 Catch:{ all -> 0x001f }
        r0 = r2.a;
        if (r0 == 0) goto L_0x000e;
    L_0x0019:
        r0 = r2.a;
        r0.uncaughtException(r3, r4);
        goto L_0x000e;
    L_0x001f:
        r0 = move-exception;
        r1 = r2.a;
        if (r1 == 0) goto L_0x0029;
    L_0x0024:
        r1 = r2.a;
        r1.uncaughtException(r3, r4);
    L_0x0029:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.br.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
