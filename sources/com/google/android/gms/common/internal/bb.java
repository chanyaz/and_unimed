package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

final class bb extends s {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Fragment b;
    private final /* synthetic */ int c;

    bb(Intent intent, Fragment fragment, int i) {
        this.a = intent;
        this.b = fragment;
        this.c = i;
    }

    public final void a() {
        if (this.a != null) {
            this.b.startActivityForResult(this.a, this.c);
        }
    }
}
