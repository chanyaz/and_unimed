package com.google.ads.mediation.customevent;

import android.app.Activity;
import com.google.ads.mediation.g;

@Deprecated
public interface CustomEventInterstitial extends CustomEvent {
    void requestInterstitialAd(CustomEventInterstitialListener customEventInterstitialListener, Activity activity, String str, String str2, g gVar, Object obj);

    void showInterstitial();
}
