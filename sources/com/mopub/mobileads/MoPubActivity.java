package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.factories.HtmlInterstitialWebViewFactory;
import java.io.Serializable;

public class MoPubActivity extends d {
    private HtmlInterstitialWebView b;

    static Intent a(Context context, String str, AdReport adReport, boolean z, String str2, String str3, CreativeOrientation creativeOrientation, long j) {
        Intent intent = new Intent(context, MoPubActivity.class);
        intent.putExtra(DataKeys.HTML_RESPONSE_BODY_KEY, str);
        intent.putExtra(DataKeys.SCROLLABLE_KEY, z);
        intent.putExtra(DataKeys.CLICKTHROUGH_URL_KEY, str3);
        intent.putExtra(DataKeys.REDIRECT_URL_KEY, str2);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.putExtra(DataKeys.CREATIVE_ORIENTATION_KEY, creativeOrientation);
        intent.addFlags(268435456);
        return intent;
    }

    static void a(Context context, AdReport adReport, final CustomEventInterstitialListener customEventInterstitialListener, String str) {
        HtmlInterstitialWebView create = HtmlInterstitialWebViewFactory.create(context, adReport, customEventInterstitialListener, false, null, null);
        create.b(false);
        create.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.equals("mopub://finishLoad")) {
                    customEventInterstitialListener.onInterstitialLoaded();
                } else if (str.equals("mopub://failLoad")) {
                    customEventInterstitialListener.onInterstitialFailed(null);
                }
                return true;
            }
        });
        create.a(str);
    }

    public static void start(Context context, String str, AdReport adReport, boolean z, String str2, String str3, CreativeOrientation creativeOrientation, long j) {
        try {
            context.startActivity(a(context, str, adReport, z, str2, str3, creativeOrientation, j));
        } catch (ActivityNotFoundException e) {
            Log.d("MoPubActivity", "MoPubActivity not found - did you declare it in AndroidManifest.xml?");
        }
    }

    public View getAdView() {
        Intent intent = getIntent();
        boolean booleanExtra = intent.getBooleanExtra(DataKeys.SCROLLABLE_KEY, false);
        String stringExtra = intent.getStringExtra(DataKeys.REDIRECT_URL_KEY);
        String stringExtra2 = intent.getStringExtra(DataKeys.CLICKTHROUGH_URL_KEY);
        String stringExtra3 = intent.getStringExtra(DataKeys.HTML_RESPONSE_BODY_KEY);
        this.b = HtmlInterstitialWebViewFactory.create(getApplicationContext(), this.a, new k(this), booleanExtra, stringExtra, stringExtra2);
        this.b.a(stringExtra3);
        return this.b;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Serializable serializableExtra = getIntent().getSerializableExtra(DataKeys.CREATIVE_ORIENTATION_KEY);
        CreativeOrientation creativeOrientation = (serializableExtra == null || !(serializableExtra instanceof CreativeOrientation)) ? CreativeOrientation.UNDEFINED : (CreativeOrientation) serializableExtra;
        DeviceUtils.lockOrientation(this, creativeOrientation);
        BaseBroadcastReceiver.a(this, a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_SHOW);
    }

    protected void onDestroy() {
        this.b.loadUrl(e.WEB_VIEW_DID_CLOSE.b());
        this.b.destroy();
        BaseBroadcastReceiver.a(this, a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_DISMISS);
        super.onDestroy();
    }
}
