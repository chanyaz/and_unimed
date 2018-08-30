package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

class i implements HtmlWebViewListener {
    private final CustomEventInterstitialListener a;

    public i(CustomEventInterstitialListener customEventInterstitialListener) {
        this.a = customEventInterstitialListener;
    }

    public void onClicked() {
        this.a.onInterstitialClicked();
    }

    public void onCollapsed() {
    }

    public void onFailed(MoPubErrorCode moPubErrorCode) {
        this.a.onInterstitialFailed(moPubErrorCode);
    }

    public void onLoaded(BaseHtmlWebView baseHtmlWebView) {
        this.a.onInterstitialLoaded();
    }
}
