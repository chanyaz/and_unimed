package com.appnext.core.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.appnext.core.g;

public class WebAppInterface {
    Context context;

    public WebAppInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void destroy() {
        g.X("destroy");
    }

    @JavascriptInterface
    public void destroy(String str) {
        g.X("destroy with error code: " + str);
    }

    @JavascriptInterface
    public String filterAds(String str) {
        g.X("filterAds: " + str);
        return str;
    }

    @JavascriptInterface
    public String getAdAt(int i) {
        g.X("getAdAt " + i);
        return "";
    }

    @JavascriptInterface
    public int getAdCount() {
        g.X("getAdCount");
        return 0;
    }

    @JavascriptInterface
    public void gotoAppWall() {
        g.X("gotoAppWall");
    }

    @JavascriptInterface
    public String init() {
        g.X("init");
        return "";
    }

    @JavascriptInterface
    public void jsError(String str) {
        g.X("jsError " + str);
    }

    @JavascriptInterface
    public String loadAds() {
        g.X("loadAds");
        return "";
    }

    @JavascriptInterface
    public void notifyImpression(String str) {
        g.X("notifyImpression");
    }

    @JavascriptInterface
    public void openLink(String str) {
        g.X("openLink " + str);
    }

    @JavascriptInterface
    public void openStore(String str) {
        g.X("openStore: " + str);
    }

    @JavascriptInterface
    public void play() {
        g.X("play");
    }

    @JavascriptInterface
    public void postView(String str) {
        g.X("postView: " + str);
    }

    @JavascriptInterface
    public void videoPlayed() {
        g.X("videoPlayed");
    }
}
