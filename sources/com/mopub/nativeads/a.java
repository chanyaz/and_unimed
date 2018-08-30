package com.mopub.nativeads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import com.mopub.nativeads.PositioningSource.PositioningListener;

class a implements PositioningSource {
    @NonNull
    private final Handler a = new Handler();
    @NonNull
    private final MoPubClientPositioning b;

    a(@NonNull MoPubClientPositioning moPubClientPositioning) {
        this.b = MoPubNativeAdPositioning.a(moPubClientPositioning);
    }

    public void loadPositions(@NonNull String str, @NonNull final PositioningListener positioningListener) {
        this.a.post(new Runnable() {
            public void run() {
                positioningListener.onLoad(a.this.b);
            }
        });
    }
}
