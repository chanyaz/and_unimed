package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

final class aom implements zzox {
    private final /* synthetic */ View a;
    private final /* synthetic */ aok b;

    aom(aok aok, View view) {
        this.b = aok;
        this.a = view;
    }

    public final void zzc(MotionEvent motionEvent) {
        this.b.onTouch(null, motionEvent);
    }

    public final void zzki() {
        if (this.b.a(aok.a)) {
            this.b.onClick(this.a);
        }
    }
}
