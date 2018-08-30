package com.mopub.common;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.UrlHandler.Builder;
import com.mopub.common.UrlHandler.ResultActions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Drawables;
import java.util.EnumSet;

class a extends WebViewClient {
    private static final EnumSet<UrlAction> a = EnumSet.of(UrlAction.HANDLE_PHONE_SCHEME, new UrlAction[]{UrlAction.OPEN_APP_MARKET, UrlAction.OPEN_IN_APP_BROWSER, UrlAction.HANDLE_SHARE_TWEET, UrlAction.FOLLOW_DEEP_LINK_WITH_FALLBACK, UrlAction.FOLLOW_DEEP_LINK});
    @NonNull
    private MoPubBrowser b;

    public a(@NonNull MoPubBrowser moPubBrowser) {
        this.b = moPubBrowser;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.b.getBackButton().setImageDrawable(webView.canGoBack() ? Drawables.LEFT_ARROW.createDrawable(this.b) : Drawables.UNLEFT_ARROW.createDrawable(this.b));
        this.b.getForwardButton().setImageDrawable(webView.canGoForward() ? Drawables.RIGHT_ARROW.createDrawable(this.b) : Drawables.UNRIGHT_ARROW.createDrawable(this.b));
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.b.getForwardButton().setImageDrawable(Drawables.UNRIGHT_ARROW.createDrawable(this.b));
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        MoPubLog.d("MoPubBrowser error: " + str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return TextUtils.isEmpty(str) ? false : new Builder().withSupportedUrlActions(a).withoutMoPubBrowser().withResultActions(new ResultActions() {
            public void urlHandlingFailed(@NonNull String str, @NonNull UrlAction urlAction) {
            }

            public void urlHandlingSucceeded(@NonNull String str, @NonNull UrlAction urlAction) {
                if (urlAction.equals(UrlAction.OPEN_IN_APP_BROWSER)) {
                    a.this.b.getWebView().loadUrl(str);
                } else {
                    a.this.b.finish();
                }
            }
        }).build().handleResolvedUrl(this.b.getApplicationContext(), str, true, null);
    }
}
