package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent.Name;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mraid.MraidNativeCommandHandler;
import com.mopub.network.AdRequest;
import com.mopub.network.AdRequest.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class AdViewController {
    private static final LayoutParams b = new LayoutParams(-2, -2, 17);
    private static final WeakHashMap<View, Boolean> c = new WeakHashMap();
    @VisibleForTesting
    int a = 1;
    private final long d;
    @Nullable
    private Context e;
    @Nullable
    private MoPubView f;
    @Nullable
    private WebViewAdUrlGenerator g;
    @Nullable
    private AdResponse h;
    private final Runnable i;
    @NonNull
    private final Listener j;
    private boolean k;
    private Handler l;
    private boolean m;
    private String n;
    private Map<String, Object> o = new HashMap();
    private boolean p = true;
    private boolean q = true;
    private String r;
    private Location s;
    private boolean t;
    private boolean u;
    @Nullable
    private String v;
    private int w;
    @Nullable
    private AdRequest x;
    @Nullable
    private Integer y;

    public AdViewController(@NonNull Context context, @NonNull MoPubView moPubView) {
        this.e = context;
        this.f = moPubView;
        this.w = -1;
        this.d = Utils.generateUniqueId();
        this.g = new WebViewAdUrlGenerator(this.e.getApplicationContext(), MraidNativeCommandHandler.isStorePictureSupported(this.e));
        this.j = new Listener() {
            public void onErrorResponse(VolleyError volleyError) {
                AdViewController.this.a(volleyError);
            }

            public void onSuccess(AdResponse adResponse) {
                AdViewController.this.a(adResponse);
            }
        };
        this.i = new Runnable() {
            public void run() {
                AdViewController.this.l();
            }
        };
        this.y = Integer.valueOf(60000);
        this.l = new Handler();
    }

    @NonNull
    @VisibleForTesting
    static MoPubErrorCode a(@NonNull VolleyError volleyError, @Nullable Context context) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (!(volleyError instanceof MoPubNetworkError)) {
            return networkResponse == null ? !DeviceUtils.isNetworkAvailable(context) ? MoPubErrorCode.NO_CONNECTION : MoPubErrorCode.UNSPECIFIED : volleyError.networkResponse.statusCode >= 400 ? MoPubErrorCode.SERVER_ERROR : MoPubErrorCode.UNSPECIFIED;
        } else {
            switch (((MoPubNetworkError) volleyError).getReason()) {
                case WARMING_UP:
                    return MoPubErrorCode.WARMUP;
                case NO_FILL:
                    return MoPubErrorCode.NO_FILL;
                default:
                    return MoPubErrorCode.UNSPECIFIED;
            }
        }
    }

    private void b(boolean z) {
        Object obj = (!this.u || this.p == z) ? null : 1;
        if (obj != null) {
            MoPubLog.d("Refresh " + (z ? "enabled" : "disabled") + " for ad unit (" + this.v + ").");
        }
        this.p = z;
        if (this.u && this.p) {
            j();
        } else if (!this.p) {
            m();
        }
    }

    private static boolean b(View view) {
        return c.get(view) != null;
    }

    private LayoutParams c(View view) {
        Integer width;
        Integer num = null;
        if (this.h != null) {
            width = this.h.getWidth();
            num = this.h.getHeight();
        } else {
            width = null;
        }
        return (width == null || num == null || !b(view) || width.intValue() <= 0 || num.intValue() <= 0) ? b : new LayoutParams(Dips.asIntPixels((float) width.intValue(), this.e), Dips.asIntPixels((float) num.intValue(), this.e), 17);
    }

    private void l() {
        this.u = true;
        if (TextUtils.isEmpty(this.v)) {
            MoPubLog.d("Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
        } else if (n()) {
            a(i());
        } else {
            MoPubLog.d("Can't load an ad because there is no network connectivity.");
            j();
        }
    }

    private void m() {
        this.l.removeCallbacks(this.i);
    }

    private boolean n() {
        if (this.e == null) {
            return false;
        }
        if (!DeviceUtils.isPermissionGranted(this.e, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.e.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        return z;
    }

    public static void setShouldHonorServerDimensions(View view) {
        c.put(view, Boolean.valueOf(true));
    }

    void a() {
        this.m = false;
        if (this.x != null) {
            if (!this.x.isCanceled()) {
                this.x.cancel();
            }
            this.x = null;
        }
    }

    void a(final View view) {
        this.l.post(new Runnable() {
            public void run() {
                MoPubView moPubView = AdViewController.this.getMoPubView();
                if (moPubView != null) {
                    moPubView.removeAllViews();
                    moPubView.addView(view, AdViewController.this.c(view));
                }
            }
        });
    }

    void a(MoPubErrorCode moPubErrorCode) {
        this.m = false;
        Log.v("MoPub", "MoPubErrorCode: " + (moPubErrorCode == null ? "" : moPubErrorCode.toString()));
        String failoverUrl = this.h == null ? "" : this.h.getFailoverUrl();
        if (TextUtils.isEmpty(failoverUrl)) {
            b(MoPubErrorCode.NO_FILL);
            return;
        }
        MoPubLog.d("Loading failover url: " + failoverUrl);
        a(failoverUrl);
    }

    @VisibleForTesting
    void a(@Nullable MoPubView moPubView, @Nullable String str, @NonNull Map<String, String> map) {
        Preconditions.checkNotNull(map);
        if (moPubView == null) {
            MoPubLog.d("Can't load an ad in this ad view because it was destroyed.");
        } else {
            moPubView.a(str, (Map) map);
        }
    }

    @VisibleForTesting
    void a(@NonNull AdResponse adResponse) {
        this.a = 1;
        this.h = adResponse;
        this.w = this.h.getAdTimeoutMillis() == null ? this.w : this.h.getAdTimeoutMillis().intValue();
        this.y = this.h.getRefreshTimeMillis();
        a();
        a(this.f, adResponse.getCustomEventClassName(), adResponse.getServerExtras());
        j();
    }

    @VisibleForTesting
    void a(VolleyError volleyError) {
        if (volleyError instanceof MoPubNetworkError) {
            MoPubNetworkError moPubNetworkError = (MoPubNetworkError) volleyError;
            if (moPubNetworkError.getRefreshTimeMillis() != null) {
                this.y = moPubNetworkError.getRefreshTimeMillis();
            }
        }
        MoPubErrorCode a = a(volleyError, this.e);
        if (a == MoPubErrorCode.SERVER_ERROR) {
            this.a++;
        }
        a();
        b(a);
    }

    void a(String str) {
        if (str != null) {
            MoPubLog.d("Loading url: " + str);
            if (!this.m) {
                this.n = str;
                this.m = true;
                b(this.n);
            } else if (!TextUtils.isEmpty(this.v)) {
                MoPubLog.i("Already loading an ad for " + this.v + ", wait to finish.");
            }
        }
    }

    void a(Map<String, Object> map) {
        this.o = map != null ? new TreeMap(map) : new TreeMap();
    }

    void a(boolean z) {
        this.q = z;
        b(z);
    }

    void b() {
        this.q = this.p;
        b(false);
    }

    void b(MoPubErrorCode moPubErrorCode) {
        MoPubLog.i("Ad failed to load.");
        a();
        MoPubView moPubView = getMoPubView();
        if (moPubView != null) {
            j();
            moPubView.a(moPubErrorCode);
        }
    }

    void b(String str) {
        MoPubView moPubView = getMoPubView();
        if (moPubView == null || this.e == null) {
            MoPubLog.d("Can't load an ad in this ad view because it was destroyed.");
            a();
            return;
        }
        Request adRequest = new AdRequest(str, moPubView.getAdFormat(), this.v, this.e, this.j);
        Networking.getRequestQueue(this.e).add(adRequest);
        this.x = adRequest;
    }

    void c() {
        b(this.q);
    }

    void d() {
        if (!this.k) {
            if (this.x != null) {
                this.x.cancel();
                this.x = null;
            }
            b(false);
            m();
            this.f = null;
            this.e = null;
            this.g = null;
            this.k = true;
        }
    }

    Integer e() {
        return Integer.valueOf(this.w);
    }

    void f() {
        if (this.h != null) {
            TrackingRequest.makeTrackingHttpRequest(this.h.getImpressionTrackingUrl(), this.e, Name.IMPRESSION_REQUEST);
        }
    }

    void g() {
        if (this.h != null) {
            TrackingRequest.makeTrackingHttpRequest(this.h.getClickTrackingUrl(), this.e, Name.CLICK_REQUEST);
        }
    }

    public int getAdHeight() {
        return (this.h == null || this.h.getHeight() == null) ? 0 : this.h.getHeight().intValue();
    }

    @Nullable
    public AdReport getAdReport() {
        return (this.v == null || this.h == null) ? null : new AdReport(this.v, ClientMetadata.getInstance(this.e), this.h);
    }

    public String getAdUnitId() {
        return this.v;
    }

    public int getAdWidth() {
        return (this.h == null || this.h.getWidth() == null) ? 0 : this.h.getWidth().intValue();
    }

    public boolean getAutorefreshEnabled() {
        return this.p;
    }

    public long getBroadcastIdentifier() {
        return this.d;
    }

    public String getKeywords() {
        return this.r;
    }

    public Location getLocation() {
        return this.s;
    }

    @Nullable
    public MoPubView getMoPubView() {
        return this.f;
    }

    public boolean getTesting() {
        return this.t;
    }

    void h() {
        a();
        loadAd();
    }

    @Nullable
    String i() {
        return this.g == null ? null : this.g.withAdUnitId(this.v).withKeywords(this.r).withLocation(this.s).generateUrlString(Constants.HOST);
    }

    void j() {
        m();
        if (this.p && this.y != null && this.y.intValue() > 0) {
            this.l.postDelayed(this.i, Math.min(600000, ((long) this.y.intValue()) * ((long) Math.pow(1.5d, (double) this.a))));
        }
    }

    Map<String, Object> k() {
        return this.o != null ? new TreeMap(this.o) : new TreeMap();
    }

    public void loadAd() {
        this.a = 1;
        l();
    }

    public void reload() {
        MoPubLog.d("Reload ad: " + this.n);
        a(this.n);
    }

    public void setAdUnitId(@NonNull String str) {
        this.v = str;
    }

    public void setKeywords(String str) {
        this.r = str;
    }

    public void setLocation(Location location) {
        this.s = location;
    }

    public void setTesting(boolean z) {
        this.t = z;
    }
}
