package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import java.lang.ref.WeakReference;

final class ba implements OnGlobalLayoutListener {
    private final /* synthetic */ WeakReference a;
    private final /* synthetic */ au b;

    ba(au auVar, WeakReference weakReference) {
        this.b = auVar;
        this.a = weakReference;
    }

    public final void onGlobalLayout() {
        this.b.a(this.a, false);
    }
}
