package com.mopub.mobileads;

import android.support.annotation.NonNull;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import java.util.Map;

public class HtmlInterstitial extends ResponseBodyInterstitial {
    private String d;
    private boolean e;
    private String f;
    private String g;
    @NonNull
    private CreativeOrientation h;

    protected void a(CustomEventInterstitialListener customEventInterstitialListener) {
        MoPubActivity.a(this.a, this.b, customEventInterstitialListener, this.d);
    }

    protected void a(Map<String, String> map) {
        this.d = (String) map.get(DataKeys.HTML_RESPONSE_BODY_KEY);
        this.e = Boolean.valueOf((String) map.get(DataKeys.SCROLLABLE_KEY)).booleanValue();
        this.f = (String) map.get(DataKeys.REDIRECT_URL_KEY);
        this.g = (String) map.get(DataKeys.CLICKTHROUGH_URL_KEY);
        this.h = CreativeOrientation.fromHeader((String) map.get(DataKeys.CREATIVE_ORIENTATION_KEY));
    }

    public void showInterstitial() {
        MoPubActivity.start(this.a, this.d, this.b, this.e, this.f, this.g, this.h, this.c);
    }
}
