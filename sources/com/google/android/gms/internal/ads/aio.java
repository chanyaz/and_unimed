package com.google.android.gms.internal.ads;

public final class aio extends abe<aio> {
    private String a;
    private Integer b;
    private int[] c;
    private aix d;

    public aio() {
        this.a = null;
        this.b = null;
        this.c = abm.a;
        this.d = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aio b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.a = abb.e();
                    continue;
                case 16:
                    j = abb.j();
                    try {
                        this.b = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 24:
                    j = abm.a(abb, 24);
                    a = this.c == null ? 0 : this.c.length;
                    Object obj = new int[(j + a)];
                    if (a != 0) {
                        System.arraycopy(this.c, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.g();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.g();
                    this.c = obj;
                    continue;
                case 26:
                    int c = abb.c(abb.g());
                    j = abb.j();
                    a = 0;
                    while (abb.i() > 0) {
                        abb.g();
                        a++;
                    }
                    abb.e(j);
                    j = this.c == null ? 0 : this.c.length;
                    Object obj2 = new int[(a + j)];
                    if (j != 0) {
                        System.arraycopy(this.c, 0, obj2, 0, j);
                    }
                    while (j < obj2.length) {
                        obj2[j] = abb.g();
                        j++;
                    }
                    this.c = obj2;
                    abb.d(c);
                    continue;
                case 34:
                    if (this.d == null) {
                        this.d = new aix();
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
        if (this.a != null) {
            a += abd.b(1, this.a);
        }
        if (this.b != null) {
            a += abd.b(2, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            int i2 = 0;
            while (i < this.c.length) {
                i2 += abd.a(this.c[i]);
                i++;
            }
            a = (a + i2) + (this.c.length * 1);
        }
        return this.d != null ? a + abd.b(4, this.d) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
        }
        if (this.b != null) {
            abd.a(2, this.b.intValue());
        }
        if (this.c != null && this.c.length > 0) {
            for (int a : this.c) {
                abd.a(3, a);
            }
        }
        if (this.d != null) {
            abd.a(4, this.d);
        }
        super.a(abd);
    }
}
