package com.google.android.gms.internal.ads;

public final class aik extends abe<aik> {
    private Integer a;
    private aix b;
    private aix c;
    private aix d;
    private aix[] e;
    private Integer f;

    public aik() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = aix.b();
        this.f = null;
        this.Y = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.b(1, this.a.intValue());
        }
        if (this.b != null) {
            a += abd.b(2, this.b);
        }
        if (this.c != null) {
            a += abd.b(3, this.c);
        }
        if (this.d != null) {
            a += abd.b(4, this.d);
        }
        if (this.e != null && this.e.length > 0) {
            int i = a;
            for (abj abj : this.e) {
                if (abj != null) {
                    i += abd.b(5, abj);
                }
            }
            a = i;
        }
        return this.f != null ? a + abd.b(6, this.f.intValue()) : a;
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
        if (this.d != null) {
            abd.a(4, this.d);
        }
        if (this.e != null && this.e.length > 0) {
            for (abj abj : this.e) {
                if (abj != null) {
                    abd.a(5, abj);
                }
            }
        }
        if (this.f != null) {
            abd.a(6, this.f.intValue());
        }
        super.a(abd);
    }
}
