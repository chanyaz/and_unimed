package com.google.android.gms.internal.ads;

import android.view.View;

final class nt implements Runnable {
    private final /* synthetic */ View a;
    private final /* synthetic */ zzait b;
    private final /* synthetic */ int c;
    private final /* synthetic */ nr d;

    nt(nr nrVar, View view, zzait zzait, int i) {
        this.d = nrVar;
        this.a = view;
        this.b = zzait;
        this.c = i;
    }

    public final void run() {
        this.d.a(this.a, this.b, this.c - 1);
    }
}
