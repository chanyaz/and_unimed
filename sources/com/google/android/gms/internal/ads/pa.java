package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import javax.annotation.ParametersAreNonnullByDefault;

@zzadh
@ParametersAreNonnullByDefault
final class pa extends WebViewClient {
    private final zzasx a;
    private final zzatb b;
    private final zzasz c;
    private final zzata d;
    private final pf e = new pf();

    pa(zzasx zzasx, zzatb zzatb, zzasz zzasz, zzata zzata) {
        this.a = zzasx;
        this.b = zzatb;
        this.c = zzasz;
        this.d = zzata;
    }

    private final boolean a(pb pbVar) {
        return this.a.zza(pbVar);
    }

    private final WebResourceResponse b(pb pbVar) {
        return this.b.zzd(pbVar);
    }

    public final void onLoadResource(WebView webView, String str) {
        if (str != null) {
            String str2 = "Loading resource: ";
            String valueOf = String.valueOf(str);
            hl.a(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            this.c.zzb(new pb(str));
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        if (str != null) {
            this.d.zzc(new pb(str));
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.e.a(i, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.e.a(sslError);
    }

    @TargetApi(24)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return (webResourceRequest == null || webResourceRequest.getUrl() == null) ? null : b(new pb(webResourceRequest));
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return str == null ? null : b(new pb(str));
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 222:
                return true;
            default:
                return false;
        }
    }

    @TargetApi(24)
    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return (webResourceRequest == null || webResourceRequest.getUrl() == null) ? false : a(new pb(webResourceRequest));
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return str == null ? false : a(new pb(str));
    }
}
