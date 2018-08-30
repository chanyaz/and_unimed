package com.google.android.gms.internal.ads;

public final class yo extends abe<yo> {
    public Long a;
    public Long b;
    public Long c;
    private Long d;
    private Long e;

    public yo() {
        this.d = null;
        this.e = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.d != null) {
            a += abd.d(1, this.d.longValue());
        }
        if (this.e != null) {
            a += abd.d(2, this.e.longValue());
        }
        if (this.a != null) {
            a += abd.d(3, this.a.longValue());
        }
        if (this.b != null) {
            a += abd.d(4, this.b.longValue());
        }
        return this.c != null ? a + abd.d(5, this.c.longValue()) : a;
    }

    public final void a(abd abd) {
        if (this.d != null) {
            abd.b(1, this.d.longValue());
        }
        if (this.e != null) {
            abd.b(2, this.e.longValue());
        }
        if (this.a != null) {
            abd.b(3, this.a.longValue());
        }
        if (this.b != null) {
            abd.b(4, this.b.longValue());
        }
        if (this.c != null) {
            abd.b(5, this.c.longValue());
        }
        super.a(abd);
    }
}
