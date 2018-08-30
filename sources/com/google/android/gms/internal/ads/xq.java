package com.google.android.gms.internal.ads;

public final class xq extends abe<xq> {
    private static volatile xq[] t;
    public Long a;
    public Long b;
    public Long c;
    public Long d;
    public Long e;
    public Long f;
    public Integer g;
    public Long h;
    public Long i;
    public Long j;
    public Integer k;
    public Long l;
    public Long m;
    public Long n;
    public Long o;
    public Long p;
    public Long q;
    public Long r;
    public Long s;
    private Long u;
    private Long v;

    public xq() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.u = null;
        this.v = null;
        this.Z = -1;
    }

    private final xq b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.a = Long.valueOf(abb.h());
                    continue;
                case 16:
                    this.b = Long.valueOf(abb.h());
                    continue;
                case 24:
                    this.c = Long.valueOf(abb.h());
                    continue;
                case 32:
                    this.d = Long.valueOf(abb.h());
                    continue;
                case 40:
                    this.e = Long.valueOf(abb.h());
                    continue;
                case 48:
                    this.f = Long.valueOf(abb.h());
                    continue;
                case 56:
                    j = abb.j();
                    try {
                        this.g = Integer.valueOf(vq.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 64:
                    this.h = Long.valueOf(abb.h());
                    continue;
                case 72:
                    this.i = Long.valueOf(abb.h());
                    continue;
                case 80:
                    this.j = Long.valueOf(abb.h());
                    continue;
                case 88:
                    j = abb.j();
                    try {
                        this.k = Integer.valueOf(vq.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 96:
                    this.l = Long.valueOf(abb.h());
                    continue;
                case 104:
                    this.m = Long.valueOf(abb.h());
                    continue;
                case 112:
                    this.n = Long.valueOf(abb.h());
                    continue;
                case 120:
                    this.o = Long.valueOf(abb.h());
                    continue;
                case 128:
                    this.p = Long.valueOf(abb.h());
                    continue;
                case 136:
                    this.q = Long.valueOf(abb.h());
                    continue;
                case 144:
                    this.r = Long.valueOf(abb.h());
                    continue;
                case 152:
                    this.s = Long.valueOf(abb.h());
                    continue;
                case 160:
                    this.u = Long.valueOf(abb.h());
                    continue;
                case 168:
                    this.v = Long.valueOf(abb.h());
                    continue;
                default:
                    if (!super.a(abb, a)) {
                        break;
                    }
                    continue;
            }
        }
        return this;
    }

    public static xq[] b() {
        if (t == null) {
            synchronized (abi.b) {
                if (t == null) {
                    t = new xq[0];
                }
            }
        }
        return t;
    }

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.d(1, this.a.longValue());
        }
        if (this.b != null) {
            a += abd.d(2, this.b.longValue());
        }
        if (this.c != null) {
            a += abd.d(3, this.c.longValue());
        }
        if (this.d != null) {
            a += abd.d(4, this.d.longValue());
        }
        if (this.e != null) {
            a += abd.d(5, this.e.longValue());
        }
        if (this.f != null) {
            a += abd.d(6, this.f.longValue());
        }
        if (this.g != null) {
            a += abd.b(7, this.g.intValue());
        }
        if (this.h != null) {
            a += abd.d(8, this.h.longValue());
        }
        if (this.i != null) {
            a += abd.d(9, this.i.longValue());
        }
        if (this.j != null) {
            a += abd.d(10, this.j.longValue());
        }
        if (this.k != null) {
            a += abd.b(11, this.k.intValue());
        }
        if (this.l != null) {
            a += abd.d(12, this.l.longValue());
        }
        if (this.m != null) {
            a += abd.d(13, this.m.longValue());
        }
        if (this.n != null) {
            a += abd.d(14, this.n.longValue());
        }
        if (this.o != null) {
            a += abd.d(15, this.o.longValue());
        }
        if (this.p != null) {
            a += abd.d(16, this.p.longValue());
        }
        if (this.q != null) {
            a += abd.d(17, this.q.longValue());
        }
        if (this.r != null) {
            a += abd.d(18, this.r.longValue());
        }
        if (this.s != null) {
            a += abd.d(19, this.s.longValue());
        }
        if (this.u != null) {
            a += abd.d(20, this.u.longValue());
        }
        return this.v != null ? a + abd.d(21, this.v.longValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.b(1, this.a.longValue());
        }
        if (this.b != null) {
            abd.b(2, this.b.longValue());
        }
        if (this.c != null) {
            abd.b(3, this.c.longValue());
        }
        if (this.d != null) {
            abd.b(4, this.d.longValue());
        }
        if (this.e != null) {
            abd.b(5, this.e.longValue());
        }
        if (this.f != null) {
            abd.b(6, this.f.longValue());
        }
        if (this.g != null) {
            abd.a(7, this.g.intValue());
        }
        if (this.h != null) {
            abd.b(8, this.h.longValue());
        }
        if (this.i != null) {
            abd.b(9, this.i.longValue());
        }
        if (this.j != null) {
            abd.b(10, this.j.longValue());
        }
        if (this.k != null) {
            abd.a(11, this.k.intValue());
        }
        if (this.l != null) {
            abd.b(12, this.l.longValue());
        }
        if (this.m != null) {
            abd.b(13, this.m.longValue());
        }
        if (this.n != null) {
            abd.b(14, this.n.longValue());
        }
        if (this.o != null) {
            abd.b(15, this.o.longValue());
        }
        if (this.p != null) {
            abd.b(16, this.p.longValue());
        }
        if (this.q != null) {
            abd.b(17, this.q.longValue());
        }
        if (this.r != null) {
            abd.b(18, this.r.longValue());
        }
        if (this.s != null) {
            abd.b(19, this.s.longValue());
        }
        if (this.u != null) {
            abd.b(20, this.u.longValue());
        }
        if (this.v != null) {
            abd.b(21, this.v.longValue());
        }
        super.a(abd);
    }
}
