package com.puzzlersworld.android.ui.activity;

import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class c extends WebViewClient {
    final /* synthetic */ CommentsActivity a;

    private c(CommentsActivity commentsActivity) {
        this.a = commentsActivity;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.a.a(false);
        if (str.contains("/plugins/close_popup.php?reload")) {
            this.a.a.removeView(this.a.ae);
            this.a.af();
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return !Uri.parse(str).getHost().equals("m.facebook.com");
    }
}
