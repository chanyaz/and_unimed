package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;

final class gz {
    private final Object a;
    private volatile int b;
    private volatile long c;

    private gz() {
        this.a = new Object();
        this.b = ha.a;
        this.c = 0;
    }

    /* synthetic */ gz(gy gyVar) {
        this();
    }

    /* JADX WARNING: Missing block: B:14:?, code:
            return;
     */
    private final void a(int r6, int r7) {
        /*
        r5 = this;
        r5.d();
        r0 = com.google.android.gms.ads.internal.au.l();
        r0 = r0.currentTimeMillis();
        r2 = r5.a;
        monitor-enter(r2);
        r3 = r5.b;	 Catch:{ all -> 0x0020 }
        if (r3 == r6) goto L_0x0014;
    L_0x0012:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
    L_0x0013:
        return;
    L_0x0014:
        r5.b = r7;	 Catch:{ all -> 0x0020 }
        r3 = r5.b;	 Catch:{ all -> 0x0020 }
        r4 = com.google.android.gms.internal.ads.ha.c;	 Catch:{ all -> 0x0020 }
        if (r3 != r4) goto L_0x001e;
    L_0x001c:
        r5.c = r0;	 Catch:{ all -> 0x0020 }
    L_0x001e:
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        goto L_0x0013;
    L_0x0020:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0020 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.gz.a(int, int):void");
    }

    private final void d() {
        long currentTimeMillis = au.l().currentTimeMillis();
        synchronized (this.a) {
            if (this.b == ha.c) {
                if (this.c + ((Long) akc.f().a(amn.di)).longValue() <= currentTimeMillis) {
                    this.b = ha.a;
                }
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            a(ha.a, ha.b);
        } else {
            a(ha.b, ha.a);
        }
    }

    public final boolean a() {
        d();
        return this.b == ha.b;
    }

    public final boolean b() {
        d();
        return this.b == ha.c;
    }

    public final void c() {
        a(ha.b, ha.c);
    }
}
