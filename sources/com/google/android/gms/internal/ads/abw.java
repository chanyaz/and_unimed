package com.google.android.gms.internal.ads;

public final class abw extends abe<abw> {
    public String a;
    public Long b;
    public Boolean c;

    public abw() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.Y = null;
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
        if (this.c == null) {
            return a;
        }
        this.c.booleanValue();
        return a + (abd.b(3) + 1);
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
        }
        if (this.b != null) {
            abd.b(2, this.b.longValue());
        }
        if (this.c != null) {
            abd.a(3, this.c.booleanValue());
        }
        super.a(abd);
    }
}
