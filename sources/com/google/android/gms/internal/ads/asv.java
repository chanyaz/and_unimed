package com.google.android.gms.internal.ads;

final class asv implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ asp b;

    asv(asp asp, String str) {
        this.b = asp;
        this.a = str;
    }

    public final void run() {
        this.b.a.loadData(this.a, "text/html", "UTF-8");
    }
}
