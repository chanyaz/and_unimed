package com.google.android.gms.internal.ads;

final class awb implements Runnable {
    private final /* synthetic */ avs a;

    awb(avs avs) {
        this.a = avs;
    }

    public final void run() {
        try {
            this.a.a.onAdClosed();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
