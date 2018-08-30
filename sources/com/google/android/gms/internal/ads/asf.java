package com.google.android.gms.internal.ads;

final /* synthetic */ class asf implements Runnable {
    private final asc a;
    private final String b;

    asf(asc asc, String str) {
        this.a = asc;
        this.b = str;
    }

    public final void run() {
        this.a.c(this.b);
    }
}
