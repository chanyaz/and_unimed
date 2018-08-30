package com.google.android.gms.internal.ads;

final class avu implements Runnable {
    private final /* synthetic */ avs a;

    avu(avs avs) {
        this.a = avs;
    }

    public final void run() {
        try {
            this.a.a.onAdOpened();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
