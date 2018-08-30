package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzaqw;

@zzadh
@VisibleForTesting
public final class h {
    public final int a;
    public final LayoutParams b;
    public final ViewGroup c;
    public final Context d;

    public h(zzaqw zzaqw) {
        this.b = zzaqw.getLayoutParams();
        ViewParent parent = zzaqw.getParent();
        this.d = zzaqw.zzua();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new f("Could not get the parent of the WebView for an overlay.");
        }
        this.c = (ViewGroup) parent;
        this.a = this.c.indexOfChild(zzaqw.getView());
        this.c.removeView(zzaqw.getView());
        zzaqw.zzai(true);
    }
}
