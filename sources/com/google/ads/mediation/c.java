package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.e;
import java.util.Map;

final class c extends e {
    private final UnifiedNativeAd a;

    public c(UnifiedNativeAd unifiedNativeAd) {
        this.a = unifiedNativeAd;
        a(unifiedNativeAd.a());
        a(unifiedNativeAd.b());
        b(unifiedNativeAd.c());
        a(unifiedNativeAd.d());
        c(unifiedNativeAd.e());
        d(unifiedNativeAd.f());
        a(unifiedNativeAd.g());
        e(unifiedNativeAd.h());
        f(unifiedNativeAd.i());
        a(unifiedNativeAd.l());
        a(true);
        b(true);
        a(unifiedNativeAd.j());
    }

    public final void a(View view, Map<String, View> map, Map<String, View> map2) {
        if (view instanceof UnifiedNativeAdView) {
            ((UnifiedNativeAdView) view).setNativeAd(this.a);
            return;
        }
        com.google.android.gms.ads.formats.e eVar = (com.google.android.gms.ads.formats.e) com.google.android.gms.ads.formats.e.a.get(view);
        if (eVar != null) {
            eVar.a(this.a);
        }
    }
}
