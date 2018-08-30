package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class ab {
    static Field b;
    static boolean c = false;
    private static Field d;
    private static boolean e;
    private static Field f;
    private static boolean g;
    private static WeakHashMap<View, String> h;
    private static final AtomicInteger i = new AtomicInteger(1);
    WeakHashMap<View, ap> a = null;

    ab() {
    }

    private static void D(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    public float A(View view) {
        return v(view) + u(view);
    }

    public boolean B(View view) {
        boolean z = true;
        if (c) {
            return false;
        }
        if (b == null) {
            try {
                b = View.class.getDeclaredField("mAccessibilityDelegate");
                b.setAccessible(true);
            } catch (Throwable th) {
                c = true;
                return false;
            }
        }
        try {
            if (b.get(view) == null) {
                z = false;
            }
            return z;
        } catch (Throwable th2) {
            c = true;
            return false;
        }
    }

    public ap C(View view) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        ap apVar = (ap) this.a.get(view);
        if (apVar != null) {
            return apVar;
        }
        apVar = new ap(view);
        this.a.put(view, apVar);
        return apVar;
    }

    long a() {
        return ValueAnimator.getFrameDelay();
    }

    public as a(View view, as asVar) {
        return asVar;
    }

    public void a(View view, float f) {
    }

    public void a(View view, int i) {
    }

    public void a(View view, int i, int i2) {
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        view.postInvalidate(i, i2, i3, i4);
    }

    public void a(View view, ColorStateList colorStateList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    public void a(View view, Paint paint) {
        view.setLayerType(view.getLayerType(), paint);
        view.invalidate();
    }

    public void a(View view, Mode mode) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
        }
    }

    public void a(View view, Rect rect) {
    }

    public void a(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public void a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
    }

    public void a(View view, @Nullable a aVar) {
        view.setAccessibilityDelegate(aVar == null ? null : aVar.a());
    }

    public void a(View view, q qVar) {
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, a());
    }

    public void a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, a() + j);
    }

    public void a(View view, String str) {
        if (h == null) {
            h = new WeakHashMap();
        }
        h.put(view, str);
    }

    public void a(View view, boolean z) {
    }

    public boolean a(View view) {
        return false;
    }

    public as b(View view, as asVar) {
        return asVar;
    }

    public void b(View view, float f) {
    }

    public void b(View view, int i) {
    }

    public void b(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public boolean b(View view) {
        return false;
    }

    public void c(View view) {
        view.postInvalidate();
    }

    public void c(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                D((View) parent);
            }
        }
    }

    public int d(View view) {
        return 0;
    }

    public void d(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            D(view);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                D((View) parent);
            }
        }
    }

    public ViewParent e(View view) {
        return view.getParent();
    }

    public int f(View view) {
        if (!e) {
            try {
                d = View.class.getDeclaredField("mMinWidth");
                d.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            e = true;
        }
        if (d != null) {
            try {
                return ((Integer) d.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    public int g(View view) {
        if (!g) {
            try {
                f = View.class.getDeclaredField("mMinHeight");
                f.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            g = true;
        }
        if (f != null) {
            try {
                return ((Integer) f.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    public void h(View view) {
    }

    public boolean i(View view) {
        return false;
    }

    public boolean j(View view) {
        return true;
    }

    public int k(View view) {
        return 0;
    }

    public int l(View view) {
        return view.getPaddingLeft();
    }

    public int m(View view) {
        return view.getPaddingRight();
    }

    public int n(View view) {
        return 0;
    }

    public boolean o(View view) {
        return false;
    }

    public Display p(View view) {
        return s(view) ? ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay() : null;
    }

    public Rect q(View view) {
        return null;
    }

    public boolean r(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    public boolean s(View view) {
        return view.getWindowToken() != null;
    }

    public String t(View view) {
        return h == null ? null : (String) h.get(view);
    }

    public float u(View view) {
        return 0.0f;
    }

    public float v(View view) {
        return 0.0f;
    }

    public boolean w(View view) {
        return view instanceof NestedScrollingChild ? ((NestedScrollingChild) view).isNestedScrollingEnabled() : false;
    }

    public void x(View view) {
        if (view instanceof NestedScrollingChild) {
            ((NestedScrollingChild) view).stopNestedScroll();
        }
    }

    public ColorStateList y(View view) {
        return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintList() : null;
    }

    public Mode z(View view) {
        return view instanceof TintableBackgroundView ? ((TintableBackgroundView) view).getSupportBackgroundTintMode() : null;
    }
}
