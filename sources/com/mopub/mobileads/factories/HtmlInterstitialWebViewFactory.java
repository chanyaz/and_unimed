package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.HtmlInterstitialWebView;

public class HtmlInterstitialWebViewFactory {
    protected static HtmlInterstitialWebViewFactory a = new HtmlInterstitialWebViewFactory();

    public static HtmlInterstitialWebView create(Context context, AdReport adReport, CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2) {
        return a.internalCreate(context, adReport, customEventInterstitialListener, z, str, str2);
    }

    @Deprecated
    public static void setInstance(HtmlInterstitialWebViewFactory htmlInterstitialWebViewFactory) {
        a = htmlInterstitialWebViewFactory;
    }

    public HtmlInterstitialWebView internalCreate(Context context, AdReport adReport, CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2) {
        HtmlInterstitialWebView htmlInterstitialWebView = new HtmlInterstitialWebView(context, adReport);
        htmlInterstitialWebView.init(customEventInterstitialListener, z, str, str2, adReport.getDspCreativeId());
        return htmlInterstitialWebView;
    }
}
