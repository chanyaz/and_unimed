package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.s;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public final class f {
    @VisibleForTesting
    static final Logger a = Logger.getLogger(f.class.getName());
    @GuardedBy("this")
    private g b;
    @GuardedBy("this")
    private boolean c;

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Throwable e) {
            a.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e);
        }
    }

    /* JADX WARNING: Missing block: B:8:0x0011, code:
            if (r1 == null) goto L_0x001d;
     */
    /* JADX WARNING: Missing block: B:9:0x0013, code:
            r2 = r1.c;
            r1.c = r0;
            r0 = r1;
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:14:0x001d, code:
            if (r0 == null) goto L_0x0007;
     */
    /* JADX WARNING: Missing block: B:15:0x001f, code:
            b(r0.a, r0.b);
            r0 = r0.c;
     */
    /* JADX WARNING: Missing block: B:22:?, code:
            return;
     */
    public void a() {
        /*
        r3 = this;
        r0 = 0;
        monitor-enter(r3);
        r1 = r3.c;	 Catch:{ all -> 0x001a }
        if (r1 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
    L_0x0007:
        return;
    L_0x0008:
        r1 = 1;
        r3.c = r1;	 Catch:{ all -> 0x001a }
        r1 = r3.b;	 Catch:{ all -> 0x001a }
        r2 = 0;
        r3.b = r2;	 Catch:{ all -> 0x001a }
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
    L_0x0011:
        if (r1 == 0) goto L_0x001d;
    L_0x0013:
        r2 = r1.c;
        r1.c = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x0011;
    L_0x001a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x001a }
        throw r0;
    L_0x001d:
        if (r0 == 0) goto L_0x0007;
    L_0x001f:
        r1 = r0.a;
        r2 = r0.b;
        b(r1, r2);
        r0 = r0.c;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.f.a():void");
    }

    public void a(Runnable runnable, Executor executor) {
        s.a((Object) runnable, (Object) "Runnable was null.");
        s.a((Object) executor, (Object) "Executor was null.");
        synchronized (this) {
            if (this.c) {
                b(runnable, executor);
                return;
            }
            this.b = new g(runnable, executor, this.b);
        }
    }
}
