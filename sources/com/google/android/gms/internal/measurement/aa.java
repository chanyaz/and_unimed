package com.google.android.gms.internal.measurement;

final class aa implements Runnable {
    private final /* synthetic */ String a;
    private final /* synthetic */ Runnable b;
    private final /* synthetic */ y c;

    aa(y yVar, String str, Runnable runnable) {
        this.c = yVar;
        this.a = str;
        this.b = runnable;
    }

    public final void run() {
        this.c.a.a(this.a);
        if (this.b != null) {
            this.b.run();
        }
    }
}
