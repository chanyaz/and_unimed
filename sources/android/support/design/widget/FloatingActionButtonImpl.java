package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.d;
import android.support.v4.content.a;
import android.support.v4.view.ViewCompat;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

@RequiresApi(14)
class FloatingActionButtonImpl {
    static final Interpolator a = a.c;
    static final int[] j = new int[]{16842919, 16842910};
    static final int[] k = new int[]{16842908, 16842910};
    static final int[] l = new int[]{16842910};
    static final int[] m = new int[0];
    int b = 0;
    z c;
    Drawable d;
    Drawable e;
    h f;
    Drawable g;
    float h;
    float i;
    final VisibilityAwareImageButton n;
    final ShadowViewDelegate o;
    private final ab p;
    private float q;
    private final Rect r = new Rect();
    private OnPreDrawListener s;

    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.n = visibilityAwareImageButton;
        this.o = shadowViewDelegate;
        this.p = new ab();
        this.p.a(j, a(new t(this)));
        this.p.a(k, a(new t(this)));
        this.p.a(l, a(new u(this)));
        this.p.a(m, a(new s(this)));
        this.q = this.n.getRotation();
    }

    private ValueAnimator a(@NonNull v vVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100);
        valueAnimator.addListener(vVar);
        valueAnimator.addUpdateListener(vVar);
        valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
        return valueAnimator;
    }

    private static ColorStateList b(int i) {
        r0 = new int[3][];
        int[] iArr = new int[]{k, i, j};
        iArr[1] = i;
        r0[2] = new int[0];
        iArr[2] = 0;
        return new ColorStateList(r0, iArr);
    }

    private void o() {
        if (this.s == null) {
            this.s = new OnPreDrawListener() {
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.j();
                    return true;
                }
            };
        }
    }

    private boolean p() {
        return ViewCompat.y(this.n) && !this.n.isInEditMode();
    }

    private void q() {
        if (VERSION.SDK_INT == 19) {
            if (this.q % 90.0f != 0.0f) {
                if (this.n.getLayerType() != 1) {
                    this.n.setLayerType(1, null);
                }
            } else if (this.n.getLayerType() != 0) {
                this.n.setLayerType(0, null);
            }
        }
        if (this.c != null) {
            this.c.a(-this.q);
        }
        if (this.f != null) {
            this.f.b(-this.q);
        }
    }

    float a() {
        return this.h;
    }

    h a(int i, ColorStateList colorStateList) {
        Context context = this.n.getContext();
        h i2 = i();
        i2.a(a.c(context, d.design_fab_stroke_top_outer_color), a.c(context, d.design_fab_stroke_top_inner_color), a.c(context, d.design_fab_stroke_end_inner_color), a.c(context, d.design_fab_stroke_end_outer_color));
        i2.a((float) i);
        i2.a(colorStateList);
        return i2;
    }

    final void a(float f) {
        if (this.h != f) {
            this.h = f;
            a(f, this.i);
        }
    }

    void a(float f, float f2) {
        if (this.c != null) {
            this.c.a(f, this.i + f);
            e();
        }
    }

    void a(int i) {
        if (this.e != null) {
            android.support.v4.graphics.drawable.a.a(this.e, b(i));
        }
    }

    void a(ColorStateList colorStateList) {
        if (this.d != null) {
            android.support.v4.graphics.drawable.a.a(this.d, colorStateList);
        }
        if (this.f != null) {
            this.f.a(colorStateList);
        }
    }

    void a(ColorStateList colorStateList, Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.d = android.support.v4.graphics.drawable.a.g(k());
        android.support.v4.graphics.drawable.a.a(this.d, colorStateList);
        if (mode != null) {
            android.support.v4.graphics.drawable.a.a(this.d, mode);
        }
        this.e = android.support.v4.graphics.drawable.a.g(k());
        android.support.v4.graphics.drawable.a.a(this.e, b(i));
        if (i2 > 0) {
            this.f = a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f, this.d, this.e};
        } else {
            this.f = null;
            drawableArr = new Drawable[]{this.d, this.e};
        }
        this.g = new LayerDrawable(drawableArr);
        this.c = new z(this.n.getContext(), this.g, this.o.getRadius(), this.h, this.h + this.i);
        this.c.a(false);
        this.o.setBackgroundDrawable(this.c);
    }

    void a(Mode mode) {
        if (this.d != null) {
            android.support.v4.graphics.drawable.a.a(this.d, mode);
        }
    }

    void a(Rect rect) {
        this.c.getPadding(rect);
    }

    void a(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (!n()) {
            this.n.animate().cancel();
            if (p()) {
                this.b = 1;
                this.n.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200).setInterpolator(a.c).setListener(new AnimatorListenerAdapter() {
                    private boolean d;

                    public void onAnimationCancel(Animator animator) {
                        this.d = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl.this.b = 0;
                        if (!this.d) {
                            FloatingActionButtonImpl.this.n.a(z ? 8 : 4, z);
                            if (internalVisibilityChangedListener != null) {
                                internalVisibilityChangedListener.onHidden();
                            }
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.n.a(0, z);
                        this.d = false;
                    }
                });
                return;
            }
            this.n.a(z ? 8 : 4, z);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
            }
        }
    }

    void a(int[] iArr) {
        this.p.a(iArr);
    }

    void b() {
        this.p.a();
    }

    final void b(float f) {
        if (this.i != f) {
            this.i = f;
            a(this.h, f);
        }
    }

    void b(Rect rect) {
    }

    void b(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (!m()) {
            this.n.animate().cancel();
            if (p()) {
                this.b = 2;
                if (this.n.getVisibility() != 0) {
                    this.n.setAlpha(0.0f);
                    this.n.setScaleY(0.0f);
                    this.n.setScaleX(0.0f);
                }
                this.n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200).setInterpolator(a.d).setListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl.this.b = 0;
                        if (internalVisibilityChangedListener != null) {
                            internalVisibilityChangedListener.onShown();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.n.a(0, z);
                    }
                });
                return;
            }
            this.n.a(0, z);
            this.n.setAlpha(1.0f);
            this.n.setScaleY(1.0f);
            this.n.setScaleX(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
            }
        }
    }

    final Drawable c() {
        return this.g;
    }

    void d() {
    }

    final void e() {
        Rect rect = this.r;
        a(rect);
        b(rect);
        this.o.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    void f() {
        if (h()) {
            o();
            this.n.getViewTreeObserver().addOnPreDrawListener(this.s);
        }
    }

    void g() {
        if (this.s != null) {
            this.n.getViewTreeObserver().removeOnPreDrawListener(this.s);
            this.s = null;
        }
    }

    boolean h() {
        return true;
    }

    h i() {
        return new h();
    }

    void j() {
        float rotation = this.n.getRotation();
        if (this.q != rotation) {
            this.q = rotation;
            q();
        }
    }

    GradientDrawable k() {
        GradientDrawable l = l();
        l.setShape(1);
        l.setColor(-1);
        return l;
    }

    GradientDrawable l() {
        return new GradientDrawable();
    }

    boolean m() {
        return this.n.getVisibility() != 0 ? this.b == 2 : this.b != 1;
    }

    boolean n() {
        return this.n.getVisibility() == 0 ? this.b == 1 : this.b != 2;
    }
}
