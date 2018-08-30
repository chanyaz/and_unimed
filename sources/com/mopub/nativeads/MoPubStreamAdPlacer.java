package com.mopub.nativeads;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubServerPositioning;
import com.mopub.nativeads.PositioningSource.PositioningListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

public class MoPubStreamAdPlacer {
    public static final int CONTENT_VIEW_TYPE = 0;
    private static final MoPubNativeAdLoadedListener a = new MoPubNativeAdLoadedListener() {
        public void onAdLoaded(int i) {
        }

        public void onAdRemoved(int i) {
        }
    };
    @NonNull
    private final Activity b;
    @NonNull
    private final Handler c;
    @NonNull
    private final Runnable d;
    @NonNull
    private final PositioningSource e;
    @NonNull
    private final NativeAdSource f;
    @NonNull
    private final HashMap<NativeAd, WeakReference<View>> g;
    @NonNull
    private final WeakHashMap<View, NativeAd> h;
    private boolean i;
    @Nullable
    private r j;
    private boolean k;
    private boolean l;
    @NonNull
    private r m;
    @Nullable
    private String n;
    @NonNull
    private MoPubNativeAdLoadedListener o;
    private int p;
    private int q;
    private int r;
    private boolean s;

    public MoPubStreamAdPlacer(@NonNull Activity activity) {
        this(activity, MoPubNativeAdPositioning.serverPositioning());
    }

    public MoPubStreamAdPlacer(@NonNull Activity activity, @NonNull MoPubClientPositioning moPubClientPositioning) {
        this(activity, new NativeAdSource(), new a(moPubClientPositioning));
    }

    public MoPubStreamAdPlacer(@NonNull Activity activity, @NonNull MoPubServerPositioning moPubServerPositioning) {
        this(activity, new NativeAdSource(), new t(activity));
    }

    @VisibleForTesting
    MoPubStreamAdPlacer(@NonNull Activity activity, @NonNull NativeAdSource nativeAdSource, @NonNull PositioningSource positioningSource) {
        this.o = a;
        Preconditions.checkNotNull(activity, "activity is not allowed to be null");
        Preconditions.checkNotNull(nativeAdSource, "adSource is not allowed to be null");
        Preconditions.checkNotNull(positioningSource, "positioningSource is not allowed to be null");
        this.b = activity;
        this.e = positioningSource;
        this.f = nativeAdSource;
        this.m = r.a();
        this.h = new WeakHashMap();
        this.g = new HashMap();
        this.c = new Handler();
        this.d = new Runnable() {
            public void run() {
                if (MoPubStreamAdPlacer.this.s) {
                    MoPubStreamAdPlacer.this.c();
                    MoPubStreamAdPlacer.this.s = false;
                }
            }
        };
        this.p = 0;
        this.q = 0;
    }

    private void a(@Nullable View view) {
        if (view != null) {
            NativeAd nativeAd = (NativeAd) this.h.get(view);
            if (nativeAd != null) {
                nativeAd.clear(view);
                this.h.remove(view);
                this.g.remove(nativeAd);
            }
        }
    }

    private void a(@NonNull NativeAd nativeAd, @NonNull View view) {
        this.g.put(nativeAd, new WeakReference(view));
        this.h.put(view, nativeAd);
        nativeAd.prepare(view);
    }

    private void a(r rVar) {
        removeAdsInRange(0, this.r);
        this.m = rVar;
        c();
        this.l = true;
    }

    private boolean a(int i) {
        NativeAd c = this.f.c();
        if (c == null) {
            return false;
        }
        this.m.a(i, c);
        this.r++;
        this.o.onAdLoaded(i);
        return true;
    }

    private boolean a(int i, int i2) {
        int i3 = i2 - 1;
        while (i <= i3 && i != -1 && i < this.r) {
            if (this.m.a(i)) {
                if (!a(i)) {
                    return false;
                }
                i3++;
            }
            i = this.m.b(i);
        }
        return true;
    }

    private void b() {
        if (!this.s) {
            this.s = true;
            this.c.post(this.d);
        }
    }

    private void c() {
        if (a(this.p, this.q)) {
            a(this.q, this.q + 6);
        }
    }

    @VisibleForTesting
    void a() {
        if (this.l) {
            b();
            return;
        }
        if (this.i) {
            a(this.j);
        }
        this.k = true;
    }

    @VisibleForTesting
    void a(@NonNull MoPubClientPositioning moPubClientPositioning) {
        r a = r.a(moPubClientPositioning);
        if (this.k) {
            a(a);
        } else {
            this.j = a;
        }
        this.i = true;
    }

    public void bindAdView(@NonNull NativeAd nativeAd, @NonNull View view) {
        WeakReference weakReference = (WeakReference) this.g.get(nativeAd);
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (!view.equals(view2)) {
            a(view2);
            a(view);
            a(nativeAd, view);
            nativeAd.renderAdView(view);
        }
    }

    public void clearAds() {
        removeAdsInRange(0, this.r);
        this.f.b();
    }

    public void destroy() {
        this.c.removeMessages(0);
        this.f.b();
        this.m.c();
    }

    @Nullable
    public Object getAdData(int i) {
        return this.m.d(i);
    }

    @Nullable
    public MoPubAdRenderer getAdRendererForViewType(int i) {
        return this.f.getAdRendererForViewType(i);
    }

    @Nullable
    public View getAdView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        NativeAd d = this.m.d(i);
        if (d == null) {
            return null;
        }
        if (view == null) {
            view = d.createAdView(this.b, viewGroup);
        }
        bindAdView(d, view);
        return view;
    }

    public int getAdViewType(int i) {
        NativeAd d = this.m.d(i);
        return d == null ? 0 : this.f.getViewTypeForAd(d);
    }

    public int getAdViewTypeCount() {
        return this.f.a();
    }

    public int getAdjustedCount(int i) {
        return this.m.h(i);
    }

    public int getAdjustedPosition(int i) {
        return this.m.f(i);
    }

    public int getOriginalCount(int i) {
        return this.m.g(i);
    }

    public int getOriginalPosition(int i) {
        return this.m.e(i);
    }

    public void insertItem(int i) {
        this.m.i(i);
    }

    public boolean isAd(int i) {
        return this.m.c(i);
    }

    public void loadAds(@NonNull String str) {
        loadAds(str, null);
    }

    public void loadAds(@NonNull String str, @Nullable RequestParameters requestParameters) {
        if (!NoThrow.checkNotNull(str, "Cannot load ads with a null ad unit ID")) {
            return;
        }
        if (this.f.a() == 0) {
            MoPubLog.w("You must register at least 1 ad renderer by calling registerAdRenderer before loading ads");
            return;
        }
        this.n = str;
        this.l = false;
        this.i = false;
        this.k = false;
        this.e.loadPositions(str, new PositioningListener() {
            public void onFailed() {
                MoPubLog.d("Unable to show ads because ad positions could not be loaded from the MoPub ad server.");
            }

            public void onLoad(@NonNull MoPubClientPositioning moPubClientPositioning) {
                MoPubStreamAdPlacer.this.a(moPubClientPositioning);
            }
        });
        this.f.a(new AdSourceListener() {
            public void onAdsAvailable() {
                MoPubStreamAdPlacer.this.a();
            }
        });
        this.f.a(this.b, str, requestParameters);
    }

    public void moveItem(int i, int i2) {
        this.m.b(i, i2);
    }

    public void placeAdsInRange(int i, int i2) {
        this.p = i;
        this.q = Math.min(i2, i + 100);
        b();
    }

    public void registerAdRenderer(@NonNull MoPubAdRenderer moPubAdRenderer) {
        if (NoThrow.checkNotNull(moPubAdRenderer, "Cannot register a null adRenderer")) {
            this.f.a(moPubAdRenderer);
        }
    }

    public int removeAdsInRange(int i, int i2) {
        int[] b = this.m.b();
        int f = this.m.f(i);
        int f2 = this.m.f(i2);
        ArrayList arrayList = new ArrayList();
        for (int length = b.length - 1; length >= 0; length--) {
            int i3 = b[length];
            if (i3 >= f && i3 < f2) {
                arrayList.add(Integer.valueOf(i3));
                if (i3 < this.p) {
                    this.p--;
                }
                this.r--;
            }
        }
        int a = this.m.a(f, f2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.o.onAdRemoved(((Integer) it.next()).intValue());
        }
        return a;
    }

    public void removeItem(int i) {
        this.m.j(i);
    }

    public void setAdLoadedListener(@Nullable MoPubNativeAdLoadedListener moPubNativeAdLoadedListener) {
        if (moPubNativeAdLoadedListener == null) {
            moPubNativeAdLoadedListener = a;
        }
        this.o = moPubNativeAdLoadedListener;
    }

    public void setItemCount(int i) {
        this.r = this.m.h(i);
        if (this.l) {
            b();
        }
    }
}
