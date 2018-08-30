package com.google.android.gms.internal.ads;

public final class zh extends abe<zh> {
    private Long a;
    private Integer b;
    private Boolean c;
    private int[] d;
    private Long e;

    public zh() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = abm.a;
        this.e = null;
        this.Z = -1;
    }

    protected final int a() {
        int i = 0;
        int a = super.a();
        if (this.a != null) {
            a += abd.d(1, this.a.longValue());
        }
        if (this.b != null) {
            a += abd.b(2, this.b.intValue());
        }
        if (this.c != null) {
            this.c.booleanValue();
            a += abd.b(3) + 1;
        }
        if (this.d != null && this.d.length > 0) {
            int i2 = 0;
            while (i < this.d.length) {
                i2 += abd.a(this.d[i]);
                i++;
            }
            a = (a + i2) + (this.d.length * 1);
        }
        return this.e != null ? a + abd.c(5, this.e.longValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.b(1, this.a.longValue());
        }
        if (this.b != null) {
            abd.a(2, this.b.intValue());
        }
        if (this.c != null) {
            abd.a(3, this.c.booleanValue());
        }
        if (this.d != null && this.d.length > 0) {
            for (int a : this.d) {
                abd.a(4, a);
            }
        }
        if (this.e != null) {
            abd.a(5, this.e.longValue());
        }
        super.a(abd);
    }
}
