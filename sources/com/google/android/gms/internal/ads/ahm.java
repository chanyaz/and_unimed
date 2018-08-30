package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.au;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class ahm {
    private final Runnable a = new ahn(this);
    private final Object b = new Object();
    @Nullable
    @GuardedBy("mLock")
    private ahs c;
    @Nullable
    @GuardedBy("mLock")
    private Context d;
    @Nullable
    @GuardedBy("mLock")
    private zzho e;

    /* JADX WARNING: Missing block: B:13:?, code:
            return;
     */
    private final void b() {
        /*
        r6 = this;
        r1 = r6.b;
        monitor-enter(r1);
        r0 = r6.d;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r6.c;	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
    L_0x000c:
        return;
    L_0x000d:
        r0 = new com.google.android.gms.internal.ads.ahp;	 Catch:{ all -> 0x002f }
        r0.<init>(r6);	 Catch:{ all -> 0x002f }
        r2 = new com.google.android.gms.internal.ads.ahq;	 Catch:{ all -> 0x002f }
        r2.<init>(r6);	 Catch:{ all -> 0x002f }
        r3 = new com.google.android.gms.internal.ads.ahs;	 Catch:{ all -> 0x002f }
        r4 = r6.d;	 Catch:{ all -> 0x002f }
        r5 = com.google.android.gms.ads.internal.au.t();	 Catch:{ all -> 0x002f }
        r5 = r5.a();	 Catch:{ all -> 0x002f }
        r3.<init>(r4, r5, r0, r2);	 Catch:{ all -> 0x002f }
        r6.c = r3;	 Catch:{ all -> 0x002f }
        r0 = r6.c;	 Catch:{ all -> 0x002f }
        r0.g();	 Catch:{ all -> 0x002f }
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        goto L_0x000c;
    L_0x002f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x002f }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahm.b():void");
    }

    private final void c() {
        synchronized (this.b) {
            if (this.c == null) {
                return;
            }
            if (this.c.isConnected() || this.c.isConnecting()) {
                this.c.disconnect();
            }
            this.c = null;
            this.e = null;
            Binder.flushPendingCommands();
        }
    }

    public final zzhi a(zzhl zzhl) {
        zzhi zzhi;
        synchronized (this.b) {
            if (this.e == null) {
                zzhi = new zzhi();
            } else {
                try {
                    zzhi = this.e.zza(zzhl);
                } catch (Throwable e) {
                    kk.b("Unable to call into cache service.", e);
                    zzhi = new zzhi();
                }
            }
        }
        return zzhi;
    }

    public final void a() {
        if (((Boolean) akc.f().a(amn.cF)).booleanValue()) {
            synchronized (this.b) {
                b();
                au.e();
                ht.a.removeCallbacks(this.a);
                au.e();
                ht.a.postDelayed(this.a, ((Long) akc.f().a(amn.cG)).longValue());
            }
        }
    }

    /* JADX WARNING: Missing block: B:20:?, code:
            return;
     */
    public final void a(android.content.Context r4) {
        /*
        r3 = this;
        if (r4 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r1 = r3.b;
        monitor-enter(r1);
        r0 = r3.d;	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x000f;
    L_0x000a:
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        goto L_0x0002;
    L_0x000c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        throw r0;
    L_0x000f:
        r0 = r4.getApplicationContext();	 Catch:{ all -> 0x000c }
        r3.d = r0;	 Catch:{ all -> 0x000c }
        r0 = com.google.android.gms.internal.ads.amn.cE;	 Catch:{ all -> 0x000c }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x000c }
        r0 = r2.a(r0);	 Catch:{ all -> 0x000c }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x000c }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x002c;
    L_0x0027:
        r3.b();	 Catch:{ all -> 0x000c }
    L_0x002a:
        monitor-exit(r1);	 Catch:{ all -> 0x000c }
        goto L_0x0002;
    L_0x002c:
        r0 = com.google.android.gms.internal.ads.amn.cD;	 Catch:{ all -> 0x000c }
        r2 = com.google.android.gms.internal.ads.akc.f();	 Catch:{ all -> 0x000c }
        r0 = r2.a(r0);	 Catch:{ all -> 0x000c }
        r0 = (java.lang.Boolean) r0;	 Catch:{ all -> 0x000c }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x000c }
        if (r0 == 0) goto L_0x002a;
    L_0x003e:
        r0 = new com.google.android.gms.internal.ads.aho;	 Catch:{ all -> 0x000c }
        r0.<init>(r3);	 Catch:{ all -> 0x000c }
        r2 = com.google.android.gms.ads.internal.au.h();	 Catch:{ all -> 0x000c }
        r2.a(r0);	 Catch:{ all -> 0x000c }
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ahm.a(android.content.Context):void");
    }
}
