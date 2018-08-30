package com.google.android.gms.internal.ads;

import java.util.List;

public final class aeo extends aez {
    private List<Long> d = null;

    public aeo(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 31);
    }

    protected final void a() {
        this.b.p = Long.valueOf(-1);
        this.b.q = Long.valueOf(-1);
        if (this.d == null) {
            this.d = (List) this.c.invoke(null, new Object[]{this.a.a()});
        }
        if (this.d != null && this.d.size() == 2) {
            synchronized (this.b) {
                this.b.p = Long.valueOf(((Long) this.d.get(0)).longValue());
                this.b.q = Long.valueOf(((Long) this.d.get(1)).longValue());
            }
        }
    }
}
