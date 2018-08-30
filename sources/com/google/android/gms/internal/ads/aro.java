package com.google.android.gms.internal.ads;

final class aro implements zzts {
    private final /* synthetic */ int a;

    aro(arh arh, int i) {
        this.a = i;
    }

    public final void zzb(arr arr) {
        if (arr.f != null) {
            arr.f.onRewardedVideoAdFailedToLoad(this.a);
        }
    }
}
