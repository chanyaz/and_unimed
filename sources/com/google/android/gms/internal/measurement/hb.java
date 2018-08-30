package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class hb implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ zzdz b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ go d;

    hb(go goVar, AtomicReference atomicReference, zzdz zzdz, boolean z) {
        this.d = goVar;
        this.a = atomicReference;
        this.b = zzdz;
        this.c = z;
    }

    /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
    public final void run() {
        /*
        r5 = this;
        r1 = r5.a;
        monitor-enter(r1);
        r0 = r5.d;	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.b;	 Catch:{ RemoteException -> 0x003d }
        if (r0 != 0) goto L_0x0021;
    L_0x000b:
        r0 = r5.d;	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.zzge();	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.r();	 Catch:{ RemoteException -> 0x003d }
        r2 = "Failed to get user properties";
        r0.a(r2);	 Catch:{ RemoteException -> 0x003d }
        r0 = r5.a;	 Catch:{ all -> 0x003a }
        r0.notify();	 Catch:{ all -> 0x003a }
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
    L_0x0020:
        return;
    L_0x0021:
        r2 = r5.a;	 Catch:{ RemoteException -> 0x003d }
        r3 = r5.b;	 Catch:{ RemoteException -> 0x003d }
        r4 = r5.c;	 Catch:{ RemoteException -> 0x003d }
        r0 = r0.zza(r3, r4);	 Catch:{ RemoteException -> 0x003d }
        r2.set(r0);	 Catch:{ RemoteException -> 0x003d }
        r0 = r5.d;	 Catch:{ RemoteException -> 0x003d }
        r0.y();	 Catch:{ RemoteException -> 0x003d }
        r0 = r5.a;	 Catch:{ all -> 0x003a }
        r0.notify();	 Catch:{ all -> 0x003a }
    L_0x0038:
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        goto L_0x0020;
    L_0x003a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
    L_0x003d:
        r0 = move-exception;
        r2 = r5.d;	 Catch:{ all -> 0x0053 }
        r2 = r2.zzge();	 Catch:{ all -> 0x0053 }
        r2 = r2.r();	 Catch:{ all -> 0x0053 }
        r3 = "Failed to get user properties";
        r2.a(r3, r0);	 Catch:{ all -> 0x0053 }
        r0 = r5.a;	 Catch:{ all -> 0x003a }
        r0.notify();	 Catch:{ all -> 0x003a }
        goto L_0x0038;
    L_0x0053:
        r0 = move-exception;
        r2 = r5.a;	 Catch:{ all -> 0x003a }
        r2.notify();	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.hb.run():void");
    }
}
