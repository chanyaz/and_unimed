package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

@zzadh
final class lc {
    private final Object a = new Object();
    private final List<Runnable> b = new ArrayList();
    private boolean c = false;

    /* JADX WARNING: Missing block: B:8:0x001c, code:
            r0 = r0;
            r3 = r0.size();
            r2 = 0;
     */
    /* JADX WARNING: Missing block: B:9:0x0024, code:
            if (r2 >= r3) goto L_0x000d;
     */
    /* JADX WARNING: Missing block: B:10:0x0026, code:
            r1 = r0.get(r2);
            r2 = r2 + 1;
            ((java.lang.Runnable) r1).run();
     */
    /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
    public final void a() {
        /*
        r4 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r4.a;
        monitor-enter(r1);
        r2 = r4.c;	 Catch:{ all -> 0x0032 }
        if (r2 == 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
    L_0x000d:
        return;
    L_0x000e:
        r2 = r4.b;	 Catch:{ all -> 0x0032 }
        r0.addAll(r2);	 Catch:{ all -> 0x0032 }
        r2 = r4.b;	 Catch:{ all -> 0x0032 }
        r2.clear();	 Catch:{ all -> 0x0032 }
        r2 = 1;
        r4.c = r2;	 Catch:{ all -> 0x0032 }
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
        r0 = (java.util.ArrayList) r0;
        r3 = r0.size();
        r1 = 0;
        r2 = r1;
    L_0x0024:
        if (r2 >= r3) goto L_0x000d;
    L_0x0026:
        r1 = r0.get(r2);
        r2 = r2 + 1;
        r1 = (java.lang.Runnable) r1;
        r1.run();
        goto L_0x0024;
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0032 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.lc.a():void");
    }

    public final void a(Runnable runnable, Executor executor) {
        synchronized (this.a) {
            if (this.c) {
                executor.execute(runnable);
            } else {
                this.b.add(new ld(executor, runnable));
            }
        }
    }
}
