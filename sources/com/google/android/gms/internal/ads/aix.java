package com.google.android.gms.internal.ads;

public final class aix extends abe<aix> {
    private static volatile aix[] a;
    private Integer b;
    private Integer c;

    public aix() {
        this.b = null;
        this.c = null;
        this.Y = null;
        this.Z = -1;
    }

    public static aix[] b() {
        if (a == null) {
            synchronized (abi.b) {
                if (a == null) {
                    a = new aix[0];
                }
            }
        }
        return a;
    }

    protected final int a() {
        int a = super.a();
        if (this.b != null) {
            a += abd.b(1, this.b.intValue());
        }
        return this.c != null ? a + abd.b(2, this.c.intValue()) : a;
    }

    public final void a(abd abd) {
        if (this.b != null) {
            abd.a(1, this.b.intValue());
        }
        if (this.c != null) {
            abd.a(2, this.c.intValue());
        }
        super.a(abd);
    }
}
