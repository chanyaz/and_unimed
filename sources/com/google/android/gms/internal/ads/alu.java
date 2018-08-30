package com.google.android.gms.internal.ads;

final class alu implements Runnable {
    private final /* synthetic */ alt a;

    alu(alt alt) {
        this.a = alt;
    }

    public final void run() {
        if (this.a.a != null) {
            try {
                this.a.a.onAdFailedToLoad(1);
            } catch (Throwable e) {
                kk.c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
