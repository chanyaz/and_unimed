package com.mopub.mobileads.factories;

import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.MoPubInterstitial;
import java.util.Map;

public class CustomEventInterstitialAdapterFactory {
    protected static CustomEventInterstitialAdapterFactory a = new CustomEventInterstitialAdapterFactory();

    public static CustomEventInterstitialAdapter create(MoPubInterstitial moPubInterstitial, String str, Map<String, String> map, long j, AdReport adReport) {
        return a.a(moPubInterstitial, str, map, j, adReport);
    }

    @Deprecated
    public static void setInstance(CustomEventInterstitialAdapterFactory customEventInterstitialAdapterFactory) {
        a = customEventInterstitialAdapterFactory;
    }

    protected CustomEventInterstitialAdapter a(MoPubInterstitial moPubInterstitial, String str, Map<String, String> map, long j, AdReport adReport) {
        return new CustomEventInterstitialAdapter(moPubInterstitial, str, map, j, adReport);
    }
}
