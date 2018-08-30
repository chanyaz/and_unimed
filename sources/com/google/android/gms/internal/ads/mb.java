package com.google.android.gms.internal.ads;

final class mb implements Runnable {
    private final /* synthetic */ lt a;

    mb(lt ltVar) {
        this.a = ltVar;
    }

    public final void run() {
        if (this.a.r != null) {
            this.a.r.onPaused();
            this.a.r.zzsy();
        }
    }
}
