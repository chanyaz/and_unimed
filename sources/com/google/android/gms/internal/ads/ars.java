package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import java.util.Random;

final class ars extends akh {
    private final zzkh a;

    ars(zzkh zzkh) {
        this.a = zzkh;
    }

    public final void onAdClicked() {
        this.a.onAdClicked();
    }

    public final void onAdClosed() {
        if (asb.a()) {
            int intValue = ((Integer) akc.f().a(amn.bb)).intValue();
            int intValue2 = ((Integer) akc.f().a(amn.bc)).intValue();
            if (intValue <= 0 || intValue2 < 0) {
                au.r().a();
            } else {
                ht.a.postDelayed(art.a, (long) (new Random().nextInt(intValue2 + 1) + intValue));
            }
        }
        this.a.onAdClosed();
    }

    public final void onAdFailedToLoad(int i) {
        this.a.onAdFailedToLoad(i);
    }

    public final void onAdImpression() {
        this.a.onAdImpression();
    }

    public final void onAdLeftApplication() {
        this.a.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.a.onAdLoaded();
    }

    public final void onAdOpened() {
        this.a.onAdOpened();
    }
}
