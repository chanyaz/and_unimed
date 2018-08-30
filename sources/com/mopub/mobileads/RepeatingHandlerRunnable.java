package com.mopub.mobileads;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.mopub.common.Preconditions;

public abstract class RepeatingHandlerRunnable implements Runnable {
    @NonNull
    protected final Handler a;
    protected volatile long b;
    private volatile boolean c;

    public RepeatingHandlerRunnable(@NonNull Handler handler) {
        Preconditions.checkNotNull(handler);
        this.a = handler;
    }

    public abstract void doWork();

    public void run() {
        if (this.c) {
            doWork();
            this.a.postDelayed(this, this.b);
        }
    }

    public void startRepeating(long j) {
        Preconditions.checkArgument(j > 0, "intervalMillis must be greater than 0. Saw: %d", Long.valueOf(j));
        this.b = j;
        if (!this.c) {
            this.c = true;
            this.a.post(this);
        }
    }

    public void stop() {
        this.c = false;
    }
}
