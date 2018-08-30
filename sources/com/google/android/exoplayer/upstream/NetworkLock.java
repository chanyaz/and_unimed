package com.google.android.exoplayer.upstream;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;
import java.util.PriorityQueue;

public final class NetworkLock {
    public static final NetworkLock a = new NetworkLock();
    private final Object b = new Object();
    private final PriorityQueue<Integer> c = new PriorityQueue();
    private int d = MoPubClientPositioning.NO_REPEAT;

    public class PriorityTooLowException extends IOException {
    }

    private NetworkLock() {
    }

    public void a(int i) {
        synchronized (this.b) {
            this.c.add(Integer.valueOf(i));
            this.d = Math.min(this.d, i);
        }
    }

    public void b(int i) {
        synchronized (this.b) {
            this.c.remove(Integer.valueOf(i));
            this.d = this.c.isEmpty() ? MoPubClientPositioning.NO_REPEAT : ((Integer) this.c.peek()).intValue();
            this.b.notifyAll();
        }
    }
}
