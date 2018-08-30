package com.google.android.gms.internal.ads;

public final class abu extends abe<abu> {
    public Integer a;
    public String b;
    public byte[] c;

    public abu() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.Y = null;
        this.Z = -1;
    }

    private final abu b(abb abb) {
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    int j = abb.j();
                    try {
                        int c = abb.c();
                        if (c < 0 || c > 1) {
                            throw new IllegalArgumentException(c + " is not a valid enum Type");
                        }
                        this.a = Integer.valueOf(c);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 18:
                    this.b = abb.e();
                    continue;
                case 26:
                    this.c = abb.f();
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
