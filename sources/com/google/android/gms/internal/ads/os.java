package com.google.android.gms.internal.ads;

import android.view.View;

final class os implements Runnable {
    private final /* synthetic */ View a;
    private final /* synthetic */ zzait b;
    private final /* synthetic */ int c;
    private final /* synthetic */ oq d;

    os(oq oqVar, View view, zzait zzait, int i) {
        this.d = oqVar;
        this.a = view;
        this.b = zzait;
        this.c = i;
    }

    public final void run() {
        this.d.a(this.a, this.b, this.c - 1);
    }
}
