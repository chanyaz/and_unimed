package com.puzzlersworld.android.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.FrameLayout.LayoutParams;
import com.puzzlersworld.wp.dto.StringConstants;

class e extends WebChromeClient {
    final /* synthetic */ FeedDetailActivity a;

    private e(FeedDetailActivity feedDetailActivity) {
        this.a = feedDetailActivity;
    }

    public void onCloseWindow(WebView webView) {
        Log.d("onCloseWindow", "called");
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        this.a.aM = new WebView(this.a.getLifecycleActivity());
        this.a.aM.setVerticalScrollBarEnabled(false);
        this.a.aM.setHorizontalScrollBarEnabled(false);
        this.a.aM.setWebViewClient(new f(this.a, null));
        this.a.aM.getSettings().setJavaScriptEnabled(true);
        this.a.aM.getSettings().setDomStorageEnabled(true);
        this.a.aM.getSettings().setSupportZoom(false);
        this.a.aM.getSettings().setBuiltInZoomControls(false);
        this.a.aM.getSettings().setSupportMultipleWindows(true);
        this.a.aM.getSettings().setSavePassword(false);
        this.a.aM.setLayoutParams(new LayoutParams(-1, -1));
        this.a.ao.addView(this.a.aM);
        ((WebViewTransport) message.obj).setWebView(this.a.aM);
        message.sendToTarget();
        return true;
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        if (this.a.aL != null) {
            this.a.aL.onReceiveValue(null);
        }
        this.a.aL = valueCallback;
        Parcelable intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        Intent intent2 = new Intent("android.intent.action.CHOOSER");
        intent2.putExtra("android.intent.extra.INTENT", intent);
        intent2.putExtra("android.intent.extra.TITLE", StringConstants.SELECT.getMessage());
        this.a.startActivityForResult(intent2, 100);
        return true;
    }
}
