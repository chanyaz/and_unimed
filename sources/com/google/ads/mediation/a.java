package com.google.ads.mediation;

import android.view.View;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.e;
import com.google.android.gms.ads.mediation.c;

final class a extends c {
    private final NativeAppInstallAd e;

    public a(NativeAppInstallAd nativeAppInstallAd) {
        this.e = nativeAppInstallAd;
        a(nativeAppInstallAd.b().toString());
        a(nativeAppInstallAd.c());
        b(nativeAppInstallAd.d().toString());
        a(nativeAppInstallAd.e());
        c(nativeAppInstallAd.f().toString());
        if (nativeAppInstallAd.g() != null) {
            a(nativeAppInstallAd.g().doubleValue());
        }
        if (nativeAppInstallAd.h() != null) {
            d(nativeAppInstallAd.h().toString());
        }
        if (nativeAppInstallAd.i() != null) {
            e(nativeAppInstallAd.i().toString());
        }
        a(true);
        b(true);
        a(nativeAppInstallAd.j());
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
