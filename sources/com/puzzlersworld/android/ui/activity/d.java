package com.puzzlersworld.android.ui.activity;

import android.util.Log;
import android.webkit.JavascriptInterface;

class d {
    final /* synthetic */ FeedDetailActivity a;

    public d(FeedDetailActivity feedDetailActivity) {
        this.a = feedDetailActivity;
    }

    @JavascriptInterface
    public void clickImage(final String str) {
        Log.d("AndroApp", "webview image url, Clicked on the url " + str);
        this.a.d.execute(new Runnable() {
            public void run() {
                d.this.a.e(str);
            }
        });
    }

    @JavascriptInterface
    public void log(String str) {
        Log.d("AndroApp", "jslog " + str);
    }
}
