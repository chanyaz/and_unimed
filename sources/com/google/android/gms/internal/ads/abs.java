package com.google.android.gms.internal.ads;

public final class abs extends abe<abs> {
    private abt a;
    private abp[] b;
    private byte[] c;
    private byte[] d;
    private Integer e;
    private byte[] f;

    public abs() {
        this.a = null;
        this.b = abp.b();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.Y = null;
        this.Z = -1;
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
            a += abd.b(3, this.c);
        }
        if (this.d != null) {
            a += abd.b(4, this.d);
        }
        if (this.e != null) {
            a += abd.b(5, this.e.intValue());
        }
        return this.f != null ? a + abd.b(6, this.f) : a;
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
            abd.a(3, this.c);
        }
        if (this.d != null) {
            abd.a(4, this.d);
        }
        if (this.e != null) {
            abd.a(5, this.e.intValue());
        }
        if (this.f != null) {
            abd.a(6, this.f);
        }
        super.a(abd);
    }
}
