package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidController.MraidListener;
import com.mopub.mraid.MraidController.UseCustomCloseListener;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import com.mopub.network.Networking;

public class MraidActivity extends d {
    @Nullable
    private MraidController b;
    @Nullable
    private MraidWebViewDebugListener c;

    @VisibleForTesting
    protected static Intent a(@NonNull Context context, @Nullable AdReport adReport, @NonNull String str, long j) {
        Intent intent = new Intent(context, MraidActivity.class);
        intent.putExtra(DataKeys.HTML_RESPONSE_BODY_KEY, str);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, j);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.addFlags(268435456);
        return intent;
    }

    public static void preRenderHtml(@NonNull Context context, @NonNull final CustomEventInterstitialListener customEventInterstitialListener, @NonNull String str) {
        BaseWebView baseWebView = new BaseWebView(context);
        baseWebView.b(false);
        baseWebView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                customEventInterstitialListener.onInterstitialLoaded();
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                customEventInterstitialListener.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return true;
            }
        });
        baseWebView.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "UTF-8", null);
    }

    public static void start(@NonNull Context context, @Nullable AdReport adReport, @NonNull String str, long j) {
        try {
            context.startActivity(a(context, adReport, str, j));
        } catch (ActivityNotFoundException e) {
            Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
        }
    }

    public View getAdView() {
        String stringExtra = getIntent().getStringExtra(DataKeys.HTML_RESPONSE_BODY_KEY);
        if (stringExtra == null) {
            MoPubLog.w("MraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        }
        this.b = new MraidController(this, this.a, PlacementType.INTERSTITIAL);
        this.b.setDebugListener(this.c);
        this.b.setMraidListener(new MraidListener() {
            public void onClose() {
                MraidActivity.this.b.loadJavascript(e.WEB_VIEW_DID_CLOSE.a());
                MraidActivity.this.finish();
            }

            public void onExpand() {
            }

            public void onFailedToLoad() {
                MoPubLog.d("MraidActivity failed to load. Finishing the activity");
                BaseBroadcastReceiver.a(MraidActivity.this, MraidActivity.this.a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_FAIL);
                MraidActivity.this.finish();
            }

            public void onLoaded(View view) {
                MraidActivity.this.b.loadJavascript(e.WEB_VIEW_DID_APPEAR.a());
            }

            public void onOpen() {
                BaseBroadcastReceiver.a(MraidActivity.this, MraidActivity.this.a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_CLICK);
            }
        });
        this.b.setUseCustomCloseListener(new UseCustomCloseListener() {
            public void useCustomCloseChanged(boolean z) {
                if (z) {
                    MraidActivity.this.c();
                } else {
                    MraidActivity.this.b();
                }
            }
        });
        this.b.loadContent(stringExtra);
        return this.b.getAdContainer();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        BaseBroadcastReceiver.a(this, a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_SHOW);
        if (VERSION.SDK_INT >= 14) {
            getWindow().setFlags(16777216, 16777216);
        }
    }

    protected void onDestroy() {
        if (this.b != null) {
            this.b.destroy();
        }
        BaseBroadcastReceiver.a(this, a().longValue(), EventForwardingBroadcastReceiver.ACTION_INTERSTITIAL_DISMISS);
        super.onDestroy();
    }

    protected void onPause() {
        if (this.b != null) {
            this.b.pause(isFinishing());
        }
        super.onPause();
    }

    protected void onResume() {
        super.onResume();
        if (this.b != null) {
            this.b.resume();
        }
    }

    @VisibleForTesting
    public void setDebugListener(@Nullable MraidWebViewDebugListener mraidWebViewDebugListener) {
        this.c = mraidWebViewDebugListener;
        if (this.b != null) {
            this.b.setDebugListener(mraidWebViewDebugListener);
        }
    }
}
