package com.google.android.gms.internal.ads;

public final class ail extends abe<ail> {
    public String a;
    public aiy b;
    private aix c;
    private Integer d;
    private Integer e;
    private Integer f;
    private Integer g;
    private Integer h;

    public ail() {
        this.a = null;
        this.c = null;
        this.d = null;
        this.b = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.Y = null;
        this.Z = -1;
    }

    private final ail b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.a = abb.e();
                    continue;
                case 18:
                    if (this.c == null) {
                        this.c = new aix();
                    }
                    abb.a(this.c);
                    continue;
                case 24:
                    this.d = Integer.valueOf(abb.g());
                    continue;
                case 34:
                    if (this.b == null) {
                        this.b = new aiy();
                    }
                    abb.a(this.b);
                    continue;
                case 40:
                    this.e = Integer.valueOf(abb.g());
                    continue;
                case 48:
                    j = abb.j();
                    try {
                        this.f = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 56:
                    j = abb.j();
                    try {
                        this.g = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 64:
                    j = abb.j();
                    try {
                        this.h = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e3) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
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
        if (this.c != null) {
            a += abd.b(2, this.c);
        }
        if (this.d != null) {
            a += abd.b(3, this.d.intValue());
        }
        if (this.b != null) {
            a += abd.b(4, this.b);
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
        return this.h != null ? a + abd.b(8, this.h.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
        }
        if (this.c != null) {
            abd.a(2, this.c);
        }
        if (this.d != null) {
            abd.a(3, this.d.intValue());
        }
        if (this.b != null) {
            abd.a(4, this.b);
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
        super.a(abd);
    }
}
