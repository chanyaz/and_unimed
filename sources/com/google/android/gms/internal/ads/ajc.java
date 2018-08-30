package com.google.android.gms.internal.ads;

public final class ajc extends abe<ajc> {
    private aiy a;
    private Integer b;
    private ajb c;
    private aix d;

    public ajc() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.Y = null;
        this.Z = -1;
    }

    private final ajc b(abb abb) {
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    if (this.a == null) {
                        this.a = new aiy();
                    }
                    abb.a(this.a);
                    continue;
                case 16:
                    int j = abb.j();
                    try {
                        this.b = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 26:
                    if (this.c == null) {
                        this.c = new ajb();
                    }
                    abb.a(this.c);
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
        int a = super.a();
        if (this.a != null) {
            a += abd.b(1, this.a);
        }
        if (this.b != null) {
            a += abd.b(2, this.b.intValue());
        }
        if (this.c != null) {
            a += abd.b(3, this.c);
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
        if (this.c != null) {
            abd.a(3, this.c);
        }
        if (this.d != null) {
            abd.a(4, this.d);
        }
        super.a(abd);
    }
}
