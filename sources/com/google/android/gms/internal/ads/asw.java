package com.google.android.gms.internal.ads;

final class asw implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ asp b;

    asw(asp asp, String str) {
        this.b = asp;
        this.a = str;
    }

    public final void run() {
        this.b.a.loadUrl(this.a);
    }
}
