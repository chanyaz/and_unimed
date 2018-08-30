package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicReference;

final class gz implements Runnable {
    private final /* synthetic */ AtomicReference a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;
    private final /* synthetic */ boolean e;
    private final /* synthetic */ zzdz f;
    private final /* synthetic */ go g;

    gz(go goVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzdz zzdz) {
        this.g = goVar;
        this.a = atomicReference;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = zzdz;
    }

    /* JADX WARNING: Missing block: B:25:?, code:
            return;
     */
    public final void run() {
        /*
        r7 = this;
        r1 = r7.a;
        monitor-enter(r1);
        r0 = r7.g;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.b;	 Catch:{ RemoteException -> 0x006e }
        if (r0 != 0) goto L_0x0034;
    L_0x000b:
        r0 = r7.g;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zzge();	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.r();	 Catch:{ RemoteException -> 0x006e }
        r2 = "Failed to get user properties";
        r3 = r7.b;	 Catch:{ RemoteException -> 0x006e }
        r3 = com.google.android.gms.internal.measurement.dp.a(r3);	 Catch:{ RemoteException -> 0x006e }
        r4 = r7.c;	 Catch:{ RemoteException -> 0x006e }
        r5 = r7.d;	 Catch:{ RemoteException -> 0x006e }
        r0.a(r2, r3, r4, r5);	 Catch:{ RemoteException -> 0x006e }
        r0 = r7.a;	 Catch:{ RemoteException -> 0x006e }
        r2 = java.util.Collections.emptyList();	 Catch:{ RemoteException -> 0x006e }
        r0.set(r2);	 Catch:{ RemoteException -> 0x006e }
        r0 = r7.a;	 Catch:{ all -> 0x0059 }
        r0.notify();	 Catch:{ all -> 0x0059 }
        monitor-exit(r1);	 Catch:{ all -> 0x0059 }
    L_0x0033:
        return;
    L_0x0034:
        r2 = r7.b;	 Catch:{ RemoteException -> 0x006e }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ RemoteException -> 0x006e }
        if (r2 == 0) goto L_0x005c;
    L_0x003c:
        r2 = r7.a;	 Catch:{ RemoteException -> 0x006e }
        r3 = r7.c;	 Catch:{ RemoteException -> 0x006e }
        r4 = r7.d;	 Catch:{ RemoteException -> 0x006e }
        r5 = r7.e;	 Catch:{ RemoteException -> 0x006e }
        r6 = r7.f;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zza(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x006e }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006e }
    L_0x004d:
        r0 = r7.g;	 Catch:{ RemoteException -> 0x006e }
        r0.y();	 Catch:{ RemoteException -> 0x006e }
        r0 = r7.a;	 Catch:{ all -> 0x0059 }
        r0.notify();	 Catch:{ all -> 0x0059 }
    L_0x0057:
        monitor-exit(r1);	 Catch:{ all -> 0x0059 }
        goto L_0x0033;
    L_0x0059:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0059 }
        throw r0;
    L_0x005c:
        r2 = r7.a;	 Catch:{ RemoteException -> 0x006e }
        r3 = r7.b;	 Catch:{ RemoteException -> 0x006e }
        r4 = r7.c;	 Catch:{ RemoteException -> 0x006e }
        r5 = r7.d;	 Catch:{ RemoteException -> 0x006e }
        r6 = r7.e;	 Catch:{ RemoteException -> 0x006e }
        r0 = r0.zza(r3, r4, r5, r6);	 Catch:{ RemoteException -> 0x006e }
        r2.set(r0);	 Catch:{ RemoteException -> 0x006e }
        goto L_0x004d;
    L_0x006e:
        r0 = move-exception;
        r2 = r7.g;	 Catch:{ all -> 0x0095 }
        r2 = r2.zzge();	 Catch:{ all -> 0x0095 }
        r2 = r2.r();	 Catch:{ all -> 0x0095 }
        r3 = "Failed to get user properties";
        r4 = r7.b;	 Catch:{ all -> 0x0095 }
        r4 = com.google.android.gms.internal.measurement.dp.a(r4);	 Catch:{ all -> 0x0095 }
        r5 = r7.c;	 Catch:{ all -> 0x0095 }
        r2.a(r3, r4, r5, r0);	 Catch:{ all -> 0x0095 }
        r0 = r7.a;	 Catch:{ all -> 0x0095 }
        r2 = java.util.Collections.emptyList();	 Catch:{ all -> 0x0095 }
        r0.set(r2);	 Catch:{ all -> 0x0095 }
        r0 = r7.a;	 Catch:{ all -> 0x0059 }
        r0.notify();	 Catch:{ all -> 0x0059 }
        goto L_0x0057;
    L_0x0095:
        r0 = move-exception;
        r2 = r7.a;	 Catch:{ all -> 0x0059 }
        r2.notify();	 Catch:{ all -> 0x0059 }
        throw r0;	 Catch:{ all -> 0x0059 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.gz.run():void");
    }
}
