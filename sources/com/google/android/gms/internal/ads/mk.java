package com.google.android.gms.internal.ads;

final class mk implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ mg b;

    mk(mg mgVar, boolean z) {
        this.b = mgVar;
        this.a = z;
    }

    public final void run() {
        this.b.a("windowVisibilityChanged", "isVisible", String.valueOf(this.a));
    }
}
