package com.google.android.gms.internal.ads;

import android.view.View;

final class agu implements Runnable {
    private final /* synthetic */ View a;
    private final /* synthetic */ agt b;

    agu(agt agt, View view) {
        this.b = agt;
        this.a = view;
    }

    public final void run() {
        this.b.a(this.a);
    }
}
