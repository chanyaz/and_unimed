package com.mopub.mobileads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;

public class VastVideoViewCountdownRunnable extends RepeatingHandlerRunnable {
    @NonNull
    private final VastVideoViewController c;

    public VastVideoViewCountdownRunnable(@NonNull VastVideoViewController vastVideoViewController, @NonNull Handler handler) {
        super(handler);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(vastVideoViewController);
        this.c = vastVideoViewController;
    }

    public void doWork() {
        this.c.m();
        if (this.c.l()) {
            this.c.k();
        }
    }
}
