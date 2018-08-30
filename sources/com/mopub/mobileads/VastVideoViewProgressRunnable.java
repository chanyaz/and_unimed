package com.mopub.mobileads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;
import com.mopub.network.TrackingRequest;
import java.util.ArrayList;
import java.util.List;

public class VastVideoViewProgressRunnable extends RepeatingHandlerRunnable {
    @NonNull
    private final VastVideoViewController c;
    @NonNull
    private final VastVideoConfig d;

    public VastVideoViewProgressRunnable(@NonNull VastVideoViewController vastVideoViewController, @NonNull VastVideoConfig vastVideoConfig, @NonNull Handler handler) {
        super(handler);
        Preconditions.checkNotNull(vastVideoViewController);
        Preconditions.checkNotNull(vastVideoConfig);
        this.c = vastVideoViewController;
        this.d = vastVideoConfig;
    }

    public void doWork() {
        int i = this.c.i();
        int j = this.c.j();
        this.c.n();
        if (i > 0) {
            List<VastTracker> untriggeredTrackersBefore = this.d.getUntriggeredTrackersBefore(j, i);
            if (!untriggeredTrackersBefore.isEmpty()) {
                List arrayList = new ArrayList();
                for (VastTracker vastTracker : untriggeredTrackersBefore) {
                    arrayList.add(vastTracker.getTrackingUrl());
                    vastTracker.setTracked();
                }
                TrackingRequest.makeTrackingHttpRequest(new VastMacroHelper(arrayList).withAssetUri(this.c.o()).withContentPlayHead(Integer.valueOf(j)).getUris(), this.c.f());
            }
            this.c.a(j);
        }
    }
}
