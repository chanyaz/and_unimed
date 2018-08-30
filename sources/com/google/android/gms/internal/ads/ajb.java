package com.google.android.gms.internal.ads;

public final class ajb extends abe<ajb> {
    private Integer a;

    public ajb() {
        this.a = null;
        this.Y = null;
        this.Z = -1;
    }

    private final ajb b(abb abb) {
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 8:
                    int j = abb.j();
                    try {
                        int g = abb.g();
                        if (g < 0 || g > 3) {
                            throw new IllegalArgumentException(g + " is not a valid enum VideoErrorCode");
                        }
                        this.a = Integer.valueOf(g);
                        continue;
                    } catch (IllegalArgumentException e) {
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
        return this.a != null ? a + abd.b(1, this.a.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        super.a(abd);
    }
}
