package com.google.android.gms.internal.ads;

public final class wr extends abe<wr> {
    public Long A;
    public Long B;
    public String C;
    public String D;
    public Integer E;
    public Integer F;
    public Long G;
    public Long H;
    public Long I;
    public Integer J;
    public xq K;
    public xq[] L;
    public yo M;
    public Long N;
    public Long O;
    public Long P;
    public Long Q;
    public Long R;
    public String S;
    public String T;
    public Integer U;
    public Boolean V;
    public Long W;
    public abc X;
    public String a;
    private Long aa;
    private Long ab;
    private Long ac;
    private Long ad;
    private Long ae;
    private Long af;
    private String ag;
    private Long ah;
    private Long ai;
    private zh aj;
    private Long ak;
    private Long al;
    private Long am;
    private Long an;
    private Integer ao;
    private Integer ap;
    private Integer aq;
    private Long ar;
    private String as;
    public String b;
    public Long c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public Long i;
    public Long j;
    public Long k;
    public Long l;
    public Long m;
    public String n;
    public String o;
    public Long p;
    public Long q;
    public Long r;
    public String s;
    public Long t;
    public Long u;
    public Long v;
    public Long w;
    public Long x;
    public Long y;
    public Long z;

    public wr() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.aa = null;
        this.d = null;
        this.e = null;
        this.ab = null;
        this.ac = null;
        this.ad = null;
        this.ae = null;
        this.af = null;
        this.f = null;
        this.ag = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.ah = null;
        this.ai = null;
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
        this.aj = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.ak = null;
        this.al = null;
        this.K = null;
        this.L = xq.b();
        this.M = null;
        this.am = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.an = null;
        this.ar = null;
        this.T = null;
        this.V = null;
        this.as = null;
        this.W = null;
        this.X = null;
        this.Z = -1;
    }

    private final wr b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            int g;
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.a = abb.e();
                    continue;
                case 18:
                    this.b = abb.e();
                    continue;
                case 24:
                    this.c = Long.valueOf(abb.h());
                    continue;
                case 32:
                    this.aa = Long.valueOf(abb.h());
                    continue;
                case 40:
                    this.d = Long.valueOf(abb.h());
                    continue;
                case 48:
                    this.e = Long.valueOf(abb.h());
                    continue;
                case 56:
                    this.ab = Long.valueOf(abb.h());
                    continue;
                case 64:
                    this.ac = Long.valueOf(abb.h());
                    continue;
                case 72:
                    this.ad = Long.valueOf(abb.h());
                    continue;
                case 80:
                    this.ae = Long.valueOf(abb.h());
                    continue;
                case 88:
                    this.af = Long.valueOf(abb.h());
                    continue;
                case 96:
                    this.f = Long.valueOf(abb.h());
                    continue;
                case 106:
                    this.ag = abb.e();
                    continue;
                case 112:
                    this.g = Long.valueOf(abb.h());
                    continue;
                case 120:
                    this.h = Long.valueOf(abb.h());
                    continue;
                case 128:
                    this.i = Long.valueOf(abb.h());
                    continue;
                case 136:
                    this.j = Long.valueOf(abb.h());
                    continue;
                case 144:
                    this.ah = Long.valueOf(abb.h());
                    continue;
                case 152:
                    this.ai = Long.valueOf(abb.h());
                    continue;
                case 160:
                    this.k = Long.valueOf(abb.h());
                    continue;
                case 168:
                    this.ar = Long.valueOf(abb.h());
                    continue;
                case 176:
                    this.l = Long.valueOf(abb.h());
                    continue;
                case 184:
                    this.m = Long.valueOf(abb.h());
                    continue;
                case 194:
                    this.T = abb.e();
                    continue;
                case 200:
                    this.W = Long.valueOf(abb.h());
                    continue;
                case 208:
                    j = abb.j();
                    try {
                        g = abb.g();
                        if (g < 0 || g > 6) {
                            throw new IllegalArgumentException(g + " is not a valid enum DeviceIdType");
                        }
                        this.U = Integer.valueOf(g);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 218:
                    this.n = abb.e();
                    continue;
                case 224:
                    this.V = Boolean.valueOf(abb.d());
                    continue;
                case 234:
                    this.o = abb.e();
                    continue;
                case 242:
                    this.as = abb.e();
                    continue;
                case 248:
                    this.p = Long.valueOf(abb.h());
                    continue;
                case 256:
                    this.q = Long.valueOf(abb.h());
                    continue;
                case 264:
                    this.r = Long.valueOf(abb.h());
                    continue;
                case 274:
                    this.s = abb.e();
                    continue;
                case 280:
                    this.t = Long.valueOf(abb.h());
                    continue;
                case 288:
                    this.u = Long.valueOf(abb.h());
                    continue;
                case 296:
                    this.v = Long.valueOf(abb.h());
                    continue;
                case 306:
                    if (this.aj == null) {
                        this.aj = new zh();
                    }
                    abb.a(this.aj);
                    continue;
                case 312:
                    this.w = Long.valueOf(abb.h());
                    continue;
                case 320:
                    this.x = Long.valueOf(abb.h());
                    continue;
                case 328:
                    this.y = Long.valueOf(abb.h());
                    continue;
                case 336:
                    this.z = Long.valueOf(abb.h());
                    continue;
                case 346:
                    j = abm.a(abb, 346);
                    a = this.L == null ? 0 : this.L.length;
                    Object obj = new xq[(j + a)];
                    if (a != 0) {
                        System.arraycopy(this.L, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new xq();
                        abb.a(obj[a]);
                        abb.a();
                        a++;
                    }
                    obj[a] = new xq();
                    abb.a(obj[a]);
                    this.L = obj;
                    continue;
                case 352:
                    this.A = Long.valueOf(abb.h());
                    continue;
                case 360:
                    this.B = Long.valueOf(abb.h());
                    continue;
                case 370:
                    this.C = abb.e();
                    continue;
                case 378:
                    this.D = abb.e();
                    continue;
                case 384:
                    j = abb.j();
                    try {
                        this.E = Integer.valueOf(vq.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 392:
                    j = abb.j();
                    try {
                        this.F = Integer.valueOf(vq.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e3) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 402:
                    if (this.K == null) {
                        this.K = new xq();
                    }
                    abb.a(this.K);
                    continue;
                case 408:
                    this.G = Long.valueOf(abb.h());
                    continue;
                case 416:
                    this.H = Long.valueOf(abb.h());
                    continue;
                case 424:
                    this.I = Long.valueOf(abb.h());
                    continue;
                case 432:
                    this.ak = Long.valueOf(abb.h());
                    continue;
                case 440:
                    this.al = Long.valueOf(abb.h());
                    continue;
                case 448:
                    j = abb.j();
                    try {
                        this.J = Integer.valueOf(vq.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e4) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 458:
                    if (this.M == null) {
                        this.M = new yo();
                    }
                    abb.a(this.M);
                    continue;
                case 464:
                    this.am = Long.valueOf(abb.h());
                    continue;
                case 472:
                    this.N = Long.valueOf(abb.h());
                    continue;
                case 480:
                    this.O = Long.valueOf(abb.h());
                    continue;
                case 488:
                    this.P = Long.valueOf(abb.h());
                    continue;
                case 496:
                    this.Q = Long.valueOf(abb.h());
                    continue;
                case 504:
                    this.R = Long.valueOf(abb.h());
                    continue;
                case 512:
                    this.an = Long.valueOf(abb.h());
                    continue;
                case 520:
                    j = abb.j();
                    try {
                        this.ao = Integer.valueOf(vq.c(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e5) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 528:
                    j = abb.j();
                    try {
                        this.ap = Integer.valueOf(vq.b(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e6) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 538:
                    this.S = abb.e();
                    continue;
                case 544:
                    j = abb.j();
                    try {
                        g = abb.g();
                        if (g < 0 || g > 3) {
                            throw new IllegalArgumentException(g + " is not a valid enum DebuggerState");
                        }
                        this.aq = Integer.valueOf(g);
                        continue;
                    } catch (IllegalArgumentException e7) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 1610:
                    if (this.X == null) {
                        this.X = new abc();
                    }
                    abb.a(this.X);
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

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.b(1, this.a);
        }
        if (this.b != null) {
            a += abd.b(2, this.b);
        }
        if (this.c != null) {
            a += abd.d(3, this.c.longValue());
        }
        if (this.aa != null) {
            a += abd.d(4, this.aa.longValue());
        }
        if (this.d != null) {
            a += abd.d(5, this.d.longValue());
        }
        if (this.e != null) {
            a += abd.d(6, this.e.longValue());
        }
        if (this.ab != null) {
            a += abd.d(7, this.ab.longValue());
        }
        if (this.ac != null) {
            a += abd.d(8, this.ac.longValue());
        }
        if (this.ad != null) {
            a += abd.d(9, this.ad.longValue());
        }
        if (this.ae != null) {
            a += abd.d(10, this.ae.longValue());
        }
        if (this.af != null) {
            a += abd.d(11, this.af.longValue());
        }
        if (this.f != null) {
            a += abd.d(12, this.f.longValue());
        }
        if (this.ag != null) {
            a += abd.b(13, this.ag);
        }
        if (this.g != null) {
            a += abd.d(14, this.g.longValue());
        }
        if (this.h != null) {
            a += abd.d(15, this.h.longValue());
        }
        if (this.i != null) {
            a += abd.d(16, this.i.longValue());
        }
        if (this.j != null) {
            a += abd.d(17, this.j.longValue());
        }
        if (this.ah != null) {
            a += abd.d(18, this.ah.longValue());
        }
        if (this.ai != null) {
            a += abd.d(19, this.ai.longValue());
        }
        if (this.k != null) {
            a += abd.d(20, this.k.longValue());
        }
        if (this.ar != null) {
            a += abd.d(21, this.ar.longValue());
        }
        if (this.l != null) {
            a += abd.d(22, this.l.longValue());
        }
        if (this.m != null) {
            a += abd.d(23, this.m.longValue());
        }
        if (this.T != null) {
            a += abd.b(24, this.T);
        }
        if (this.W != null) {
            a += abd.d(25, this.W.longValue());
        }
        if (this.U != null) {
            a += abd.b(26, this.U.intValue());
        }
        if (this.n != null) {
            a += abd.b(27, this.n);
        }
        if (this.V != null) {
            this.V.booleanValue();
            a += abd.b(28) + 1;
        }
        if (this.o != null) {
            a += abd.b(29, this.o);
        }
        if (this.as != null) {
            a += abd.b(30, this.as);
        }
        if (this.p != null) {
            a += abd.d(31, this.p.longValue());
        }
        if (this.q != null) {
            a += abd.d(32, this.q.longValue());
        }
        if (this.r != null) {
            a += abd.d(33, this.r.longValue());
        }
        if (this.s != null) {
            a += abd.b(34, this.s);
        }
        if (this.t != null) {
            a += abd.d(35, this.t.longValue());
        }
        if (this.u != null) {
            a += abd.d(36, this.u.longValue());
        }
        if (this.v != null) {
            a += abd.d(37, this.v.longValue());
        }
        if (this.aj != null) {
            a += abd.b(38, this.aj);
        }
        if (this.w != null) {
            a += abd.d(39, this.w.longValue());
        }
        if (this.x != null) {
            a += abd.d(40, this.x.longValue());
        }
        if (this.y != null) {
            a += abd.d(41, this.y.longValue());
        }
        if (this.z != null) {
            a += abd.d(42, this.z.longValue());
        }
        if (this.L != null && this.L.length > 0) {
            int i = a;
            for (abj abj : this.L) {
                if (abj != null) {
                    i += abd.b(43, abj);
                }
            }
            a = i;
        }
        if (this.A != null) {
            a += abd.d(44, this.A.longValue());
        }
        if (this.B != null) {
            a += abd.d(45, this.B.longValue());
        }
        if (this.C != null) {
            a += abd.b(46, this.C);
        }
        if (this.D != null) {
            a += abd.b(47, this.D);
        }
        if (this.E != null) {
            a += abd.b(48, this.E.intValue());
        }
        if (this.F != null) {
            a += abd.b(49, this.F.intValue());
        }
        if (this.K != null) {
            a += abd.b(50, this.K);
        }
        if (this.G != null) {
            a += abd.d(51, this.G.longValue());
        }
        if (this.H != null) {
            a += abd.d(52, this.H.longValue());
        }
        if (this.I != null) {
            a += abd.d(53, this.I.longValue());
        }
        if (this.ak != null) {
            a += abd.d(54, this.ak.longValue());
        }
        if (this.al != null) {
            a += abd.d(55, this.al.longValue());
        }
        if (this.J != null) {
            a += abd.b(56, this.J.intValue());
        }
        if (this.M != null) {
            a += abd.b(57, this.M);
        }
        if (this.am != null) {
            a += abd.d(58, this.am.longValue());
        }
        if (this.N != null) {
            a += abd.d(59, this.N.longValue());
        }
        if (this.O != null) {
            a += abd.d(60, this.O.longValue());
        }
        if (this.P != null) {
            a += abd.d(61, this.P.longValue());
        }
        if (this.Q != null) {
            a += abd.d(62, this.Q.longValue());
        }
        if (this.R != null) {
            a += abd.d(63, this.R.longValue());
        }
        if (this.an != null) {
            a += abd.d(64, this.an.longValue());
        }
        if (this.ao != null) {
            a += abd.b(65, this.ao.intValue());
        }
        if (this.ap != null) {
            a += abd.b(66, this.ap.intValue());
        }
        if (this.S != null) {
            a += abd.b(67, this.S);
        }
        if (this.aq != null) {
            a += abd.b(68, this.aq.intValue());
        }
        return this.X != null ? a + abd.b(201, this.X) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
        }
        if (this.b != null) {
            abd.a(2, this.b);
        }
        if (this.c != null) {
            abd.b(3, this.c.longValue());
        }
        if (this.aa != null) {
            abd.b(4, this.aa.longValue());
        }
        if (this.d != null) {
            abd.b(5, this.d.longValue());
        }
        if (this.e != null) {
            abd.b(6, this.e.longValue());
        }
        if (this.ab != null) {
            abd.b(7, this.ab.longValue());
        }
        if (this.ac != null) {
            abd.b(8, this.ac.longValue());
        }
        if (this.ad != null) {
            abd.b(9, this.ad.longValue());
        }
        if (this.ae != null) {
            abd.b(10, this.ae.longValue());
        }
        if (this.af != null) {
            abd.b(11, this.af.longValue());
        }
        if (this.f != null) {
            abd.b(12, this.f.longValue());
        }
        if (this.ag != null) {
            abd.a(13, this.ag);
        }
        if (this.g != null) {
            abd.b(14, this.g.longValue());
        }
        if (this.h != null) {
            abd.b(15, this.h.longValue());
        }
        if (this.i != null) {
            abd.b(16, this.i.longValue());
        }
        if (this.j != null) {
            abd.b(17, this.j.longValue());
        }
        if (this.ah != null) {
            abd.b(18, this.ah.longValue());
        }
        if (this.ai != null) {
            abd.b(19, this.ai.longValue());
        }
        if (this.k != null) {
            abd.b(20, this.k.longValue());
        }
        if (this.ar != null) {
            abd.b(21, this.ar.longValue());
        }
        if (this.l != null) {
            abd.b(22, this.l.longValue());
        }
        if (this.m != null) {
            abd.b(23, this.m.longValue());
        }
        if (this.T != null) {
            abd.a(24, this.T);
        }
        if (this.W != null) {
            abd.b(25, this.W.longValue());
        }
        if (this.U != null) {
            abd.a(26, this.U.intValue());
        }
        if (this.n != null) {
            abd.a(27, this.n);
        }
        if (this.V != null) {
            abd.a(28, this.V.booleanValue());
        }
        if (this.o != null) {
            abd.a(29, this.o);
        }
        if (this.as != null) {
            abd.a(30, this.as);
        }
        if (this.p != null) {
            abd.b(31, this.p.longValue());
        }
        if (this.q != null) {
            abd.b(32, this.q.longValue());
        }
        if (this.r != null) {
            abd.b(33, this.r.longValue());
        }
        if (this.s != null) {
            abd.a(34, this.s);
        }
        if (this.t != null) {
            abd.b(35, this.t.longValue());
        }
        if (this.u != null) {
            abd.b(36, this.u.longValue());
        }
        if (this.v != null) {
            abd.b(37, this.v.longValue());
        }
        if (this.aj != null) {
            abd.a(38, this.aj);
        }
        if (this.w != null) {
            abd.b(39, this.w.longValue());
        }
        if (this.x != null) {
            abd.b(40, this.x.longValue());
        }
        if (this.y != null) {
            abd.b(41, this.y.longValue());
        }
        if (this.z != null) {
            abd.b(42, this.z.longValue());
        }
        if (this.L != null && this.L.length > 0) {
            for (abj abj : this.L) {
                if (abj != null) {
                    abd.a(43, abj);
                }
            }
        }
        if (this.A != null) {
            abd.b(44, this.A.longValue());
        }
        if (this.B != null) {
            abd.b(45, this.B.longValue());
        }
        if (this.C != null) {
            abd.a(46, this.C);
        }
        if (this.D != null) {
            abd.a(47, this.D);
        }
        if (this.E != null) {
            abd.a(48, this.E.intValue());
        }
        if (this.F != null) {
            abd.a(49, this.F.intValue());
        }
        if (this.K != null) {
            abd.a(50, this.K);
        }
        if (this.G != null) {
            abd.b(51, this.G.longValue());
        }
        if (this.H != null) {
            abd.b(52, this.H.longValue());
        }
        if (this.I != null) {
            abd.b(53, this.I.longValue());
        }
        if (this.ak != null) {
            abd.b(54, this.ak.longValue());
        }
        if (this.al != null) {
            abd.b(55, this.al.longValue());
        }
        if (this.J != null) {
            abd.a(56, this.J.intValue());
        }
        if (this.M != null) {
            abd.a(57, this.M);
        }
        if (this.am != null) {
            abd.b(58, this.am.longValue());
        }
        if (this.N != null) {
            abd.b(59, this.N.longValue());
        }
        if (this.O != null) {
            abd.b(60, this.O.longValue());
        }
        if (this.P != null) {
            abd.b(61, this.P.longValue());
        }
        if (this.Q != null) {
            abd.b(62, this.Q.longValue());
        }
        if (this.R != null) {
            abd.b(63, this.R.longValue());
        }
        if (this.an != null) {
            abd.b(64, this.an.longValue());
        }
        if (this.ao != null) {
            abd.a(65, this.ao.intValue());
        }
        if (this.ap != null) {
            abd.a(66, this.ap.intValue());
        }
        if (this.S != null) {
            abd.a(67, this.S);
        }
        if (this.aq != null) {
            abd.a(68, this.aq.intValue());
        }
        if (this.X != null) {
            abd.a(201, this.X);
        }
        super.a(abd);
    }
}
