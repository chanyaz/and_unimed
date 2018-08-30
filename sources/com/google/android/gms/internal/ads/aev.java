package com.google.android.gms.internal.ads;

public final class aev extends aez {
    public aev(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 48);
    }

    protected final void a() {
        this.b.E = Integer.valueOf(2);
        boolean booleanValue = ((Boolean) this.c.invoke(null, new Object[]{this.a.a()})).booleanValue();
        synchronized (this.b) {
            if (booleanValue) {
                this.b.E = Integer.valueOf(1);
            } else {
                this.b.E = Integer.valueOf(0);
            }
        }
    }
}
