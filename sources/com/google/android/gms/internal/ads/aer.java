package com.google.android.gms.internal.ads;

public final class aer extends aez {
    private final StackTraceElement[] d;

    public aer(adn adn, String str, String str2, wr wrVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(adn, str, str2, wrVar, i, 45);
        this.d = stackTraceElementArr;
    }

    protected final void a() {
        if (this.d != null) {
            adl adl = new adl((String) this.c.invoke(null, new Object[]{this.d}));
            synchronized (this.b) {
                this.b.B = adl.a;
                if (adl.b.booleanValue()) {
                    this.b.J = Integer.valueOf(adl.c.booleanValue() ? 0 : 1);
                }
            }
        }
    }
}
