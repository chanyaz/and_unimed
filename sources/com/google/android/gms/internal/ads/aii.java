package com.google.android.gms.internal.ads;

public final class aii extends abe<aii> {
    private String a;
    private aih[] b;
    private Integer c;

    public aii() {
        this.a = null;
        this.b = aih.b();
        this.c = null;
        this.Y = null;
        this.Z = -1;
    }

    private final aii b(abb abb) {
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
        return this.c != null ? a + abd.b(3, this.c.intValue()) : a;
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
        super.a(abd);
    }
}
