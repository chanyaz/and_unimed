package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class aq implements OnTouchListener {
    private final /* synthetic */ ao a;

    aq(ao aoVar) {
        this.a = aoVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.h != null) {
            this.a.h.a(motionEvent);
        }
        return false;
    }
}
