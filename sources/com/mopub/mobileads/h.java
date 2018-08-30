package com.mopub.mobileads;

import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;

class h implements HtmlWebViewListener {
    private final CustomEventBannerListener a;

    public h(CustomEventBannerListener customEventBannerListener) {
        this.a = customEventBannerListener;
    }

    public void onClicked() {
        this.a.onBannerClicked();
    }

    public void onCollapsed() {
        this.a.onBannerCollapsed();
    }

    public void onFailed(MoPubErrorCode moPubErrorCode) {
        this.a.onBannerFailed(moPubErrorCode);
    }

    public void onLoaded(BaseHtmlWebView baseHtmlWebView) {
        this.a.onBannerLoaded(baseHtmlWebView);
    }
}
