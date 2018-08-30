package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener;

@zzadh
public final class aqg extends apt {
    private final OnUnifiedNativeAdLoadedListener a;

    public aqg(OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
        this.a = onUnifiedNativeAdLoadedListener;
    }

    public final void zza(zzrr zzrr) {
        this.a.onUnifiedNativeAdLoaded(new apy(zzrr));
    }
}
