package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

final class ba extends s {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ Activity b;
    private final /* synthetic */ int c;

    ba(Intent intent, Activity activity, int i) {
        this.a = intent;
        this.b = activity;
        this.c = i;
    }

    public final void a() {
        if (this.a != null) {
            this.b.startActivityForResult(this.a, this.c);
        }
    }
}
