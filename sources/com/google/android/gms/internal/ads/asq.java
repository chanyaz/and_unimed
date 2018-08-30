package com.google.android.gms.internal.ads;

final /* synthetic */ class asq implements Runnable {
    private final asp a;
    private final String b;

    asq(asp asp, String str) {
        this.a = asp;
        this.b = str;
    }

    public final void run() {
        this.a.a(this.b);
    }
}
