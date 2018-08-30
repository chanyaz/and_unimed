package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.au;
import com.google.android.gms.ads.internal.bs;
import com.google.android.gms.ads.internal.overlay.c;
import com.google.android.gms.common.util.p;

@zzadh
@TargetApi(11)
public final class nj extends WebChromeClient {
    private final zzaqw a;

    public nj(zzaqw zzaqw) {
        this.a = zzaqw;
    }

    private static Context a(WebView webView) {
        if (!(webView instanceof zzaqw)) {
            return webView.getContext();
        }
        zzaqw zzaqw = (zzaqw) webView;
        Context zzto = zzaqw.zzto();
        return zzto == null ? zzaqw.getContext() : zzto;
    }

    private final boolean a(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        try {
            if (!(this.a == null || this.a.zzuf() == null || this.a.zzuf().zzut() == null)) {
                bs zzut = this.a.zzuf().zzut();
                if (!(zzut == null || zzut.b())) {
                    zzut.a(new StringBuilder((String.valueOf(str).length() + 11) + String.valueOf(str3).length()).append("window.").append(str).append("('").append(str3).append("')").toString());
                    return false;
                }
            }
            Builder builder = new Builder(context);
            builder.setTitle(str2);
            if (z) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                View textView = new TextView(context);
                textView.setText(str3);
                View editText = new EditText(context);
                editText.setText(str4);
                linearLayout.addView(textView);
                linearLayout.addView(editText);
                builder.setView(linearLayout).setPositiveButton(17039370, new np(jsPromptResult, editText)).setNegativeButton(17039360, new no(jsPromptResult)).setOnCancelListener(new nn(jsPromptResult)).create().show();
                return true;
            }
            builder.setMessage(str3).setPositiveButton(17039370, new nm(jsResult)).setNegativeButton(17039360, new nl(jsResult)).setOnCancelListener(new nk(jsResult)).create().show();
            return true;
        } catch (Throwable e) {
            kk.c("Fail to display Dialog.", e);
            return true;
        }
    }

    public final void onCloseWindow(WebView webView) {
        if (webView instanceof zzaqw) {
            c zzub = ((zzaqw) webView).zzub();
            if (zzub == null) {
                kk.e("Tried to close an AdWebView not associated with an overlay.");
                return;
            } else {
                zzub.a();
                return;
            }
        }
        kk.e("Tried to close a WebView that wasn't an AdWebView.");
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        message = new StringBuilder((String.valueOf(message).length() + 19) + String.valueOf(sourceId).length()).append("JS: ").append(message).append(" (").append(sourceId).append(":").append(consoleMessage.lineNumber()).append(")").toString();
        if (message.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (nq.a[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                kk.c(message);
                break;
            case 2:
                kk.e(message);
                break;
            case 3:
            case 4:
                kk.d(message);
                break;
            case 5:
                kk.b(message);
                break;
            default:
                kk.d(message);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebViewTransport webViewTransport = (WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.a.zzug() != null) {
            webView2.setWebViewClient(this.a.zzug());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(Math.min(131072, j4) + j, com.appnext.base.b.c.jl);
            } else if (j2 <= Math.min(com.appnext.base.b.c.jl - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > com.appnext.base.b.c.jl) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, Callback callback) {
        if (callback != null) {
            boolean z;
            au.e();
            if (!ht.a(this.a.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                au.e();
                if (!ht.a(this.a.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        c zzub = this.a.zzub();
        if (zzub == null) {
            kk.e("Could not get ad overlay when hiding custom view.");
        } else {
            zzub.b();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "alert", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return a(a(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return a(a(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (p.i()) {
            if (!((Boolean) akc.f().a(amn.aC)).booleanValue()) {
                if (this.a == null || this.a.zzuf() == null || this.a.zzuf().zzvf() == null) {
                    super.onPermissionRequest(permissionRequest);
                    return;
                }
                String[] zzb = this.a.zzuf().zzvf().zzb(permissionRequest.getResources());
                if (zzb.length > 0) {
                    permissionRequest.grant(zzb);
                    return;
                } else {
                    permissionRequest.deny();
                    return;
                }
            }
        }
        super.onPermissionRequest(permissionRequest);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, QuotaUpdater quotaUpdater) {
        long j3 = 131072 + j;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
        c zzub = this.a.zzub();
        if (zzub == null) {
            kk.e("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzub.a(view, customViewCallback);
        zzub.a(i);
    }

    public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
