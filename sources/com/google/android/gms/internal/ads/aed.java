package com.google.android.gms.internal.ads;

public final class aed extends aez {
    private static volatile String d = null;
    private static final Object e = new Object();

    public aed(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 29);
    }

    protected final void a() {
        this.b.o = "E";
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = (String) this.c.invoke(null, new Object[]{this.a.a()});
                }
            }
        }
        synchronized (this.b) {
            this.b.o = acb.a(d.getBytes(), true);
        }
    }
}
