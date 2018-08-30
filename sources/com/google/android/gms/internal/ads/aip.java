package com.google.android.gms.internal.ads;

public final class aip extends abe<aip> {
    private Integer a;
    private int[] b;

    public aip() {
        this.a = null;
        this.b = abm.a;
        this.Y = null;
        this.Z = -1;
    }

    private final aip b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    j = abb.j();
                    try {
                        this.a = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 16:
                    j = abm.a(abb, 16);
                    a = this.b == null ? 0 : this.b.length;
                    Object obj = new int[(j + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.g();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.g();
                    this.b = obj;
                    continue;
                case 18:
                    int c = abb.c(abb.g());
                    j = abb.j();
                    a = 0;
                    while (abb.i() > 0) {
                        abb.g();
                        a++;
                    }
                    abb.e(j);
                    j = this.b == null ? 0 : this.b.length;
                    Object obj2 = new int[(a + j)];
                    if (j != 0) {
                        System.arraycopy(this.b, 0, obj2, 0, j);
                    }
                    while (j < obj2.length) {
                        obj2[j] = abb.g();
                        j++;
                    }
                    this.b = obj2;
                    abb.d(c);
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
            a += abd.b(1, this.a.intValue());
        }
        if (this.b == null || this.b.length <= 0) {
            return a;
        }
        int i2 = 0;
        while (i < this.b.length) {
            i2 += abd.a(this.b[i]);
            i++;
        }
        return (a + i2) + (this.b.length * 1);
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null && this.b.length > 0) {
            for (int a : this.b) {
                abd.a(2, a);
            }
        }
        super.a(abd);
    }
}
