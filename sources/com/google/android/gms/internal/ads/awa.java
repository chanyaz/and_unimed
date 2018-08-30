package com.google.android.gms.internal.ads;

final class awa implements Runnable {
    private final /* synthetic */ avs a;

    awa(avs avs) {
        this.a = avs;
    }

    public final void run() {
        try {
            this.a.a.onAdLoaded();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
