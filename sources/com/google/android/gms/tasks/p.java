package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

final class p<TResult> {
    private final Object a = new Object();
    @GuardedBy("mLock")
    private Queue<zzq<TResult>> b;
    @GuardedBy("mLock")
    private boolean c;

    p() {
    }

    /* JADX WARNING: Missing block: B:10:0x0011, code:
            r1 = r2.a;
     */
    /* JADX WARNING: Missing block: B:11:0x0013, code:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:13:?, code:
            r0 = (com.google.android.gms.tasks.zzq) r2.b.poll();
     */
    /* JADX WARNING: Missing block: B:14:0x001c, code:
            if (r0 != null) goto L_0x0029;
     */
    /* JADX WARNING: Missing block: B:15:0x001e, code:
            r2.c = false;
     */
    /* JADX WARNING: Missing block: B:16:0x0021, code:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:25:?, code:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:26:0x002a, code:
            r0.onComplete(r3);
     */
    /* JADX WARNING: Missing block: B:32:?, code:
            return;
     */
    /* JADX WARNING: Missing block: B:33:?, code:
            return;
     */
    public final void a(@android.support.annotation.NonNull com.google.android.gms.tasks.a<TResult> r3) {
        /*
        r2 = this;
        r1 = r2.a;
        monitor-enter(r1);
        r0 = r2.b;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.c;	 Catch:{ all -> 0x0026 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = 1;
        r2.c = r0;	 Catch:{ all -> 0x0026 }
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
    L_0x0011:
        r1 = r2.a;
        monitor-enter(r1);
        r0 = r2.b;	 Catch:{ all -> 0x0023 }
        r0 = r0.poll();	 Catch:{ all -> 0x0023 }
        r0 = (com.google.android.gms.tasks.zzq) r0;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0029;
    L_0x001e:
        r0 = 0;
        r2.c = r0;	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0026 }
        throw r0;
    L_0x0029:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        r0.onComplete(r3);
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tasks.p.a(com.google.android.gms.tasks.a):void");
    }

    public final void a(@NonNull zzq<TResult> zzq) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(zzq);
        }
    }
}
