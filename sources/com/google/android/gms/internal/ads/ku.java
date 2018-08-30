package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeoutException;

final /* synthetic */ class ku implements Runnable {
    private final lk a;

    ku(lk lkVar) {
        this.a = lkVar;
    }

    public final void run() {
        this.a.a(new TimeoutException());
    }
}
