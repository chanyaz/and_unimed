package com.google.android.gms.internal.ads;

public final class us extends abe<us> {
    public String a;
    private String b;
    private String c;
    private String d;
    private String e;

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
        if (this.d != null) {
            a += abd.b(4, this.d);
        }
        return this.e != null ? a + abd.b(5, this.e) : a;
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
        if (this.e != null) {
            abd.a(5, this.e);
        }
        super.a(abd);
    }
}
