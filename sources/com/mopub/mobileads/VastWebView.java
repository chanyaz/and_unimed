package com.mopub.mobileads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Utils;
import com.mopub.common.util.VersionCode;
import com.mopub.network.Networking;

class VastWebView extends BaseWebView {
    @Nullable
    VastWebViewClickListener b;

    interface VastWebViewClickListener {
        void onVastWebViewClick();
    }

    VastWebView(Context context) {
        super(context);
        a();
        getSettings().setJavaScriptEnabled(true);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            b(true);
        }
        setBackgroundColor(0);
        setOnTouchListener(new ad(this));
        setId((int) Utils.generateUniqueId());
    }

    @NonNull
    static VastWebView a(@NonNull Context context, @NonNull aa aaVar) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(aaVar);
        VastWebView vastWebView = new VastWebView(context);
        aaVar.initializeWebView(vastWebView);
        return vastWebView;
    }

    private void a() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    void a(@NonNull VastWebViewClickListener vastWebViewClickListener) {
        this.b = vastWebViewClickListener;
    }

    void a(String str) {
        loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "utf-8", null);
    }
}
