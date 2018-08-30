package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNative.MoPubNativeNetworkListener;
import java.util.ArrayList;
import java.util.List;

class NativeAdSource {
    @VisibleForTesting
    static final int[] a = new int[]{1000, 3000, 5000, 25000, 60000, 300000};
    @VisibleForTesting
    boolean b;
    @VisibleForTesting
    boolean c;
    @VisibleForTesting
    int d;
    @VisibleForTesting
    int e;
    @NonNull
    private final List<w<NativeAd>> f;
    @NonNull
    private final Handler g;
    @NonNull
    private final Runnable h;
    @NonNull
    private final MoPubNativeNetworkListener i;
    @Nullable
    private AdSourceListener j;
    @Nullable
    private RequestParameters k;
    @Nullable
    private MoPubNative l;
    @NonNull
    private final AdRendererRegistry m;

    interface AdSourceListener {
        void onAdsAvailable();
    }

    NativeAdSource() {
        this(new ArrayList(1), new Handler(), new AdRendererRegistry());
    }

    @VisibleForTesting
    NativeAdSource(@NonNull List<w<NativeAd>> list, @NonNull Handler handler, @NonNull AdRendererRegistry adRendererRegistry) {
        this.f = list;
        this.g = handler;
        this.h = new Runnable() {
            public void run() {
                NativeAdSource.this.c = false;
                NativeAdSource.this.g();
            }
        };
        this.m = adRendererRegistry;
        this.i = new MoPubNativeNetworkListener() {
            public void onNativeFail(NativeErrorCode nativeErrorCode) {
                NativeAdSource.this.b = false;
                if (NativeAdSource.this.e >= NativeAdSource.a.length - 1) {
                    NativeAdSource.this.e();
                    return;
                }
                NativeAdSource.this.d();
                NativeAdSource.this.c = true;
                NativeAdSource.this.g.postDelayed(NativeAdSource.this.h, (long) NativeAdSource.this.f());
            }

            public void onNativeLoad(@NonNull NativeAd nativeAd) {
                if (NativeAdSource.this.l != null) {
                    NativeAdSource.this.b = false;
                    NativeAdSource nativeAdSource = NativeAdSource.this;
                    nativeAdSource.d++;
                    NativeAdSource.this.e();
                    NativeAdSource.this.f.add(new w(nativeAd));
                    if (NativeAdSource.this.f.size() == 1 && NativeAdSource.this.j != null) {
                        NativeAdSource.this.j.onAdsAvailable();
                    }
                    NativeAdSource.this.g();
                }
            }
        };
        this.d = 0;
        e();
    }

    int a() {
        return this.m.getAdRendererCount();
    }

    void a(@NonNull Activity activity, @NonNull String str, RequestParameters requestParameters) {
        a(requestParameters, new MoPubNative(activity, str, this.i));
    }

    void a(@NonNull MoPubAdRenderer moPubAdRenderer) {
        this.m.registerAdRenderer(moPubAdRenderer);
        if (this.l != null) {
            this.l.registerAdRenderer(moPubAdRenderer);
        }
    }

    void a(@Nullable AdSourceListener adSourceListener) {
        this.j = adSourceListener;
    }

    @VisibleForTesting
    void a(RequestParameters requestParameters, MoPubNative moPubNative) {
        b();
        for (MoPubAdRenderer registerAdRenderer : this.m.getRendererIterable()) {
            moPubNative.registerAdRenderer(registerAdRenderer);
        }
        this.k = requestParameters;
        this.l = moPubNative;
        g();
    }

    void b() {
        if (this.l != null) {
            this.l.destroy();
            this.l = null;
        }
        this.k = null;
        for (w wVar : this.f) {
            ((NativeAd) wVar.a).destroy();
        }
        this.f.clear();
        this.g.removeMessages(0);
        this.b = false;
        this.d = 0;
        e();
    }

    @Nullable
    NativeAd c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!(this.b || this.c)) {
            this.g.post(this.h);
        }
        while (!this.f.isEmpty()) {
            w wVar = (w) this.f.remove(0);
            if (uptimeMillis - wVar.b < 900000) {
                return (NativeAd) wVar.a;
            }
        }
        return null;
    }

    @VisibleForTesting
    void d() {
        if (this.e < a.length - 1) {
            this.e++;
        }
    }

    @VisibleForTesting
    void e() {
        this.e = 0;
    }

    @VisibleForTesting
    int f() {
        if (this.e >= a.length) {
            this.e = a.length - 1;
        }
        return a[this.e];
    }

    @VisibleForTesting
    void g() {
        if (!this.b && this.l != null && this.f.size() < 1) {
            this.b = true;
            this.l.makeRequest(this.k, Integer.valueOf(this.d));
        }
    }

    @Nullable
    public MoPubAdRenderer getAdRendererForViewType(int i) {
        return this.m.getRendererForViewType(i);
    }

    public int getViewTypeForAd(@NonNull NativeAd nativeAd) {
        return this.m.getViewTypeForAd(nativeAd);
    }
}
