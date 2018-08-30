package com.google.ads.mediation;

import com.google.android.gms.ads.a;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class f extends a implements OnAppInstallAdLoadedListener, OnContentAdLoadedListener, OnCustomClickListener, OnCustomTemplateAdLoadedListener, OnUnifiedNativeAdLoadedListener {
    @VisibleForTesting
    private final AbstractAdViewAdapter a;
    @VisibleForTesting
    private final MediationNativeListener b;

    public f(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
        this.a = abstractAdViewAdapter;
        this.b = mediationNativeListener;
    }

    public final void onAdClicked() {
        this.b.onAdClicked(this.a);
    }

    public final void onAdClosed() {
        this.b.onAdClosed(this.a);
    }

    public final void onAdFailedToLoad(int i) {
        this.b.onAdFailedToLoad(this.a, i);
    }

    public final void onAdImpression() {
        this.b.onAdImpression(this.a);
    }

    public final void onAdLeftApplication() {
        this.b.onAdLeftApplication(this.a);
    }

    public final void onAdLoaded() {
    }

    public final void onAdOpened() {
        this.b.onAdOpened(this.a);
    }

    public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
        this.b.onAdLoaded(this.a, new a(nativeAppInstallAd));
    }

    public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
        this.b.onAdLoaded(this.a, new b(nativeContentAd));
    }

    public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        this.b.zza(this.a, nativeCustomTemplateAd, str);
    }

    public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
        this.b.zza(this.a, nativeCustomTemplateAd);
    }

    public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
        this.b.onAdLoaded(this.a, new c(unifiedNativeAd));
    }
}
