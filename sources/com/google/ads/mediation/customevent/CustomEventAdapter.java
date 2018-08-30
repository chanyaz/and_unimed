package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.g;
import com.google.android.gms.ads.mediation.customevent.d;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.kk;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<d, c>, MediationInterstitialAdapter<d, c> {
    private View a;
    @VisibleForTesting
    private CustomEventBanner b;
    @VisibleForTesting
    private CustomEventInterstitial c;

    private static <T> T a(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            kk.e(new StringBuilder((String.valueOf(str).length() + 46) + String.valueOf(message).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(message).toString());
            return null;
        }
    }

    private final void a(View view) {
        this.a = view;
    }

    public final void destroy() {
        if (this.b != null) {
            this.b.destroy();
        }
        if (this.c != null) {
            this.c.destroy();
        }
    }

    public final Class<d> getAdditionalParametersType() {
        return d.class;
    }

    public final View getBannerView() {
        return this.a;
    }

    public final Class<c> getServerParametersType() {
        return c.class;
    }

    public final void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, c cVar, a aVar, g gVar, d dVar) {
        this.b = (CustomEventBanner) a(cVar.b);
        if (this.b == null) {
            mediationBannerListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.b.requestBannerAd(new a(this, mediationBannerListener), activity, cVar.a, cVar.c, aVar, gVar, dVar == null ? null : dVar.a(cVar.a));
        }
    }

    public final void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, c cVar, g gVar, d dVar) {
        this.c = (CustomEventInterstitial) a(cVar.b);
        if (this.c == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        } else {
            this.c.requestInterstitialAd(new b(this, this, mediationInterstitialListener), activity, cVar.a, cVar.c, gVar, dVar == null ? null : dVar.a(cVar.a));
        }
    }

    public final void showInterstitial() {
        this.c.showInterstitial();
    }
}
