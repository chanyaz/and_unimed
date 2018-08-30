package com.google.android.gms.stats;

final class b implements Runnable {
    private final /* synthetic */ WakeLock a;

    b(WakeLock wakeLock) {
        this.a = wakeLock;
    }

    public final void run() {
        this.a.a(0);
    }
}
