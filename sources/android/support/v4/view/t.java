package android.support.v4.view;

import android.graphics.drawable.Drawable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewParent;

@RequiresApi(16)
class t extends s {
    t() {
    }

    public void a(View view, int i) {
        if (i == 4) {
            i = 2;
        }
        view.setImportantForAccessibility(i);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidateOnAnimation(i, i2, i3, i4);
    }

    public void a(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public void a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public void a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public void a(View view, boolean z) {
        view.setHasTransientState(z);
    }

    public boolean b(View view) {
        return view.hasTransientState();
    }

    public void c(View view) {
        view.postInvalidateOnAnimation();
    }

    public int d(View view) {
        return view.getImportantForAccessibility();
    }

    public ViewParent e(View view) {
        return view.getParentForAccessibility();
    }

    public int f(View view) {
        return view.getMinimumWidth();
    }

    public int g(View view) {
        return view.getMinimumHeight();
    }

    public void h(View view) {
        view.requestFitSystemWindows();
    }

    public boolean i(View view) {
        return view.getFitsSystemWindows();
    }

    public boolean j(View view) {
        return view.hasOverlappingRendering();
    }
}
