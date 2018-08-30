package com.google.android.gms.internal.ads;

public final class aem extends aez {
    private static volatile String d = null;
    private static final Object e = new Object();

    public aem(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 1);
    }

    protected final void a() {
        this.b.a = "E";
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = (String) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.a = d;
        }
    }
}
