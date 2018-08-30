package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;

@zzadh
public final class lp {
    public static void a(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        new lq(view, onGlobalLayoutListener).a();
    }

    public static void a(View view, OnScrollChangedListener onScrollChangedListener) {
        new lr(view, onScrollChangedListener).a();
    }
}
