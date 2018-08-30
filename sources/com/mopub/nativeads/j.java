package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import com.mopub.common.VisibleForTesting;
import com.mopub.network.TrackingRequest;

@TargetApi(16)
@VisibleForTesting
class j implements OnTrackedStrategy {
    @NonNull
    private final Context a;
    @NonNull
    private final String b;

    j(@NonNull Context context, @NonNull String str) {
        this.a = context.getApplicationContext();
        this.b = str;
    }

    public void execute() {
        TrackingRequest.makeTrackingHttpRequest(this.b, this.a);
    }
}
