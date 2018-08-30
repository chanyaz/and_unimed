package com.google.android.gms.ads.internal;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.akc;
import com.google.android.gms.internal.ads.amn;
import com.google.android.gms.internal.ads.kk;

final class ap extends WebViewClient {
    private final /* synthetic */ ao a;

    ap(ao aoVar) {
        this.a = aoVar;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.a.g != null) {
            try {
                this.a.g.onAdFailedToLoad(0);
            } catch (Throwable e) {
                kk.d("#007 Could not call remote method.", e);
            }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.startsWith(this.a.b())) {
            return false;
        }
        if (str.startsWith((String) akc.f().a(amn.cu))) {
            if (this.a.g != null) {
                try {
                    this.a.g.onAdFailedToLoad(3);
                } catch (Throwable e) {
                    kk.d("#007 Could not call remote method.", e);
                }
            }
            this.a.a(0);
            return true;
        }
        if (str.startsWith((String) akc.f().a(amn.cv))) {
            if (this.a.g != null) {
                try {
                    this.a.g.onAdFailedToLoad(0);
                } catch (Throwable e2) {
                    kk.d("#007 Could not call remote method.", e2);
                }
            }
            this.a.a(0);
            return true;
        }
        if (str.startsWith((String) akc.f().a(amn.cw))) {
            if (this.a.g != null) {
                try {
                    this.a.g.onAdLoaded();
                } catch (Throwable e22) {
                    kk.d("#007 Could not call remote method.", e22);
                }
            }
            this.a.a(this.a.a(str));
            return true;
        } else if (str.startsWith("gmsg://")) {
            return true;
        } else {
            if (this.a.g != null) {
                try {
                    this.a.g.onAdLeftApplication();
                } catch (Throwable e222) {
                    kk.d("#007 Could not call remote method.", e222);
                }
            }
            this.a.c(this.a.b(str));
            return true;
        }
    }
}
