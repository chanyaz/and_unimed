package com.google.android.gms.internal.ads;

public final class aeu extends aez {
    private static volatile Long d = null;
    private static final Object e = new Object();

    public aeu(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 33);
    }

    protected final void a() {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = (Long) this.c.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.b) {
            this.b.r = d;
        }
    }
}
