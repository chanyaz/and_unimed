package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.a;

@zzadh
public class ake extends a {
    private final Object a = new Object();
    private a b;

    public final void a(a aVar) {
        synchronized (this.a) {
            this.b = aVar;
        }
    }

    public void onAdClosed() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.a) {
            if (this.b != null) {
                this.b.onAdOpened();
            }
        }
    }
}
