package com.mopub.common.util;

import java.util.concurrent.TimeUnit;

public class Timer {
    private long a;
    private long b;
    private c c = c.STOPPED;

    public long getTime() {
        return TimeUnit.MILLISECONDS.convert((this.c == c.STARTED ? System.nanoTime() : this.a) - this.b, TimeUnit.NANOSECONDS);
    }

    public void start() {
        this.b = System.nanoTime();
        this.c = c.STARTED;
    }

    public void stop() {
        if (this.c != c.STARTED) {
            throw new IllegalStateException("EventTimer was not started.");
        }
        this.c = c.STOPPED;
        this.a = System.nanoTime();
    }
}
