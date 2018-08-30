package com.google.android.gms.internal.measurement;

import android.content.ComponentName;

final class ap implements Runnable {
    private final /* synthetic */ ComponentName a;
    private final /* synthetic */ an b;

    ap(an anVar, ComponentName componentName) {
        this.b = anVar;
        this.a = componentName;
    }

    public final void run() {
        this.b.a.a(this.a);
    }
}
