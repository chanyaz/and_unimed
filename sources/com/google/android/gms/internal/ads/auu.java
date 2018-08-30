package com.google.android.gms.internal.ads;

final class auu implements Runnable {
    private final /* synthetic */ auo a;

    auu(aut aut, auo auo) {
        this.a = auo;
    }

    public final void run() {
        try {
            this.a.c.destroy();
        } catch (Throwable e) {
            kk.c("Could not destroy mediation adapter.", e);
        }
    }
}
