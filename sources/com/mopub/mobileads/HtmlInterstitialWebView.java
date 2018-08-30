package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;

public class HtmlInterstitialWebView extends BaseHtmlWebView {
    private Handler b = new Handler();

    public HtmlInterstitialWebView(Context context, AdReport adReport) {
        super(context, adReport);
    }

    public void init(CustomEventInterstitialListener customEventInterstitialListener, boolean z, String str, String str2, String str3) {
        super.init(z);
        setWebViewClient(new j(new i(customEventInterstitialListener), this, str2, str, str3));
    }
}
