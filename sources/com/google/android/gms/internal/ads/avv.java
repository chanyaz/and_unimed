package com.google.android.gms.internal.ads;

final class avv implements Runnable {
    private final /* synthetic */ avs a;

    avv(avs avs) {
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
