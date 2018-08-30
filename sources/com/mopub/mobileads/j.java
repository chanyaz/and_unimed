package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.MoPubSchemeListener;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.util.EnumSet;

class j extends WebViewClient {
    private final EnumSet<UrlAction> a = EnumSet.of(UrlAction.HANDLE_MOPUB_SCHEME, new UrlAction[]{UrlAction.IGNORE_ABOUT_SCHEME, UrlAction.HANDLE_PHONE_SCHEME, UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_NATIVE_BROWSER, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
    private final Context b;
    private final String c;
    private HtmlWebViewListener d;
    private BaseHtmlWebView e;
    private final String f;
    private final String g;

    j(HtmlWebViewListener htmlWebViewListener, BaseHtmlWebView baseHtmlWebView, String str, String str2, String str3) {
        this.d = htmlWebViewListener;
        this.e = baseHtmlWebView;
        this.f = str;
        this.g = str2;
        this.c = str3;
        this.b = baseHtmlWebView.getContext();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.g != null && str.startsWith(this.g)) {
            webView.stopLoading();
            if (this.e.wasClicked()) {
                try {
                    Intents.showMoPubBrowserForUrl(this.b, Uri.parse(str), this.c);
                    return;
                } catch (IntentNotResolvableException e) {
                    MoPubLog.d(e.getMessage());
                    return;
                }
            }
            MoPubLog.d("Attempted to redirect without user interaction");
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        new Builder().withDspCreativeId(this.c).withSupportedUrlActions(this.a).withResultActions(new ResultActions() {
            public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
            }

            public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
                if (j.this.e.wasClicked()) {
                    j.this.d.onClicked();
                    j.this.e.onResetUserClick();
                }
            }
        }).withMoPubSchemeListener(new MoPubSchemeListener() {
            public void onClose() {
                j.this.d.onCollapsed();
            }

            public void onFailLoad() {
                j.this.d.onFailed(MoPubErrorCode.UNSPECIFIED);
            }

            public void onFinishLoad() {
                j.this.d.onLoaded(j.this.e);
            }
        }).build().handleUrl(this.b, str, this.e.wasClicked());
        return true;
    }
}
