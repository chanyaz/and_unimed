package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.p;
import javax.annotation.concurrent.GuardedBy;

@zzadh
final class pe {
    @GuardedBy("InvokeJavascriptWorkaround.class")
    @VisibleForTesting
    private static Boolean a;

    private pe() {
    }

    @TargetApi(19)
    static void a(WebView webView, String str) {
        if (p.g() && a(webView)) {
            webView.evaluateJavascript(str, null);
            return;
        }
        String str2 = "javascript:";
        String valueOf = String.valueOf(str);
        webView.loadUrl(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
    }

    @TargetApi(19)
    private static boolean a(WebView webView) {
        boolean booleanValue;
        synchronized (pe.class) {
            if (a == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    a = Boolean.valueOf(true);
                } catch (IllegalStateException e) {
                    a = Boolean.valueOf(false);
                }
            }
            booleanValue = a.booleanValue();
        }
        return booleanValue;
    }
}
