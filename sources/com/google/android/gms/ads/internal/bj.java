package com.google.android.gms.ads.internal;

import android.view.View;
import android.view.View.OnClickListener;

final class bj implements OnClickListener {
    private final /* synthetic */ bs a;
    private final /* synthetic */ bg b;

    bj(bg bgVar, bs bsVar) {
        this.b = bgVar;
        this.a = bsVar;
    }

    public final void onClick(View view) {
        this.a.a();
        if (this.b.b != null) {
            this.b.b.zzpi();
        }
    }
}
