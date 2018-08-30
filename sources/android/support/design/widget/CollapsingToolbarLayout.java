package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.StyleRes;
import android.support.design.g;
import android.support.design.k;
import android.support.design.l;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v4.content.a;
import android.support.v4.util.n;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.support.v4.widget.au;
import android.support.v7.a.j;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CollapsingToolbarLayout extends FrameLayout {
    final j a;
    Drawable b;
    int c;
    as d;
    private boolean e;
    private int f;
    private Toolbar g;
    private View h;
    private View i;
    private int j;
    private int k;
    private int l;
    private int m;
    private final Rect n;
    private boolean o;
    private boolean p;
    private Drawable q;
    private int r;
    private boolean s;
    private ValueAnimator t;
    private long u;
    private int v;
    private OnOffsetChangedListener w;

    public class LayoutParams extends android.widget.FrameLayout.LayoutParams {
        int a = 0;
        float b = 0.5f;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        @interface CollapseMode {
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.CollapsingToolbarLayout_Layout);
            this.a = obtainStyledAttributes.getInt(l.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            a(obtainStyledAttributes.getFloat(l.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void a(float f) {
            this.b = f;
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = true;
        this.n = new Rect();
        this.v = -1;
        am.a(context);
        this.a = new j(this);
        this.a.a(a.e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.CollapsingToolbarLayout, i, k.Widget_Design_CollapsingToolbar);
        this.a.a(obtainStyledAttributes.getInt(l.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.a.b(obtainStyledAttributes.getInt(l.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.m = dimensionPixelSize;
        this.l = dimensionPixelSize;
        this.k = dimensionPixelSize;
        this.j = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.j = obtainStyledAttributes.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (obtainStyledAttributes.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.l = obtainStyledAttributes.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (obtainStyledAttributes.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.k = obtainStyledAttributes.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (obtainStyledAttributes.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.m = obtainStyledAttributes.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.o = obtainStyledAttributes.getBoolean(l.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(obtainStyledAttributes.getText(l.CollapsingToolbarLayout_title));
        this.a.d(k.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.a.c(j.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (obtainStyledAttributes.hasValue(l.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.a.d(obtainStyledAttributes.getResourceId(l.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (obtainStyledAttributes.hasValue(l.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.a.c(obtainStyledAttributes.getResourceId(l.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.v = obtainStyledAttributes.getDimensionPixelSize(l.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.u = (long) obtainStyledAttributes.getInt(l.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(l.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(l.CollapsingToolbarLayout_statusBarScrim));
        this.f = obtainStyledAttributes.getResourceId(l.CollapsingToolbarLayout_toolbarId, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.a((View) this, new OnApplyWindowInsetsListener() {
            public as onApplyWindowInsets(View view, as asVar) {
                return CollapsingToolbarLayout.this.a(asVar);
            }
        });
    }

    static an a(View view) {
        an anVar = (an) view.getTag(g.view_offset_helper);
        if (anVar != null) {
            return anVar;
        }
        anVar = new an(view);
        view.setTag(g.view_offset_helper, anVar);
        return anVar;
    }

    private void a(int i) {
        c();
        if (this.t == null) {
            this.t = new ValueAnimator();
            this.t.setDuration(this.u);
            this.t.setInterpolator(i > this.r ? a.c : a.d);
            this.t.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (this.t.isRunning()) {
            this.t.cancel();
        }
        this.t.setIntValues(new int[]{this.r, i});
        this.t.start();
    }

    private void c() {
        if (this.e) {
            this.g = null;
            this.h = null;
            if (this.f != -1) {
                this.g = (Toolbar) findViewById(this.f);
                if (this.g != null) {
                    this.h = d(this.g);
                }
            }
            if (this.g == null) {
                Toolbar toolbar;
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                }
                toolbar = null;
                this.g = toolbar;
            }
            d();
            this.e = false;
        }
    }

    private boolean c(View view) {
        return (this.h == null || this.h == this) ? view == this.g : view == this.h;
    }

    private View d(View view) {
        CollapsingToolbarLayout parent = view.getParent();
        View view2 = view;
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view2 = parent;
            }
            parent = parent.getParent();
        }
        return view2;
    }

    private void d() {
        if (!(this.o || this.i == null)) {
            ViewParent parent = this.i.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.i);
            }
        }
        if (this.o && this.g != null) {
            if (this.i == null) {
                this.i = new View(getContext());
            }
            if (this.i.getParent() == null) {
                this.g.addView(this.i, -1, -1);
            }
        }
    }

    private static int e(@NonNull View view) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof MarginLayoutParams)) {
            return view.getHeight();
        }
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
        return marginLayoutParams.bottomMargin + (view.getHeight() + marginLayoutParams.topMargin);
    }

    /* renamed from: a */
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    as a(as asVar) {
        as asVar2 = null;
        if (ViewCompat.r(this)) {
            asVar2 = asVar;
        }
        if (!n.a(this.d, asVar2)) {
            this.d = asVar2;
            requestLayout();
        }
        return asVar.g();
    }

    /* renamed from: a */
    protected android.widget.FrameLayout.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void a(boolean z, boolean z2) {
        int i = 255;
        if (this.s != z) {
            if (z2) {
                if (!z) {
                    i = 0;
                }
                a(i);
            } else {
                if (!z) {
                    i = 0;
                }
                setScrimAlpha(i);
            }
            this.s = z;
        }
    }

    final int b(View view) {
        return ((getHeight() - a(view).c()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    final void b() {
        if (this.q != null || this.b != null) {
            setScrimsShown(getHeight() + this.c < getScrimVisibleHeightTrigger());
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        c();
        if (this.g == null && this.q != null && this.r > 0) {
            this.q.mutate().setAlpha(this.r);
            this.q.draw(canvas);
        }
        if (this.o && this.p) {
            this.a.a(canvas);
        }
        if (this.b != null && this.r > 0) {
            int b = this.d != null ? this.d.b() : 0;
            if (b > 0) {
                this.b.setBounds(0, -this.c, getWidth(), b - this.c);
                this.b.mutate().setAlpha(this.r);
                this.b.draw(canvas);
            }
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        if (this.q == null || this.r <= 0 || !c(view)) {
            z = false;
        } else {
            this.q.mutate().setAlpha(this.r);
            this.q.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j) || z;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.b;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (this.a != null) {
            i |= this.a.a(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public android.widget.FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.a.c();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.a.d();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.q;
    }

    public int getExpandedTitleGravity() {
        return this.a.b();
    }

    public int getExpandedTitleMarginBottom() {
        return this.m;
    }

    public int getExpandedTitleMarginEnd() {
        return this.l;
    }

    public int getExpandedTitleMarginStart() {
        return this.j;
    }

    public int getExpandedTitleMarginTop() {
        return this.k;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.a.e();
    }

    int getScrimAlpha() {
        return this.r;
    }

    public long getScrimAnimationDuration() {
        return this.u;
    }

    public int getScrimVisibleHeightTrigger() {
        if (this.v >= 0) {
            return this.v;
        }
        int b = this.d != null ? this.d.b() : 0;
        int k = ViewCompat.k(this);
        return k > 0 ? Math.min(b + (k * 2), getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.b;
    }

    @Nullable
    public CharSequence getTitle() {
        return this.o ? this.a.j() : null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.b((View) this, ViewCompat.r((View) parent));
            if (this.w == null) {
                this.w = new k(this);
            }
            ((AppBarLayout) parent).a(this.w);
            ViewCompat.q(this);
        }
    }

    protected void onDetachedFromWindow() {
        ViewParent parent = getParent();
        if (this.w != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).b(this.w);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int b;
        int i5;
        int i6 = 1;
        int i7 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.d != null) {
            b = this.d.b();
            int childCount = getChildCount();
            for (i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (!ViewCompat.r(childAt) && childAt.getTop() < b) {
                    ViewCompat.d(childAt, b);
                }
            }
        }
        if (this.o && this.i != null) {
            boolean z2 = ViewCompat.B(this.i) && this.i.getVisibility() == 0;
            this.p = z2;
            if (this.p) {
                if (ViewCompat.f(this) != 1) {
                    i6 = 0;
                }
                b = b(this.h != null ? this.h : this.g);
                au.b(this, this.i, this.n);
                this.a.b(this.n.left + (i6 != 0 ? this.g.getTitleMarginEnd() : this.g.getTitleMarginStart()), this.g.getTitleMarginTop() + (this.n.top + b), (i6 != 0 ? this.g.getTitleMarginStart() : this.g.getTitleMarginEnd()) + this.n.right, (b + this.n.bottom) - this.g.getTitleMarginBottom());
                this.a.a(i6 != 0 ? this.l : this.j, this.n.top + this.k, (i3 - i) - (i6 != 0 ? this.j : this.l), (i4 - i2) - this.m);
                this.a.i();
            }
        }
        i5 = getChildCount();
        while (i7 < i5) {
            a(getChildAt(i7)).a();
            i7++;
        }
        if (this.g != null) {
            if (this.o && TextUtils.isEmpty(this.a.j())) {
                this.a.a(this.g.getTitle());
            }
            if (this.h == null || this.h == this) {
                setMinimumHeight(e(this.g));
            } else {
                setMinimumHeight(e(this.h));
            }
        }
        b();
    }

    protected void onMeasure(int i, int i2) {
        c();
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i2);
        int b = this.d != null ? this.d.b() : 0;
        if (mode == 0 && b > 0) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(b + getMeasuredHeight(), 1073741824));
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.q != null) {
            this.q.setBounds(0, 0, i, i2);
        }
    }

    public void setCollapsedTitleGravity(int i) {
        this.a.b(i);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        this.a.c(i);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.a.a(colorStateList);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.a.a(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = null;
        if (this.q != drawable) {
            if (this.q != null) {
                this.q.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.q = drawable2;
            if (this.q != null) {
                this.q.setBounds(0, 0, getWidth(), getHeight());
                this.q.setCallback(this);
                this.q.setAlpha(this.r);
            }
            ViewCompat.d(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(@DrawableRes int i) {
        setContentScrim(a.a(getContext(), i));
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        this.a.a(i);
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.m = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.l = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.j = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.k = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        this.a.d(i);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.a.b(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.a.b(typeface);
    }

    void setScrimAlpha(int i) {
        if (i != this.r) {
            if (!(this.q == null || this.g == null)) {
                ViewCompat.d(this.g);
            }
            this.r = i;
            ViewCompat.d(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        this.u = j;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i) {
        if (this.v != i) {
            this.v = i;
            b();
        }
    }

    public void setScrimsShown(boolean z) {
        boolean z2 = ViewCompat.y(this) && !isInEditMode();
        a(z, z2);
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = null;
        if (this.b != drawable) {
            if (this.b != null) {
                this.b.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.b = drawable2;
            if (this.b != null) {
                if (this.b.isStateful()) {
                    this.b.setState(getDrawableState());
                }
                android.support.v4.graphics.drawable.a.b(this.b, ViewCompat.f(this));
                this.b.setVisible(getVisibility() == 0, false);
                this.b.setCallback(this);
                this.b.setAlpha(this.r);
            }
            ViewCompat.d(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        setStatusBarScrim(a.a(getContext(), i));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.a.a(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.o) {
            this.o = z;
            d();
            requestLayout();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (!(this.b == null || this.b.isVisible() == z)) {
            this.b.setVisible(z, false);
        }
        if (this.q != null && this.q.isVisible() != z) {
            this.q.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q || drawable == this.b;
    }
}
