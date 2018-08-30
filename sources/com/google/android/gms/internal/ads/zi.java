package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map.Entry;

final class zi<T> implements zzbdm<T> {
    private final zzbcu a;
    private final aaf<?, ?> b;
    private final boolean c;
    private final xu<?> d;

    private zi(aaf<?, ?> aaf, xu<?> xuVar, zzbcu zzbcu) {
        this.b = aaf;
        this.c = xuVar.a(zzbcu);
        this.d = xuVar;
        this.a = zzbcu;
    }

    static <T> zi<T> a(aaf<?, ?> aaf, xu<?> xuVar, zzbcu zzbcu) {
        return new zi(aaf, xuVar, zzbcu);
    }

    public final boolean equals(T t, T t2) {
        return !this.b.b(t).equals(this.b.b(t2)) ? false : this.c ? this.d.a((Object) t).equals(this.d.a((Object) t2)) : true;
    }

    public final int hashCode(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a((Object) t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.a.zzadf().zzadj();
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0037 A:{SYNTHETIC} */
    public final void zza(T r12, com.google.android.gms.internal.ads.zzbdl r13, com.google.android.gms.internal.ads.xs r14) {
        /*
        r11 = this;
        r1 = 0;
        r10 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r4 = r11.b;
        r5 = r11.d;
        r6 = r4.c(r12);
        r7 = r5.b(r12);
    L_0x0010:
        r0 = r13.zzaci();	 Catch:{ all -> 0x006c }
        if (r0 != r10) goto L_0x001a;
    L_0x0016:
        r4.b(r12, r6);
    L_0x0019:
        return;
    L_0x001a:
        r0 = r13.getTag();	 Catch:{ all -> 0x006c }
        r2 = 11;
        if (r0 == r2) goto L_0x0045;
    L_0x0022:
        r2 = r0 & 7;
        r3 = 2;
        if (r2 != r3) goto L_0x0040;
    L_0x0027:
        r2 = r11.a;	 Catch:{ all -> 0x006c }
        r0 = r0 >>> 3;
        r0 = r5.a(r14, r2, r0);	 Catch:{ all -> 0x006c }
        if (r0 == 0) goto L_0x003b;
    L_0x0031:
        r5.a(r13, r0, r14, r7);	 Catch:{ all -> 0x006c }
    L_0x0034:
        r0 = 1;
    L_0x0035:
        if (r0 != 0) goto L_0x0010;
    L_0x0037:
        r4.b(r12, r6);
        goto L_0x0019;
    L_0x003b:
        r0 = r4.a(r6, r13);	 Catch:{ all -> 0x006c }
        goto L_0x0035;
    L_0x0040:
        r0 = r13.zzacj();	 Catch:{ all -> 0x006c }
        goto L_0x0035;
    L_0x0045:
        r0 = 0;
        r2 = r1;
        r3 = r0;
        r0 = r1;
    L_0x0049:
        r8 = r13.zzaci();	 Catch:{ all -> 0x006c }
        if (r8 == r10) goto L_0x007c;
    L_0x004f:
        r8 = r13.getTag();	 Catch:{ all -> 0x006c }
        r9 = 16;
        if (r8 != r9) goto L_0x0062;
    L_0x0057:
        r3 = r13.zzabt();	 Catch:{ all -> 0x006c }
        r0 = r11.a;	 Catch:{ all -> 0x006c }
        r0 = r5.a(r14, r0, r3);	 Catch:{ all -> 0x006c }
        goto L_0x0049;
    L_0x0062:
        r9 = 26;
        if (r8 != r9) goto L_0x0076;
    L_0x0066:
        if (r0 == 0) goto L_0x0071;
    L_0x0068:
        r5.a(r13, r0, r14, r7);	 Catch:{ all -> 0x006c }
        goto L_0x0049;
    L_0x006c:
        r0 = move-exception;
        r4.b(r12, r6);
        throw r0;
    L_0x0071:
        r2 = r13.zzabs();	 Catch:{ all -> 0x006c }
        goto L_0x0049;
    L_0x0076:
        r8 = r13.zzacj();	 Catch:{ all -> 0x006c }
        if (r8 != 0) goto L_0x0049;
    L_0x007c:
        r8 = r13.getTag();	 Catch:{ all -> 0x006c }
        r9 = 12;
        if (r8 == r9) goto L_0x0089;
    L_0x0084:
        r0 = com.google.android.gms.internal.ads.zzbbu.e();	 Catch:{ all -> 0x006c }
        throw r0;	 Catch:{ all -> 0x006c }
    L_0x0089:
        if (r2 == 0) goto L_0x0034;
    L_0x008b:
        if (r0 == 0) goto L_0x0091;
    L_0x008d:
        r5.a(r2, r0, r14, r7);	 Catch:{ all -> 0x006c }
        goto L_0x0034;
    L_0x0091:
        r4.a(r6, r3, r2);	 Catch:{ all -> 0x006c }
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zi.zza(java.lang.Object, com.google.android.gms.internal.ads.zzbdl, com.google.android.gms.internal.ads.xs):void");
    }

    public final void zza(T t, zzbey zzbey) {
        Iterator e = this.d.a((Object) t).e();
        while (e.hasNext()) {
            Entry entry = (Entry) e.next();
            zzbbi zzbbi = (zzbbi) entry.getKey();
            if (zzbbi.zzacz() != zzbex.MESSAGE || zzbbi.zzada() || zzbbi.zzadb()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (entry instanceof yn) {
                zzbey.zza(zzbbi.zzhq(), ((yn) entry).a().c());
            } else {
                zzbey.zza(zzbbi.zzhq(), entry.getValue());
            }
        }
        aaf aaf = this.b;
        aaf.b(aaf.b(t), zzbey);
    }

    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.ads.ww r14) {
        /*
        r9 = this;
        r7 = 2;
        r0 = r10;
        r0 = (com.google.android.gms.internal.ads.yd) r0;
        r4 = r0.zzdtt;
        r0 = com.google.android.gms.internal.ads.aag.a();
        if (r4 != r0) goto L_0x0014;
    L_0x000c:
        r4 = com.google.android.gms.internal.ads.aag.b();
        r10 = (com.google.android.gms.internal.ads.yd) r10;
        r10.zzdtt = r4;
    L_0x0014:
        if (r12 >= r13) goto L_0x0074;
    L_0x0016:
        r2 = com.google.android.gms.internal.ads.wv.a(r11, r12, r14);
        r0 = r14.a;
        r1 = 11;
        if (r0 == r1) goto L_0x0031;
    L_0x0020:
        r1 = r0 & 7;
        if (r1 != r7) goto L_0x002c;
    L_0x0024:
        r1 = r11;
        r3 = r13;
        r5 = r14;
        r12 = com.google.android.gms.internal.ads.wv.a(r0, r1, r2, r3, r4, r5);
        goto L_0x0014;
    L_0x002c:
        r12 = com.google.android.gms.internal.ads.wv.a(r0, r11, r2, r13, r14);
        goto L_0x0014;
    L_0x0031:
        r1 = 0;
        r0 = 0;
        r8 = r0;
        r0 = r2;
        r2 = r1;
        r1 = r8;
    L_0x0037:
        if (r0 >= r13) goto L_0x0069;
    L_0x0039:
        r0 = com.google.android.gms.internal.ads.wv.a(r11, r0, r14);
        r3 = r14.a;
        r5 = r3 >>> 3;
        r6 = r3 & 7;
        switch(r5) {
            case 2: goto L_0x004f;
            case 3: goto L_0x005b;
            default: goto L_0x0046;
        };
    L_0x0046:
        r5 = 12;
        if (r3 == r5) goto L_0x0069;
    L_0x004a:
        r0 = com.google.android.gms.internal.ads.wv.a(r3, r11, r0, r13, r14);
        goto L_0x0037;
    L_0x004f:
        if (r6 != 0) goto L_0x0046;
    L_0x0051:
        r2 = com.google.android.gms.internal.ads.wv.a(r11, r0, r14);
        r0 = r14.a;
        r8 = r0;
        r0 = r2;
        r2 = r8;
        goto L_0x0037;
    L_0x005b:
        if (r6 != r7) goto L_0x0046;
    L_0x005d:
        r1 = com.google.android.gms.internal.ads.wv.e(r11, r0, r14);
        r0 = r14.c;
        r0 = (com.google.android.gms.internal.ads.zzbah) r0;
        r8 = r0;
        r0 = r1;
        r1 = r8;
        goto L_0x0037;
    L_0x0069:
        if (r1 == 0) goto L_0x0072;
    L_0x006b:
        r2 = r2 << 3;
        r2 = r2 | 2;
        r4.a(r2, r1);
    L_0x0072:
        r12 = r0;
        goto L_0x0014;
    L_0x0074:
        if (r12 == r13) goto L_0x007b;
    L_0x0076:
        r0 = com.google.android.gms.internal.ads.zzbbu.g();
        throw r0;
    L_0x007b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zi.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.ww):void");
    }

    public final boolean zzaa(T t) {
        return this.d.a((Object) t).g();
    }

    public final void zzc(T t, T t2) {
        zq.a(this.b, (Object) t, (Object) t2);
        if (this.c) {
            zq.a(this.d, (Object) t, (Object) t2);
        }
    }

    public final void zzo(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    public final int zzy(T t) {
        aaf aaf = this.b;
        int e = aaf.e(aaf.b(t)) + 0;
        return this.c ? e + this.d.a((Object) t).i() : e;
    }
}
