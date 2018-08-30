package com.google.android.gms.internal.ads;

final class aeq implements Runnable {
    private final /* synthetic */ apk a;
    private final /* synthetic */ adp b;

    aeq(adp adp, apk apk) {
        this.b = adp;
        this.a = apk;
    }

    public final void run() {
        try {
            this.b.c.put(this.a);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
