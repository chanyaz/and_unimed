package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.Nullable;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

class RewardedVastVideoInterstitial extends VastVideoInterstitial {
    @Nullable
    private RewardedVideoBroadcastReceiver d;

    interface CustomEventRewardedVideoInterstitialListener extends CustomEventInterstitialListener {
        void onVideoComplete();
    }

    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2) {
        super.loadInterstitial(context, customEventInterstitialListener, map, map2);
        if (customEventInterstitialListener instanceof CustomEventRewardedVideoInterstitialListener) {
            this.d = new RewardedVideoBroadcastReceiver((CustomEventRewardedVideoInterstitialListener) customEventInterstitialListener, this.c);
            this.d.register(this.d, context);
        }
    }

    public void onInvalidate() {
        super.onInvalidate();
        if (this.d != null) {
            this.d.unregister(this.d);
        }
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig != null) {
            vastVideoConfig.setIsRewardedVideo(true);
        }
        super.onVastVideoConfigurationPrepared(vastVideoConfig);
    }
}
