package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class gr implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ zzdz b;
    private final /* synthetic */ go c;

    gr(go goVar, AtomicReference atomicReference, zzdz zzdz) {
        this.c = goVar;
        this.a = atomicReference;
        this.b = zzdz;
    }

    /* JADX WARNING: Missing block: B:23:?, code:
            return;
     */
    public final void run() {
        /*
        r4 = this;
        r1 = r4.a;
        monitor-enter(r1);
        r0 = r4.c;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.b;	 Catch:{ RemoteException -> 0x0059 }
        if (r0 != 0) goto L_0x0021;
    L_0x000b:
        r0 = r4.c;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.zzge();	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.r();	 Catch:{ RemoteException -> 0x0059 }
        r2 = "Failed to get app instance id";
        r0.a(r2);	 Catch:{ RemoteException -> 0x0059 }
        r0 = r4.a;	 Catch:{ all -> 0x0056 }
        r0.notify();	 Catch:{ all -> 0x0056 }
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
    L_0x0020:
        return;
    L_0x0021:
        r2 = r4.a;	 Catch:{ RemoteException -> 0x0059 }
        r3 = r4.b;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.zzc(r3);	 Catch:{ RemoteException -> 0x0059 }
        r2.set(r0);	 Catch:{ RemoteException -> 0x0059 }
        r0 = r4.a;	 Catch:{ RemoteException -> 0x0059 }
        r0 = r0.get();	 Catch:{ RemoteException -> 0x0059 }
        r0 = (java.lang.String) r0;	 Catch:{ RemoteException -> 0x0059 }
        if (r0 == 0) goto L_0x004a;
    L_0x0036:
        r2 = r4.c;	 Catch:{ RemoteException -> 0x0059 }
        r2 = r2.e();	 Catch:{ RemoteException -> 0x0059 }
        r2.a(r0);	 Catch:{ RemoteException -> 0x0059 }
        r2 = r4.c;	 Catch:{ RemoteException -> 0x0059 }
        r2 = r2.n();	 Catch:{ RemoteException -> 0x0059 }
        r2 = r2.j;	 Catch:{ RemoteException -> 0x0059 }
        r2.a(r0);	 Catch:{ RemoteException -> 0x0059 }
    L_0x004a:
        r0 = r4.c;	 Catch:{ RemoteException -> 0x0059 }
        r0.y();	 Catch:{ RemoteException -> 0x0059 }
        r0 = r4.a;	 Catch:{ all -> 0x0056 }
        r0.notify();	 Catch:{ all -> 0x0056 }
    L_0x0054:
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        goto L_0x0020;
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0056 }
        throw r0;
    L_0x0059:
        r0 = move-exception;
        r2 = r4.c;	 Catch:{ all -> 0x006f }
        r2 = r2.zzge();	 Catch:{ all -> 0x006f }
        r2 = r2.r();	 Catch:{ all -> 0x006f }
        r3 = "Failed to get app instance id";
        r2.a(r3, r0);	 Catch:{ all -> 0x006f }
        r0 = r4.a;	 Catch:{ all -> 0x0056 }
        r0.notify();	 Catch:{ all -> 0x0056 }
        goto L_0x0054;
    L_0x006f:
        r0 = move-exception;
        r2 = r4.a;	 Catch:{ all -> 0x0056 }
        r2.notify();	 Catch:{ all -> 0x0056 }
        throw r0;	 Catch:{ all -> 0x0056 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.gr.run():void");
    }
}
