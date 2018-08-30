package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.Collections;
import java.util.List;

@KeepForSdk
@VisibleForTesting
public class c<T extends AnyClient, O> {
    @KeepForSdk
    public int a() {
        return MoPubClientPositioning.NO_REPEAT;
    }

    @KeepForSdk
    public List<Scope> a(O o) {
        return Collections.emptyList();
    }
}
