package com.google.android.gms.internal.ads;

final /* synthetic */ class lu implements Runnable {
    private final lt a;
    private final int b;

    lu(lt ltVar, int i) {
        this.a = ltVar;
        this.b = i;
    }

    public final void run() {
        this.a.b(this.b);
    }
}
