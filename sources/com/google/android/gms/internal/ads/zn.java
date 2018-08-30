package com.google.android.gms.internal.ads;

final class zn implements zzbcs {
    private final zzbcu a;
    private final String b;
    private final zo c;

    zn(zzbcu zzbcu, String str, Object[] objArr) {
        this.a = zzbcu;
        this.b = str;
        this.c = new zo(zzbcu.getClass(), str, objArr);
    }

    final zo a() {
        return this.c;
    }

    public final int b() {
        return this.c.h;
    }

    public final int c() {
        return this.c.i;
    }

    public final int d() {
        return this.c.e;
    }

    public final int e() {
        return this.c.j;
    }

    public final int f() {
        return this.c.m;
    }

    final int[] g() {
        return this.c.n;
    }

    public final int h() {
        return this.c.l;
    }

    public final int i() {
        return this.c.k;
    }

    public final int zzaeh() {
        return (this.c.d & 1) == 1 ? yi.h : yi.i;
    }

    public final boolean zzaei() {
        return (this.c.d & 2) == 2;
    }

    public final zzbcu zzaej() {
        return this.a;
    }
}
