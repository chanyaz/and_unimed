package com.mopub.common;

import android.os.SystemClock;
import com.mopub.common.DoubleTimeTracker.Clock;

class i implements Clock {
    private i() {
    }

    public long elapsedRealTime() {
        return SystemClock.elapsedRealtime();
    }
}
