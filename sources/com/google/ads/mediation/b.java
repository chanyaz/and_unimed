package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.e;
import com.google.android.gms.ads.mediation.d;

final class b extends d {
    private final NativeContentAd e;

    public b(NativeContentAd nativeContentAd) {
        this.e = nativeContentAd;
        a(nativeContentAd.b().toString());
        a(nativeContentAd.c());
        b(nativeContentAd.d().toString());
        if (nativeContentAd.e() != null) {
            a(nativeContentAd.e());
        }
        c(nativeContentAd.f().toString());
        d(nativeContentAd.g().toString());
        a(true);
        b(true);
        a(nativeContentAd.h());
    }

    public final void a(View view) {
        if (view instanceof NativeAdView) {
            ((NativeAdView) view).setNativeAd(this.e);
        }
        e eVar = (e) e.a.get(view);
        if (eVar != null) {
            eVar.a(this.e);
        }
    }
}
