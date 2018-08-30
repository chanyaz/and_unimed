package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

final class nu implements OnAttachStateChangeListener {
    private final /* synthetic */ zzait a;
    private final /* synthetic */ nr b;

    nu(nr nrVar, zzait zzait) {
        this.b = nrVar;
        this.a = zzait;
    }

    public final void onViewAttachedToWindow(View view) {
        this.b.a(view, this.a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
