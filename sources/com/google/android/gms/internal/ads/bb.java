package com.google.android.gms.internal.ads;

import android.view.ViewTreeObserver.OnScrollChangedListener;
import java.lang.ref.WeakReference;

final class bb implements OnScrollChangedListener {
    private final /* synthetic */ WeakReference a;
    private final /* synthetic */ au b;

    bb(au auVar, WeakReference weakReference) {
        this.b = auVar;
        this.a = weakReference;
    }

    public final void onScrollChanged() {
        this.b.a(this.a, true);
    }
}
