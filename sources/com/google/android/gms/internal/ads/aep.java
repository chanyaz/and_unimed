package com.google.android.gms.internal.ads;

public final class aep extends aez {
    private final boolean d;

    public aep(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 61);
        this.d = adn.j();
    }

    protected final void a() {
        long longValue = ((Long) this.c.invoke(null, new Object[]{this.a.a(), Boolean.valueOf(this.d)})).longValue();
        synchronized (this.b) {
            this.b.P = Long.valueOf(longValue);
        }
    }
}
