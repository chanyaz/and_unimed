package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class bm implements Runnable {
    private final /* synthetic */ bl a;

    bm(bl blVar) {
        this.a = blVar;
    }

    public final void run() {
        this.a.h.zzg(new ConnectionResult(4));
    }
}
