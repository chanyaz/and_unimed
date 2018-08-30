package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

final class aoj implements zzox {
    private final /* synthetic */ View a;
    private final /* synthetic */ aoi b;

    aoj(aoi aoi, View view) {
        this.b = aoi;
        this.a = view;
    }

    public final void zzc(MotionEvent motionEvent) {
        this.b.onTouch(null, motionEvent);
    }

    public final void zzki() {
        this.b.onClick(this.a);
    }
}
