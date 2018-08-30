package com.google.android.gms.internal.measurement;

import android.content.ComponentName;

final class he implements Runnable {
    private final /* synthetic */ ComponentName a;
    private final /* synthetic */ hc b;

    he(hc hcVar, ComponentName componentName) {
        this.b = hcVar;
        this.a = componentName;
    }

    public final void run() {
        this.b.a.a(this.a);
    }
}
