package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.p;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzadh
@ParametersAreNonnullByDefault
public final class agq {
    private final Object a = new Object();
    @GuardedBy("mActivityTrackerLock")
    private agr b = null;
    @GuardedBy("mActivityTrackerLock")
    private boolean c = false;

    @Nullable
    public final Activity a() {
        Activity activity = null;
        synchronized (this.a) {
            if (!p.b()) {
            } else if (this.b != null) {
                activity = this.b.a();
            }
        }
        return activity;
    }

    /* JADX WARNING: Missing block: B:34:?, code:
            return;
     */
    public final void a(android.content.Context r5) {
        /*
        r4 = this;
        r2 = r4.a;
        monitor-enter(r2);
        r0 = r4.c;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0050;
    L_0x0007:
        r0 = com.google.android.gms.common.util.p.b();	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        monitor-exit(r2);	 Catch:{ all -> 0x0023 }
    L_0x000e:
        return;
    L_0x000f:
        r0 = com.google.android.gms.internal.ads.amn.aG;	 Catch:{ all -> 0x0023 }
        r1 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x0023 }
        r0 = r1.a(r0);	 Catch:{ all -> 0x0023 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x0023 }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0026;
    L_0x0021:
        monitor-exit(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x000e;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r1 = 0;
        r0 = r5.getApplicationContext();	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x002e;
    L_0x002d:
        r0 = r5;
    L_0x002e:
        r3 = r0 instanceof android.app.Application;	 Catch:{ all -> 0x0023 }
        if (r3 == 0) goto L_0x0052;
    L_0x0032:
        r0 = (android.app.Application) r0;	 Catch:{ all -> 0x0023 }
    L_0x0034:
        if (r0 != 0) goto L_0x003d;
    L_0x0036:
        r0 = "Can not cast Context to Application";
        com.google.android.gms.internal.ads.kk.e(r0);	 Catch:{ all -> 0x0023 }
        monitor-exit(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x000e;
    L_0x003d:
        r1 = r4.b;	 Catch:{ all -> 0x0023 }
        if (r1 != 0) goto L_0x0048;
    L_0x0041:
        r1 = new com.google.android.gms.internal.ads.agr;	 Catch:{ all -> 0x0023 }
        r1.<init>();	 Catch:{ all -> 0x0023 }
        r4.b = r1;	 Catch:{ all -> 0x0023 }
    L_0x0048:
        r1 = r4.b;	 Catch:{ all -> 0x0023 }
        r1.a(r0, r5);	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r4.c = r0;	 Catch:{ all -> 0x0023 }
    L_0x0050:
        monitor-exit(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x000e;
    L_0x0052:
        r0 = r1;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agq.a(android.content.Context):void");
    }

    public final void a(zzgj zzgj) {
        synchronized (this.a) {
            if (p.b()) {
                if (((Boolean) akc.f().a(amn.aG)).booleanValue()) {
                    if (this.b == null) {
                        this.b = new agr();
                    }
                    this.b.a(zzgj);
                    return;
                }
                return;
            }
        }
    }

    @Nullable
    public final Context b() {
        Context context = null;
        synchronized (this.a) {
            if (!p.b()) {
            } else if (this.b != null) {
                context = this.b.b();
            }
        }
        return context;
    }
}
