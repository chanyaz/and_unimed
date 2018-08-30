package com.google.android.gms.internal.ads;

final class all extends ake {
    private final /* synthetic */ alk a;

    all(alk alk) {
        this.a = alk;
    }

    public final void onAdFailedToLoad(int i) {
        this.a.d.a(this.a.l());
        super.onAdFailedToLoad(i);
    }

    public final void onAdLoaded() {
        this.a.d.a(this.a.l());
        super.onAdLoaded();
    }
}
