package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.VersionCode;
import com.mopub.mobileads.ViewGestureDetector.UserClickListener;
import com.mopub.network.Networking;

public class BaseHtmlWebView extends BaseWebView implements UserClickListener {
    private final ViewGestureDetector b;
    private boolean c;

    public BaseHtmlWebView(Context context, AdReport adReport) {
        super(context);
        a();
        getSettings().setJavaScriptEnabled(true);
        this.b = new ViewGestureDetector(context, (View) this, adReport);
        this.b.setUserClickListener(this);
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.ICE_CREAM_SANDWICH)) {
            b(true);
        }
        setBackgroundColor(0);
    }

    private void a() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
    }

    void a(String str) {
        loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", str, "text/html", "utf-8", null);
    }

    void a(final boolean z) {
        setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                BaseHtmlWebView.this.b.sendTouchEvent(motionEvent);
                return motionEvent.getAction() == 2 && !z;
            }
        });
    }

    public void init(boolean z) {
        a(z);
    }

    public void loadUrl(String str) {
        if (str != null) {
            MoPubLog.d("Loading url: " + str);
            if (str.startsWith("javascript:")) {
                super.loadUrl(str);
            }
        }
    }

    public void onResetUserClick() {
        this.c = false;
    }

    public void onUserClick() {
        this.c = true;
    }

    public boolean wasClicked() {
        return this.c;
    }
}
