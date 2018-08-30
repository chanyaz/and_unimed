package com.google.android.gms.internal.ads;

import android.os.IInterface;

public interface zzkh extends IInterface {
    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i);

    void onAdImpression();

    void onAdLeftApplication();

    void onAdLoaded();

    void onAdOpened();
}
