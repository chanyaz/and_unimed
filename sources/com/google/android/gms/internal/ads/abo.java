package com.google.android.gms.internal.ads;

public final class abo extends abe<abo> {
    public String a;

    public abo() {
        this.a = null;
        this.Y = null;
        this.Z = -1;
    }

    protected final int a() {
        int a = super.a();
        return this.a != null ? a + abd.b(1, this.a) : a;
    }

    public final void a(abd abd) {
        if (this.a != null) {
            abd.a(1, this.a);
        }
        super.a(abd);
    }
}
