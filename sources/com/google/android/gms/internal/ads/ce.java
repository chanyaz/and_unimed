package com.google.android.gms.internal.ads;

final class ce implements Runnable {
    private final /* synthetic */ bw a;

    ce(bw bwVar) {
        this.a = bwVar;
    }

    public final void run() {
        synchronized (this.a.d) {
            if (this.a.a == null) {
                return;
            }
            this.a.b();
            this.a.a(2, "Timed out waiting for ad response.");
        }
    }
}
