package com.google.android.gms.internal.ads;

public final class aes extends aez {
    public aes(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 51);
    }

    protected final void a() {
        synchronized (this.b) {
            adm adm = new adm((String) this.c.invoke(null, new Object[0]));
            this.b.G = adm.a;
            this.b.H = adm.b;
        }
    }
}
