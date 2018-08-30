package com.google.android.gms.internal.ads;

final class acw implements Runnable {
    private final /* synthetic */ acv a;

    acw(acv acv) {
        this.a = acv;
    }

    public final void run() {
        if (this.a.b == null) {
            synchronized (acv.d) {
                if (this.a.b != null) {
                    return;
                }
                boolean booleanValue = ((Boolean) akc.f().a(amn.bC)).booleanValue();
                if (booleanValue) {
                    try {
                        acv.a = new aib(this.a.c.a, "ADSHIELD", null);
                    } catch (Throwable th) {
                        booleanValue = false;
                    }
                }
                this.a.b = Boolean.valueOf(booleanValue);
                acv.d.open();
            }
        }
    }
}
