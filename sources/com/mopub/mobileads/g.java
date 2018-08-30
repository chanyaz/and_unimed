package com.mopub.mobileads;

import android.util.Log;
import com.google.android.gms.ads.a;

class g extends a {
    final /* synthetic */ GooglePlayServicesInterstitial a;

    private g(GooglePlayServicesInterstitial googlePlayServicesInterstitial) {
        this.a = googlePlayServicesInterstitial;
    }

    public void onAdClosed() {
        Log.d("MoPub", "Google Play Services interstitial ad dismissed.");
        if (this.a.a != null) {
            this.a.a.onInterstitialDismissed();
        }
    }

    public void onAdFailedToLoad(int i) {
        Log.d("MoPub", "Google Play Services interstitial ad failed to load.");
        if (this.a.a != null) {
            this.a.a.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onAdLeftApplication() {
        Log.d("MoPub", "Google Play Services interstitial ad clicked.");
        if (this.a.a != null) {
            this.a.a.onInterstitialClicked();
        }
    }

    public void onAdLoaded() {
        Log.d("MoPub", "Google Play Services interstitial ad loaded successfully.");
        if (this.a.a != null) {
            this.a.a.onInterstitialLoaded();
        }
    }

    public void onAdOpened() {
        Log.d("MoPub", "Showing Google Play Services interstitial ad.");
        if (this.a.a != null) {
            this.a.a.onInterstitialShown();
        }
    }
}
