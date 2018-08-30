package com.google.android.gms.internal.ads;

final class atf implements Runnable {
    private final /* synthetic */ atp a;
    private final /* synthetic */ zzuu b;
    private final /* synthetic */ asy c;

    atf(asy asy, atp atp, zzuu zzuu) {
        this.c = asy;
        this.a = atp;
        this.b = zzuu;
    }

    /* JADX WARNING: Missing block: B:13:?, code:
            return;
     */
    public final void run() {
        /*
        r3 = this;
        r0 = r3.c;
        r1 = r0.a;
        monitor-enter(r1);
        r0 = r3.a;	 Catch:{ all -> 0x0035 }
        r0 = r0.b();	 Catch:{ all -> 0x0035 }
        r2 = -1;
        if (r0 == r2) goto L_0x0019;
    L_0x0010:
        r0 = r3.a;	 Catch:{ all -> 0x0035 }
        r0 = r0.b();	 Catch:{ all -> 0x0035 }
        r2 = 1;
        if (r0 != r2) goto L_0x001b;
    L_0x0019:
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
    L_0x001a:
        return;
    L_0x001b:
        r0 = r3.a;	 Catch:{ all -> 0x0035 }
        r0.a();	 Catch:{ all -> 0x0035 }
        r0 = com.google.android.gms.internal.ads.lf.a;	 Catch:{ all -> 0x0035 }
        r2 = r3.b;	 Catch:{ all -> 0x0035 }
        r2.getClass();	 Catch:{ all -> 0x0035 }
        r2 = com.google.android.gms.internal.ads.atg.a(r2);	 Catch:{ all -> 0x0035 }
        r0.execute(r2);	 Catch:{ all -> 0x0035 }
        r0 = "Could not receive loaded message in a timely manner. Rejecting.";
        com.google.android.gms.internal.ads.hl.a(r0);	 Catch:{ all -> 0x0035 }
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        goto L_0x001a;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0035 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.atf.run():void");
    }
}
