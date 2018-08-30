package com.google.android.gms.internal.ads;

import java.util.Map;

final /* synthetic */ class of implements Runnable {
    private final oe a;
    private final Map b;

    of(oe oeVar, Map map) {
        this.a = oeVar;
        this.b = map;
    }

    public final void run() {
        this.a.a(this.b);
    }
}
