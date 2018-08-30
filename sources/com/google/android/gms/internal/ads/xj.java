package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.List;

final class xj implements zzbdl {
    private final xg a;
    private int b;
    private int c;
    private int d = 0;

    private xj(xg xgVar) {
        this.a = (xg) yk.a((Object) xgVar, "input");
        this.a.c = this;
    }

    public static xj a(xg xgVar) {
        return xgVar.c != null ? xgVar.c : new xj(xgVar);
    }

    private final <T> T a(zzbdm<T> zzbdm, xs xsVar) {
        int m = this.a.m();
        if (this.a.a >= this.a.b) {
            throw new zzbbu("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        m = this.a.c(m);
        T newInstance = zzbdm.newInstance();
        xg xgVar = this.a;
        xgVar.a++;
        zzbdm.zza(newInstance, this, xsVar);
        zzbdm.zzo(newInstance);
        this.a.a(0);
        xgVar = this.a;
        xgVar.a--;
        this.a.d(m);
        return newInstance;
    }

    private final Object a(zzbes zzbes, Class<?> cls, xs xsVar) {
        switch (xk.a[zzbes.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzabq());
            case 2:
                return zzabs();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzabu());
            case 5:
                return Integer.valueOf(zzabp());
            case 6:
                return Long.valueOf(zzabo());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzabn());
            case 9:
                return Long.valueOf(zzabm());
            case 10:
                a(2);
                return a(zl.a().a((Class) cls), xsVar);
            case 11:
                return Integer.valueOf(zzabv());
            case 12:
                return Long.valueOf(zzabw());
            case 13:
                return Integer.valueOf(zzabx());
            case 14:
                return Long.valueOf(zzaby());
            case 15:
                return zzabr();
            case 16:
                return Integer.valueOf(zzabt());
            case 17:
                return Long.valueOf(zzabl());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void a(int i) {
        if ((this.b & 7) != i) {
            throw zzbbu.f();
        }
    }

    private final void a(List<String> list, boolean z) {
        int a;
        if ((this.b & 7) != 2) {
            throw zzbbu.f();
        } else if (!(list instanceof zzbcd) || z) {
            do {
                list.add(z ? zzabr() : readString());
                if (!this.a.t()) {
                    a = this.a.a();
                } else {
                    return;
                }
            } while (a == this.b);
            this.d = a;
        } else {
            zzbcd zzbcd = (zzbcd) list;
            do {
                zzbcd.zzap(zzabs());
                if (!this.a.t()) {
                    a = this.a.a();
                } else {
                    return;
                }
            } while (a == this.b);
            this.d = a;
        }
    }

    private final <T> T b(zzbdm<T> zzbdm, xs xsVar) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            T newInstance = zzbdm.newInstance();
            zzbdm.zza(newInstance, this, xsVar);
            zzbdm.zzo(newInstance);
            if (this.b == this.c) {
                return newInstance;
            }
            throw zzbbu.g();
        } finally {
            this.c = i;
        }
    }

    private static void b(int i) {
        if ((i & 7) != 0) {
            throw zzbbu.g();
        }
    }

    private static void c(int i) {
        if ((i & 3) != 0) {
            throw zzbbu.g();
        }
    }

    private final void d(int i) {
        if (this.a.u() != i) {
            throw zzbbu.a();
        }
    }

    public final int getTag() {
        return this.b;
    }

    public final double readDouble() {
        a(1);
        return this.a.b();
    }

    public final float readFloat() {
        a(5);
        return this.a.c();
    }

    public final String readString() {
        a(2);
        return this.a.j();
    }

    public final void readStringList(List<String> list) {
        a((List) list, false);
    }

    public final <T> T zza(zzbdm<T> zzbdm, xs xsVar) {
        a(2);
        return a((zzbdm) zzbdm, xsVar);
    }

    public final <T> void zza(List<T> list, zzbdm<T> zzbdm, xs xsVar) {
        if ((this.b & 7) != 2) {
            throw zzbbu.f();
        }
        int a;
        int i = this.b;
        do {
            list.add(a((zzbdm) zzbdm, xsVar));
            if (!this.a.t() && this.d == 0) {
                a = this.a.a();
            } else {
                return;
            }
        } while (a == i);
        this.d = a;
    }

    public final <K, V> void zza(java.util.Map<K, V> r7, com.google.android.gms.internal.ads.zb<K, V> r8, com.google.android.gms.internal.ads.xs r9) {
        /*
        r6 = this;
        r0 = 2;
        r6.a(r0);
        r0 = r6.a;
        r0 = r0.m();
        r1 = r6.a;
        r2 = r1.c(r0);
        r1 = r8.b;
        r0 = r8.d;
    L_0x0014:
        r3 = r6.zzaci();	 Catch:{ all -> 0x0045 }
        r4 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        if (r3 == r4) goto L_0x0062;
    L_0x001d:
        r4 = r6.a;	 Catch:{ all -> 0x0045 }
        r4 = r4.t();	 Catch:{ all -> 0x0045 }
        if (r4 != 0) goto L_0x0062;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x004c;
            case 2: goto L_0x0055;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r6.zzacj();	 Catch:{ zzbbv -> 0x0036 }
        if (r3 != 0) goto L_0x0014;
    L_0x002e:
        r3 = new com.google.android.gms.internal.ads.zzbbu;	 Catch:{ zzbbv -> 0x0036 }
        r4 = "Unable to parse map entry.";
        r3.<init>(r4);	 Catch:{ zzbbv -> 0x0036 }
        throw r3;	 Catch:{ zzbbv -> 0x0036 }
    L_0x0036:
        r3 = move-exception;
        r3 = r6.zzacj();	 Catch:{ all -> 0x0045 }
        if (r3 != 0) goto L_0x0014;
    L_0x003d:
        r0 = new com.google.android.gms.internal.ads.zzbbu;	 Catch:{ all -> 0x0045 }
        r1 = "Unable to parse map entry.";
        r0.<init>(r1);	 Catch:{ all -> 0x0045 }
        throw r0;	 Catch:{ all -> 0x0045 }
    L_0x0045:
        r0 = move-exception;
        r1 = r6.a;
        r1.d(r2);
        throw r0;
    L_0x004c:
        r3 = r8.a;	 Catch:{ zzbbv -> 0x0036 }
        r4 = 0;
        r5 = 0;
        r1 = r6.a(r3, r4, r5);	 Catch:{ zzbbv -> 0x0036 }
        goto L_0x0014;
    L_0x0055:
        r3 = r8.c;	 Catch:{ zzbbv -> 0x0036 }
        r4 = r8.d;	 Catch:{ zzbbv -> 0x0036 }
        r4 = r4.getClass();	 Catch:{ zzbbv -> 0x0036 }
        r0 = r6.a(r3, r4, r9);	 Catch:{ zzbbv -> 0x0036 }
        goto L_0x0014;
    L_0x0062:
        r7.put(r1, r0);	 Catch:{ all -> 0x0045 }
        r0 = r6.a;
        r0.d(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.xj.zza(java.util.Map, com.google.android.gms.internal.ads.zb, com.google.android.gms.internal.ads.xs):void");
    }

    public final void zzaa(List<Integer> list) {
        int m;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        yjVar.b(this.a.n());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                yjVar.b(this.a.n());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.n()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Integer.valueOf(this.a.n()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzab(List<Integer> list) {
        int m;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            switch (this.b & 7) {
                case 2:
                    m = this.a.m();
                    c(m);
                    m += this.a.u();
                    do {
                        yjVar.b(this.a.o());
                    } while (this.a.u() < m);
                    return;
                case 5:
                    break;
                default:
                    throw zzbbu.f();
            }
            do {
                yjVar.b(this.a.o());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 2:
                m = this.a.m();
                c(m);
                m += this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.o()));
                } while (this.a.u() < m);
                return;
            case 5:
                break;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Integer.valueOf(this.a.o()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final long zzabl() {
        a(0);
        return this.a.d();
    }

    public final long zzabm() {
        a(0);
        return this.a.e();
    }

    public final int zzabn() {
        a(0);
        return this.a.f();
    }

    public final long zzabo() {
        a(1);
        return this.a.g();
    }

    public final int zzabp() {
        a(5);
        return this.a.h();
    }

    public final boolean zzabq() {
        a(0);
        return this.a.i();
    }

    public final String zzabr() {
        a(2);
        return this.a.k();
    }

    public final zzbah zzabs() {
        a(2);
        return this.a.l();
    }

    public final int zzabt() {
        a(0);
        return this.a.m();
    }

    public final int zzabu() {
        a(0);
        return this.a.n();
    }

    public final int zzabv() {
        a(5);
        return this.a.o();
    }

    public final long zzabw() {
        a(1);
        return this.a.p();
    }

    public final int zzabx() {
        a(0);
        return this.a.q();
    }

    public final long zzaby() {
        a(0);
        return this.a.r();
    }

    public final void zzac(List<Long> list) {
        int m;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.a.m();
                    b(m);
                    m += this.a.u();
                    do {
                        ywVar.a(this.a.p());
                    } while (this.a.u() < m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                ywVar.a(this.a.p());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                m = this.a.m();
                b(m);
                m += this.a.u();
                do {
                    list.add(Long.valueOf(this.a.p()));
                } while (this.a.u() < m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Long.valueOf(this.a.p()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final int zzaci() {
        if (this.d != 0) {
            this.b = this.d;
            this.d = 0;
        } else {
            this.b = this.a.a();
        }
        return (this.b == 0 || this.b == this.c) ? MoPubClientPositioning.NO_REPEAT : this.b >>> 3;
    }

    public final boolean zzacj() {
        return (this.a.t() || this.b == this.c) ? false : this.a.b(this.b);
    }

    public final void zzad(List<Integer> list) {
        int m;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        yjVar.b(this.a.q());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                yjVar.b(this.a.q());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.q()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Integer.valueOf(this.a.q()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzae(List<Long> list) {
        int m;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        ywVar.a(this.a.r());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                ywVar.a(this.a.r());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Long.valueOf(this.a.r()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Long.valueOf(this.a.r()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final <T> T zzb(zzbdm<T> zzbdm, xs xsVar) {
        a(3);
        return b(zzbdm, xsVar);
    }

    public final <T> void zzb(List<T> list, zzbdm<T> zzbdm, xs xsVar) {
        if ((this.b & 7) != 3) {
            throw zzbbu.f();
        }
        int a;
        int i = this.b;
        do {
            list.add(b(zzbdm, xsVar));
            if (!this.a.t() && this.d == 0) {
                a = this.a.a();
            } else {
                return;
            }
        } while (a == i);
        this.d = a;
    }

    public final void zzp(List<Double> list) {
        int m;
        if (list instanceof xo) {
            xo xoVar = (xo) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.a.m();
                    b(m);
                    m += this.a.u();
                    do {
                        xoVar.a(this.a.b());
                    } while (this.a.u() < m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                xoVar.a(this.a.b());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                m = this.a.m();
                b(m);
                m += this.a.u();
                do {
                    list.add(Double.valueOf(this.a.b()));
                } while (this.a.u() < m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Double.valueOf(this.a.b()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzq(List<Float> list) {
        int m;
        if (list instanceof yb) {
            yb ybVar = (yb) list;
            switch (this.b & 7) {
                case 2:
                    m = this.a.m();
                    c(m);
                    m += this.a.u();
                    do {
                        ybVar.a(this.a.c());
                    } while (this.a.u() < m);
                    return;
                case 5:
                    break;
                default:
                    throw zzbbu.f();
            }
            do {
                ybVar.a(this.a.c());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 2:
                m = this.a.m();
                c(m);
                m += this.a.u();
                do {
                    list.add(Float.valueOf(this.a.c()));
                } while (this.a.u() < m);
                return;
            case 5:
                break;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Float.valueOf(this.a.c()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzr(List<Long> list) {
        int m;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        ywVar.a(this.a.d());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                ywVar.a(this.a.d());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Long.valueOf(this.a.d()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Long.valueOf(this.a.d()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzs(List<Long> list) {
        int m;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        ywVar.a(this.a.e());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                ywVar.a(this.a.e());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Long.valueOf(this.a.e()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Long.valueOf(this.a.e()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzt(List<Integer> list) {
        int m;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        yjVar.b(this.a.f());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                yjVar.b(this.a.f());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.f()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Integer.valueOf(this.a.f()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzu(List<Long> list) {
        int m;
        if (list instanceof yw) {
            yw ywVar = (yw) list;
            switch (this.b & 7) {
                case 1:
                    break;
                case 2:
                    m = this.a.m();
                    b(m);
                    m += this.a.u();
                    do {
                        ywVar.a(this.a.g());
                    } while (this.a.u() < m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                ywVar.a(this.a.g());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 1:
                break;
            case 2:
                m = this.a.m();
                b(m);
                m += this.a.u();
                do {
                    list.add(Long.valueOf(this.a.g()));
                } while (this.a.u() < m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Long.valueOf(this.a.g()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzv(List<Integer> list) {
        int m;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            switch (this.b & 7) {
                case 2:
                    m = this.a.m();
                    c(m);
                    m += this.a.u();
                    do {
                        yjVar.b(this.a.h());
                    } while (this.a.u() < m);
                    return;
                case 5:
                    break;
                default:
                    throw zzbbu.f();
            }
            do {
                yjVar.b(this.a.h());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 2:
                m = this.a.m();
                c(m);
                m += this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.h()));
                } while (this.a.u() < m);
                return;
            case 5:
                break;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Integer.valueOf(this.a.h()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzw(List<Boolean> list) {
        int m;
        if (list instanceof wx) {
            wx wxVar = (wx) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        wxVar.a(this.a.i());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                wxVar.a(this.a.i());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Boolean.valueOf(this.a.i()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Boolean.valueOf(this.a.i()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }

    public final void zzx(List<String> list) {
        a((List) list, true);
    }

    public final void zzy(List<zzbah> list) {
        if ((this.b & 7) != 2) {
            throw zzbbu.f();
        }
        int a;
        do {
            list.add(zzabs());
            if (!this.a.t()) {
                a = this.a.a();
            } else {
                return;
            }
        } while (a == this.b);
        this.d = a;
    }

    public final void zzz(List<Integer> list) {
        int m;
        if (list instanceof yj) {
            yj yjVar = (yj) list;
            switch (this.b & 7) {
                case 0:
                    break;
                case 2:
                    m = this.a.m() + this.a.u();
                    do {
                        yjVar.b(this.a.m());
                    } while (this.a.u() < m);
                    d(m);
                    return;
                default:
                    throw zzbbu.f();
            }
            do {
                yjVar.b(this.a.m());
                if (!this.a.t()) {
                    m = this.a.a();
                } else {
                    return;
                }
            } while (m == this.b);
            this.d = m;
            return;
        }
        switch (this.b & 7) {
            case 0:
                break;
            case 2:
                m = this.a.m() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.m()));
                } while (this.a.u() < m);
                d(m);
                return;
            default:
                throw zzbbu.f();
        }
        do {
            list.add(Integer.valueOf(this.a.m()));
            if (!this.a.t()) {
                m = this.a.a();
            } else {
                return;
            }
        } while (m == this.b);
        this.d = m;
    }
}
