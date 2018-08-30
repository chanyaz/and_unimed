package com.google.android.gms.internal.ads;

public final class aja extends abe<aja> {
    private Integer a;
    private ajb b;
    private aix c;

    public aja() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aja b(abb abb) {
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
                case 26:
                    if (this.c == null) {
                        this.c = new aix();
                    }
                    abb.a(this.c);
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
        return this.c != null ? a + abd.b(3, this.c) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(2, this.b);
        }
        if (this.c != null) {
            abd.a(3, this.c);
        }
        super.a(abd);
    }
}
