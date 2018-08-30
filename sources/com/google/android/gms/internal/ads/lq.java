package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.google.android.gms.ads.internal.au;
import java.lang.ref.WeakReference;

@zzadh
final class lq extends ls implements OnGlobalLayoutListener {
    private final WeakReference<OnGlobalLayoutListener> a;

    public lq(View view, OnGlobalLayoutListener onGlobalLayoutListener) {
        super(view);
        this.a = new WeakReference(onGlobalLayoutListener);
    }

    protected final void a(ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnGlobalLayoutListener(this);
    }

    protected final void b(ViewTreeObserver viewTreeObserver) {
        au.g().a(viewTreeObserver, (OnGlobalLayoutListener) this);
    }

    public final void onGlobalLayout() {
        OnGlobalLayoutListener onGlobalLayoutListener = (OnGlobalLayoutListener) this.a.get();
        if (onGlobalLayoutListener != null) {
            onGlobalLayoutListener.onGlobalLayout();
        } else {
            b();
        }
    }
}
