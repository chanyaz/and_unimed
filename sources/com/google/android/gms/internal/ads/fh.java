package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.gmsg.zzb;
import java.util.concurrent.Future;

@zzadh
public final class fh extends hg implements zzaht, zzahw, zzaia {
    public final String a;
    private final gs b;
    private final Context c;
    private final fs d;
    private final zzahw e;
    private final Object f;
    private final String g;
    private final auh h;
    private final long i;
    private int j = 0;
    private int k = 3;
    private fk l;
    private Future m;
    private volatile zzb n;

    public fh(Context context, String str, String str2, auh auh, gs gsVar, fs fsVar, zzahw zzahw, long j) {
        this.c = context;
        this.a = str;
        this.g = str2;
        this.h = auh;
        this.b = gsVar;
        this.d = fsVar;
        this.f = new Object();
        this.e = zzahw;
        this.i = j;
    }

    private final void a(zzjj zzjj, zzxq zzxq) {
        this.d.b().a((zzahw) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.a)) {
                zzxq.zza(zzjj, this.g, this.h.a);
            } else {
                zzxq.zzc(zzjj, this.g);
            }
        } catch (Throwable e) {
            kk.c("Fail to load ad from adapter.", e);
            zza(this.a, 0);
        }
    }

    private final boolean a(long j) {
        long elapsedRealtime = this.i - (au.l().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            this.k = 4;
            return false;
        }
        try {
            this.f.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.k = 5;
            return false;
        }
    }

    /* JADX WARNING: Missing block: B:17:0x0051, code:
            r2 = new com.google.android.gms.internal.ads.fm().a(com.google.android.gms.ads.internal.au.l().elapsedRealtime() - r2);
     */
    /* JADX WARNING: Missing block: B:18:0x0066, code:
            if (1 != r10.j) goto L_0x00ac;
     */
    /* JADX WARNING: Missing block: B:19:0x0068, code:
            r0 = 6;
     */
    /* JADX WARNING: Missing block: B:20:0x0069, code:
            r10.l = r2.a(r0).a(r10.a).b(r10.h.d).a();
     */
    /* JADX WARNING: Missing block: B:30:?, code:
            r0 = r10.k;
     */
    public final void a() {
        /*
        r10 = this;
        r9 = 1;
        r8 = 0;
        r0 = r10.d;
        if (r0 == 0) goto L_0x0016;
    L_0x0006:
        r0 = r10.d;
        r0 = r0.b();
        if (r0 == 0) goto L_0x0016;
    L_0x000e:
        r0 = r10.d;
        r0 = r0.a();
        if (r0 != 0) goto L_0x0017;
    L_0x0016:
        return;
    L_0x0017:
        r0 = r10.d;
        r1 = r0.b();
        r1.a(r8);
        r1.a(r10);
        r1.a(r10);
        r0 = r10.b;
        r0 = r0.a;
        r0 = r0.c;
        r2 = r10.d;
        r2 = r2.a();
        r3 = r2.isInitialized();	 Catch:{ RemoteException -> 0x009f }
        if (r3 == 0) goto L_0x0094;
    L_0x0038:
        r3 = com.google.android.gms.internal.ads.kb.a;	 Catch:{ RemoteException -> 0x009f }
        r4 = new com.google.android.gms.internal.ads.fi;	 Catch:{ RemoteException -> 0x009f }
        r4.<init>(r10, r0, r2);	 Catch:{ RemoteException -> 0x009f }
        r3.post(r4);	 Catch:{ RemoteException -> 0x009f }
    L_0x0042:
        r0 = com.google.android.gms.ads.internal.au.l();
        r2 = r0.elapsedRealtime();
    L_0x004a:
        r4 = r10.f;
        monitor-enter(r4);
        r0 = r10.j;	 Catch:{ all -> 0x00e4 }
        if (r0 == 0) goto L_0x00af;
    L_0x0051:
        r0 = new com.google.android.gms.internal.ads.fm;	 Catch:{ all -> 0x00e4 }
        r0.<init>();	 Catch:{ all -> 0x00e4 }
        r5 = com.google.android.gms.ads.internal.au.l();	 Catch:{ all -> 0x00e4 }
        r6 = r5.elapsedRealtime();	 Catch:{ all -> 0x00e4 }
        r2 = r6 - r2;
        r2 = r0.a(r2);	 Catch:{ all -> 0x00e4 }
        r0 = r10.j;	 Catch:{ all -> 0x00e4 }
        if (r9 != r0) goto L_0x00ac;
    L_0x0068:
        r0 = 6;
    L_0x0069:
        r0 = r2.a(r0);	 Catch:{ all -> 0x00e4 }
        r2 = r10.a;	 Catch:{ all -> 0x00e4 }
        r0 = r0.a(r2);	 Catch:{ all -> 0x00e4 }
        r2 = r10.h;	 Catch:{ all -> 0x00e4 }
        r2 = r2.d;	 Catch:{ all -> 0x00e4 }
        r0 = r0.b(r2);	 Catch:{ all -> 0x00e4 }
        r0 = r0.a();	 Catch:{ all -> 0x00e4 }
        r10.l = r0;	 Catch:{ all -> 0x00e4 }
        monitor-exit(r4);	 Catch:{ all -> 0x00e4 }
    L_0x0082:
        r1.a(r8);
        r1.a(r8);
        r0 = r10.j;
        if (r0 != r9) goto L_0x00ea;
    L_0x008c:
        r0 = r10.e;
        r1 = r10.a;
        r0.zzcb(r1);
        goto L_0x0016;
    L_0x0094:
        r3 = com.google.android.gms.internal.ads.kb.a;	 Catch:{ RemoteException -> 0x009f }
        r4 = new com.google.android.gms.internal.ads.fj;	 Catch:{ RemoteException -> 0x009f }
        r4.<init>(r10, r2, r0, r1);	 Catch:{ RemoteException -> 0x009f }
        r3.post(r4);	 Catch:{ RemoteException -> 0x009f }
        goto L_0x0042;
    L_0x009f:
        r0 = move-exception;
        r2 = "Fail to check if adapter is initialized.";
        com.google.android.gms.internal.ads.kk.c(r2, r0);
        r0 = r10.a;
        r2 = 0;
        r10.zza(r0, r2);
        goto L_0x0042;
    L_0x00ac:
        r0 = r10.k;	 Catch:{ all -> 0x00e4 }
        goto L_0x0069;
    L_0x00af:
        r0 = r10.a(r2);	 Catch:{ all -> 0x00e4 }
        if (r0 != 0) goto L_0x00e7;
    L_0x00b5:
        r0 = new com.google.android.gms.internal.ads.fm;	 Catch:{ all -> 0x00e4 }
        r0.<init>();	 Catch:{ all -> 0x00e4 }
        r5 = r10.k;	 Catch:{ all -> 0x00e4 }
        r0 = r0.a(r5);	 Catch:{ all -> 0x00e4 }
        r5 = com.google.android.gms.ads.internal.au.l();	 Catch:{ all -> 0x00e4 }
        r6 = r5.elapsedRealtime();	 Catch:{ all -> 0x00e4 }
        r2 = r6 - r2;
        r0 = r0.a(r2);	 Catch:{ all -> 0x00e4 }
        r2 = r10.a;	 Catch:{ all -> 0x00e4 }
        r0 = r0.a(r2);	 Catch:{ all -> 0x00e4 }
        r2 = r10.h;	 Catch:{ all -> 0x00e4 }
        r2 = r2.d;	 Catch:{ all -> 0x00e4 }
        r0 = r0.b(r2);	 Catch:{ all -> 0x00e4 }
        r0 = r0.a();	 Catch:{ all -> 0x00e4 }
        r10.l = r0;	 Catch:{ all -> 0x00e4 }
        monitor-exit(r4);	 Catch:{ all -> 0x00e4 }
        goto L_0x0082;
    L_0x00e4:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00e4 }
        throw r0;
    L_0x00e7:
        monitor-exit(r4);	 Catch:{ all -> 0x00e4 }
        goto L_0x004a;
    L_0x00ea:
        r0 = r10.e;
        r1 = r10.a;
        r2 = r10.k;
        r0.zza(r1, r2);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.fh.a():void");
    }

    public final void a(zzb zzb) {
        this.n = zzb;
    }

    public final void b() {
    }

    public final Future c() {
        if (this.m != null) {
            return this.m;
        }
        zzanz zzanz = (zzanz) zznt();
        this.m = zzanz;
        return zzanz;
    }

    public final fk d() {
        fk fkVar;
        synchronized (this.f) {
            fkVar = this.l;
        }
        return fkVar;
    }

    public final auh e() {
        return this.h;
    }

    public final void zza(String str, int i) {
        synchronized (this.f) {
            this.j = 2;
            this.k = i;
            this.f.notify();
        }
    }

    public final void zzac(int i) {
        zza(this.a, 0);
    }

    public final void zzc(Bundle bundle) {
        zzb zzb = this.n;
        if (zzb != null) {
            zzb.zza("", bundle);
        }
    }

    public final void zzcb(String str) {
        synchronized (this.f) {
            this.j = 1;
            this.f.notify();
        }
    }

    public final void zzpc() {
        a(this.b.a.c, this.d.a());
    }
}
