package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.m;
import android.support.v7.a.b;
import android.support.v7.a.g;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

@RestrictTo({Scope.LIBRARY_GROUP})
public class ActionBarOverlayLayout extends ViewGroup implements NestedScrollingParent, DecorContentParent {
    static final int[] e = new int[]{b.actionBarSize, 16842841};
    private final Runnable A;
    private final Runnable B;
    private final m C;
    ActionBarContainer a;
    boolean b;
    ViewPropertyAnimator c;
    final AnimatorListenerAdapter d;
    private int f;
    private int g;
    private ContentFrameLayout h;
    private DecorToolbar i;
    private Drawable j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    private final Rect q;
    private final Rect r;
    private final Rect s;
    private final Rect t;
    private final Rect u;
    private final Rect v;
    private final Rect w;
    private ActionBarVisibilityCallback x;
    private final int y;
    private OverScroller z;

    public interface ActionBarVisibilityCallback {
        void enableContentAnimations(boolean z);

        void hideForSystem();

        void onContentScrollStarted();

        void onContentScrollStopped();

        void onWindowVisibilityChanged(int i);

        void showForSystem();
    }

    public class LayoutParams extends MarginLayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = 0;
        this.q = new Rect();
        this.r = new Rect();
        this.s = new Rect();
        this.t = new Rect();
        this.u = new Rect();
        this.v = new Rect();
        this.w = new Rect();
        this.y = 600;
        this.d = new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.c = null;
                ActionBarOverlayLayout.this.b = false;
            }
        };
        this.A = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        this.B = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.d();
                ActionBarOverlayLayout.this.c = ActionBarOverlayLayout.this.a.animate().translationY((float) (-ActionBarOverlayLayout.this.a.getHeight())).setListener(ActionBarOverlayLayout.this.d);
            }
        };
        a(context);
        this.C = new m(this);
    }

    private DecorToolbar a(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(e);
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.j = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.j == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.k = z;
        this.z = new OverScroller(context);
    }

    private boolean a(float f, float f2) {
        this.z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, MoPubClientPositioning.NO_REPEAT);
        return this.z.getFinalY() > this.a.getHeight();
    }

    private boolean a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z && layoutParams.leftMargin != rect.left) {
            layoutParams.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && layoutParams.topMargin != rect.top) {
            layoutParams.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && layoutParams.rightMargin != rect.right) {
            layoutParams.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || layoutParams.bottomMargin == rect.bottom) {
            return z5;
        }
        layoutParams.bottomMargin = rect.bottom;
        return true;
    }

    private void e() {
        d();
        postDelayed(this.A, 600);
    }

    private void f() {
        d();
        postDelayed(this.B, 600);
    }

    private void g() {
        d();
        this.A.run();
    }

    private void h() {
        d();
        this.B.run();
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public boolean a() {
        return this.l;
    }

    /* renamed from: b */
    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    void c() {
        if (this.h == null) {
            this.h = (ContentFrameLayout) findViewById(g.action_bar_activity_content);
            this.a = (ActionBarContainer) findViewById(g.action_bar_container);
            this.i = a(findViewById(g.action_bar));
        }
    }

    public boolean canShowOverflowMenu() {
        c();
        return this.i.canShowOverflowMenu();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void d() {
        removeCallbacks(this.A);
        removeCallbacks(this.B);
        if (this.c != null) {
            this.c.cancel();
        }
    }

    public void dismissPopups() {
        c();
        this.i.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.j != null && !this.k) {
            int bottom = this.a.getVisibility() == 0 ? (int) ((((float) this.a.getBottom()) + this.a.getTranslationY()) + 0.5f) : 0;
            this.j.setBounds(0, bottom, getWidth(), this.j.getIntrinsicHeight() + bottom);
            this.j.draw(canvas);
        }
    }

    protected boolean fitSystemWindows(Rect rect) {
        c();
        if ((ViewCompat.p(this) & 256) != 0) {
        }
        boolean a = a(this.a, rect, true, true, false, true);
        this.t.set(rect);
        dk.a(this, this.t, this.q);
        if (!this.u.equals(this.t)) {
            this.u.set(this.t);
            a = true;
        }
        if (!this.r.equals(this.q)) {
            this.r.set(this.q);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getActionBarHideOffset() {
        return this.a != null ? -((int) this.a.getTranslationY()) : 0;
    }

    public int getNestedScrollAxes() {
        return this.C.a();
    }

    public CharSequence getTitle() {
        c();
        return this.i.getTitle();
    }

    public boolean hasIcon() {
        c();
        return this.i.hasIcon();
    }

    public boolean hasLogo() {
        c();
        return this.i.hasLogo();
    }

    public boolean hideOverflowMenu() {
        c();
        return this.i.hideOverflowMenu();
    }

    public void initFeature(int i) {
        c();
        switch (i) {
            case 2:
                this.i.initProgress();
                return;
            case 5:
                this.i.initIndeterminateProgress();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public boolean isOverflowMenuShowPending() {
        c();
        return this.i.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        c();
        return this.i.isOverflowMenuShowing();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(getContext());
        ViewCompat.q(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int i6 = layoutParams.leftMargin + paddingLeft;
                paddingRight = layoutParams.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        c();
        measureChildWithMargins(this.a, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
        int max = Math.max(0, (this.a.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        int max2 = Math.max(0, layoutParams.bottomMargin + (this.a.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates = View.combineMeasuredStates(0, this.a.getMeasuredState());
        Object obj = (ViewCompat.p(this) & 256) != 0 ? 1 : null;
        if (obj != null) {
            i3 = this.f;
            if (this.m && this.a.getTabContainer() != null) {
                i3 += this.f;
            }
        } else {
            i3 = this.a.getVisibility() != 8 ? this.a.getMeasuredHeight() : 0;
        }
        this.s.set(this.q);
        this.v.set(this.t);
        Rect rect;
        Rect rect2;
        if (this.l || obj != null) {
            rect = this.v;
            rect.top = i3 + rect.top;
            rect2 = this.v;
            rect2.bottom += 0;
        } else {
            rect = this.s;
            rect.top = i3 + rect.top;
            rect2 = this.s;
            rect2.bottom += 0;
        }
        a(this.h, this.s, true, true, true, true);
        if (!this.w.equals(this.v)) {
            this.w.set(this.v);
            this.h.a(this.v);
        }
        measureChildWithMargins(this.h, i, 0, i2, 0);
        layoutParams = (LayoutParams) this.h.getLayoutParams();
        int max3 = Math.max(max, (this.h.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
        i3 = Math.max(max2, layoutParams.bottomMargin + (this.h.getMeasuredHeight() + layoutParams.topMargin));
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.n || !z) {
            return false;
        }
        if (a(f, f2)) {
            h();
        } else {
            g();
        }
        this.b = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.o += i2;
        setActionBarHideOffset(this.o);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.C.a(view, view2, i);
        this.o = getActionBarHideOffset();
        d();
        if (this.x != null) {
            this.x.onContentScrollStarted();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return ((i & 2) == 0 || this.a.getVisibility() != 0) ? false : this.n;
    }

    public void onStopNestedScroll(View view) {
        if (this.n && !this.b) {
            if (this.o <= this.a.getHeight()) {
                e();
            } else {
                f();
            }
        }
        if (this.x != null) {
            this.x.onContentScrollStopped();
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        c();
        int i2 = this.p ^ i;
        this.p = i;
        boolean z2 = (i & 4) == 0;
        boolean z3 = (i & 256) != 0;
        if (this.x != null) {
            ActionBarVisibilityCallback actionBarVisibilityCallback = this.x;
            if (z3) {
                z = false;
            }
            actionBarVisibilityCallback.enableContentAnimations(z);
            if (z2 || !z3) {
                this.x.showForSystem();
            } else {
                this.x.hideForSystem();
            }
        }
        if ((i2 & 256) != 0 && this.x != null) {
            ViewCompat.q(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.g = i;
        if (this.x != null) {
            this.x.onWindowVisibilityChanged(i);
        }
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        c();
        this.i.restoreHierarchyState(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        c();
        this.i.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int i) {
        d();
        this.a.setTranslationY((float) (-Math.max(0, Math.min(i, this.a.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.x = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.x.onWindowVisibilityChanged(this.g);
            if (this.p != 0) {
                onWindowSystemUiVisibilityChanged(this.p);
                ViewCompat.q(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.n) {
            this.n = z;
            if (!z) {
                d();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        c();
        this.i.setIcon(i);
    }

    public void setIcon(Drawable drawable) {
        c();
        this.i.setIcon(drawable);
    }

    public void setLogo(int i) {
        c();
        this.i.setLogo(i);
    }

    public void setMenu(Menu menu, Callback callback) {
        c();
        this.i.setMenu(menu, callback);
    }

    public void setMenuPrepared() {
        c();
        this.i.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.l = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.k = z2;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    public void setWindowCallback(Window.Callback callback) {
        c();
        this.i.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        c();
        this.i.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        c();
        return this.i.showOverflowMenu();
    }
}
