package com.google.android.gms.internal.ads;

public final class ait extends abe<ait> {
    private Integer a;
    private Integer b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Integer h;
    private Integer i;
    private Integer j;
    private aiu k;

    public ait() {
        this.a = null;
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
        this.Y = null;
        this.Z = -1;
    }

    private final ait b(abb abb) {
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
                    j = abb.j();
                    try {
                        this.b = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 24:
                    this.c = Integer.valueOf(abb.g());
                    continue;
                case 32:
                    this.d = Integer.valueOf(abb.g());
                    continue;
                case 40:
                    this.e = Integer.valueOf(abb.g());
                    continue;
                case 48:
                    this.f = Integer.valueOf(abb.g());
                    continue;
                case 56:
                    this.g = Integer.valueOf(abb.g());
                    continue;
                case 64:
                    this.h = Integer.valueOf(abb.g());
                    continue;
                case 72:
                    this.i = Integer.valueOf(abb.g());
                    continue;
                case 80:
                    this.j = Integer.valueOf(abb.g());
                    continue;
                case 90:
                    if (this.k == null) {
                        this.k = new aiu();
                    }
                    abb.a(this.k);
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
            a += abd.b(1, this.a.intValue());
        }
        if (this.b != null) {
            a += abd.b(2, this.b.intValue());
        }
        if (this.c != null) {
            a += abd.b(3, this.c.intValue());
        }
        if (this.d != null) {
            a += abd.b(4, this.d.intValue());
        }
        if (this.e != null) {
            a += abd.b(5, this.e.intValue());
        }
        if (this.f != null) {
            a += abd.b(6, this.f.intValue());
        }
        if (this.g != null) {
            a += abd.b(7, this.g.intValue());
        }
        if (this.h != null) {
            a += abd.b(8, this.h.intValue());
        }
        if (this.i != null) {
            a += abd.b(9, this.i.intValue());
        }
        if (this.j != null) {
            a += abd.b(10, this.j.intValue());
        }
        return this.k != null ? a + abd.b(11, this.k) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(2, this.b.intValue());
        }
        if (this.c != null) {
            abd.a(3, this.c.intValue());
        }
        if (this.d != null) {
            abd.a(4, this.d.intValue());
        }
        if (this.e != null) {
            abd.a(5, this.e.intValue());
        }
        if (this.f != null) {
            abd.a(6, this.f.intValue());
        }
        if (this.g != null) {
            abd.a(7, this.g.intValue());
        }
        if (this.h != null) {
            abd.a(8, this.h.intValue());
        }
        if (this.i != null) {
            abd.a(9, this.i.intValue());
        }
        if (this.j != null) {
            abd.a(10, this.j.intValue());
        }
        if (this.k != null) {
            abd.a(11, this.k);
        }
        super.a(abd);
    }
}
