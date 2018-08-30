package com.google.android.gms.internal.ads;

public final class ajg extends abe<ajg> {
    private Integer a;
    private ajb b;
    private Integer c;
    private Integer d;
    private Integer e;
    private Long f;

    public ajg() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.Y = null;
        this.Z = -1;
    }

    private final ajg b(abb abb) {
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    int j = abb.j();
                    try {
                        this.a = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 18:
                    if (this.b == null) {
                        this.b = new ajb();
                    }
                    abb.a(this.b);
                    continue;
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
                    this.f = Long.valueOf(abb.h());
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
            a += abd.b(2, this.b);
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
        return this.f != null ? a + abd.c(6, this.f.longValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(2, this.b);
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
            abd.a(6, this.f.longValue());
        }
        super.a(abd);
    }
}
