package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class gy implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ zzdz e;
    private final /* synthetic */ go f;

    gy(go goVar, AtomicReference atomicReference, String str, String str2, String str3, zzdz zzdz) {
        this.f = goVar;
        this.a = atomicReference;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = zzdz;
    }

    /* JADX WARNING: Missing block: B:25:?, code:
            return;
     */
    public final void run() {
        /*
        r6 = this;
        r1 = r6.a;
        monitor-enter(r1);
        r0 = r6.f;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.b;	 Catch:{ RemoteException -> 0x006a }
        if (r0 != 0) goto L_0x0034;
    L_0x000b:
        r0 = r6.f;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zzge();	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.r();	 Catch:{ RemoteException -> 0x006a }
        r2 = "Failed to get conditional properties";
        r3 = r6.b;	 Catch:{ RemoteException -> 0x006a }
        r3 = com.google.android.gms.internal.measurement.dp.a(r3);	 Catch:{ RemoteException -> 0x006a }
        r4 = r6.c;	 Catch:{ RemoteException -> 0x006a }
        r5 = r6.d;	 Catch:{ RemoteException -> 0x006a }
        r0.a(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x006a }
        r0 = r6.a;	 Catch:{ RemoteException -> 0x006a }
        r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x006a }
        r0.set(r2);	 Catch:{ RemoteException -> 0x006a }
        r0 = r6.a;	 Catch:{ all -> 0x0057 }
        r0.notify();	 Catch:{ all -> 0x0057 }
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
    L_0x0033:
        return;
    L_0x0034:
        r2 = r6.b;	 Catch:{ RemoteException -> 0x006a }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x006a }
        if (r2 == 0) goto L_0x005a;
    L_0x003c:
        r2 = r6.a;	 Catch:{ RemoteException -> 0x006a }
        r3 = r6.c;	 Catch:{ RemoteException -> 0x006a }
        r4 = r6.d;	 Catch:{ RemoteException -> 0x006a }
        r5 = r6.e;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zza(r3, r4, r5);	 Catch:{ RemoteException -> 0x006a }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006a }
    L_0x004b:
        r0 = r6.f;	 Catch:{ RemoteException -> 0x006a }
        r0.y();	 Catch:{ RemoteException -> 0x006a }
        r0 = r6.a;	 Catch:{ all -> 0x0057 }
        r0.notify();	 Catch:{ all -> 0x0057 }
    L_0x0055:
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        goto L_0x0033;
    L_0x0057:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0057 }
        throw r0;
    L_0x005a:
        r2 = r6.a;	 Catch:{ RemoteException -> 0x006a }
        r3 = r6.b;	 Catch:{ RemoteException -> 0x006a }
        r4 = r6.c;	 Catch:{ RemoteException -> 0x006a }
        r5 = r6.d;	 Catch:{ RemoteException -> 0x006a }
        r0 = r0.zze(r3, r4, r5);	 Catch:{ RemoteException -> 0x006a }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006a }
        goto L_0x004b;
    L_0x006a:
        r0 = move-exception;
        r2 = r6.f;	 Catch:{ all -> 0x0091 }
        r2 = r2.zzge();	 Catch:{ all -> 0x0091 }
        r2 = r2.r();	 Catch:{ all -> 0x0091 }
        r3 = "Failed to get conditional properties";
        r4 = r6.b;	 Catch:{ all -> 0x0091 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x0091 }
        r5 = r6.c;	 Catch:{ all -> 0x0091 }
        r2.a(r3, r4, r5, r0);	 Catch:{ all -> 0x0091 }
        r0 = r6.a;	 Catch:{ all -> 0x0091 }
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x0091 }
        r0.set(r2);	 Catch:{ all -> 0x0091 }
        r0 = r6.a;	 Catch:{ all -> 0x0057 }
        r0.notify();	 Catch:{ all -> 0x0057 }
        goto L_0x0055;
    L_0x0091:
        r0 = move-exception;
        r2 = r6.a;	 Catch:{ all -> 0x0057 }
        r2.notify();	 Catch:{ all -> 0x0057 }
        throw r0;	 Catch:{ all -> 0x0057 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.gy.run():void");
    }
}
