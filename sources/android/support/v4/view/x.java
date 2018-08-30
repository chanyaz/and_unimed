package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

@RequiresApi(21)
class x extends w {
    private static ThreadLocal<Rect> d;

    x() {
    }

    private static Rect b() {
        if (d == null) {
            d = new ThreadLocal();
        }
        Rect rect = (Rect) d.get();
        if (rect == null) {
            rect = new Rect();
            d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public float A(View view) {
        return view.getZ();
    }

    public as a(View view, as asVar) {
        Object obj = (WindowInsets) as.a(asVar);
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(obj);
        if (onApplyWindowInsets != obj) {
            obj = new WindowInsets(onApplyWindowInsets);
        }
        return as.a(obj);
    }

    public void a(View view, float f) {
        view.setElevation(f);
    }

    public void a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public void a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public void a(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        if (onApplyWindowInsetsListener == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return (WindowInsets) as.a(onApplyWindowInsetsListener.onApplyWindowInsets(view, as.a((Object) windowInsets)));
                }
            });
        }
    }

    public void a(View view, String str) {
        view.setTransitionName(str);
    }

    public as b(View view, as asVar) {
        Object obj = (WindowInsets) as.a(asVar);
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(obj);
        if (dispatchApplyWindowInsets != obj) {
            obj = new WindowInsets(dispatchApplyWindowInsets);
        }
        return as.a(obj);
    }

    public void b(View view, float f) {
        view.setTranslationZ(f);
    }

    public void c(View view, int i) {
        Object obj;
        Rect b = b();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        super.c(view, i);
        if (obj != null && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(b);
        }
    }

    public void d(View view, int i) {
        Object obj;
        Rect b = b();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        super.d(view, i);
        if (obj != null && b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(b);
        }
    }

    public void h(View view) {
        view.requestApplyInsets();
    }

    public String t(View view) {
        return view.getTransitionName();
    }

    public float u(View view) {
        return view.getElevation();
    }

    public float v(View view) {
        return view.getTranslationZ();
    }

    public boolean w(View view) {
        return view.isNestedScrollingEnabled();
    }

    public void x(View view) {
        view.stopNestedScroll();
    }

    public ColorStateList y(View view) {
        return view.getBackgroundTintList();
    }

    public Mode z(View view) {
        return view.getBackgroundTintMode();
    }
}
