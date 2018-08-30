package com.google.android.gms.internal.ads;

final /* synthetic */ class asi implements Runnable {
    private final asc a;
    private final String b;

    asi(asc asc, String str) {
        this.a = asc;
        this.b = str;
    }

    public final void run() {
        this.a.a(this.b);
    }
}
