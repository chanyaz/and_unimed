package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest.ErrorCode;

final class awc implements Runnable {
    private final /* synthetic */ ErrorCode a;
    private final /* synthetic */ avs b;

    awc(avs avs, ErrorCode errorCode) {
        this.b = avs;
        this.a = errorCode;
    }

    public final void run() {
        try {
            this.b.a.onAdFailedToLoad(awe.a(this.a));
        } catch (Throwable e) {
            kk.d("#007 Could not call remote method.", e);
        }
    }
}
