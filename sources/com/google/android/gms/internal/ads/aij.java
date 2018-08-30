package com.google.android.gms.internal.ads;

public final class aij extends abe<aij> {
    private String a;
    private aih[] b;
    private Integer c;
    private Integer d;
    private Integer e;

    public aij() {
        this.a = null;
        this.b = aih.b();
        this.c = null;
        this.d = null;
        this.e = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aij b(abb abb) {
        while (true) {
            int a = abb.a();
            int a2;
            switch (a) {
                case 0:
                    break;
                case 10:
                    this.a = abb.e();
                    continue;
                case 18:
                    a2 = abm.a(abb, 18);
                    a = this.b == null ? 0 : this.b.length;
                    Object obj = new aih[(a2 + a)];
                    if (a != 0) {
                        System.arraycopy(this.b, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = new aih();
                        abb.a(obj[a]);
                        abb.a();
                        a++;
                    }
                    obj[a] = new aih();
                    abb.a(obj[a]);
                    this.b = obj;
                    continue;
                case 24:
                    a2 = abb.j();
                    try {
                        this.c = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(a2);
                        a(abb, a);
                        break;
                    }
                case 32:
                    a2 = abb.j();
                    try {
                        this.d = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e2) {
                        abb.e(a2);
                        a(abb, a);
                        break;
                    }
                case 40:
                    a2 = abb.j();
                    try {
                        this.e = Integer.valueOf(aif.a(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e3) {
                        abb.e(a2);
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
        if (this.b != null && this.b.length > 0) {
            int i = a;
            for (abj abj : this.b) {
                if (abj != null) {
                    i += abd.b(2, abj);
                }
            }
            a = i;
        }
        if (this.c != null) {
            a += abd.b(3, this.c.intValue());
        }
        if (this.d != null) {
            a += abd.b(4, this.d.intValue());
        }
        return this.e != null ? a + abd.b(5, this.e.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
        }
        if (this.b != null && this.b.length > 0) {
            for (abj abj : this.b) {
                if (abj != null) {
                    abd.a(2, abj);
                }
            }
        }
        if (this.c != null) {
            abd.a(3, this.c.intValue());
        }
        if (this.d != null) {
            abd.a(4, this.d.intValue());
        }
        if (this.e != null) {
            abd.a(5, this.e.intValue());
        }
        super.a(abd);
    }
}
