package com.google.android.gms.internal.ads;

public final class aig extends abe<aig> {
    public Integer a;
    public aij b;
    private Integer c;
    private aii d;
    private aih[] e;
    private aik f;
    private ait g;
    private ais h;
    private aip i;
    private aiq j;
    private aiz[] k;

    public aig() {
        this.a = null;
        this.c = null;
        this.d = null;
        this.b = null;
        this.e = aih.b();
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = aiz.b();
        this.Y = null;
        this.Z = -1;
    }

    private final aig b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            Object obj;
            switch (a) {
                case 0:
                    break;
                case 56:
                    j = abb.j();
                    try {
                        int g = abb.g();
                        if (g < 0 || g > 9) {
                            throw new IllegalArgumentException(g + " is not a valid enum AdInitiater");
                        }
                        this.a = Integer.valueOf(g);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 64:
                    j = abb.j();
                    try {
                        this.c = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 74:
                    if (this.d == null) {
                        this.d = new aii();
                    }
                    abb.a(this.d);
                    continue;
                case 82:
                    if (this.b == null) {
                        this.b = new aij();
                    }
                    abb.a(this.b);
                    continue;
                case 90:
                    j = abm.a(abb, 90);
                    a = this.e == null ? 0 : this.e.length;
                    obj = new aih[(j + a)];
                    if (a != 0) {
                        System.arraycopy(this.e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aih();
                        abb.a(obj[a]);
                        abb.a();
                        a++;
                    }
                    obj[a] = new aih();
                    abb.a(obj[a]);
                    this.e = obj;
                    continue;
                case 98:
                    if (this.f == null) {
                        this.f = new aik();
                    }
                    abb.a(this.f);
                    continue;
                case 106:
                    if (this.g == null) {
                        this.g = new ait();
                    }
                    abb.a(this.g);
                    continue;
                case 114:
                    if (this.h == null) {
                        this.h = new ais();
                    }
                    abb.a(this.h);
                    continue;
                case 122:
                    if (this.i == null) {
                        this.i = new aip();
                    }
                    abb.a(this.i);
                    continue;
                case 130:
                    if (this.j == null) {
                        this.j = new aiq();
                    }
                    abb.a(this.j);
                    continue;
                case 138:
                    j = abm.a(abb, 138);
                    a = this.k == null ? 0 : this.k.length;
                    obj = new aiz[(j + a)];
                    if (a != 0) {
                        System.arraycopy(this.k, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aiz();
                        abb.a(obj[a]);
                        abb.a();
                        a++;
                    }
                    obj[a] = new aiz();
                    abb.a(obj[a]);
                    this.k = obj;
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
        int i = 0;
        int a = super.a();
        if (this.a != null) {
            a += abd.b(7, this.a.intValue());
        }
        if (this.c != null) {
            a += abd.b(8, this.c.intValue());
        }
        if (this.d != null) {
            a += abd.b(9, this.d);
        }
        if (this.b != null) {
            a += abd.b(10, this.b);
        }
        if (this.e != null && this.e.length > 0) {
            int i2 = a;
            for (abj abj : this.e) {
                if (abj != null) {
                    i2 += abd.b(11, abj);
                }
            }
            a = i2;
        }
        if (this.f != null) {
            a += abd.b(12, this.f);
        }
        if (this.g != null) {
            a += abd.b(13, this.g);
        }
        if (this.h != null) {
            a += abd.b(14, this.h);
        }
        if (this.i != null) {
            a += abd.b(15, this.i);
        }
        if (this.j != null) {
            a += abd.b(16, this.j);
        }
        if (this.k != null && this.k.length > 0) {
            while (i < this.k.length) {
                abj abj2 = this.k[i];
                if (abj2 != null) {
                    a += abd.b(17, abj2);
                }
                i++;
            }
        }
        return a;
    }

    public final void a(abd abd) {
        int i = 0;
        if (this.a != null) {
            abd.a(7, this.a.intValue());
        }
        if (this.c != null) {
            abd.a(8, this.c.intValue());
        }
        if (this.d != null) {
            abd.a(9, this.d);
        }
        if (this.b != null) {
            abd.a(10, this.b);
        }
        if (this.e != null && this.e.length > 0) {
            for (abj abj : this.e) {
                if (abj != null) {
                    abd.a(11, abj);
                }
            }
        }
        if (this.f != null) {
            abd.a(12, this.f);
        }
        if (this.g != null) {
            abd.a(13, this.g);
        }
        if (this.h != null) {
            abd.a(14, this.h);
        }
        if (this.i != null) {
            abd.a(15, this.i);
        }
        if (this.j != null) {
            abd.a(16, this.j);
        }
        if (this.k != null && this.k.length > 0) {
            while (i < this.k.length) {
                abj abj2 = this.k[i];
                if (abj2 != null) {
                    abd.a(17, abj2);
                }
                i++;
            }
        }
        super.a(abd);
    }
}
