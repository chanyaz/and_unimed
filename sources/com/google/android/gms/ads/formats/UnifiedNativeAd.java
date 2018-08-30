package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.k;
import java.util.List;

public abstract class UnifiedNativeAd {

    public interface OnUnifiedNativeAdLoadedListener {
        void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd);
    }

    public interface UnconfirmedClickListener {
        void onUnconfirmedClickCancelled();

        void onUnconfirmedClickReceived(String str);
    }

    public abstract String a();

    public abstract List<c> b();

    public abstract String c();

    public abstract c d();

    public abstract String e();

    public abstract String f();

    public abstract Double g();

    public abstract String h();

    public abstract String i();

    public abstract k j();

    protected abstract Object k();

    public abstract Object l();
}
