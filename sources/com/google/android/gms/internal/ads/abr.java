package com.google.android.gms.internal.ads;

public final class abr extends abe<abr> {
    private byte[] a;
    private byte[] b;
    private byte[] c;

    public abr() {
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
            a += abd.b(2, this.b);
        }
        return this.c != null ? a + abd.b(3, this.c) : a;
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
        super.a(abd);
    }
}
