package com.mopub.mobileads.util;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Reflection.MethodBuilder;

public class WebViews {
    @TargetApi(11)
    public static void onPause(@NonNull WebView webView, boolean z) {
        if (z) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        if (VERSION.SDK_INT >= 11) {
            webView.onPause();
            return;
        }
        try {
            new MethodBuilder(webView, "onPause").setAccessible().execute();
        } catch (Exception e) {
        }
    }

    @TargetApi(11)
    public static void onResume(@NonNull WebView webView) {
        if (VERSION.SDK_INT >= 11) {
            webView.onResume();
            return;
        }
        try {
            new MethodBuilder(webView, "onResume").setAccessible().execute();
        } catch (Exception e) {
        }
    }

    public static void setDisableJSChromeClient(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient() {
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                MoPubLog.d(str2);
                jsResult.confirm();
                return true;
            }

            public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
                MoPubLog.d(str2);
                jsResult.confirm();
                return true;
            }

            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                MoPubLog.d(str2);
                jsResult.confirm();
                return true;
            }

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                MoPubLog.d(str2);
                jsPromptResult.confirm();
                return true;
            }
        });
    }
}
