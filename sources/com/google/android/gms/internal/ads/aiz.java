package com.google.android.gms.internal.ads;

public final class aiz extends abe<aiz> {
    private static volatile aiz[] a;
    private ajd b;
    private ajg c;
    private ajh d;
    private aji e;
    private aja f;
    private aje g;
    private ajc h;
    private Integer i;
    private Integer j;
    private aix k;
    private Integer l;
    private Integer m;
    private Integer n;
    private Integer o;
    private Integer p;
    private Long q;

    public aiz() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.Y = null;
        this.Z = -1;
    }

    public static aiz[] b() {
        if (a == null) {
            synchronized (abi.b) {
                if (a == null) {
                    a = new aiz[0];
                }
            }
        }
        return a;
    }

    protected final int a() {
        int a = super.a();
        if (this.b != null) {
            a += abd.b(5, this.b);
        }
        if (this.c != null) {
            a += abd.b(6, this.c);
        }
        if (this.d != null) {
            a += abd.b(7, this.d);
        }
        if (this.e != null) {
            a += abd.b(8, this.e);
        }
        if (this.f != null) {
            a += abd.b(9, this.f);
        }
        if (this.g != null) {
            a += abd.b(10, this.g);
        }
        if (this.h != null) {
            a += abd.b(11, this.h);
        }
        if (this.i != null) {
            a += abd.b(12, this.i.intValue());
        }
        if (this.j != null) {
            a += abd.b(13, this.j.intValue());
        }
        if (this.k != null) {
            a += abd.b(14, this.k);
        }
        if (this.l != null) {
            a += abd.b(15, this.l.intValue());
        }
        if (this.m != null) {
            a += abd.b(16, this.m.intValue());
        }
        if (this.n != null) {
            a += abd.b(17, this.n.intValue());
        }
        if (this.o != null) {
            a += abd.b(18, this.o.intValue());
        }
        if (this.p != null) {
            a += abd.b(19, this.p.intValue());
        }
        return this.q != null ? a + abd.c(20, this.q.longValue()) : a;
    }

    public final void a(abd abd) {
        if (this.b != null) {
            abd.a(5, this.b);
        }
        if (this.c != null) {
            abd.a(6, this.c);
        }
        if (this.d != null) {
            abd.a(7, this.d);
        }
        if (this.e != null) {
            abd.a(8, this.e);
        }
        if (this.f != null) {
            abd.a(9, this.f);
        }
        if (this.g != null) {
            abd.a(10, this.g);
        }
        if (this.h != null) {
            abd.a(11, this.h);
        }
        if (this.i != null) {
            abd.a(12, this.i.intValue());
        }
        if (this.j != null) {
            abd.a(13, this.j.intValue());
        }
        if (this.k != null) {
            abd.a(14, this.k);
        }
        if (this.l != null) {
            abd.a(15, this.l.intValue());
        }
        if (this.m != null) {
            abd.a(16, this.m.intValue());
        }
        if (this.n != null) {
            abd.a(17, this.n.intValue());
        }
        if (this.o != null) {
            abd.a(18, this.o.intValue());
        }
        if (this.p != null) {
            abd.a(19, this.p.intValue());
        }
        if (this.q != null) {
            abd.a(20, this.q.longValue());
        }
        super.a(abd);
    }
}
