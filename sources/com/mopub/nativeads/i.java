package com.mopub.nativeads;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.EventDetails;
import com.mopub.mobileads.VastVideoConfig;
import java.util.List;

@TargetApi(16)
@VisibleForTesting
class i {
    i() {
    }

    public NativeVideoController createForId(long j, @NonNull Context context, @NonNull List<VisibilityTrackingEvent> list, @NonNull VastVideoConfig vastVideoConfig, @Nullable EventDetails eventDetails) {
        return NativeVideoController.createForId(j, context, list, vastVideoConfig, eventDetails);
    }
}
