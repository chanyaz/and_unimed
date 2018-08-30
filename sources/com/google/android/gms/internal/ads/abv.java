package com.google.android.gms.internal.ads;

public final class abv extends abe<abv> {
    private static volatile abv[] f;
    public Integer a;
    public String b;
    public abq c;
    public Integer d;
    public String[] e;
    private abs g;
    private Integer h;
    private int[] i;
    private String j;

    public abv() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.g = null;
        this.h = null;
        this.i = abm.a;
        this.j = null;
        this.d = null;
        this.e = abm.c;
        this.Y = null;
        this.Z = -1;
    }

    private final abv b(abb abb) {
        while (true) {
            int a = abb.a();
            int a2;
            Object obj;
            int c;
            switch (a) {
                case 0:
                    break;
                case 8:
                    this.a = Integer.valueOf(abb.c());
                    continue;
                case 18:
                    this.b = abb.e();
                    continue;
                case 26:
                    if (this.c == null) {
                        this.c = new abq();
                    }
                    abb.a(this.c);
                    continue;
                case 34:
                    if (this.g == null) {
                        this.g = new abs();
                    }
                    abb.a(this.g);
                    continue;
                case 40:
                    this.h = Integer.valueOf(abb.c());
                    continue;
                case 48:
                    a2 = abm.a(abb, 48);
                    a = this.i == null ? 0 : this.i.length;
                    obj = new int[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.i, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.c();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.c();
                    this.i = obj;
                    continue;
                case 50:
                    c = abb.c(abb.g());
                    a2 = abb.j();
                    a = 0;
                    while (abb.i() > 0) {
                        abb.c();
                        a++;
                    }
                    abb.e(a2);
                    a2 = this.i == null ? 0 : this.i.length;
                    Object obj2 = new int[(a + a2)];
                    if (a2 != 0) {
                        System.arraycopy(this.i, 0, obj2, 0, a2);
                    }
                    while (a2 < obj2.length) {
                        obj2[a2] = abb.c();
                        a2++;
                    }
                    this.i = obj2;
                    abb.d(c);
                    continue;
                case 58:
                    this.j = abb.e();
                    continue;
                case 64:
                    a2 = abb.j();
                    try {
                        c = abb.c();
                        if (c < 0 || c > 3) {
                            throw new IllegalArgumentException(c + " is not a valid enum AdResourceType");
                        }
                        this.d = Integer.valueOf(c);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(a2);
                        a(abb, a);
                        break;
                    }
                case 74:
                    a2 = abm.a(abb, 74);
                    a = this.e == null ? 0 : this.e.length;
                    obj = new String[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.e, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.e();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.e();
                    this.e = obj;
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

    public static abv[] b() {
        if (f == null) {
            synchronized (abi.b) {
                if (f == null) {
                    f = new abv[0];
                }
            }
        }
        return f;
    }

    protected final int a() {
        int i;
        int i2;
        int i3 = 0;
        int a = super.a() + abd.b(1, this.a.intValue());
        if (this.b != null) {
            a += abd.b(2, this.b);
        }
        if (this.c != null) {
            a += abd.b(3, this.c);
        }
        if (this.g != null) {
            a += abd.b(4, this.g);
        }
        if (this.h != null) {
            a += abd.b(5, this.h.intValue());
        }
        if (this.i != null && this.i.length > 0) {
            i = 0;
            for (int a2 : this.i) {
                i += abd.a(a2);
            }
            a = (a + i) + (this.i.length * 1);
        }
        if (this.j != null) {
            a += abd.b(7, this.j);
        }
        if (this.d != null) {
            a += abd.b(8, this.d.intValue());
        }
        if (this.e == null || this.e.length <= 0) {
            return a;
        }
        i2 = 0;
        i = 0;
        while (i3 < this.e.length) {
            String str = this.e[i3];
            if (str != null) {
                i++;
                i2 += abd.a(str);
            }
            i3++;
        }
        return (a + i2) + (i * 1);
    }

    public final void a(abd abd) {
        int i = 0;
        abd.a(1, this.a.intValue());
        if (this.b != null) {
            abd.a(2, this.b);
        }
        if (this.c != null) {
            abd.a(3, this.c);
        }
        if (this.g != null) {
            abd.a(4, this.g);
        }
        if (this.h != null) {
            abd.a(5, this.h.intValue());
        }
        if (this.i != null && this.i.length > 0) {
            for (int a : this.i) {
                abd.a(6, a);
            }
        }
        if (this.j != null) {
            abd.a(7, this.j);
        }
        if (this.d != null) {
            abd.a(8, this.d.intValue());
        }
        if (this.e != null && this.e.length > 0) {
            while (i < this.e.length) {
                String str = this.e[i];
                if (str != null) {
                    abd.a(9, str);
                }
                i++;
            }
        }
        super.a(abd);
    }
}
