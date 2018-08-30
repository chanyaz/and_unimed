package com.google.android.gms.internal.ads;

final class als implements Runnable {
    private final /* synthetic */ alr a;

    als(alr alr) {
        this.a = alr;
    }

    public final void run() {
        if (this.a.a.a != null) {
            try {
                this.a.a.a.onAdFailedToLoad(1);
            } catch (Throwable e) {
                kk.c("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
