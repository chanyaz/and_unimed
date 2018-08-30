package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;

public final class afn implements zzgd {
    private final WeakReference<View> a;
    private final WeakReference<gr> b;

    public afn(View view, gr grVar) {
        this.a = new WeakReference(view);
        this.b = new WeakReference(grVar);
    }

    public final View zzgh() {
        return (View) this.a.get();
    }

    public final boolean zzgi() {
        return this.a.get() == null || this.b.get() == null;
    }

    public final zzgd zzgj() {
        return new afm((View) this.a.get(), (gr) this.b.get());
    }
}
