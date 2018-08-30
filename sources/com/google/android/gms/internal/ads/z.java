package com.google.android.gms.internal.ads;

final class z implements Runnable {
    private final /* synthetic */ y a;

    z(y yVar) {
        this.a = yVar;
    }

    public final void run() {
        if (this.a.h.get()) {
            kk.c("Timed out waiting for WebView to finish loading.");
            this.a.cancel();
        }
    }
}
