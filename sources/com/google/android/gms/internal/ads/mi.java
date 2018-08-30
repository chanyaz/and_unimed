package com.google.android.gms.internal.ads;

final class mi implements Runnable {
    private final /* synthetic */ mg a;

    mi(mg mgVar) {
        this.a = mgVar;
    }

    public final void run() {
        this.a.a("surfaceCreated", new String[0]);
    }
}
