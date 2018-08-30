package com.google.android.gms.internal.ads;

public final class aef extends aez {
    public aef(adn adn, String str, String str2, wr wrVar, int i, int i2) {
        super(adn, str, str2, wrVar, i, 5);
    }

    protected final void a() {
        this.b.d = Long.valueOf(-1);
        this.b.e = Long.valueOf(-1);
        int[] iArr = (int[]) this.c.invoke(null, new Object[]{this.a.a()});
        synchronized (this.b) {
            this.b.d = Long.valueOf((long) iArr[0]);
            this.b.e = Long.valueOf((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.b.N = Long.valueOf((long) iArr[2]);
            }
        }
    }
}
