package com.puzzlersworld.android.ui.activity.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.Map;

public class VideoEnabledWebView extends WebView {
    private VideoEnabledWebChromeClient a;
    private boolean b = false;

    public VideoEnabledWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a() {
        if (!this.b) {
            addJavascriptInterface(new b(this), "_VideoEnabledWebView");
            this.b = true;
        }
    }

    public void loadData(String str, String str2, String str3) {
        a();
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        a();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        a();
        super.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        a();
        super.loadUrl(str, map);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        getSettings().setJavaScriptEnabled(true);
        if (webChromeClient instanceof VideoEnabledWebChromeClient) {
            this.a = (VideoEnabledWebChromeClient) webChromeClient;
        }
        super.setWebChromeClient(webChromeClient);
    }
}
