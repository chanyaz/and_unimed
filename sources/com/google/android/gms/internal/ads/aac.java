package com.google.android.gms.internal.ads;

public final class aac extends abe<aac> {
    public byte[] a;
    public byte[] b;
    public byte[] c;
    public byte[] d;

    public aac() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.b(1, this.a);
        }
        if (this.b != null) {
            a += abd.b(2, this.b);
        }
        if (this.c != null) {
            a += abd.b(3, this.c);
        }
        return this.d != null ? a + abd.b(4, this.d) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
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
        super.a(abd);
    }
}
