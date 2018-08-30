package com.google.android.gms.internal.ads;

public final class aeh extends aez {
    private long d;

    public aeh(adn adn, String str, String str2, wr wrVar, long j, int i, int i2) {
        super(adn, str, str2, wrVar, i, 25);
        this.d = j;
    }

    protected final void a() {
        long longValue = ((Long) this.c.invoke(null, new Object[0])).longValue();
        synchronized (this.b) {
            this.b.W = Long.valueOf(longValue);
            if (this.d != 0) {
                this.b.j = Long.valueOf(longValue - this.d);
                this.b.m = Long.valueOf(this.d);
            }
        }
    }
}
