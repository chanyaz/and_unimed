package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.l;
import android.support.v4.view.m;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    private static final int[] D = new int[]{16842766};
    private static final String m = SwipeRefreshLayout.class.getSimpleName();
    private int A;
    private boolean B;
    private final DecelerateInterpolator C;
    private int E;
    private Animation F;
    private Animation G;
    private Animation H;
    private Animation I;
    private Animation J;
    private int K;
    private OnChildScrollUpCallback L;
    private AnimationListener M;
    private final Animation N;
    private final Animation O;
    OnRefreshListener a;
    boolean b;
    int c;
    boolean d;
    d e;
    protected int f;
    float g;
    protected int h;
    int i;
    CircularProgressDrawable j;
    boolean k;
    boolean l;
    private View n;
    private int o;
    private float p;
    private float q;
    private final m r;
    private final l s;
    private final int[] t;
    private final int[] u;
    private boolean v;
    private int w;
    private float x;
    private float y;
    private boolean z;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(@NonNull SwipeRefreshLayout swipeRefreshLayout, @Nullable View view);
    }

    public interface OnRefreshListener {
        void onRefresh();
    }

    public SwipeRefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
        this.p = -1.0f;
        this.t = new int[2];
        this.u = new int[2];
        this.A = -1;
        this.E = -1;
        this.M = new AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.b) {
                    SwipeRefreshLayout.this.j.setAlpha(255);
                    SwipeRefreshLayout.this.j.start();
                    if (SwipeRefreshLayout.this.k && SwipeRefreshLayout.this.a != null) {
                        SwipeRefreshLayout.this.a.onRefresh();
                    }
                    SwipeRefreshLayout.this.c = SwipeRefreshLayout.this.e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.a();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        };
        this.N = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((((int) (((float) ((!SwipeRefreshLayout.this.l ? SwipeRefreshLayout.this.i - Math.abs(SwipeRefreshLayout.this.h) : SwipeRefreshLayout.this.i) - SwipeRefreshLayout.this.f)) * f)) + SwipeRefreshLayout.this.f) - SwipeRefreshLayout.this.e.getTop());
                SwipeRefreshLayout.this.j.b(1.0f - f);
            }
        };
        this.O = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.w = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.C = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.K = (int) (40.0f * displayMetrics.density);
        c();
        setChildrenDrawingOrderEnabled(true);
        this.i = (int) (displayMetrics.density * 64.0f);
        this.p = (float) this.i;
        this.r = new m(this);
        this.s = new l(this);
        setNestedScrollingEnabled(true);
        int i = -this.K;
        this.c = i;
        this.h = i;
        a(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, D);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private Animation a(final int i, final int i2) {
        Animation anonymousClass4 = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.j.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        anonymousClass4.setDuration(300);
        this.e.a(null);
        this.e.clearAnimation();
        this.e.startAnimation(anonymousClass4);
        return anonymousClass4;
    }

    private void a(int i, AnimationListener animationListener) {
        this.f = i;
        this.N.reset();
        this.N.setDuration(200);
        this.N.setInterpolator(this.C);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.N);
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.A) {
            this.A = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void a(boolean z, boolean z2) {
        if (this.b != z) {
            this.k = z2;
            f();
            this.b = z;
            if (this.b) {
                a(this.c, this.M);
            } else {
                a(this.M);
            }
        }
    }

    private boolean a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void b(float f) {
        this.j.a(true);
        float min = Math.min(1.0f, Math.abs(f / this.p));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.p;
        float f2 = this.l ? (float) (this.i - this.h) : (float) this.i;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.h;
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (!this.d) {
            this.e.setScaleX(1.0f);
            this.e.setScaleY(1.0f);
        }
        if (this.d) {
            setAnimationProgress(Math.min(1.0f, f / this.p));
        }
        if (f < this.p) {
            if (this.j.getAlpha() > 76 && !a(this.H)) {
                d();
            }
        } else if (this.j.getAlpha() < 255 && !a(this.I)) {
            e();
        }
        this.j.a(0.0f, Math.min(0.8f, max * 0.8f));
        this.j.b(Math.min(1.0f, max));
        this.j.c(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.c);
    }

    private void b(int i, AnimationListener animationListener) {
        if (this.d) {
            c(i, animationListener);
            return;
        }
        this.f = i;
        this.O.reset();
        this.O.setDuration(200);
        this.O.setInterpolator(this.C);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.O);
    }

    private void b(AnimationListener animationListener) {
        this.e.setVisibility(0);
        this.j.setAlpha(255);
        this.F = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.F.setDuration((long) this.w);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.F);
    }

    private void c() {
        this.e = new d(getContext(), -328966);
        this.j = new CircularProgressDrawable(getContext());
        this.j.a(1);
        this.e.setImageDrawable(this.j);
        this.e.setVisibility(8);
        addView(this.e);
    }

    private void c(float f) {
        if (f > this.p) {
            a(true, true);
            return;
        }
        this.b = false;
        this.j.a(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.d) {
            animationListener = new AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.d) {
                        SwipeRefreshLayout.this.a(null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            };
        }
        b(this.c, animationListener);
        this.j.a(false);
    }

    private void c(int i, AnimationListener animationListener) {
        this.f = i;
        this.g = this.e.getScaleX();
        this.J = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.g + ((-SwipeRefreshLayout.this.g) * f));
                SwipeRefreshLayout.this.a(f);
            }
        };
        this.J.setDuration(150);
        if (animationListener != null) {
            this.e.a(animationListener);
        }
        this.e.clearAnimation();
        this.e.startAnimation(this.J);
    }

    private void d() {
        this.H = a(this.j.getAlpha(), 76);
    }

    private void d(float f) {
        if (f - this.y > ((float) this.o) && !this.z) {
            this.x = this.y + ((float) this.o);
            this.z = true;
            this.j.setAlpha(76);
        }
    }

    private void e() {
        this.I = a(this.j.getAlpha(), 255);
    }

    private void f() {
        if (this.n == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.e)) {
                    i++;
                } else {
                    this.n = childAt;
                    return;
                }
            }
        }
    }

    private void setColorViewAlpha(int i) {
        this.e.getBackground().setAlpha(i);
        this.j.setAlpha(i);
    }

    void a() {
        this.e.clearAnimation();
        this.j.stop();
        this.e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.d) {
            setAnimationProgress(0.0f);
        } else {
            setTargetOffsetTopAndBottom(this.h - this.c);
        }
        this.c = this.e.getTop();
    }

    void a(float f) {
        setTargetOffsetTopAndBottom((this.f + ((int) (((float) (this.h - this.f)) * f))) - this.e.getTop());
    }

    void a(AnimationListener animationListener) {
        this.G = new Animation() {
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.G.setDuration(150);
        this.e.a(animationListener);
        this.e.clearAnimation();
        this.e.startAnimation(this.G);
    }

    public void a(boolean z, int i, int i2) {
        this.d = z;
        this.h = i;
        this.i = i2;
        this.l = true;
        a();
        this.b = false;
    }

    public boolean b() {
        return this.L != null ? this.L.canChildScrollUp(this, this.n) : this.n instanceof ListView ? x.b((ListView) this.n, -1) : this.n.canScrollVertically(-1);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.s.a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.s.a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.s.a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.s.a(i, i2, i3, i4, iArr);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.E < 0 ? i2 : i2 == i + -1 ? this.E : i2 >= this.E ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.r.a();
    }

    public int getProgressCircleDiameter() {
        return this.K;
    }

    public int getProgressViewEndOffset() {
        return this.i;
    }

    public int getProgressViewStartOffset() {
        return this.h;
    }

    public boolean hasNestedScrollingParent() {
        return this.s.b();
    }

    public boolean isNestedScrollingEnabled() {
        return this.s.a();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.B && actionMasked == 0) {
            this.B = false;
        }
        if (!isEnabled() || this.B || b() || this.b || this.v) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                setTargetOffsetTopAndBottom(this.h - this.e.getTop());
                this.A = motionEvent.getPointerId(0);
                this.z = false;
                actionMasked = motionEvent.findPointerIndex(this.A);
                if (actionMasked >= 0) {
                    this.y = motionEvent.getY(actionMasked);
                    break;
                }
                return false;
            case 1:
            case 3:
                this.z = false;
                this.A = -1;
                break;
            case 2:
                if (this.A == -1) {
                    Log.e(m, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                actionMasked = motionEvent.findPointerIndex(this.A);
                if (actionMasked >= 0) {
                    d(motionEvent.getY(actionMasked));
                    break;
                }
                return false;
            case 6:
                a(motionEvent);
                break;
        }
        return this.z;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.n == null) {
                f();
            }
            if (this.n != null) {
                View view = this.n;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.e.getMeasuredWidth();
                this.e.layout((measuredWidth / 2) - (measuredHeight / 2), this.c, (measuredWidth / 2) + (measuredHeight / 2), this.c + this.e.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.n == null) {
            f();
        }
        if (this.n != null) {
            this.n.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.e.measure(MeasureSpec.makeMeasureSpec(this.K, 1073741824), MeasureSpec.makeMeasureSpec(this.K, 1073741824));
            this.E = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.e) {
                    this.E = i3;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.q > 0.0f) {
            if (((float) i2) > this.q) {
                iArr[1] = i2 - ((int) this.q);
                this.q = 0.0f;
            } else {
                this.q -= (float) i2;
                iArr[1] = i2;
            }
            b(this.q);
        }
        if (this.l && i2 > 0 && this.q == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.e.setVisibility(8);
        }
        int[] iArr2 = this.t;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.u);
        int i5 = this.u[1] + i4;
        if (i5 < 0 && !b()) {
            this.q = ((float) Math.abs(i5)) + this.q;
            b(this.q);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.r.a(view, view2, i);
        startNestedScroll(i & 2);
        this.q = 0.0f;
        this.v = true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.B || this.b || (i & 2) == 0) ? false : true;
    }

    public void onStopNestedScroll(View view) {
        this.r.a(view);
        this.v = false;
        if (this.q > 0.0f) {
            c(this.q);
            this.q = 0.0f;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.B && actionMasked == 0) {
            this.B = false;
        }
        if (!isEnabled() || this.B || b() || this.b || this.v) {
            return false;
        }
        float y;
        switch (actionMasked) {
            case 0:
                this.A = motionEvent.getPointerId(0);
                this.z = false;
                break;
            case 1:
                actionMasked = motionEvent.findPointerIndex(this.A);
                if (actionMasked < 0) {
                    Log.e(m, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.z) {
                    y = (motionEvent.getY(actionMasked) - this.x) * 0.5f;
                    this.z = false;
                    c(y);
                }
                this.A = -1;
                return false;
            case 2:
                actionMasked = motionEvent.findPointerIndex(this.A);
                if (actionMasked < 0) {
                    Log.e(m, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                y = motionEvent.getY(actionMasked);
                d(y);
                if (this.z) {
                    y = (y - this.x) * 0.5f;
                    if (y > 0.0f) {
                        b(y);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                actionMasked = motionEvent.getActionIndex();
                if (actionMasked >= 0) {
                    this.A = motionEvent.getPointerId(actionMasked);
                    break;
                }
                Log.e(m, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case 6:
                a(motionEvent);
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.n instanceof AbsListView)) {
            return;
        }
        if (this.n == null || ViewCompat.w(this.n)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    void setAnimationProgress(float f) {
        this.e.setScaleX(f);
        this.e.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        f();
        this.j.a(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = a.c(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.p = (float) i;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            a();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.s.a(z);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.L = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.a = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i) {
        this.e.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i) {
        setProgressBackgroundColorSchemeColor(a.c(getContext(), i));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.b == z) {
            a(z, false);
            return;
        }
        this.b = z;
        setTargetOffsetTopAndBottom((!this.l ? this.i + this.h : this.i) - this.c);
        this.k = false;
        b(this.M);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.K = (int) (displayMetrics.density * 56.0f);
            } else {
                this.K = (int) (displayMetrics.density * 40.0f);
            }
            this.e.setImageDrawable(null);
            this.j.a(i);
            this.e.setImageDrawable(this.j);
        }
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.e.bringToFront();
        ViewCompat.d(this.e, i);
        this.c = this.e.getTop();
    }

    public boolean startNestedScroll(int i) {
        return this.s.b(i);
    }

    public void stopNestedScroll() {
        this.s.c();
    }
}
