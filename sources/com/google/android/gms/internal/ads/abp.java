package com.google.android.gms.internal.ads;

public final class abp extends abe<abp> {
    private static volatile abp[] c;
    public byte[] a;
    public byte[] b;

    public abp() {
        this.a = null;
        this.b = null;
        this.Y = null;
        this.Z = -1;
    }

    public static abp[] b() {
        if (c == null) {
            synchronized (abi.b) {
                if (c == null) {
                    c = new abp[0];
                }
            }
        }
        return c;
    }

    protected final int a() {
        int a = super.a() + abd.b(1, this.a);
        return this.b != null ? a + abd.b(2, this.b) : a;
    }

    public final void a(abd abd) {
        abd.a(1, this.a);
        if (this.b != null) {
            abd.a(2, this.b);
        }
        super.a(abd);
    }
}
