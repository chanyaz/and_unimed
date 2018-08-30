package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.analytics.t;
import com.google.android.gms.common.internal.ar;
import com.google.android.gms.common.stats.b;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class an implements ServiceConnection {
    final /* synthetic */ al a;
    private volatile zzci b;
    private volatile boolean c;

    protected an(al alVar) {
        this.a = alVar;
    }

    public final zzci a() {
        zzci zzci = null;
        t.d();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context j = this.a.j();
        intent.putExtra("app_package_name", j.getPackageName());
        b a = b.a();
        synchronized (this) {
            this.b = null;
            this.c = true;
            boolean a2 = a.a(j, intent, this.a.a, 129);
            this.a.a("Bind to service requested", Boolean.valueOf(a2));
            if (a2) {
                try {
                    wait(((Long) bk.B.a()).longValue());
                } catch (InterruptedException e) {
                    this.a.e("Wait for service connect was interrupted");
                }
                this.c = false;
                zzci = this.b;
                this.b = null;
                if (zzci == null) {
                    this.a.f("Successfully bound to service but never got onServiceConnected callback");
                }
            } else {
                this.c = false;
            }
        }
        return zzci;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073 A:{SYNTHETIC, Splitter: B:36:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A:{SYNTHETIC, Splitter: B:15:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d A:{SYNTHETIC, Splitter: B:15:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073 A:{SYNTHETIC, Splitter: B:36:0x0073} */
    /* JADX WARNING: Missing block: B:43:?, code:
            return;
     */
    public final void onServiceConnected(android.content.ComponentName r5, android.os.IBinder r6) {
        /*
        r4 = this;
        r1 = 0;
        r0 = "AnalyticsServiceConnection.onServiceConnected";
        com.google.android.gms.common.internal.ar.b(r0);
        monitor-enter(r4);
        if (r6 != 0) goto L_0x0015;
    L_0x0009:
        r0 = r4.a;	 Catch:{ all -> 0x0065 }
        r1 = "Service connected with null binder";
        r0.f(r1);	 Catch:{ all -> 0x0065 }
        r4.notifyAll();	 Catch:{ all -> 0x0045 }
        monitor-exit(r4);	 Catch:{ all -> 0x0045 }
    L_0x0014:
        return;
    L_0x0015:
        r0 = r6.getInterfaceDescriptor();	 Catch:{ RemoteException -> 0x005b }
        r2 = "com.google.android.gms.analytics.internal.IAnalyticsService";
        r2 = r2.equals(r0);	 Catch:{ RemoteException -> 0x005b }
        if (r2 == 0) goto L_0x006a;
    L_0x0021:
        if (r6 != 0) goto L_0x0048;
    L_0x0023:
        r0 = r1;
    L_0x0024:
        r1 = r4.a;	 Catch:{ RemoteException -> 0x0092 }
        r2 = "Bound to IAnalyticsService interface";
        r1.b(r2);	 Catch:{ RemoteException -> 0x0092 }
    L_0x002b:
        if (r0 != 0) goto L_0x0073;
    L_0x002d:
        r0 = com.google.android.gms.common.stats.b.a();	 Catch:{ IllegalArgumentException -> 0x0090 }
        r1 = r4.a;	 Catch:{ IllegalArgumentException -> 0x0090 }
        r1 = r1.j();	 Catch:{ IllegalArgumentException -> 0x0090 }
        r2 = r4.a;	 Catch:{ IllegalArgumentException -> 0x0090 }
        r2 = r2.a;	 Catch:{ IllegalArgumentException -> 0x0090 }
        r0.a(r1, r2);	 Catch:{ IllegalArgumentException -> 0x0090 }
    L_0x0040:
        r4.notifyAll();	 Catch:{ all -> 0x0045 }
        monitor-exit(r4);	 Catch:{ all -> 0x0045 }
        goto L_0x0014;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0045 }
        throw r0;
    L_0x0048:
        r0 = "com.google.android.gms.analytics.internal.IAnalyticsService";
        r0 = r6.queryLocalInterface(r0);	 Catch:{ RemoteException -> 0x005b }
        r2 = r0 instanceof com.google.android.gms.internal.measurement.zzci;	 Catch:{ RemoteException -> 0x005b }
        if (r2 == 0) goto L_0x0055;
    L_0x0052:
        r0 = (com.google.android.gms.internal.measurement.zzci) r0;	 Catch:{ RemoteException -> 0x005b }
        goto L_0x0024;
    L_0x0055:
        r0 = new com.google.android.gms.internal.measurement.bq;	 Catch:{ RemoteException -> 0x005b }
        r0.<init>(r6);	 Catch:{ RemoteException -> 0x005b }
        goto L_0x0024;
    L_0x005b:
        r0 = move-exception;
        r0 = r1;
    L_0x005d:
        r1 = r4.a;	 Catch:{ all -> 0x0065 }
        r2 = "Service connect failed to get IAnalyticsService";
        r1.f(r2);	 Catch:{ all -> 0x0065 }
        goto L_0x002b;
    L_0x0065:
        r0 = move-exception;
        r4.notifyAll();	 Catch:{ all -> 0x0045 }
        throw r0;	 Catch:{ all -> 0x0045 }
    L_0x006a:
        r2 = r4.a;	 Catch:{ RemoteException -> 0x005b }
        r3 = "Got binder with a wrong descriptor";
        r2.e(r3, r0);	 Catch:{ RemoteException -> 0x005b }
        r0 = r1;
        goto L_0x002b;
    L_0x0073:
        r1 = r4.c;	 Catch:{ all -> 0x0065 }
        if (r1 != 0) goto L_0x008d;
    L_0x0077:
        r1 = r4.a;	 Catch:{ all -> 0x0065 }
        r2 = "onServiceConnected received after the timeout limit";
        r1.e(r2);	 Catch:{ all -> 0x0065 }
        r1 = r4.a;	 Catch:{ all -> 0x0065 }
        r1 = r1.m();	 Catch:{ all -> 0x0065 }
        r2 = new com.google.android.gms.internal.measurement.ao;	 Catch:{ all -> 0x0065 }
        r2.<init>(r4, r0);	 Catch:{ all -> 0x0065 }
        r1.a(r2);	 Catch:{ all -> 0x0065 }
        goto L_0x0040;
    L_0x008d:
        r4.b = r0;	 Catch:{ all -> 0x0065 }
        goto L_0x0040;
    L_0x0090:
        r0 = move-exception;
        goto L_0x0040;
    L_0x0092:
        r1 = move-exception;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.an.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        ar.b("AnalyticsServiceConnection.onServiceDisconnected");
        this.a.m().a(new ap(this, componentName));
    }
}
