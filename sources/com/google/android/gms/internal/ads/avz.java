package com.google.android.gms.internal.ads;

final class avz implements Runnable {
    private final /* synthetic */ avs a;

    avz(avs avs) {
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
