package com.google.android.gms.internal.ads;

final class avy implements Runnable {
    private final /* synthetic */ avs a;

    avy(avs avs) {
        this.a = avs;
    }

    public final void run() {
        try {
            this.a.a.onAdLeftApplication();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
