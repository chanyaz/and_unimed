package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

final class aur implements Callable<auo> {
    private final /* synthetic */ aul a;
    private final /* synthetic */ auq b;

    aur(auq auq, aul aul) {
        this.b = auq;
        this.a = aul;
    }

    private final auo a() {
        synchronized (this.b.i) {
            if (this.b.j) {
                return null;
            }
            return this.a.a(this.b.f, this.b.g);
        }
    }
}
