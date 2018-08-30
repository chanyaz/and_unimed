package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

final class j implements Runnable {
    private final /* synthetic */ Drawable a;
    private final /* synthetic */ i b;

    j(i iVar, Drawable drawable) {
        this.b = iVar;
        this.a = drawable;
    }

    public final void run() {
        this.b.a.a.getWindow().setBackgroundDrawable(this.a);
    }
}
