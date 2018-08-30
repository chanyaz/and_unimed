package com.google.android.gms.internal.ads;

final class aqv implements zzts {
    private final /* synthetic */ int a;

    aqv(aqt aqt, int i) {
        this.a = i;
    }

    public final void zzb(arr arr) {
        if (arr.a != null) {
            arr.a.onAdFailedToLoad(this.a);
        }
    }
}
