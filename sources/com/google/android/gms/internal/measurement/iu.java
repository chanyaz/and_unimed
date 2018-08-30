package com.google.android.gms.internal.measurement;

public final class iu extends j<iu> {
    private static volatile iu[] K;
    public String A;
    public Boolean B;
    public iq[] C;
    public String D;
    public Integer E;
    public String F;
    public Long G;
    public Long H;
    public String I;
    public Integer J;
    private Integer L;
    private Integer M;
    private String N;
    public Integer c;
    public ir[] d;
    public iw[] e;
    public Long f;
    public Long g;
    public Long h;
    public Long i;
    public Long j;
    public String k;
    public String l;
    public String m;
    public String n;
    public Integer o;
    public String p;
    public String q;
    public String r;
    public Long s;
    public Long t;
    public String u;
    public Boolean v;
    public String w;
    public Long x;
    public Integer y;
    public String z;

    public iu() {
        this.c = null;
        this.d = ir.e();
        this.e = iw.e();
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
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = iq.e();
        this.D = null;
        this.E = null;
        this.L = null;
        this.M = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.N = null;
        this.J = null;
        this.a = null;
        this.b = -1;
    }

    public static iu[] e() {
        if (K == null) {
            synchronized (o.b) {
                if (K == null) {
                    K = new iu[0];
                }
            }
        }
        return K;
    }

    protected final int a() {
        int i;
        int i2 = 0;
        int a = super.a();
        if (this.c != null) {
            a += i.b(1, this.c.intValue());
        }
        if (this.d != null && this.d.length > 0) {
            i = a;
            for (p pVar : this.d) {
                if (pVar != null) {
                    i += i.b(2, pVar);
                }
            }
            a = i;
        }
        if (this.e != null && this.e.length > 0) {
            i = a;
            for (p pVar2 : this.e) {
                if (pVar2 != null) {
                    i += i.b(3, pVar2);
                }
            }
            a = i;
        }
        if (this.f != null) {
            a += i.c(4, this.f.longValue());
        }
        if (this.g != null) {
            a += i.c(5, this.g.longValue());
        }
        if (this.h != null) {
            a += i.c(6, this.h.longValue());
        }
        if (this.j != null) {
            a += i.c(7, this.j.longValue());
        }
        if (this.k != null) {
            a += i.b(8, this.k);
        }
        if (this.l != null) {
            a += i.b(9, this.l);
        }
        if (this.m != null) {
            a += i.b(10, this.m);
        }
        if (this.n != null) {
            a += i.b(11, this.n);
        }
        if (this.o != null) {
            a += i.b(12, this.o.intValue());
        }
        if (this.p != null) {
            a += i.b(13, this.p);
        }
        if (this.q != null) {
            a += i.b(14, this.q);
        }
        if (this.r != null) {
            a += i.b(16, this.r);
        }
        if (this.s != null) {
            a += i.c(17, this.s.longValue());
        }
        if (this.t != null) {
            a += i.c(18, this.t.longValue());
        }
        if (this.u != null) {
            a += i.b(19, this.u);
        }
        if (this.v != null) {
            this.v.booleanValue();
            a += i.b(20) + 1;
        }
        if (this.w != null) {
            a += i.b(21, this.w);
        }
        if (this.x != null) {
            a += i.c(22, this.x.longValue());
        }
        if (this.y != null) {
            a += i.b(23, this.y.intValue());
        }
        if (this.z != null) {
            a += i.b(24, this.z);
        }
        if (this.A != null) {
            a += i.b(25, this.A);
        }
        if (this.i != null) {
            a += i.c(26, this.i.longValue());
        }
        if (this.B != null) {
            this.B.booleanValue();
            a += i.b(28) + 1;
        }
        if (this.C != null && this.C.length > 0) {
            while (i2 < this.C.length) {
                p pVar3 = this.C[i2];
                if (pVar3 != null) {
                    a += i.b(29, pVar3);
                }
                i2++;
            }
        }
        if (this.D != null) {
            a += i.b(30, this.D);
        }
        if (this.E != null) {
            a += i.b(31, this.E.intValue());
        }
        if (this.L != null) {
            a += i.b(32, this.L.intValue());
        }
        if (this.M != null) {
            a += i.b(33, this.M.intValue());
        }
        if (this.F != null) {
            a += i.b(34, this.F);
        }
        if (this.G != null) {
            a += i.c(35, this.G.longValue());
        }
        if (this.H != null) {
            a += i.c(36, this.H.longValue());
        }
        if (this.I != null) {
            a += i.b(37, this.I);
        }
        if (this.N != null) {
            a += i.b(38, this.N);
        }
        return this.J != null ? a + i.b(39, this.J.intValue()) : a;
    }

    public final void a(i iVar) {
        int i = 0;
        if (this.c != null) {
            iVar.a(1, this.c.intValue());
        }
        if (this.d != null && this.d.length > 0) {
            for (p pVar : this.d) {
                if (pVar != null) {
                    iVar.a(2, pVar);
                }
            }
        }
        if (this.e != null && this.e.length > 0) {
            for (p pVar2 : this.e) {
                if (pVar2 != null) {
                    iVar.a(3, pVar2);
                }
            }
        }
        if (this.f != null) {
            iVar.b(4, this.f.longValue());
        }
        if (this.g != null) {
            iVar.b(5, this.g.longValue());
        }
        if (this.h != null) {
            iVar.b(6, this.h.longValue());
        }
        if (this.j != null) {
            iVar.b(7, this.j.longValue());
        }
        if (this.k != null) {
            iVar.a(8, this.k);
        }
        if (this.l != null) {
            iVar.a(9, this.l);
        }
        if (this.m != null) {
            iVar.a(10, this.m);
        }
        if (this.n != null) {
            iVar.a(11, this.n);
        }
        if (this.o != null) {
            iVar.a(12, this.o.intValue());
        }
        if (this.p != null) {
            iVar.a(13, this.p);
        }
        if (this.q != null) {
            iVar.a(14, this.q);
        }
        if (this.r != null) {
            iVar.a(16, this.r);
        }
        if (this.s != null) {
            iVar.b(17, this.s.longValue());
        }
        if (this.t != null) {
            iVar.b(18, this.t.longValue());
        }
        if (this.u != null) {
            iVar.a(19, this.u);
        }
        if (this.v != null) {
            iVar.a(20, this.v.booleanValue());
        }
        if (this.w != null) {
            iVar.a(21, this.w);
        }
        if (this.x != null) {
            iVar.b(22, this.x.longValue());
        }
        if (this.y != null) {
            iVar.a(23, this.y.intValue());
        }
        if (this.z != null) {
            iVar.a(24, this.z);
        }
        if (this.A != null) {
            iVar.a(25, this.A);
        }
        if (this.i != null) {
            iVar.b(26, this.i.longValue());
        }
        if (this.B != null) {
            iVar.a(28, this.B.booleanValue());
        }
        if (this.C != null && this.C.length > 0) {
            while (i < this.C.length) {
                p pVar3 = this.C[i];
                if (pVar3 != null) {
                    iVar.a(29, pVar3);
                }
                i++;
            }
        }
        if (this.D != null) {
            iVar.a(30, this.D);
        }
        if (this.E != null) {
            iVar.a(31, this.E.intValue());
        }
        if (this.L != null) {
            iVar.a(32, this.L.intValue());
        }
        if (this.M != null) {
            iVar.a(33, this.M.intValue());
        }
        if (this.F != null) {
            iVar.a(34, this.F);
        }
        if (this.G != null) {
            iVar.b(35, this.G.longValue());
        }
        if (this.H != null) {
            iVar.b(36, this.H.longValue());
        }
        if (this.I != null) {
            iVar.a(37, this.I);
        }
        if (this.N != null) {
            iVar.a(38, this.N);
        }
        if (this.J != null) {
            iVar.a(39, this.J.intValue());
        }
        super.a(iVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof iu)) {
            return false;
        }
        iu iuVar = (iu) obj;
        if (this.c == null) {
            if (iuVar.c != null) {
                return false;
            }
        } else if (!this.c.equals(iuVar.c)) {
            return false;
        }
        if (!o.a(this.d, iuVar.d)) {
            return false;
        }
        if (!o.a(this.e, iuVar.e)) {
            return false;
        }
        if (this.f == null) {
            if (iuVar.f != null) {
                return false;
            }
        } else if (!this.f.equals(iuVar.f)) {
            return false;
        }
        if (this.g == null) {
            if (iuVar.g != null) {
                return false;
            }
        } else if (!this.g.equals(iuVar.g)) {
            return false;
        }
        if (this.h == null) {
            if (iuVar.h != null) {
                return false;
            }
        } else if (!this.h.equals(iuVar.h)) {
            return false;
        }
        if (this.i == null) {
            if (iuVar.i != null) {
                return false;
            }
        } else if (!this.i.equals(iuVar.i)) {
            return false;
        }
        if (this.j == null) {
            if (iuVar.j != null) {
                return false;
            }
        } else if (!this.j.equals(iuVar.j)) {
            return false;
        }
        if (this.k == null) {
            if (iuVar.k != null) {
                return false;
            }
        } else if (!this.k.equals(iuVar.k)) {
            return false;
        }
        if (this.l == null) {
            if (iuVar.l != null) {
                return false;
            }
        } else if (!this.l.equals(iuVar.l)) {
            return false;
        }
        if (this.m == null) {
            if (iuVar.m != null) {
                return false;
            }
        } else if (!this.m.equals(iuVar.m)) {
            return false;
        }
        if (this.n == null) {
            if (iuVar.n != null) {
                return false;
            }
        } else if (!this.n.equals(iuVar.n)) {
            return false;
        }
        if (this.o == null) {
            if (iuVar.o != null) {
                return false;
            }
        } else if (!this.o.equals(iuVar.o)) {
            return false;
        }
        if (this.p == null) {
            if (iuVar.p != null) {
                return false;
            }
        } else if (!this.p.equals(iuVar.p)) {
            return false;
        }
        if (this.q == null) {
            if (iuVar.q != null) {
                return false;
            }
        } else if (!this.q.equals(iuVar.q)) {
            return false;
        }
        if (this.r == null) {
            if (iuVar.r != null) {
                return false;
            }
        } else if (!this.r.equals(iuVar.r)) {
            return false;
        }
        if (this.s == null) {
            if (iuVar.s != null) {
                return false;
            }
        } else if (!this.s.equals(iuVar.s)) {
            return false;
        }
        if (this.t == null) {
            if (iuVar.t != null) {
                return false;
            }
        } else if (!this.t.equals(iuVar.t)) {
            return false;
        }
        if (this.u == null) {
            if (iuVar.u != null) {
                return false;
            }
        } else if (!this.u.equals(iuVar.u)) {
            return false;
        }
        if (this.v == null) {
            if (iuVar.v != null) {
                return false;
            }
        } else if (!this.v.equals(iuVar.v)) {
            return false;
        }
        if (this.w == null) {
            if (iuVar.w != null) {
                return false;
            }
        } else if (!this.w.equals(iuVar.w)) {
            return false;
        }
        if (this.x == null) {
            if (iuVar.x != null) {
                return false;
            }
        } else if (!this.x.equals(iuVar.x)) {
            return false;
        }
        if (this.y == null) {
            if (iuVar.y != null) {
                return false;
            }
        } else if (!this.y.equals(iuVar.y)) {
            return false;
        }
        if (this.z == null) {
            if (iuVar.z != null) {
                return false;
            }
        } else if (!this.z.equals(iuVar.z)) {
            return false;
        }
        if (this.A == null) {
            if (iuVar.A != null) {
                return false;
            }
        } else if (!this.A.equals(iuVar.A)) {
            return false;
        }
        if (this.B == null) {
            if (iuVar.B != null) {
                return false;
            }
        } else if (!this.B.equals(iuVar.B)) {
            return false;
        }
        if (!o.a(this.C, iuVar.C)) {
            return false;
        }
        if (this.D == null) {
            if (iuVar.D != null) {
                return false;
            }
        } else if (!this.D.equals(iuVar.D)) {
            return false;
        }
        if (this.E == null) {
            if (iuVar.E != null) {
                return false;
            }
        } else if (!this.E.equals(iuVar.E)) {
            return false;
        }
        if (this.L == null) {
            if (iuVar.L != null) {
                return false;
            }
        } else if (!this.L.equals(iuVar.L)) {
            return false;
        }
        if (this.M == null) {
            if (iuVar.M != null) {
                return false;
            }
        } else if (!this.M.equals(iuVar.M)) {
            return false;
        }
        if (this.F == null) {
            if (iuVar.F != null) {
                return false;
            }
        } else if (!this.F.equals(iuVar.F)) {
            return false;
        }
        if (this.G == null) {
            if (iuVar.G != null) {
                return false;
            }
        } else if (!this.G.equals(iuVar.G)) {
            return false;
        }
        if (this.H == null) {
            if (iuVar.H != null) {
                return false;
            }
        } else if (!this.H.equals(iuVar.H)) {
            return false;
        }
        if (this.I == null) {
            if (iuVar.I != null) {
                return false;
            }
        } else if (!this.I.equals(iuVar.I)) {
            return false;
        }
        if (this.N == null) {
            if (iuVar.N != null) {
                return false;
            }
        } else if (!this.N.equals(iuVar.N)) {
            return false;
        }
        if (this.J == null) {
            if (iuVar.J != null) {
                return false;
            }
        } else if (!this.J.equals(iuVar.J)) {
            return false;
        }
        return (this.a == null || this.a.b()) ? iuVar.a == null || iuVar.a.b() : this.a.equals(iuVar.a);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.J == null ? 0 : this.J.hashCode()) + (((this.N == null ? 0 : this.N.hashCode()) + (((this.I == null ? 0 : this.I.hashCode()) + (((this.H == null ? 0 : this.H.hashCode()) + (((this.G == null ? 0 : this.G.hashCode()) + (((this.F == null ? 0 : this.F.hashCode()) + (((this.M == null ? 0 : this.M.hashCode()) + (((this.L == null ? 0 : this.L.hashCode()) + (((this.E == null ? 0 : this.E.hashCode()) + (((this.D == null ? 0 : this.D.hashCode()) + (((((this.B == null ? 0 : this.B.hashCode()) + (((this.A == null ? 0 : this.A.hashCode()) + (((this.z == null ? 0 : this.z.hashCode()) + (((this.y == null ? 0 : this.y.hashCode()) + (((this.x == null ? 0 : this.x.hashCode()) + (((this.w == null ? 0 : this.w.hashCode()) + (((this.v == null ? 0 : this.v.hashCode()) + (((this.u == null ? 0 : this.u.hashCode()) + (((this.t == null ? 0 : this.t.hashCode()) + (((this.s == null ? 0 : this.s.hashCode()) + (((this.r == null ? 0 : this.r.hashCode()) + (((this.q == null ? 0 : this.q.hashCode()) + (((this.p == null ? 0 : this.p.hashCode()) + (((this.o == null ? 0 : this.o.hashCode()) + (((this.n == null ? 0 : this.n.hashCode()) + (((this.m == null ? 0 : this.m.hashCode()) + (((this.l == null ? 0 : this.l.hashCode()) + (((this.k == null ? 0 : this.k.hashCode()) + (((this.j == null ? 0 : this.j.hashCode()) + (((this.i == null ? 0 : this.i.hashCode()) + (((this.h == null ? 0 : this.h.hashCode()) + (((this.g == null ? 0 : this.g.hashCode()) + (((this.f == null ? 0 : this.f.hashCode()) + (((((((this.c == null ? 0 : this.c.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + o.a(this.d)) * 31) + o.a(this.e)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + o.a(this.C)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (!(this.a == null || this.a.b())) {
            i = this.a.hashCode();
        }
        return hashCode + i;
    }
}
