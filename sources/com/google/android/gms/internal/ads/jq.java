package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.au;
import javax.annotation.concurrent.GuardedBy;

@zzadh
public final class jq {
    private long a;
    @GuardedBy("mLock")
    private long b = Long.MIN_VALUE;
    private Object c = new Object();

    public jq(long j) {
        this.a = j;
    }

    public final boolean a() {
        boolean z;
        synchronized (this.c) {
            long elapsedRealtime = au.l().elapsedRealtime();
            if (this.b + this.a > elapsedRealtime) {
                z = false;
            } else {
                this.b = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
