package com.google.ads.mediation.customevent;

import android.app.Activity;
import com.google.ads.a;
import com.google.ads.mediation.g;

@Deprecated
public interface CustomEventBanner extends CustomEvent {
    void requestBannerAd(CustomEventBannerListener customEventBannerListener, Activity activity, String str, String str2, a aVar, g gVar, Object obj);
}
