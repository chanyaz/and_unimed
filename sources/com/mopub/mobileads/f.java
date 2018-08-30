package com.mopub.mobileads;

import android.util.Log;
import com.google.android.gms.ads.a;

class f extends a {
    final /* synthetic */ GooglePlayServicesBanner a;

    private f(GooglePlayServicesBanner googlePlayServicesBanner) {
        this.a = googlePlayServicesBanner;
    }

    public void onAdClosed() {
    }

    public void onAdFailedToLoad(int i) {
        Log.d("MoPub", "Google Play Services banner ad failed to load.");
        if (this.a.a != null) {
            this.a.a.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onAdLeftApplication() {
    }

    public void onAdLoaded() {
        Log.d("MoPub", "Google Play Services banner ad loaded successfully. Showing ad...");
        if (this.a.a != null) {
            this.a.a.onBannerLoaded(this.a.b);
        }
    }

    public void onAdOpened() {
        Log.d("MoPub", "Google Play Services banner ad clicked.");
        if (this.a.a != null) {
            this.a.a.onBannerClicked();
        }
    }
}
