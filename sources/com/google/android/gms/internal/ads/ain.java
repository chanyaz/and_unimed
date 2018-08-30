package com.google.android.gms.internal.ads;

public final class ain extends abe<ain> {
    public String a;
    public long[] b;
    public ail c;
    public aig d;
    private Integer e;
    private Integer f;
    private Integer g;
    private aiy h;
    private aim i;
    private air j;

    public ain() {
        this.e = null;
        this.a = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.b = abm.b;
        this.c = null;
        this.i = null;
        this.j = null;
        this.d = null;
        this.Y = null;
        this.Z = -1;
    }

    private final ain b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 72:
                    this.e = Integer.valueOf(abb.g());
                    continue;
                case 82:
                    this.a = abb.e();
                    continue;
                case 88:
                    this.f = Integer.valueOf(abb.g());
                    continue;
                case 96:
                    j = abb.j();
                    try {
                        this.g = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 106:
                    if (this.h == null) {
                        this.h = new aiy();
                    }
                    abb.a(this.h);
                    continue;
                case 112:
                    j = abm.a(abb, 112);
                    a = this.b == null ? 0 : this.b.length;
                    Object obj = new long[(j + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.h();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.h();
                    this.b = obj;
                    continue;
                case 114:
                    int c = abb.c(abb.g());
                    j = abb.j();
                    a = 0;
                    while (abb.i() > 0) {
                        abb.h();
                        a++;
                    }
                    abb.e(j);
                    j = this.b == null ? 0 : this.b.length;
                    Object obj2 = new long[(a + j)];
                    if (j != 0) {
                        System.arraycopy(this.b, 0, obj2, 0, j);
                    }
                    while (j < obj2.length) {
                        obj2[j] = abb.h();
                        j++;
                    }
                    this.b = obj2;
                    abb.d(c);
                    continue;
                case 122:
                    if (this.c == null) {
                        this.c = new ail();
                    }
                    abb.a(this.c);
                    continue;
                case 130:
                    if (this.i == null) {
                        this.i = new aim();
                    }
                    abb.a(this.i);
                    continue;
                case 138:
                    if (this.j == null) {
                        this.j = new air();
                    }
                    abb.a(this.j);
                    continue;
                case 146:
                    if (this.d == null) {
                        this.d = new aig();
                    }
                    abb.a(this.d);
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
        if (this.e != null) {
            a += abd.b(9, this.e.intValue());
        }
        if (this.a != null) {
            a += abd.b(10, this.a);
        }
        if (this.f != null) {
            a += abd.d(this.f.intValue()) + abd.b(11);
        }
        if (this.g != null) {
            a += abd.b(12, this.g.intValue());
        }
        if (this.h != null) {
            a += abd.b(13, this.h);
        }
        if (this.b != null && this.b.length > 0) {
            int i2 = 0;
            while (i < this.b.length) {
                i2 += abd.a(this.b[i]);
                i++;
            }
            a = (a + i2) + (this.b.length * 1);
        }
        if (this.c != null) {
            a += abd.b(15, this.c);
        }
        if (this.i != null) {
            a += abd.b(16, this.i);
        }
        if (this.j != null) {
            a += abd.b(17, this.j);
        }
        return this.d != null ? a + abd.b(18, this.d) : a;
    }

    public final void a(abd abd) {
        int i = 0;
        if (this.e != null) {
            abd.a(9, this.e.intValue());
        }
        if (this.a != null) {
            abd.a(10, this.a);
        }
        if (this.f != null) {
            int intValue = this.f.intValue();
            abd.c(11, 0);
            abd.c(intValue);
        }
        if (this.g != null) {
            abd.a(12, this.g.intValue());
        }
        if (this.h != null) {
            abd.a(13, this.h);
        }
        if (this.b != null && this.b.length > 0) {
            while (i < this.b.length) {
                abd.a(14, this.b[i]);
                i++;
            }
        }
        if (this.c != null) {
            abd.a(15, this.c);
        }
        if (this.i != null) {
            abd.a(16, this.i);
        }
        if (this.j != null) {
            abd.a(17, this.j);
        }
        if (this.d != null) {
            abd.a(18, this.d);
        }
        super.a(abd);
    }
}
