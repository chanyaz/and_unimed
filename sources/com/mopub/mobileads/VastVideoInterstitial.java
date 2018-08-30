package com.mopub.mobileads;

import com.mopub.common.CacheService;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.VastManager.VastManagerListener;
import com.mopub.mobileads.factories.VastManagerFactory;
import java.util.Map;

class VastVideoInterstitial extends ResponseBodyInterstitial implements VastManagerListener {
    private CustomEventInterstitialListener d;
    private String e;
    private VastManager f;
    private VastVideoConfig g;

    VastVideoInterstitial() {
    }

    protected void a(CustomEventInterstitialListener customEventInterstitialListener) {
        this.d = customEventInterstitialListener;
        if (CacheService.initializeDiskCache(this.a)) {
            this.f = VastManagerFactory.create(this.a);
            this.f.prepareVastVideoConfiguration(this.e, this, this.b.getDspCreativeId(), this.a);
            return;
        }
        this.d.onInterstitialFailed(MoPubErrorCode.VIDEO_CACHE_ERROR);
    }

    protected void a(Map<String, String> map) {
        this.e = (String) map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    public void onInvalidate() {
        if (this.f != null) {
            this.f.cancel();
        }
        super.onInvalidate();
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig == null) {
            this.d.onInterstitialFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
            return;
        }
        this.g = vastVideoConfig;
        this.d.onInterstitialLoaded();
    }

    public void showInterstitial() {
        BaseVideoPlayerActivity.a(this.a, this.g, this.c);
    }
}
