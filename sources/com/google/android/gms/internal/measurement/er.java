package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.ar;
import java.util.concurrent.BlockingQueue;

final class er extends Thread {
    private final Object a = new Object();
    private final BlockingQueue<eq<?>> b;
    private final /* synthetic */ en c;

    public er(en enVar, String str, BlockingQueue<eq<?>> blockingQueue) {
        this.c = enVar;
        ar.a((Object) str);
        ar.a((Object) blockingQueue);
        this.b = blockingQueue;
        setName(str);
    }

    private final void a(InterruptedException interruptedException) {
        this.c.zzge().u().a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.a) {
            this.a.notifyAll();
        }
    }

    /* JADX WARNING: Missing block: B:45:0x008b, code:
            r1 = r6.c.h;
     */
    /* JADX WARNING: Missing block: B:46:0x0091, code:
            monitor-enter(r1);
     */
    /* JADX WARNING: Missing block: B:48:?, code:
            r6.c.i.release();
            r6.c.h.notifyAll();
     */
    /* JADX WARNING: Missing block: B:49:0x00aa, code:
            if (r6 != r6.c.b) goto L_0x00bc;
     */
    /* JADX WARNING: Missing block: B:50:0x00ac, code:
            r6.c.b = null;
     */
    /* JADX WARNING: Missing block: B:51:0x00b2, code:
            monitor-exit(r1);
     */
    /* JADX WARNING: Missing block: B:52:0x00b3, code:
            return;
     */
    /* JADX WARNING: Missing block: B:62:0x00c2, code:
            if (r6 != r6.c.c) goto L_0x00ce;
     */
    /* JADX WARNING: Missing block: B:63:0x00c4, code:
            r6.c.c = null;
     */
    /* JADX WARNING: Missing block: B:68:?, code:
            r6.c.zzge().r().a("Current scheduler thread is neither worker nor network");
     */
    public final void run() {
        /*
        r6 = this;
        r0 = 0;
        r1 = r0;
    L_0x0002:
        if (r1 != 0) goto L_0x0015;
    L_0x0004:
        r0 = r6.c;	 Catch:{ InterruptedException -> 0x0010 }
        r0 = r0.i;	 Catch:{ InterruptedException -> 0x0010 }
        r0.acquire();	 Catch:{ InterruptedException -> 0x0010 }
        r0 = 1;
        r1 = r0;
        goto L_0x0002;
    L_0x0010:
        r0 = move-exception;
        r6.a(r0);
        goto L_0x0002;
    L_0x0015:
        r0 = android.os.Process.myTid();	 Catch:{ all -> 0x0033 }
        r2 = android.os.Process.getThreadPriority(r0);	 Catch:{ all -> 0x0033 }
    L_0x001d:
        r0 = r6.b;	 Catch:{ all -> 0x0033 }
        r0 = r0.poll();	 Catch:{ all -> 0x0033 }
        r0 = (com.google.android.gms.internal.measurement.eq) r0;	 Catch:{ all -> 0x0033 }
        if (r0 == 0) goto L_0x0060;
    L_0x0027:
        r1 = r0.a;	 Catch:{ all -> 0x0033 }
        if (r1 == 0) goto L_0x005d;
    L_0x002b:
        r1 = r2;
    L_0x002c:
        android.os.Process.setThreadPriority(r1);	 Catch:{ all -> 0x0033 }
        r0.run();	 Catch:{ all -> 0x0033 }
        goto L_0x001d;
    L_0x0033:
        r0 = move-exception;
        r1 = r6.c;
        r1 = r1.h;
        monitor-enter(r1);
        r2 = r6.c;	 Catch:{ all -> 0x00f4 }
        r2 = r2.i;	 Catch:{ all -> 0x00f4 }
        r2.release();	 Catch:{ all -> 0x00f4 }
        r2 = r6.c;	 Catch:{ all -> 0x00f4 }
        r2 = r2.h;	 Catch:{ all -> 0x00f4 }
        r2.notifyAll();	 Catch:{ all -> 0x00f4 }
        r2 = r6.c;	 Catch:{ all -> 0x00f4 }
        r2 = r2.b;	 Catch:{ all -> 0x00f4 }
        if (r6 != r2) goto L_0x00e4;
    L_0x0055:
        r2 = r6.c;	 Catch:{ all -> 0x00f4 }
        r3 = 0;
        r2.b = null;	 Catch:{ all -> 0x00f4 }
    L_0x005b:
        monitor-exit(r1);	 Catch:{ all -> 0x00f4 }
        throw r0;
    L_0x005d:
        r1 = 10;
        goto L_0x002c;
    L_0x0060:
        r1 = r6.a;	 Catch:{ all -> 0x0033 }
        monitor-enter(r1);	 Catch:{ all -> 0x0033 }
        r0 = r6.b;	 Catch:{ all -> 0x00b9 }
        r0 = r0.peek();	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x007a;
    L_0x006b:
        r0 = r6.c;	 Catch:{ all -> 0x00b9 }
        r0 = r0.j;	 Catch:{ all -> 0x00b9 }
        if (r0 != 0) goto L_0x007a;
    L_0x0073:
        r0 = r6.a;	 Catch:{ InterruptedException -> 0x00b4 }
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.wait(r4);	 Catch:{ InterruptedException -> 0x00b4 }
    L_0x007a:
        monitor-exit(r1);	 Catch:{ all -> 0x00b9 }
        r0 = r6.c;	 Catch:{ all -> 0x0033 }
        r1 = r0.h;	 Catch:{ all -> 0x0033 }
        monitor-enter(r1);	 Catch:{ all -> 0x0033 }
        r0 = r6.b;	 Catch:{ all -> 0x00e1 }
        r0 = r0.peek();	 Catch:{ all -> 0x00e1 }
        if (r0 != 0) goto L_0x00de;
    L_0x008a:
        monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
        r0 = r6.c;
        r1 = r0.h;
        monitor-enter(r1);
        r0 = r6.c;	 Catch:{ all -> 0x00cb }
        r0 = r0.i;	 Catch:{ all -> 0x00cb }
        r0.release();	 Catch:{ all -> 0x00cb }
        r0 = r6.c;	 Catch:{ all -> 0x00cb }
        r0 = r0.h;	 Catch:{ all -> 0x00cb }
        r0.notifyAll();	 Catch:{ all -> 0x00cb }
        r0 = r6.c;	 Catch:{ all -> 0x00cb }
        r0 = r0.b;	 Catch:{ all -> 0x00cb }
        if (r6 != r0) goto L_0x00bc;
    L_0x00ac:
        r0 = r6.c;	 Catch:{ all -> 0x00cb }
        r2 = 0;
        r0.b = null;	 Catch:{ all -> 0x00cb }
    L_0x00b2:
        monitor-exit(r1);	 Catch:{ all -> 0x00cb }
        return;
    L_0x00b4:
        r0 = move-exception;
        r6.a(r0);	 Catch:{ all -> 0x00b9 }
        goto L_0x007a;
    L_0x00b9:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00b9 }
        throw r0;	 Catch:{ all -> 0x0033 }
    L_0x00bc:
        r0 = r6.c;	 Catch:{ all -> 0x00cb }
        r0 = r0.c;	 Catch:{ all -> 0x00cb }
        if (r6 != r0) goto L_0x00ce;
    L_0x00c4:
        r0 = r6.c;	 Catch:{ all -> 0x00cb }
        r2 = 0;
        r0.c = null;	 Catch:{ all -> 0x00cb }
        goto L_0x00b2;
    L_0x00cb:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00cb }
        throw r0;
    L_0x00ce:
        r0 = r6.c;	 Catch:{ all -> 0x00cb }
        r0 = r0.zzge();	 Catch:{ all -> 0x00cb }
        r0 = r0.r();	 Catch:{ all -> 0x00cb }
        r2 = "Current scheduler thread is neither worker nor network";
        r0.a(r2);	 Catch:{ all -> 0x00cb }
        goto L_0x00b2;
    L_0x00de:
        monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
        goto L_0x001d;
    L_0x00e1:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00e1 }
        throw r0;	 Catch:{ all -> 0x0033 }
    L_0x00e4:
        r2 = r6.c;	 Catch:{ all -> 0x00f4 }
        r2 = r2.c;	 Catch:{ all -> 0x00f4 }
        if (r6 != r2) goto L_0x00f7;
    L_0x00ec:
        r2 = r6.c;	 Catch:{ all -> 0x00f4 }
        r3 = 0;
        r2.c = null;	 Catch:{ all -> 0x00f4 }
        goto L_0x005b;
    L_0x00f4:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00f4 }
        throw r0;
    L_0x00f7:
        r2 = r6.c;	 Catch:{ all -> 0x00f4 }
        r2 = r2.zzge();	 Catch:{ all -> 0x00f4 }
        r2 = r2.r();	 Catch:{ all -> 0x00f4 }
        r3 = "Current scheduler thread is neither worker nor network";
        r2.a(r3);	 Catch:{ all -> 0x00f4 }
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.er.run():void");
    }
}
