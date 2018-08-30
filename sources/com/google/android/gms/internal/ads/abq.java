package com.google.android.gms.internal.ads;

public final class abq extends abe<abq> {
    public abp[] a;
    private abr b;
    private byte[] c;
    private byte[] d;
    private Integer e;

    public abq() {
        this.b = null;
        this.a = abp.b();
        this.c = null;
        this.d = null;
        this.e = null;
        this.Y = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.b != null) {
            a += abd.b(1, this.b);
        }
        if (this.a != null && this.a.length > 0) {
            int i = a;
            for (abj abj : this.a) {
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
        return this.e != null ? a + abd.b(5, this.e.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.b != null) {
            abd.a(1, this.b);
        }
        if (this.a != null && this.a.length > 0) {
            for (abj abj : this.a) {
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
        super.a(abd);
    }
}
