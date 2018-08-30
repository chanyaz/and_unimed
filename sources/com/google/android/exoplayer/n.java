package com.google.android.exoplayer;

import android.os.SystemClock;

final class n implements MediaClock {
    private boolean a;
    private long b;
    private long c;

    n() {
    }

    private long b(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }

    public void a() {
        if (!this.a) {
            this.a = true;
            this.c = b(this.b);
        }
    }

    public void a(long j) {
        this.b = j;
        this.c = b(j);
    }

    public void b() {
        if (this.a) {
            this.b = b(this.c);
            this.a = false;
        }
    }

    public long getPositionUs() {
        return this.a ? b(this.c) : this.b;
    }
}
