package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

final /* synthetic */ class ky implements Runnable {
    private final zzanz a;
    private final Future b;

    ky(zzanz zzanz, Future future) {
        this.a = zzanz;
        this.b = future;
    }

    public final void run() {
        zzanz zzanz = this.a;
        Future future = this.b;
        if (zzanz.isCancelled()) {
            future.cancel(true);
        }
    }
}
