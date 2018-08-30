package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class cg extends i {
    private final /* synthetic */ Dialog a;
    private final /* synthetic */ cf b;

    cg(cf cfVar, Dialog dialog) {
        this.b = cfVar;
        this.a = dialog;
    }

    public final void a() {
        this.b.a.h();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
