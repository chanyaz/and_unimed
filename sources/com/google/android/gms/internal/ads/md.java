package com.google.android.gms.internal.ads;

final class md implements Runnable {
    private final /* synthetic */ lt a;

    md(lt ltVar) {
        this.a = ltVar;
    }

    public final void run() {
        if (this.a.r != null) {
            this.a.r.onPaused();
        }
    }
}
