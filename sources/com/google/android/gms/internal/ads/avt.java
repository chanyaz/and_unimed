package com.google.android.gms.internal.ads;

final class avt implements Runnable {
    private final /* synthetic */ avs a;

    avt(avs avs) {
        this.a = avs;
    }

    public final void run() {
        try {
            this.a.a.onAdClicked();
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
