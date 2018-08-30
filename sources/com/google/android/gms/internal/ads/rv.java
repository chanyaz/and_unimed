package com.google.android.gms.internal.ads;

public final class rv extends abe<rv> {
    public String a;
    public Long b;
    private String c;
    private String d;
    private String e;
    private Long f;
    private Long g;
    private String h;
    private Long i;
    private String j;

    public rv() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.b(1, this.a);
        }
        if (this.b != null) {
            a += abd.d(2, this.b.longValue());
        }
        if (this.c != null) {
            a += abd.b(3, this.c);
        }
        if (this.d != null) {
            a += abd.b(4, this.d);
        }
        if (this.e != null) {
            a += abd.b(5, this.e);
        }
        if (this.f != null) {
            a += abd.d(6, this.f.longValue());
        }
        if (this.g != null) {
            a += abd.d(7, this.g.longValue());
        }
        if (this.h != null) {
            a += abd.b(8, this.h);
        }
        if (this.i != null) {
            a += abd.d(9, this.i.longValue());
        }
        return this.j != null ? a + abd.b(10, this.j) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
        }
        if (this.b != null) {
            abd.b(2, this.b.longValue());
        }
        if (this.c != null) {
            abd.a(3, this.c);
        }
        if (this.d != null) {
            abd.a(4, this.d);
        }
        if (this.e != null) {
            abd.a(5, this.e);
        }
        if (this.f != null) {
            abd.b(6, this.f.longValue());
        }
        if (this.g != null) {
            abd.b(7, this.g.longValue());
        }
        if (this.h != null) {
            abd.a(8, this.h);
        }
        if (this.i != null) {
            abd.b(9, this.i.longValue());
        }
        if (this.j != null) {
            abd.a(10, this.j);
        }
        super.a(abd);
    }
}
