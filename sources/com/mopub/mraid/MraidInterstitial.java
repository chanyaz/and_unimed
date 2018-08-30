package com.mopub.mraid;

import android.support.annotation.NonNull;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.ResponseBodyInterstitial;
import java.util.Map;

class MraidInterstitial extends ResponseBodyInterstitial {
    private String d;

    MraidInterstitial() {
    }

    protected void a(@NonNull CustomEventInterstitialListener customEventInterstitialListener) {
        MraidActivity.preRenderHtml(this.a, customEventInterstitialListener, this.d);
    }

    protected void a(Map<String, String> map) {
        this.d = (String) map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
    }

    public void showInterstitial() {
        MraidActivity.start(this.a, this.b, this.d, this.c);
    }
}
