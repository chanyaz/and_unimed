package com.google.android.gms.internal.ads;

public final class abn extends abe<abn> {
    public Integer a;
    public String b;
    public String c;
    public abo d;
    public abv[] e;
    public String f;
    public abu g;
    public abw h;
    public String[] i;
    public String[] j;
    private Integer k;
    private String l;
    private Boolean m;
    private String[] n;
    private String o;
    private Boolean p;
    private Boolean q;
    private byte[] r;

    public abn() {
        this.a = null;
        this.k = null;
        this.b = null;
        this.c = null;
        this.l = null;
        this.d = null;
        this.e = abv.b();
        this.f = null;
        this.g = null;
        this.m = null;
        this.n = abm.c;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.h = null;
        this.i = abm.c;
        this.j = abm.c;
        this.Y = null;
        this.Z = -1;
    }

    private final abn b(abb abb) {
        while (true) {
            int a = abb.a();
            int a2;
            Object obj;
            int c;
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.b = abb.e();
                    continue;
                case 18:
                    this.c = abb.e();
                    continue;
                case 26:
                    this.l = abb.e();
                    continue;
                case 34:
                    a2 = abm.a(abb, 34);
                    a = this.e == null ? 0 : this.e.length;
                    obj = new abv[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new abv();
                        abb.a(obj[a]);
                        abb.a();
                        a++;
                    }
                    obj[a] = new abv();
                    abb.a(obj[a]);
                    this.e = obj;
                    continue;
                case 40:
                    this.m = Boolean.valueOf(abb.d());
                    continue;
                case 50:
                    a2 = abm.a(abb, 50);
                    a = this.n == null ? 0 : this.n.length;
                    obj = new String[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.n, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.e();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.e();
                    this.n = obj;
                    continue;
                case 58:
                    this.o = abb.e();
                    continue;
                case 64:
                    this.p = Boolean.valueOf(abb.d());
                    continue;
                case 72:
                    this.q = Boolean.valueOf(abb.d());
                    continue;
                case 80:
                    a2 = abb.j();
                    try {
                        c = abb.c();
                        if (c < 0 || c > 9) {
                            throw new IllegalArgumentException(c + " is not a valid enum ReportType");
                        }
                        this.a = Integer.valueOf(c);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(a2);
                        a(abb, a);
                        break;
                    }
                case 88:
                    a2 = abb.j();
                    try {
                        c = abb.c();
                        if (c < 0 || c > 4) {
                            throw new IllegalArgumentException(c + " is not a valid enum Verdict");
                        }
                        this.k = Integer.valueOf(c);
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(a2);
                        a(abb, a);
                        break;
                    }
                case 98:
                    if (this.d == null) {
                        this.d = new abo();
                    }
                    abb.a(this.d);
                    continue;
                case 106:
                    this.f = abb.e();
                    continue;
                case 114:
                    if (this.g == null) {
                        this.g = new abu();
                    }
                    abb.a(this.g);
                    continue;
                case 122:
                    this.r = abb.f();
                    continue;
                case 138:
                    if (this.h == null) {
                        this.h = new abw();
                    }
                    abb.a(this.h);
                    continue;
                case 162:
                    a2 = abm.a(abb, 162);
                    a = this.i == null ? 0 : this.i.length;
                    obj = new String[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.i, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.e();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.e();
                    this.i = obj;
                    continue;
                case 170:
                    a2 = abm.a(abb, 170);
                    a = this.j == null ? 0 : this.j.length;
                    obj = new String[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.j, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.e();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.e();
                    this.j = obj;
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
        int i;
        int i2;
        int i3;
        int i4 = 0;
        int a = super.a();
        if (this.b != null) {
            a += abd.b(1, this.b);
        }
        if (this.c != null) {
            a += abd.b(2, this.c);
        }
        if (this.l != null) {
            a += abd.b(3, this.l);
        }
        if (this.e != null && this.e.length > 0) {
            i = a;
            for (abj abj : this.e) {
                if (abj != null) {
                    i += abd.b(4, abj);
                }
            }
            a = i;
        }
        if (this.m != null) {
            this.m.booleanValue();
            a += abd.b(5) + 1;
        }
        if (this.n != null && this.n.length > 0) {
            i2 = 0;
            i3 = 0;
            for (String str : this.n) {
                if (str != null) {
                    i3++;
                    i2 += abd.a(str);
                }
            }
            a = (a + i2) + (i3 * 1);
        }
        if (this.o != null) {
            a += abd.b(7, this.o);
        }
        if (this.p != null) {
            this.p.booleanValue();
            a += abd.b(8) + 1;
        }
        if (this.q != null) {
            this.q.booleanValue();
            a += abd.b(9) + 1;
        }
        if (this.a != null) {
            a += abd.b(10, this.a.intValue());
        }
        if (this.k != null) {
            a += abd.b(11, this.k.intValue());
        }
        if (this.d != null) {
            a += abd.b(12, this.d);
        }
        if (this.f != null) {
            a += abd.b(13, this.f);
        }
        if (this.g != null) {
            a += abd.b(14, this.g);
        }
        if (this.r != null) {
            a += abd.b(15, this.r);
        }
        if (this.h != null) {
            a += abd.b(17, this.h);
        }
        if (this.i != null && this.i.length > 0) {
            i2 = 0;
            i3 = 0;
            for (String str2 : this.i) {
                if (str2 != null) {
                    i3++;
                    i2 += abd.a(str2);
                }
            }
            a = (a + i2) + (i3 * 2);
        }
        if (this.j == null || this.j.length <= 0) {
            return a;
        }
        i = 0;
        i2 = 0;
        while (i4 < this.j.length) {
            String str3 = this.j[i4];
            if (str3 != null) {
                i2++;
                i += abd.a(str3);
            }
            i4++;
        }
        return (a + i) + (i2 * 2);
    }

    public final void a(abd abd) {
        int i = 0;
        if (this.b != null) {
            abd.a(1, this.b);
        }
        if (this.c != null) {
            abd.a(2, this.c);
        }
        if (this.l != null) {
            abd.a(3, this.l);
        }
        if (this.e != null && this.e.length > 0) {
            for (abj abj : this.e) {
                if (abj != null) {
                    abd.a(4, abj);
                }
            }
        }
        if (this.m != null) {
            abd.a(5, this.m.booleanValue());
        }
        if (this.n != null && this.n.length > 0) {
            for (String str : this.n) {
                if (str != null) {
                    abd.a(6, str);
                }
            }
        }
        if (this.o != null) {
            abd.a(7, this.o);
        }
        if (this.p != null) {
            abd.a(8, this.p.booleanValue());
        }
        if (this.q != null) {
            abd.a(9, this.q.booleanValue());
        }
        if (this.a != null) {
            abd.a(10, this.a.intValue());
        }
        if (this.k != null) {
            abd.a(11, this.k.intValue());
        }
        if (this.d != null) {
            abd.a(12, this.d);
        }
        if (this.f != null) {
            abd.a(13, this.f);
        }
        if (this.g != null) {
            abd.a(14, this.g);
        }
        if (this.r != null) {
            abd.a(15, this.r);
        }
        if (this.h != null) {
            abd.a(17, this.h);
        }
        if (this.i != null && this.i.length > 0) {
            for (String str2 : this.i) {
                if (str2 != null) {
                    abd.a(20, str2);
                }
            }
        }
        if (this.j != null && this.j.length > 0) {
            while (i < this.j.length) {
                String str3 = this.j[i];
                if (str3 != null) {
                    abd.a(21, str3);
                }
                i++;
            }
        }
        super.a(abd);
    }
}
