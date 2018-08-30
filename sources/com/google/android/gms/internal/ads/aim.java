package com.google.android.gms.internal.ads;

public final class aim extends abe<aim> {
    private Integer a;
    private aiy b;
    private String c;
    private String d;

    public aim() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aim b(abb abb) {
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 40:
                    int j = abb.j();
                    try {
                        int g = abb.g();
                        if (g < 0 || g > 2) {
                            throw new IllegalArgumentException(g + " is not a valid enum Platform");
                        }
                        this.a = Integer.valueOf(g);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 50:
                    if (this.b == null) {
                        this.b = new aiy();
                    }
                    abb.a(this.b);
                    continue;
                case 58:
                    this.c = abb.e();
                    continue;
                case 66:
                    this.d = abb.e();
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
            a += abd.b(5, this.a.intValue());
        }
        if (this.b != null) {
            a += abd.b(6, this.b);
        }
        if (this.c != null) {
            a += abd.b(7, this.c);
        }
        return this.d != null ? a + abd.b(8, this.d) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(5, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(6, this.b);
        }
        if (this.c != null) {
            abd.a(7, this.c);
        }
        if (this.d != null) {
            abd.a(8, this.d);
        }
        super.a(abd);
    }
}
