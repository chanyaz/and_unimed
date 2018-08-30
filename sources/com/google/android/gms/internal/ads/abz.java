package com.google.android.gms.internal.ads;

public final class abz extends abe<abz> {
    public byte[][] a;
    public byte[] b;
    public Integer c;
    private Integer d;

    public abz() {
        this.a = abm.d;
        this.b = null;
        this.Z = -1;
    }

    private final abz b(abb abb) {
        while (true) {
            int a = abb.a();
            int a2;
            switch (a) {
                case 0:
                    break;
                case 10:
                    a2 = abm.a(abb, 10);
                    a = this.a == null ? 0 : this.a.length;
                    Object obj = new byte[(a2 + a)][];
                    if (a != 0) {
                        System.arraycopy(this.a, 0, obj, 0, a);
                    }
                    while (a < obj.length - 1) {
                        obj[a] = abb.f();
                        abb.a();
                        a++;
                    }
                    obj[a] = abb.f();
                    this.a = obj;
                    continue;
                case 18:
                    this.b = abb.f();
                    continue;
                case 24:
                    a2 = abb.j();
                    try {
                        this.d = Integer.valueOf(vq.b(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e) {
                        abb.e(a2);
                        a(abb, a);
                        break;
                    }
                case 32:
                    a2 = abb.j();
                    try {
                        this.c = Integer.valueOf(vq.c(abb.g()));
                        continue;
                    } catch (IllegalArgumentException e2) {
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
        int i = 0;
        int a = super.a();
        if (this.a == null || this.a.length <= 0) {
            i = a;
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i < this.a.length) {
                byte[] bArr = this.a[i];
                if (bArr != null) {
                    i3++;
                    i2 += abd.b(bArr);
                }
                i++;
            }
            i = (a + i2) + (i3 * 1);
        }
        if (this.b != null) {
            i += abd.b(2, this.b);
        }
        if (this.d != null) {
            i += abd.b(3, this.d.intValue());
        }
        return this.c != null ? i + abd.b(4, this.c.intValue()) : i;
    }

    public final void a(abd abd) {
        if (this.a != null && this.a.length > 0) {
            for (byte[] bArr : this.a) {
                if (bArr != null) {
                    abd.a(1, bArr);
                }
            }
        }
        if (this.b != null) {
            abd.a(2, this.b);
        }
        if (this.d != null) {
            abd.a(3, this.d.intValue());
        }
        if (this.c != null) {
            abd.a(4, this.c.intValue());
        }
        super.a(abd);
    }
}
