package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

@zzadh
public final class aut implements zzww {
    private final zzaef a;
    private final zzxn b;
    private final Context c;
    private final Object d = new Object();
    private final aui e;
    private final boolean f;
    private final long g;
    private final long h;
    private final ana i;
    private final boolean j;
    private final String k;
    private boolean l = false;
    private aul m;
    private List<auo> n = new ArrayList();
    private final boolean o;

    public aut(Context context, zzaef zzaef, zzxn zzxn, aui aui, boolean z, boolean z2, String str, long j, long j2, ana ana, boolean z3) {
        this.c = context;
        this.a = zzaef;
        this.b = zzxn;
        this.e = aui;
        this.f = z;
        this.j = z2;
        this.k = str;
        this.g = j;
        this.h = j2;
        this.i = ana;
        this.o = z3;
    }

    public final void cancel() {
        synchronized (this.d) {
            this.l = true;
            if (this.m != null) {
                this.m.a();
            }
        }
    }

    /* JADX WARNING: Missing block: B:31:0x00ed, code:
            r2 = r24.m.a(r24.g, r24.h);
            r24.n.add(r2);
     */
    /* JADX WARNING: Missing block: B:32:0x0106, code:
            if (r2.a != 0) goto L_0x0154;
     */
    /* JADX WARNING: Missing block: B:33:0x0108, code:
            com.google.android.gms.internal.ads.kk.b("Adapter succeeded.");
            r24.i.a("mediation_network_succeed", r4);
     */
    /* JADX WARNING: Missing block: B:34:0x011a, code:
            if (r18.isEmpty() != false) goto L_0x012d;
     */
    /* JADX WARNING: Missing block: B:35:0x011c, code:
            r24.i.a("mediation_networks_fail", android.text.TextUtils.join(",", r18));
     */
    /* JADX WARNING: Missing block: B:36:0x012d, code:
            r24.i.a(r22, "mls");
            r24.i.a(r19, "ttm");
     */
    /* JADX WARNING: Missing block: B:41:0x0154, code:
            r18.add(r4);
            r24.i.a(r22, "mlf");
     */
    /* JADX WARNING: Missing block: B:42:0x016c, code:
            if (r2.c == null) goto L_0x006d;
     */
    /* JADX WARNING: Missing block: B:43:0x016e, code:
            com.google.android.gms.internal.ads.ht.a.post(new com.google.android.gms.internal.ads.auu(r24, r2));
     */
    /* JADX WARNING: Missing block: B:64:?, code:
            return r2;
     */
    public final com.google.android.gms.internal.ads.auo zzh(java.util.List<com.google.android.gms.internal.ads.auh> r25) {
        /*
        r24 = this;
        r2 = "Starting mediation.";
        com.google.android.gms.internal.ads.kk.b(r2);
        r18 = new java.util.ArrayList;
        r18.<init>();
        r0 = r24;
        r2 = r0.i;
        r19 = r2.a();
        r0 = r24;
        r2 = r0.a;
        r2 = r2.d;
        r3 = 2;
        r3 = new int[r3];
        r4 = r2.g;
        if (r4 == 0) goto L_0x019b;
    L_0x001f:
        com.google.android.gms.ads.internal.au.x();
        r0 = r24;
        r4 = r0.k;
        r4 = com.google.android.gms.internal.ads.aup.a(r4, r3);
        if (r4 == 0) goto L_0x019b;
    L_0x002c:
        r4 = 0;
        r4 = r3[r4];
        r5 = 1;
        r5 = r3[r5];
        r6 = r2.g;
        r7 = r6.length;
        r3 = 0;
    L_0x0036:
        if (r3 >= r7) goto L_0x019b;
    L_0x0038:
        r9 = r6[r3];
        r8 = r9.e;
        if (r4 != r8) goto L_0x0096;
    L_0x003e:
        r8 = r9.b;
        if (r5 != r8) goto L_0x0096;
    L_0x0042:
        r20 = r25.iterator();
    L_0x0046:
        r2 = r20.hasNext();
        if (r2 == 0) goto L_0x017c;
    L_0x004c:
        r7 = r20.next();
        r7 = (com.google.android.gms.internal.ads.auh) r7;
        r3 = "Trying mediation network: ";
        r2 = r7.b;
        r2 = java.lang.String.valueOf(r2);
        r4 = r2.length();
        if (r4 == 0) goto L_0x0099;
    L_0x0060:
        r2 = r3.concat(r2);
    L_0x0064:
        com.google.android.gms.internal.ads.kk.d(r2);
        r2 = r7.c;
        r21 = r2.iterator();
    L_0x006d:
        r2 = r21.hasNext();
        if (r2 == 0) goto L_0x0046;
    L_0x0073:
        r4 = r21.next();
        r4 = (java.lang.String) r4;
        r0 = r24;
        r2 = r0.i;
        r22 = r2.a();
        r0 = r24;
        r0 = r0.d;
        r23 = r0;
        monitor-enter(r23);
        r0 = r24;
        r2 = r0.l;	 Catch:{ all -> 0x0151 }
        if (r2 == 0) goto L_0x009f;
    L_0x008e:
        r2 = new com.google.android.gms.internal.ads.auo;	 Catch:{ all -> 0x0151 }
        r3 = -1;
        r2.<init>(r3);	 Catch:{ all -> 0x0151 }
        monitor-exit(r23);	 Catch:{ all -> 0x0151 }
    L_0x0095:
        return r2;
    L_0x0096:
        r3 = r3 + 1;
        goto L_0x0036;
    L_0x0099:
        r2 = new java.lang.String;
        r2.<init>(r3);
        goto L_0x0064;
    L_0x009f:
        r2 = new com.google.android.gms.internal.ads.aul;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r3 = r0.c;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r5 = r0.b;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r6 = r0.e;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r8 = r0.a;	 Catch:{ all -> 0x0151 }
        r8 = r8.c;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r10 = r0.a;	 Catch:{ all -> 0x0151 }
        r10 = r10.k;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r11 = r0.f;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r12 = r0.j;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r13 = r0.a;	 Catch:{ all -> 0x0151 }
        r13 = r13.y;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r14 = r0.a;	 Catch:{ all -> 0x0151 }
        r14 = r14.n;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r15 = r0.a;	 Catch:{ all -> 0x0151 }
        r15 = r15.z;	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r0 = r0.a;	 Catch:{ all -> 0x0151 }
        r16 = r0;
        r0 = r16;
        r0 = r0.X;	 Catch:{ all -> 0x0151 }
        r16 = r0;
        r0 = r24;
        r0 = r0.o;	 Catch:{ all -> 0x0151 }
        r17 = r0;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r0.m = r2;	 Catch:{ all -> 0x0151 }
        monitor-exit(r23);	 Catch:{ all -> 0x0151 }
        r0 = r24;
        r2 = r0.m;
        r0 = r24;
        r10 = r0.g;
        r0 = r24;
        r12 = r0.h;
        r2 = r2.a(r10, r12);
        r0 = r24;
        r3 = r0.n;
        r3.add(r2);
        r3 = r2.a;
        if (r3 != 0) goto L_0x0154;
    L_0x0108:
        r3 = "Adapter succeeded.";
        com.google.android.gms.internal.ads.kk.b(r3);
        r0 = r24;
        r3 = r0.i;
        r5 = "mediation_network_succeed";
        r3.a(r5, r4);
        r3 = r18.isEmpty();
        if (r3 != 0) goto L_0x012d;
    L_0x011c:
        r0 = r24;
        r3 = r0.i;
        r4 = "mediation_networks_fail";
        r5 = ",";
        r0 = r18;
        r5 = android.text.TextUtils.join(r5, r0);
        r3.a(r4, r5);
    L_0x012d:
        r0 = r24;
        r3 = r0.i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mls";
        r4[r5] = r6;
        r0 = r22;
        r3.a(r0, r4);
        r0 = r24;
        r3 = r0.i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "ttm";
        r4[r5] = r6;
        r0 = r19;
        r3.a(r0, r4);
        goto L_0x0095;
    L_0x0151:
        r2 = move-exception;
        monitor-exit(r23);	 Catch:{ all -> 0x0151 }
        throw r2;
    L_0x0154:
        r0 = r18;
        r0.add(r4);
        r0 = r24;
        r3 = r0.i;
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = "mlf";
        r4[r5] = r6;
        r0 = r22;
        r3.a(r0, r4);
        r3 = r2.c;
        if (r3 == 0) goto L_0x006d;
    L_0x016e:
        r3 = com.google.android.gms.internal.ads.ht.a;
        r4 = new com.google.android.gms.internal.ads.auu;
        r0 = r24;
        r4.<init>(r0, r2);
        r3.post(r4);
        goto L_0x006d;
    L_0x017c:
        r2 = r18.isEmpty();
        if (r2 != 0) goto L_0x0193;
    L_0x0182:
        r0 = r24;
        r2 = r0.i;
        r3 = "mediation_networks_fail";
        r4 = ",";
        r0 = r18;
        r4 = android.text.TextUtils.join(r4, r0);
        r2.a(r3, r4);
    L_0x0193:
        r2 = new com.google.android.gms.internal.ads.auo;
        r3 = 1;
        r2.<init>(r3);
        goto L_0x0095;
    L_0x019b:
        r9 = r2;
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.aut.zzh(java.util.List):com.google.android.gms.internal.ads.auo");
    }

    public final List<auo> zzme() {
        return this.n;
    }
}
