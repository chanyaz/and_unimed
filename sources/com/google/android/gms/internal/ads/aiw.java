package com.google.android.gms.internal.ads;

public final class aiw extends abe<aiw> {
    private static volatile aiw[] a;
    private String b;
    private Integer c;
    private aix d;

    public aiw() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aiw b(abb abb) {
        while (true) {
            int a = abb.a();
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.b = abb.e();
                    continue;
                case 16:
                    int j = abb.j();
                    try {
                        this.c = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(j);
                        a(abb, a);
                        break;
                    }
                case 26:
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

    public static aiw[] b() {
        if (a == null) {
            synchronized (abi.b) {
                if (a == null) {
                    a = new aiw[0];
                }
            }
        }
        return a;
    }

    protected final int a() {
        int a = super.a();
        if (this.b != null) {
            a += abd.b(1, this.b);
        }
        if (this.c != null) {
            a += abd.b(2, this.c.intValue());
        }
        return this.d != null ? a + abd.b(3, this.d) : a;
    }

    public final void a(abd abd) {
        if (this.b != null) {
            abd.a(1, this.b);
        }
        if (this.c != null) {
            abd.a(2, this.c.intValue());
        }
        if (this.d != null) {
            abd.a(3, this.d);
        }
        super.a(abd);
    }
}
