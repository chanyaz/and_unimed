package com.google.android.gms.internal.ads;

final /* synthetic */ class asg implements Runnable {
    private final asc a;
    private final String b;

    asg(asc asc, String str) {
        this.a = asc;
        this.b = str;
    }

    public final void run() {
        this.a.b(this.b);
    }
}
