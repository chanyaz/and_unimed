package com.google.android.gms.internal.ads;

public final class aiy extends abe<aiy> {
    public Integer a;
    public Integer b;
    public Integer c;

    public aiy() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.Y = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.b(1, this.a.intValue());
        }
        if (this.b != null) {
            a += abd.b(2, this.b.intValue());
        }
        return this.c != null ? a + abd.b(3, this.c.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(2, this.b.intValue());
        }
        if (this.c != null) {
            abd.a(3, this.c.intValue());
        }
        super.a(abd);
    }
}
