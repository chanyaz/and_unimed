package com.google.android.gms.internal.ads;

public final class aji extends abe<aji> {
    private Integer a;
    private ajb b;

    public aji() {
        this.a = null;
        this.b = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aji b(abb abb) {
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
        return this.b != null ? a + abd.b(2, this.b) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(2, this.b);
        }
        super.a(abd);
    }
}
