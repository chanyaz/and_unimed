package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;
import java.lang.ref.WeakReference;

@TargetApi(16)
@VisibleForTesting
class g implements OnTrackedStrategy {
    @NonNull
    private final WeakReference<MoPubVideoNativeAd> a;

    g(@NonNull MoPubVideoNativeAd moPubVideoNativeAd) {
        this.a = new WeakReference(moPubVideoNativeAd);
    }

    public void execute() {
        MoPubVideoNativeAd moPubVideoNativeAd = (MoPubVideoNativeAd) this.a.get();
        if (moPubVideoNativeAd != null) {
            moPubVideoNativeAd.a();
        }
    }
}
