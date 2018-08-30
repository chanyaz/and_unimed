package com.puzzlersworld.android.ui.activity.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class b {
    final /* synthetic */ VideoEnabledWebView a;

    public b(VideoEnabledWebView videoEnabledWebView) {
        this.a = videoEnabledWebView;
    }

    @JavascriptInterface
    public void notifyVideoEnd() {
        Log.d("___", "GOT IT");
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (b.this.a.a != null) {
                    b.this.a.a.onHideCustomView();
                }
            }
        });
    }
}
