package com.mopub.mobileads;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import com.mopub.common.util.VersionCode;
import com.mopub.common.util.Views;
import com.mopub.mobileads.util.WebViews;

public class BaseWebView extends WebView {
    private static boolean b = false;
    protected boolean a;

    public BaseWebView(Context context) {
        super(context.getApplicationContext());
        b(false);
        WebViews.setDisableJSChromeClient(this);
        if (!b) {
            a(getContext());
            b = true;
        }
        getSettings().setAllowFileAccess(false);
        if (VERSION.SDK_INT >= 11) {
            getSettings().setAllowContentAccess(false);
        }
        if (VERSION.SDK_INT >= 16) {
            getSettings().setAllowFileAccessFromFileURLs(false);
            getSettings().setAllowUniversalAccessFromFileURLs(false);
        }
    }

    private void a(@NonNull Context context) {
        if (VERSION.SDK_INT == 19) {
            View webView = new WebView(context.getApplicationContext());
            webView.setBackgroundColor(0);
            webView.loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
            LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = 1;
            layoutParams.height = 1;
            layoutParams.type = 2005;
            layoutParams.flags = 16777240;
            layoutParams.format = -2;
            layoutParams.gravity = 8388659;
            ((WindowManager) context.getSystemService("window")).addView(webView, layoutParams);
        }
    }

    protected void b(boolean z) {
        if (!VersionCode.currentApiLevel().isAtLeast(VersionCode.JELLY_BEAN_MR2)) {
            if (z) {
                getSettings().setPluginState(PluginState.ON);
            } else {
                getSettings().setPluginState(PluginState.OFF);
            }
        }
    }

    public void destroy() {
        this.a = true;
        Views.removeFromParent(this);
        removeAllViews();
        super.destroy();
    }

    @Deprecated
    void setIsDestroyed(boolean z) {
        this.a = z;
    }
}
