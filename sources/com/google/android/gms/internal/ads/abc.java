package com.google.android.gms.internal.ads;

public final class abc extends abe<abc> {
    public Long a;
    private String b;
    private byte[] c;

    public abc() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.d(1, this.a.longValue());
        }
        if (this.b != null) {
            a += abd.b(3, this.b);
        }
        return this.c != null ? a + abd.b(4, this.c) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.b(1, this.a.longValue());
        }
        if (this.b != null) {
            abd.a(3, this.b);
        }
        if (this.c != null) {
            abd.a(4, this.c);
        }
        super.a(abd);
    }
}
