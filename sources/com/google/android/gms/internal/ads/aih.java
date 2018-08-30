package com.google.android.gms.internal.ads;

public final class aih extends abe<aih> {
    private static volatile aih[] a;
    private Integer b;
    private aiv c;

    public aih() {
        this.b = null;
        this.c = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aih b(abb abb) {
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    int j = abb.j();
                    try {
                        int g = abb.g();
                        if (g < 0 || g > 10) {
                            throw new IllegalArgumentException(g + " is not a valid enum AdFormatType");
                        }
                        this.b = Integer.valueOf(g);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 18:
                    if (this.c == null) {
                        this.c = new aiv();
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

    public static aih[] b() {
        if (a == null) {
            synchronized (abi.b) {
                if (a == null) {
                    a = new aih[0];
                }
            }
        }
        return a;
    }

    protected final int a() {
        int a = super.a();
        if (this.b != null) {
            a += abd.b(1, this.b.intValue());
        }
        return this.c != null ? a + abd.b(2, this.c) : a;
    }

    public final void a(abd abd) {
        if (this.b != null) {
            abd.a(1, this.b.intValue());
        }
        if (this.c != null) {
            abd.a(2, this.c);
        }
        super.a(abd);
    }
}
