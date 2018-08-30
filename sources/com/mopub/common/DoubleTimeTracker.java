package com.mopub.common;

import android.support.annotation.NonNull;
import com.mopub.common.logging.MoPubLog;

public class DoubleTimeTracker {
    @NonNull
    private volatile h a;
    private long b;
    private long c;
    @NonNull
    private final Clock d;

    public interface Clock {
        long elapsedRealTime();
    }

    public DoubleTimeTracker() {
        this(new i());
    }

    @VisibleForTesting
    public DoubleTimeTracker(@NonNull Clock clock) {
        this.d = clock;
        this.a = h.PAUSED;
    }

    private synchronized long a() {
        return this.a == h.PAUSED ? 0 : this.d.elapsedRealTime() - this.b;
    }

    public synchronized double getInterval() {
        return (double) (this.c + a());
    }

    public synchronized void pause() {
        if (this.a == h.PAUSED) {
            MoPubLog.v("DoubleTimeTracker already paused.");
        } else {
            this.c += a();
            this.b = 0;
            this.a = h.PAUSED;
        }
    }

    public synchronized void start() {
        if (this.a == h.STARTED) {
            MoPubLog.v("DoubleTimeTracker already started.");
        } else {
            this.a = h.STARTED;
            this.b = this.d.elapsedRealTime();
        }
    }
}
