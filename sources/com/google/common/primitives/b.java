package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

@GwtCompatible(emulated = true)
public final class b {
    private b() {
    }

    public static int a(int i, int i2) {
        return i < i2 ? -1 : i > i2 ? 1 : 0;
    }

    public static int a(long j) {
        return j > 2147483647L ? MoPubClientPositioning.NO_REPEAT : j < -2147483648L ? Integer.MIN_VALUE : (int) j;
    }
}
