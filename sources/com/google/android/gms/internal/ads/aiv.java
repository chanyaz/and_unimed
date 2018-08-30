package com.google.android.gms.internal.ads;

public final class aiv extends abe<aiv> {
    private Integer a;
    private Integer b;

    public aiv() {
        this.a = null;
        this.b = null;
        this.Y = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        if (this.a != null) {
            a += abd.b(1, this.a.intValue());
        }
        return this.b != null ? a + abd.b(2, this.b.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a.intValue());
        }
        if (this.b != null) {
            abd.a(2, this.b.intValue());
        }
        super.a(abd);
    }
}
