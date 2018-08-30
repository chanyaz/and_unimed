package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

class k implements CustomEventInterstitialListener {
    final /* synthetic */ MoPubActivity a;

    k(MoPubActivity moPubActivity) {
        this.a = moPubActivity;
    }

    public void onInterstitialClicked() {
        BaseBroadcastReceiver.a(this.a, this.a.a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_CLICK);
    }

    public void onInterstitialDismissed() {
    }

    public void onInterstitialFailed(MoPubErrorCode moPubErrorCode) {
        BaseBroadcastReceiver.a(this.a, this.a.a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_FAIL);
        this.a.finish();
    }

    public void onInterstitialLoaded() {
        this.a.b.loadUrl(e.WEB_VIEW_DID_APPEAR.b());
    }

    public void onInterstitialShown() {
    }

    public void onLeaveApplication() {
    }
}
