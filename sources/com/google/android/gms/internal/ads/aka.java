package com.google.android.gms.internal.ads;

final class aka implements Runnable {
    private final apk a;
    private final auj b;
    private final Runnable c;

    public aka(aie aie, apk apk, auj auj, Runnable runnable) {
        this.a = apk;
        this.b = auj;
        this.c = runnable;
    }

    public final void run() {
        this.a.g();
        if ((this.b.c == null ? 1 : null) != null) {
            this.a.a(this.b.a);
        } else {
            this.a.a(this.b.c);
        }
        if (this.b.d) {
            this.a.b("intermediate-response");
        } else {
            this.a.c("done");
        }
        if (this.c != null) {
            this.c.run();
        }
    }
}
