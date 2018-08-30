package com.mopub.common;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.mopub.common.event.BaseEvent.Category;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.event.BaseEvent.SamplingRate;
import com.mopub.common.event.Event.Builder;
import com.mopub.common.event.MoPubEvents;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.util.WebViews;

public class MoPubBrowser extends Activity {
    public static final String DESTINATION_URL_KEY = "URL";
    public static final String DSP_CREATIVE_ID = "mopub-dsp-creative-id";
    public static final int MOPUB_BROWSER_REQUEST_CODE = 1;
    private WebView a;
    private ImageButton b;
    private ImageButton c;
    private ImageButton d;
    private ImageButton e;
    private DoubleTimeTracker f;
    private String g;

    private ImageButton a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }

    private void a() {
        WebSettings settings = this.a.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        this.g = getIntent().getStringExtra(DSP_CREATIVE_ID);
        this.a.loadUrl(getIntent().getStringExtra(DESTINATION_URL_KEY));
        this.a.setWebViewClient(new a(this));
        this.a.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView webView, int i) {
                MoPubBrowser.this.setTitle("Loading...");
                MoPubBrowser.this.setProgress(i * 100);
                if (i == 100) {
                    MoPubBrowser.this.setTitle(webView.getUrl());
                }
            }
        });
    }

    private void b() {
        this.b.setBackgroundColor(0);
        this.b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MoPubBrowser.this.a.canGoBack()) {
                    MoPubBrowser.this.a.goBack();
                }
            }
        });
        this.c.setBackgroundColor(0);
        this.c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (MoPubBrowser.this.a.canGoForward()) {
                    MoPubBrowser.this.a.goForward();
                }
            }
        });
        this.d.setBackgroundColor(0);
        this.d.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MoPubBrowser.this.a.reload();
            }
        });
        this.e.setBackgroundColor(0);
        this.e.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                MoPubBrowser.this.finish();
            }
        });
    }

    private void c() {
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
    }

    private View d() {
        View linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        View relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(relativeLayout);
        View linearLayout2 = new LinearLayout(this);
        linearLayout2.setId(1);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setBackgroundDrawable(Drawables.BACKGROUND.createDrawable(this));
        relativeLayout.addView(linearLayout2);
        this.b = a(Drawables.LEFT_ARROW.createDrawable(this));
        this.c = a(Drawables.RIGHT_ARROW.createDrawable(this));
        this.d = a(Drawables.REFRESH.createDrawable(this));
        this.e = a(Drawables.CLOSE.createDrawable(this));
        linearLayout2.addView(this.b);
        linearLayout2.addView(this.c);
        linearLayout2.addView(this.d);
        linearLayout2.addView(this.e);
        this.a = new BaseWebView(this);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, 1);
        this.a.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.a);
        return linearLayout;
    }

    public void finish() {
        ((ViewGroup) getWindow().getDecorView()).removeAllViews();
        super.finish();
    }

    @NonNull
    public ImageButton getBackButton() {
        return this.b;
    }

    @NonNull
    public ImageButton getCloseButton() {
        return this.e;
    }

    @NonNull
    public ImageButton getForwardButton() {
        return this.c;
    }

    @NonNull
    public ImageButton getRefreshButton() {
        return this.d;
    }

    @NonNull
    public WebView getWebView() {
        return this.a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(-1);
        getWindow().requestFeature(2);
        getWindow().setFeatureInt(2, -1);
        setContentView(d());
        this.f = new DoubleTimeTracker();
        a();
        b();
        c();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.a.destroy();
        this.a = null;
        MoPubEvents.log(new Builder(Name.AD_DWELL_TIME, Category.AD_INTERACTIONS, SamplingRate.AD_INTERACTIONS.getSamplingRate()).withDspCreativeId(this.g).withPerformanceDurationMs(Double.valueOf(this.f.getInterval())).build());
    }

    protected void onPause() {
        super.onPause();
        CookieSyncManager.getInstance().stopSync();
        WebViews.onPause(this.a, isFinishing());
        this.f.pause();
    }

    protected void onResume() {
        super.onResume();
        CookieSyncManager.getInstance().startSync();
        WebViews.onResume(this.a);
        this.f.start();
    }
}
