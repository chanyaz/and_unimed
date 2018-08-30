package com.puzzlersworld.android.ui.activity;

import android.os.Message;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.FrameLayout.LayoutParams;

class b extends WebChromeClient {
    final /* synthetic */ CommentsActivity a;

    b(CommentsActivity commentsActivity) {
        this.a = commentsActivity;
    }

    public void onCloseWindow(WebView webView) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        this.a.ae = new WebView(this.a.getLifecycleActivity());
        this.a.ae.setVerticalScrollBarEnabled(false);
        this.a.ae.setHorizontalScrollBarEnabled(false);
        this.a.ae.setWebViewClient(new c(this.a, null));
        this.a.ae.setWebChromeClient(this);
        this.a.ae.getSettings().setJavaScriptEnabled(true);
        this.a.ae.getSettings().setDomStorageEnabled(true);
        this.a.ae.getSettings().setSupportZoom(false);
        this.a.ae.getSettings().setBuiltInZoomControls(false);
        this.a.ae.getSettings().setSupportMultipleWindows(true);
        this.a.ae.setLayoutParams(new LayoutParams(-1, -1));
        this.a.a.addView(this.a.ae);
        ((WebViewTransport) message.obj).setWebView(this.a.ae);
        message.sendToTarget();
        return true;
    }
}
