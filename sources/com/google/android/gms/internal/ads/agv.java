package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class agv implements Runnable {
    final /* synthetic */ ago a;
    final /* synthetic */ WebView b;
    final /* synthetic */ boolean c;
    final /* synthetic */ agt d;
    private ValueCallback<String> e = new agw(this);

    agv(agt agt, ago ago, WebView webView, boolean z) {
        this.d = agt;
        this.a = ago;
        this.b = webView;
        this.c = z;
    }

    public final void run() {
        if (this.b.getSettings().getJavaScriptEnabled()) {
            try {
                this.b.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.e);
            } catch (Throwable th) {
                this.e.onReceiveValue("");
            }
        }
    }
}
