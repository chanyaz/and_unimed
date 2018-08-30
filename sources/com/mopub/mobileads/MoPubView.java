package com.mopub.mobileads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.ManifestUtils;
import com.mopub.common.util.Visibility;
import com.mopub.mobileads.factories.AdViewControllerFactory;
import com.mopub.mobileads.factories.CustomEventBannerAdapterFactory;
import java.util.Map;
import java.util.TreeMap;

public class MoPubView extends FrameLayout {
    private Context a;
    @Nullable
    protected AdViewController b;
    protected CustomEventBannerAdapter c;
    private int d;
    private BroadcastReceiver e;
    private BannerAdListener f;

    public interface BannerAdListener {
        void onBannerClicked(MoPubView moPubView);

        void onBannerCollapsed(MoPubView moPubView);

        void onBannerExpanded(MoPubView moPubView);

        void onBannerFailed(MoPubView moPubView, MoPubErrorCode moPubErrorCode);

        void onBannerLoaded(MoPubView moPubView);
    }

    public MoPubView(Context context) {
        this(context, null);
    }

    public MoPubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ManifestUtils.checkWebViewActivitiesDeclared(context);
        this.a = context;
        this.d = getVisibility();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        if (WebViewDatabase.getInstance(context) == null) {
            MoPubLog.e("Disabling MoPub. Local cache file is inaccessible so MoPub will fail if we try to create a WebView. Details of this Android bug found at:https://code.google.com/p/android/issues/detail?id=10789");
            return;
        }
        this.b = AdViewControllerFactory.create(context, this);
        a();
    }

    private void a() {
        this.e = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (Visibility.isScreenVisible(MoPubView.this.d) && intent != null) {
                    String action = intent.getAction();
                    if ("android.intent.action.USER_PRESENT".equals(action)) {
                        MoPubView.this.setAdVisibility(0);
                    } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        MoPubView.this.setAdVisibility(8);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.a.registerReceiver(this.e, intentFilter);
    }

    private void i() {
        try {
            this.a.unregisterReceiver(this.e);
        } catch (Exception e) {
            MoPubLog.d("Failed to unregister screen state broadcast receiver (never registered).");
        }
    }

    private void setAdVisibility(int i) {
        if (this.b != null) {
            if (Visibility.isScreenVisible(i)) {
                this.b.c();
            } else {
                this.b.b();
            }
        }
    }

    protected void a(MoPubErrorCode moPubErrorCode) {
        if (this.f != null) {
            this.f.onBannerFailed(this, moPubErrorCode);
        }
    }

    protected void a(String str, Map<String, String> map) {
        if (this.b != null) {
            if (TextUtils.isEmpty(str)) {
                MoPubLog.d("Couldn't invoke custom event because the server did not specify one.");
                b(MoPubErrorCode.ADAPTER_NOT_FOUND);
                return;
            }
            if (this.c != null) {
                this.c.b();
            }
            MoPubLog.d("Loading custom event adapter.");
            this.c = CustomEventBannerAdapterFactory.create(this, str, map, this.b.getBroadcastIdentifier(), this.b.getAdReport());
            this.c.a();
        }
    }

    protected void b() {
        if (this.b != null) {
            this.b.g();
            g();
        }
    }

    protected void b(MoPubErrorCode moPubErrorCode) {
        if (this.b != null) {
            this.b.a(moPubErrorCode);
        }
    }

    protected void c() {
        MoPubLog.d("Tracking impression for native adapter.");
        if (this.b != null) {
            this.b.f();
        }
    }

    protected void d() {
        MoPubLog.d("adLoaded");
        if (this.f != null) {
            this.f.onBannerLoaded(this);
        }
    }

    public void destroy() {
        i();
        removeAllViews();
        if (this.b != null) {
            this.b.d();
            this.b = null;
        }
        if (this.c != null) {
            this.c.b();
            this.c = null;
        }
    }

    protected void e() {
        if (this.f != null) {
            this.f.onBannerExpanded(this);
        }
    }

    protected void f() {
        if (this.f != null) {
            this.f.onBannerCollapsed(this);
        }
    }

    public void forceRefresh() {
        if (this.c != null) {
            this.c.b();
            this.c = null;
        }
        if (this.b != null) {
            this.b.h();
        }
    }

    protected void g() {
        if (this.f != null) {
            this.f.onBannerClicked(this);
        }
    }

    public Activity getActivity() {
        return (Activity) this.a;
    }

    public AdFormat getAdFormat() {
        return AdFormat.BANNER;
    }

    public int getAdHeight() {
        return this.b != null ? this.b.getAdHeight() : 0;
    }

    Integer getAdTimeoutDelay() {
        return this.b != null ? this.b.e() : null;
    }

    public String getAdUnitId() {
        return this.b != null ? this.b.getAdUnitId() : null;
    }

    AdViewController getAdViewController() {
        return this.b;
    }

    public int getAdWidth() {
        return this.b != null ? this.b.getAdWidth() : 0;
    }

    public boolean getAutorefreshEnabled() {
        if (this.b != null) {
            return this.b.getAutorefreshEnabled();
        }
        MoPubLog.d("Can't get autorefresh status for destroyed MoPubView. Returning false.");
        return false;
    }

    public BannerAdListener getBannerAdListener() {
        return this.f;
    }

    @Deprecated
    public String getClickTrackingUrl() {
        return null;
    }

    public String getKeywords() {
        return this.b != null ? this.b.getKeywords() : null;
    }

    public Map<String, Object> getLocalExtras() {
        return this.b != null ? this.b.k() : new TreeMap();
    }

    public Location getLocation() {
        return this.b != null ? this.b.getLocation() : null;
    }

    @Deprecated
    public String getResponseString() {
        return null;
    }

    public boolean getTesting() {
        if (this.b != null) {
            return this.b.getTesting();
        }
        MoPubLog.d("Can't get testing status for destroyed MoPubView. Returning false.");
        return false;
    }

    protected void h() {
        if (this.b != null) {
            this.b.j();
        }
        d();
    }

    public void loadAd() {
        if (this.b != null) {
            this.b.loadAd();
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        if (Visibility.hasScreenVisibilityChanged(this.d, i)) {
            this.d = i;
            setAdVisibility(this.d);
        }
    }

    public void setAdContentView(View view) {
        if (this.b != null) {
            this.b.a(view);
        }
    }

    public void setAdUnitId(String str) {
        if (this.b != null) {
            this.b.setAdUnitId(str);
        }
    }

    public void setAutorefreshEnabled(boolean z) {
        if (this.b != null) {
            this.b.a(z);
        }
    }

    public void setBannerAdListener(BannerAdListener bannerAdListener) {
        this.f = bannerAdListener;
    }

    public void setKeywords(String str) {
        if (this.b != null) {
            this.b.setKeywords(str);
        }
    }

    public void setLocalExtras(Map<String, Object> map) {
        if (this.b != null) {
            this.b.a((Map) map);
        }
    }

    public void setLocation(Location location) {
        if (this.b != null) {
            this.b.setLocation(location);
        }
    }

    public void setTesting(boolean z) {
        if (this.b != null) {
            this.b.setTesting(z);
        }
    }

    @Deprecated
    public void setTimeout(int i) {
    }
}
