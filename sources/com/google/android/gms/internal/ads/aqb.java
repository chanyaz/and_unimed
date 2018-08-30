package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener;

@zzadh
public final class aqb extends api {
    private final OnAppInstallAdLoadedListener a;

    public aqb(OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.a = onAppInstallAdLoadedListener;
    }

    public final void zza(zzqk zzqk) {
        this.a.onAppInstallAdLoaded(new apb(zzqk));
    }
}
