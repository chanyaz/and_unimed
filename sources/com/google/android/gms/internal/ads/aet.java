package com.google.android.gms.internal.ads;

public final class aet extends aez {
    private final ady d;
    private long e;

    public aet(adn adn, String str, String str2, wr wrVar, int i, int i2, ady ady) {
        super(adn, str, str2, wrVar, i, 53);
        this.d = ady;
        if (ady != null) {
            this.e = ady.a();
        }
    }

    protected final void a() {
        if (this.d != null) {
            this.b.I = (Long) this.c.invoke(null, new Object[]{Long.valueOf(this.e)});
        }
    }
}
