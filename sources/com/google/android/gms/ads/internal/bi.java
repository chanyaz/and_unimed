package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class bi implements OnTouchListener {
    private final /* synthetic */ bs a;
    private final /* synthetic */ bg b;

    bi(bg bgVar, bs bsVar) {
        this.b = bgVar;
        this.a = bsVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.a();
        if (this.b.b != null) {
            this.b.b.zzpi();
        }
        return false;
    }
}
