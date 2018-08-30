package com.google.android.gms.internal.ads;

public final class aen extends aez {
    public aen(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 3);
    }

    protected final void a() {
        synchronized (this.b) {
            adc adc = new adc((String) this.c.invoke(null, new Object[]{this.a.a()}));
            synchronized (this.b) {
                this.b.c = Long.valueOf(adc.a);
                this.b.O = Long.valueOf(adc.b);
            }
        }
    }
}
