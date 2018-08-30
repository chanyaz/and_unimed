package com.puzzlersworld.android.ui.activity;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class f extends WebViewClient {
    final /* synthetic */ FeedDetailActivity a;

    private f(FeedDetailActivity feedDetailActivity) {
        this.a = feedDetailActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        this.a.aw.setRefreshing(false);
        this.a.i.setVisibility(8);
        super.onPageFinished(webView, str);
        if (str.indexOf("disqus.com/next/login-success") > -1) {
            this.a.ae();
        }
        if (str.indexOf("disqus.com/_ax/twitter/complete") > -1 || str.indexOf("disqus.com/_ax/facebook/complete") > -1 || str.indexOf("disqus.com/_ax/google/complete") > -1) {
            this.a.ae();
        }
        if (str.contains("/plugins/close_popup.php?reload")) {
            this.a.ao.removeView(this.a.aM);
            this.a.ae();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.a.b(webView, str);
    }
}
