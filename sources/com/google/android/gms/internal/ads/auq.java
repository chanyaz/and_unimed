package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.au;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@zzadh
public final class auq implements zzww {
    private final zzaef a;
    private final zzxn b;
    private final Context c;
    private final aui d;
    private final boolean e;
    private final long f;
    private final long g;
    private final int h;
    private final Object i = new Object();
    private boolean j = false;
    private final Map<zzanz<auo>, aul> k = new HashMap();
    private final boolean l;
    private final String m;
    private List<auo> n = new ArrayList();
    private final boolean o;

    public auq(Context context, zzaef zzaef, zzxn zzxn, aui aui, boolean z, boolean z2, String str, long j, long j2, int i, boolean z3) {
        this.c = context;
        this.a = zzaef;
        this.b = zzxn;
        this.d = aui;
        this.e = z;
        this.l = z2;
        this.m = str;
        this.f = j;
        this.g = j2;
        this.h = 2;
        this.o = z3;
    }

    /* JADX WARNING: Missing block: B:8:0x0010, code:
            r2 = r5.iterator();
     */
    private final com.google.android.gms.internal.ads.auo a(java.util.List<com.google.android.gms.internal.ads.zzanz<com.google.android.gms.internal.ads.auo>> r5) {
        /*
        r4 = this;
        r2 = r4.i;
        monitor-enter(r2);
        r0 = r4.j;	 Catch:{ all -> 0x003c }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r1 = new com.google.android.gms.internal.ads.auo;	 Catch:{ all -> 0x003c }
        r0 = -1;
        r1.<init>(r0);	 Catch:{ all -> 0x003c }
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
    L_0x000e:
        return r1;
    L_0x000f:
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        r2 = r5.iterator();
    L_0x0014:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x003f;
    L_0x001a:
        r0 = r2.next();
        r0 = (com.google.android.gms.internal.ads.zzanz) r0;
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r1 = (com.google.android.gms.internal.ads.auo) r1;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r3 = r4.n;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        r3.add(r1);	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        if (r1 == 0) goto L_0x0014;
    L_0x002d:
        r3 = r1.a;	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        if (r3 != 0) goto L_0x0014;
    L_0x0031:
        r4.a(r0);	 Catch:{ InterruptedException -> 0x0035, ExecutionException -> 0x004a }
        goto L_0x000e;
    L_0x0035:
        r0 = move-exception;
    L_0x0036:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.ads.kk.c(r1, r0);
        goto L_0x0014;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x003c }
        throw r0;
    L_0x003f:
        r0 = 0;
        r4.a(r0);
        r1 = new com.google.android.gms.internal.ads.auo;
        r0 = 1;
        r1.<init>(r0);
        goto L_0x000e;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auq.a(java.util.List):com.google.android.gms.internal.ads.auo");
    }

    private final void a(zzanz<auo> zzanz) {
        ht.a.post(new aus(this, zzanz));
    }

    /* JADX WARNING: Missing block: B:8:0x0010, code:
            r4 = -1;
            r3 = null;
            r2 = null;
     */
    /* JADX WARNING: Missing block: B:9:0x001b, code:
            if (r15.d.n == -1) goto L_0x0081;
     */
    /* JADX WARNING: Missing block: B:10:0x001d, code:
            r0 = r15.d.n;
     */
    /* JADX WARNING: Missing block: B:11:0x0021, code:
            r8 = r16.iterator();
            r6 = r0;
     */
    /* JADX WARNING: Missing block: B:35:0x0081, code:
            r0 = 10000;
     */
    private final com.google.android.gms.internal.ads.auo b(java.util.List<com.google.android.gms.internal.ads.zzanz<com.google.android.gms.internal.ads.auo>> r16) {
        /*
        r15 = this;
        r1 = r15.i;
        monitor-enter(r1);
        r0 = r15.j;	 Catch:{ all -> 0x007e }
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r2 = new com.google.android.gms.internal.ads.auo;	 Catch:{ all -> 0x007e }
        r0 = -1;
        r2.<init>(r0);	 Catch:{ all -> 0x007e }
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
    L_0x000e:
        return r2;
    L_0x000f:
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        r4 = -1;
        r3 = 0;
        r2 = 0;
        r0 = r15.d;
        r0 = r0.n;
        r6 = -1;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0081;
    L_0x001d:
        r0 = r15.d;
        r0 = r0.n;
    L_0x0021:
        r8 = r16.iterator();
        r6 = r0;
    L_0x0026:
        r0 = r8.hasNext();
        if (r0 == 0) goto L_0x00b8;
    L_0x002c:
        r0 = r8.next();
        r0 = (com.google.android.gms.internal.ads.zzanz) r0;
        r1 = com.google.android.gms.ads.internal.au.l();
        r10 = r1.currentTimeMillis();
        r12 = 0;
        r1 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x0084;
    L_0x0040:
        r1 = r0.isDone();	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        if (r1 == 0) goto L_0x0084;
    L_0x0046:
        r1 = r0.get();	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        r1 = (com.google.android.gms.internal.ads.auo) r1;	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
    L_0x004c:
        r5 = r15.n;	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        r5.add(r1);	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        if (r1 == 0) goto L_0x00cb;
    L_0x0053:
        r5 = r1.a;	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        if (r5 != 0) goto L_0x00cb;
    L_0x0057:
        r5 = r1.f;	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        if (r5 == 0) goto L_0x00cb;
    L_0x005b:
        r9 = r5.zzmm();	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        if (r9 <= r4) goto L_0x00cb;
    L_0x0061:
        r2 = r5.zzmm();	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        r14 = r1;
        r1 = r0;
        r0 = r14;
    L_0x0068:
        r3 = com.google.android.gms.ads.internal.au.l();
        r4 = r3.currentTimeMillis();
        r4 = r4 - r10;
        r4 = r6 - r4;
        r6 = 0;
        r4 = java.lang.Math.max(r4, r6);
        r6 = r4;
        r3 = r1;
        r4 = r2;
        r2 = r0;
        goto L_0x0026;
    L_0x007e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x007e }
        throw r0;
    L_0x0081:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        goto L_0x0021;
    L_0x0084:
        r1 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        r1 = r0.get(r6, r1);	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        r1 = (com.google.android.gms.internal.ads.auo) r1;	 Catch:{ InterruptedException -> 0x00c5, ExecutionException -> 0x00c7, RemoteException -> 0x008d, TimeoutException -> 0x00c9 }
        goto L_0x004c;
    L_0x008d:
        r0 = move-exception;
    L_0x008e:
        r1 = "Exception while processing an adapter; continuing with other adapters";
        com.google.android.gms.internal.ads.kk.c(r1, r0);	 Catch:{ all -> 0x00a6 }
        r0 = com.google.android.gms.ads.internal.au.l();
        r0 = r0.currentTimeMillis();
        r0 = r0 - r10;
        r0 = r6 - r0;
        r6 = 0;
        r0 = java.lang.Math.max(r0, r6);
        r6 = r0;
        goto L_0x0026;
    L_0x00a6:
        r0 = move-exception;
        r1 = com.google.android.gms.ads.internal.au.l();
        r2 = r1.currentTimeMillis();
        r2 = r2 - r10;
        r2 = r6 - r2;
        r4 = 0;
        java.lang.Math.max(r2, r4);
        throw r0;
    L_0x00b8:
        r15.a(r3);
        if (r2 != 0) goto L_0x000e;
    L_0x00bd:
        r2 = new com.google.android.gms.internal.ads.auo;
        r0 = 1;
        r2.<init>(r0);
        goto L_0x000e;
    L_0x00c5:
        r0 = move-exception;
        goto L_0x008e;
    L_0x00c7:
        r0 = move-exception;
        goto L_0x008e;
    L_0x00c9:
        r0 = move-exception;
        goto L_0x008e;
    L_0x00cb:
        r0 = r2;
        r1 = r3;
        r2 = r4;
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.auq.b(java.util.List):com.google.android.gms.internal.ads.auo");
    }

    public final void cancel() {
        synchronized (this.i) {
            this.j = true;
            for (aul a : this.k.values()) {
                a.a();
            }
        }
    }

    public final auo zzh(List<auh> list) {
        kk.b("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zzjn zzjn = this.a.d;
        int[] iArr = new int[2];
        if (zzjn.g != null) {
            au.x();
            if (aup.a(this.m, iArr)) {
                int i = iArr[0];
                int i2 = iArr[1];
                for (zzjn zzjn2 : zzjn.g) {
                    if (i == zzjn2.e && i2 == zzjn2.b) {
                        break;
                    }
                }
            }
        }
        zzjn zzjn22 = zzjn;
        for (auh auh : list) {
            String str = "Trying mediation network: ";
            String valueOf = String.valueOf(auh.b);
            kk.d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            for (String aul : auh.c) {
                aul aul2 = new aul(this.c, aul, this.b, this.d, auh, this.a.c, zzjn22, this.a.k, this.e, this.l, this.a.y, this.a.n, this.a.z, this.a.X, this.o);
                zzanz a = hr.a(new aur(this, aul2));
                this.k.put(a, aul2);
                arrayList.add(a);
            }
        }
        switch (this.h) {
            case 2:
                return b((List) arrayList);
            default:
                return a((List) arrayList);
        }
    }

    public final List<auo> zzme() {
        return this.n;
    }
}
