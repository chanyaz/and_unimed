package com.google.android.gms.internal.measurement;

final class dy implements Runnable {
    private final /* synthetic */ boolean a;
    private final /* synthetic */ dx b;

    dy(dx dxVar, boolean z) {
        this.b = dxVar;
        this.a = z;
    }

    public final void run() {
        this.b.b.a(this.a);
    }
}
