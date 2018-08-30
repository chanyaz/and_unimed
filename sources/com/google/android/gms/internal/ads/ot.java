package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class ot implements OnAttachStateChangeListener {
    private final /* synthetic */ zzait a;
    private final /* synthetic */ oq b;

    ot(oq oqVar, zzait zzait) {
        this.b = oqVar;
        this.a = zzait;
    }

    public final void onViewAttachedToWindow(View view) {
        this.b.a(view, this.a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
