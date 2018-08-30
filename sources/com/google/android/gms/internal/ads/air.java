package com.google.android.gms.internal.ads;

public final class air extends abe<air> {
    private Integer a;
    private Integer b;

    public air() {
        this.a = null;
        this.b = null;
        this.Y = null;
        this.Z = -1;
    }

    private final air b(abb abb) {
        int j;
        while (true) {
            int a = abb.a();
            int g;
            switch (a) {
                case 0:
                    break;
                case 8:
                    j = abb.j();
                    try {
                        g = abb.g();
                        if (g < 0 || g > 2) {
                            throw new IllegalArgumentException(g + " is not a valid enum NetworkType");
                        }
                        this.a = Integer.valueOf(g);
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 16:
                    g = abb.j();
                    try {
                        j = abb.g();
                        if ((j < 0 || j > 2) && (j < 4 || j > 4)) {
                            throw new IllegalArgumentException(j + " is not a valid enum CellularNetworkType");
                        }
                        this.b = Integer.valueOf(j);
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(g);
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
            a += abd.b(1, this.a.intValue());
        }
        return this.b != null ? a + abd.b(2, this.b.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(2, this.b.intValue());
        }
        super.a(abd);
    }
}
