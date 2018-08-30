package com.google.android.gms.internal.ads;

final class ma implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ int b;
    private final /* synthetic */ lt c;

    ma(lt ltVar, int i, int i2) {
        this.c = ltVar;
        this.a = i;
        this.b = i2;
    }

    public final void run() {
        if (this.c.r != null) {
            this.c.r.zzf(this.a, this.b);
        }
    }
}
