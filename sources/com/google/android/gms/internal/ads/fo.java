package com.google.android.gms.internal.ads;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONObject;

@zzadh
public final class fo extends hg implements zzahw {
    private final gs a;
    private final Context b;
    private final ArrayList<fh> c;
    private final List<fk> d;
    private final HashSet<String> e;
    private final Object f;
    private final eo g;
    private final long h;

    public fo(Context context, gs gsVar, eo eoVar) {
        long longValue = ((Long) akc.f().a(amn.aE)).longValue();
        this(context, gsVar, eoVar, longValue);
    }

    @VisibleForTesting
    private fo(Context context, gs gsVar, eo eoVar, long j) {
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new HashSet();
        this.f = new Object();
        this.b = context;
        this.a = gsVar;
        this.g = eoVar;
        this.h = j;
    }

    private final gr a(int i, @Nullable String str, @Nullable auh auh) {
        String stringBuilder;
        zzjj zzjj = this.a.a.c;
        List list = this.a.b.c;
        List list2 = this.a.b.e;
        List list3 = this.a.b.i;
        int i2 = this.a.b.k;
        long j = this.a.b.j;
        String str2 = this.a.a.i;
        boolean z = this.a.b.g;
        aui aui = this.a.c;
        long j2 = this.a.b.h;
        zzjn zzjn = this.a.d;
        long j3 = this.a.b.f;
        long j4 = this.a.f;
        long j5 = this.a.b.m;
        String str3 = this.a.b.n;
        JSONObject jSONObject = this.a.h;
        zzaig zzaig = this.a.b.A;
        List list4 = this.a.b.B;
        List list5 = this.a.b.C;
        boolean z2 = this.a.b.D;
        zzael zzael = this.a.b.E;
        StringBuilder stringBuilder2 = new StringBuilder("");
        if (this.d == null) {
            stringBuilder = stringBuilder2.toString();
        } else {
            for (fk fkVar : this.d) {
                if (!(fkVar == null || TextUtils.isEmpty(fkVar.a))) {
                    int i3;
                    String str4 = fkVar.a;
                    switch (fkVar.b) {
                        case 3:
                            i3 = 1;
                            break;
                        case 4:
                            i3 = 2;
                            break;
                        case 5:
                            i3 = 4;
                            break;
                        case 6:
                            i3 = 0;
                            break;
                        case 7:
                            i3 = 3;
                            break;
                        default:
                            i3 = 6;
                            break;
                    }
                    stringBuilder2 = stringBuilder2;
                    stringBuilder2.append(String.valueOf(new StringBuilder(String.valueOf(str4).length() + 33).append(str4).append(".").append(i3).append(".").append(fkVar.c).toString()).concat("_"));
                }
            }
            stringBuilder = stringBuilder2.substring(0, Math.max(0, stringBuilder2.length() - 1));
        }
        return new gr(zzjj, null, list, i, list2, list3, i2, j, str2, z, auh, null, str, aui, null, j2, zzjn, j3, j4, j5, str3, jSONObject, null, zzaig, list4, list5, z2, zzael, stringBuilder, this.a.b.H, this.a.b.L, this.a.i, this.a.b.O, this.a.j, this.a.b.Q, this.a.b.R, this.a.b.S, this.a.b.T);
    }

    /* JADX WARNING: Missing block: B:105:0x0190, code:
            r2 = r3;
     */
    public final void a() {
        /*
        r15 = this;
        r14 = 0;
        r10 = 0;
        r0 = r15.a;
        r0 = r0.c;
        r0 = r0.a;
        r11 = r0.iterator();
    L_0x000c:
        r0 = r11.hasNext();
        if (r0 == 0) goto L_0x00aa;
    L_0x0012:
        r4 = r11.next();
        r4 = (com.google.android.gms.internal.ads.auh) r4;
        r3 = r4.k;
        r0 = r4.c;
        r12 = r0.iterator();
    L_0x0020:
        r0 = r12.hasNext();
        if (r0 == 0) goto L_0x000c;
    L_0x0026:
        r0 = r12.next();
        r0 = (java.lang.String) r0;
        r1 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x003c;
    L_0x0034:
        r1 = "com.google.ads.mediation.customevent.CustomEventAdapter";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0196;
    L_0x003c:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0086 }
        r0.<init>(r3);	 Catch:{ JSONException -> 0x0086 }
        r1 = "class_name";
        r2 = r0.getString(r1);	 Catch:{ JSONException -> 0x0086 }
    L_0x0047:
        r13 = r15.f;
        monitor-enter(r13);
        r0 = r15.g;	 Catch:{ all -> 0x0083 }
        r6 = r0.a(r2);	 Catch:{ all -> 0x0083 }
        if (r6 == 0) goto L_0x005e;
    L_0x0052:
        r0 = r6.b();	 Catch:{ all -> 0x0083 }
        if (r0 == 0) goto L_0x005e;
    L_0x0058:
        r0 = r6.a();	 Catch:{ all -> 0x0083 }
        if (r0 != 0) goto L_0x008d;
    L_0x005e:
        r0 = r15.d;	 Catch:{ all -> 0x0083 }
        r1 = new com.google.android.gms.internal.ads.fm;	 Catch:{ all -> 0x0083 }
        r1.<init>();	 Catch:{ all -> 0x0083 }
        r5 = r4.d;	 Catch:{ all -> 0x0083 }
        r1 = r1.b(r5);	 Catch:{ all -> 0x0083 }
        r1 = r1.a(r2);	 Catch:{ all -> 0x0083 }
        r6 = 0;
        r1 = r1.a(r6);	 Catch:{ all -> 0x0083 }
        r2 = 7;
        r1 = r1.a(r2);	 Catch:{ all -> 0x0083 }
        r1 = r1.a();	 Catch:{ all -> 0x0083 }
        r0.add(r1);	 Catch:{ all -> 0x0083 }
        monitor-exit(r13);	 Catch:{ all -> 0x0083 }
        goto L_0x0020;
    L_0x0083:
        r0 = move-exception;
        monitor-exit(r13);	 Catch:{ all -> 0x0083 }
        throw r0;
    L_0x0086:
        r0 = move-exception;
        r1 = "Unable to determine custom event class name, skipping...";
        com.google.android.gms.internal.ads.kk.b(r1, r0);
        goto L_0x0020;
    L_0x008d:
        r0 = new com.google.android.gms.internal.ads.fh;	 Catch:{ all -> 0x0083 }
        r1 = r15.b;	 Catch:{ all -> 0x0083 }
        r5 = r15.a;	 Catch:{ all -> 0x0083 }
        r8 = r15.h;	 Catch:{ all -> 0x0083 }
        r7 = r15;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8);	 Catch:{ all -> 0x0083 }
        r1 = r15.g;	 Catch:{ all -> 0x0083 }
        r1 = r1.a();	 Catch:{ all -> 0x0083 }
        r0.a(r1);	 Catch:{ all -> 0x0083 }
        r1 = r15.c;	 Catch:{ all -> 0x0083 }
        r1.add(r0);	 Catch:{ all -> 0x0083 }
        monitor-exit(r13);	 Catch:{ all -> 0x0083 }
        goto L_0x0020;
    L_0x00aa:
        r3 = new java.util.HashSet;
        r3.<init>();
        r0 = r15.c;
        r0 = (java.util.ArrayList) r0;
        r4 = r0.size();
        r2 = r10;
    L_0x00b8:
        if (r2 >= r4) goto L_0x00ce;
    L_0x00ba:
        r1 = r0.get(r2);
        r2 = r2 + 1;
        r1 = (com.google.android.gms.internal.ads.fh) r1;
        r5 = r1.a;
        r5 = r3.add(r5);
        if (r5 == 0) goto L_0x00b8;
    L_0x00ca:
        r1.c();
        goto L_0x00b8;
    L_0x00ce:
        r0 = r15.c;
        r0 = (java.util.ArrayList) r0;
        r4 = r0.size();
        r2 = r10;
    L_0x00d7:
        if (r2 >= r4) goto L_0x0141;
    L_0x00d9:
        r1 = r0.get(r2);
        r3 = r2 + 1;
        r1 = (com.google.android.gms.internal.ads.fh) r1;
        r2 = r1.c();	 Catch:{ InterruptedException -> 0x0124, Exception -> 0x0154 }
        r2.get();	 Catch:{ InterruptedException -> 0x0124, Exception -> 0x0154 }
        r2 = r15.f;
        monitor-enter(r2);
        r5 = r1.a;	 Catch:{ all -> 0x0121 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0121 }
        if (r5 != 0) goto L_0x00fc;
    L_0x00f3:
        r5 = r15.d;	 Catch:{ all -> 0x0121 }
        r6 = r1.d();	 Catch:{ all -> 0x0121 }
        r5.add(r6);	 Catch:{ all -> 0x0121 }
    L_0x00fc:
        monitor-exit(r2);	 Catch:{ all -> 0x0121 }
        r2 = r15.f;
        monitor-enter(r2);
        r5 = r15.e;	 Catch:{ all -> 0x0193 }
        r6 = r1.a;	 Catch:{ all -> 0x0193 }
        r5 = r5.contains(r6);	 Catch:{ all -> 0x0193 }
        if (r5 == 0) goto L_0x018f;
    L_0x010a:
        r0 = r1.a;	 Catch:{ all -> 0x0193 }
        r1 = r1.e();	 Catch:{ all -> 0x0193 }
        r3 = -2;
        r0 = r15.a(r3, r0, r1);	 Catch:{ all -> 0x0193 }
        r1 = com.google.android.gms.internal.ads.kb.a;	 Catch:{ all -> 0x0193 }
        r3 = new com.google.android.gms.internal.ads.fp;	 Catch:{ all -> 0x0193 }
        r3.<init>(r15, r0);	 Catch:{ all -> 0x0193 }
        r1.post(r3);	 Catch:{ all -> 0x0193 }
        monitor-exit(r2);	 Catch:{ all -> 0x0193 }
    L_0x0120:
        return;
    L_0x0121:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0121 }
        throw r0;
    L_0x0124:
        r0 = move-exception;
        r0 = java.lang.Thread.currentThread();	 Catch:{ all -> 0x0175 }
        r0.interrupt();	 Catch:{ all -> 0x0175 }
        r2 = r15.f;
        monitor-enter(r2);
        r0 = r1.a;	 Catch:{ all -> 0x0151 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x0151 }
        if (r0 != 0) goto L_0x0140;
    L_0x0137:
        r0 = r15.d;	 Catch:{ all -> 0x0151 }
        r1 = r1.d();	 Catch:{ all -> 0x0151 }
        r0.add(r1);	 Catch:{ all -> 0x0151 }
    L_0x0140:
        monitor-exit(r2);	 Catch:{ all -> 0x0151 }
    L_0x0141:
        r0 = 3;
        r0 = r15.a(r0, r14, r14);
        r1 = com.google.android.gms.internal.ads.kb.a;
        r2 = new com.google.android.gms.internal.ads.fq;
        r2.<init>(r15, r0);
        r1.post(r2);
        goto L_0x0120;
    L_0x0151:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0151 }
        throw r0;
    L_0x0154:
        r2 = move-exception;
        r5 = "Unable to resolve rewarded adapter.";
        com.google.android.gms.internal.ads.kk.c(r5, r2);	 Catch:{ all -> 0x0175 }
        r2 = r15.f;
        monitor-enter(r2);
        r5 = r1.a;	 Catch:{ all -> 0x0172 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0172 }
        if (r5 != 0) goto L_0x016e;
    L_0x0165:
        r5 = r15.d;	 Catch:{ all -> 0x0172 }
        r1 = r1.d();	 Catch:{ all -> 0x0172 }
        r5.add(r1);	 Catch:{ all -> 0x0172 }
    L_0x016e:
        monitor-exit(r2);	 Catch:{ all -> 0x0172 }
        r2 = r3;
        goto L_0x00d7;
    L_0x0172:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0172 }
        throw r0;
    L_0x0175:
        r0 = move-exception;
        r2 = r15.f;
        monitor-enter(r2);
        r3 = r1.a;	 Catch:{ all -> 0x018c }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x018c }
        if (r3 != 0) goto L_0x018a;
    L_0x0181:
        r3 = r15.d;	 Catch:{ all -> 0x018c }
        r1 = r1.d();	 Catch:{ all -> 0x018c }
        r3.add(r1);	 Catch:{ all -> 0x018c }
    L_0x018a:
        monitor-exit(r2);	 Catch:{ all -> 0x018c }
        throw r0;
    L_0x018c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x018c }
        throw r0;
    L_0x018f:
        monitor-exit(r2);	 Catch:{ all -> 0x0193 }
        r2 = r3;
        goto L_0x00d7;
    L_0x0193:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0193 }
        throw r0;
    L_0x0196:
        r2 = r0;
        goto L_0x0047;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.fo.a():void");
    }

    final /* synthetic */ void a(gr grVar) {
        this.g.b().zzb(grVar);
    }

    public final void b() {
    }

    final /* synthetic */ void b(gr grVar) {
        this.g.b().zzb(grVar);
    }

    public final void zza(String str, int i) {
    }

    public final void zzcb(String str) {
        synchronized (this.f) {
            this.e.add(str);
        }
    }
}
