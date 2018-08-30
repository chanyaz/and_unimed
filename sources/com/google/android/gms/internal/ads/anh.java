package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzadh
public final class anh extends anf {
    private final OnCustomRenderedAdLoadedListener a;

    public anh(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.a = onCustomRenderedAdLoadedListener;
    }

    public final void zza(zzoa zzoa) {
        this.a.onCustomRenderedAdLoaded(new anc(zzoa));
    }
}
