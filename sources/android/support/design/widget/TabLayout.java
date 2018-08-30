package android.support.design.widget;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.e;
import android.support.design.k;
import android.support.design.l;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.p;
import android.support.v4.util.q;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.DecorView;
import android.support.v4.view.n;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;

@DecorView
public class TabLayout extends HorizontalScrollView {
    private static final Pool<ah> n = new q(16);
    private DataSetObserver A;
    private ai B;
    private ae C;
    private boolean D;
    private final Pool<aj> E;
    int a;
    int b;
    int c;
    int d;
    int e;
    ColorStateList f;
    float g;
    float h;
    final int i;
    int j;
    int k;
    int l;
    ViewPager m;
    private final ArrayList<ah> o;
    private ah p;
    private final ag q;
    private final int r;
    private final int s;
    private final int t;
    private int u;
    private OnTabSelectedListener v;
    private final ArrayList<OnTabSelectedListener> w;
    private OnTabSelectedListener x;
    private ValueAnimator y;
    private n z;

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener {
        void onTabReselected(ah ahVar);

        void onTabSelected(ah ahVar);

        void onTabUnselected(ah ahVar);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = new ArrayList();
        this.j = MoPubClientPositioning.NO_REPEAT;
        this.w = new ArrayList();
        this.E = new p(12);
        am.a(context);
        setHorizontalScrollBarEnabled(false);
        this.q = new ag(this, context);
        super.addView(this.q, 0, new LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.TabLayout, i, k.Widget_Design_TabLayout);
        this.q.b(obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabIndicatorHeight, 0));
        this.q.a(obtainStyledAttributes.getColor(l.TabLayout_tabIndicatorColor, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabPadding, 0);
        this.d = dimensionPixelSize;
        this.c = dimensionPixelSize;
        this.b = dimensionPixelSize;
        this.a = dimensionPixelSize;
        this.a = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabPaddingStart, this.a);
        this.b = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabPaddingTop, this.b);
        this.c = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabPaddingEnd, this.c);
        this.d = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabPaddingBottom, this.d);
        this.e = obtainStyledAttributes.getResourceId(l.TabLayout_tabTextAppearance, k.TextAppearance_Design_Tab);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(this.e, android.support.v7.a.k.TextAppearance);
        try {
            this.g = (float) obtainStyledAttributes2.getDimensionPixelSize(android.support.v7.a.k.TextAppearance_android_textSize, 0);
            this.f = obtainStyledAttributes2.getColorStateList(android.support.v7.a.k.TextAppearance_android_textColor);
            if (obtainStyledAttributes.hasValue(l.TabLayout_tabTextColor)) {
                this.f = obtainStyledAttributes.getColorStateList(l.TabLayout_tabTextColor);
            }
            if (obtainStyledAttributes.hasValue(l.TabLayout_tabSelectedTextColor)) {
                this.f = b(this.f.getDefaultColor(), obtainStyledAttributes.getColor(l.TabLayout_tabSelectedTextColor, 0));
            }
            this.r = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabMinWidth, -1);
            this.s = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabMaxWidth, -1);
            this.i = obtainStyledAttributes.getResourceId(l.TabLayout_tabBackground, 0);
            this.u = obtainStyledAttributes.getDimensionPixelSize(l.TabLayout_tabContentStart, 0);
            this.l = obtainStyledAttributes.getInt(l.TabLayout_tabMode, 1);
            this.k = obtainStyledAttributes.getInt(l.TabLayout_tabGravity, 0);
            obtainStyledAttributes.recycle();
            Resources resources = getResources();
            this.h = (float) resources.getDimensionPixelSize(e.design_tab_text_size_2line);
            this.t = resources.getDimensionPixelSize(e.design_tab_scrollable_min_width);
            g();
        } finally {
            obtainStyledAttributes2.recycle();
        }
    }

    private int a(int i, float f) {
        int i2 = 0;
        if (this.l != 0) {
            return 0;
        }
        View childAt = this.q.getChildAt(i);
        View childAt2 = i + 1 < this.q.getChildCount() ? this.q.getChildAt(i + 1) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        if (childAt2 != null) {
            i2 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        i2 = (int) ((((float) (i2 + width)) * 0.5f) * f);
        return ViewCompat.f(this) == 0 ? i2 + left : left - i2;
    }

    private void a(@NonNull TabItem tabItem) {
        ah a = a();
        if (tabItem.a != null) {
            a.a(tabItem.a);
        }
        if (tabItem.b != null) {
            a.a(tabItem.b);
        }
        if (tabItem.c != 0) {
            a.a(tabItem.c);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            a.b(tabItem.getContentDescription());
        }
        a(a);
    }

    private void a(ah ahVar, int i) {
        ahVar.b(i);
        this.o.add(i, ahVar);
        int size = this.o.size();
        for (int i2 = i + 1; i2 < size; i2++) {
            ((ah) this.o.get(i2)).b(i2);
        }
    }

    private void a(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        if (this.m != null) {
            if (this.B != null) {
                this.m.b(this.B);
            }
            if (this.C != null) {
                this.m.b(this.C);
            }
        }
        if (this.x != null) {
            b(this.x);
            this.x = null;
        }
        if (viewPager != null) {
            this.m = viewPager;
            if (this.B == null) {
                this.B = new ai(this);
            }
            this.B.a();
            viewPager.a(this.B);
            this.x = new ak(viewPager);
            a(this.x);
            n adapter = viewPager.getAdapter();
            if (adapter != null) {
                a(adapter, z);
            }
            if (this.C == null) {
                this.C = new ae(this);
            }
            this.C.a(z);
            viewPager.a(this.C);
            a(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.m = null;
            a(null, false);
        }
        this.D = z2;
    }

    private void a(View view) {
        if (view instanceof TabItem) {
            a((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void a(LinearLayout.LayoutParams layoutParams) {
        if (this.l == 1 && this.k == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private static ColorStateList b(int i, int i2) {
        r0 = new int[2][];
        int[] iArr = new int[]{SELECTED_STATE_SET, i2};
        r0[1] = EMPTY_STATE_SET;
        iArr[1] = i;
        return new ColorStateList(r0, iArr);
    }

    private aj c(@NonNull ah ahVar) {
        aj ajVar = this.E != null ? (aj) this.E.acquire() : null;
        if (ajVar == null) {
            ajVar = new aj(this, getContext());
        }
        ajVar.a(ahVar);
        ajVar.setFocusable(true);
        ajVar.setMinimumWidth(getTabMinWidth());
        return ajVar;
    }

    private void c(int i) {
        aj ajVar = (aj) this.q.getChildAt(i);
        this.q.removeViewAt(i);
        if (ajVar != null) {
            ajVar.a();
            this.E.release(ajVar);
        }
        requestLayout();
    }

    private void d() {
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            ((ah) this.o.get(i)).i();
        }
    }

    private void d(int i) {
        if (i != -1) {
            if (getWindowToken() == null || !ViewCompat.y(this) || this.q.a()) {
                a(i, 0.0f, true);
                return;
            }
            if (getScrollX() != a(i, 0.0f)) {
                f();
                this.y.setIntValues(new int[]{r0, r1});
                this.y.start();
            }
            this.q.b(i, 300);
        }
    }

    private void d(ah ahVar) {
        this.q.addView(ahVar.b, ahVar.d(), e());
    }

    private LinearLayout.LayoutParams e() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        a(layoutParams);
        return layoutParams;
    }

    private void e(@NonNull ah ahVar) {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            ((OnTabSelectedListener) this.w.get(size)).onTabSelected(ahVar);
        }
    }

    private void f() {
        if (this.y == null) {
            this.y = new ValueAnimator();
            this.y.setInterpolator(a.b);
            this.y.setDuration(300);
            this.y.addUpdateListener(new AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private void f(@NonNull ah ahVar) {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            ((OnTabSelectedListener) this.w.get(size)).onTabUnselected(ahVar);
        }
    }

    private void g() {
        ViewCompat.b(this.q, this.l == 0 ? Math.max(0, this.u - this.a) : 0, 0, 0, 0);
        switch (this.l) {
            case 0:
                this.q.setGravity(8388611);
                break;
            case 1:
                this.q.setGravity(1);
                break;
        }
        a(true);
    }

    private void g(@NonNull ah ahVar) {
        for (int size = this.w.size() - 1; size >= 0; size--) {
            ((OnTabSelectedListener) this.w.get(size)).onTabReselected(ahVar);
        }
    }

    private int getDefaultHeight() {
        Object obj;
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            ah ahVar = (ah) this.o.get(i);
            if (ahVar != null && ahVar.c() != null && !TextUtils.isEmpty(ahVar.e())) {
                obj = 1;
                break;
            }
        }
        obj = null;
        return obj != null ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.q.b();
    }

    private int getTabMinWidth() {
        return this.r != -1 ? this.r : this.l == 0 ? this.t : 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.q.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i) {
        int childCount = this.q.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.q.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    @NonNull
    public ah a() {
        ah ahVar = (ah) n.acquire();
        if (ahVar == null) {
            ahVar = new ah();
        }
        ahVar.a = this;
        ahVar.b = c(ahVar);
        return ahVar;
    }

    @Nullable
    public ah a(int i) {
        return (i < 0 || i >= getTabCount()) ? null : (ah) this.o.get(i);
    }

    public void a(int i, float f, boolean z) {
        a(i, f, z, true);
    }

    void a(int i, float f, boolean z, boolean z2) {
        int round = Math.round(((float) i) + f);
        if (round >= 0 && round < this.q.getChildCount()) {
            if (z2) {
                this.q.a(i, f);
            }
            if (this.y != null && this.y.isRunning()) {
                this.y.cancel();
            }
            scrollTo(a(i, f), 0);
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public void a(int i, int i2) {
        setTabTextColors(b(i, i2));
    }

    public void a(@NonNull OnTabSelectedListener onTabSelectedListener) {
        if (!this.w.contains(onTabSelectedListener)) {
            this.w.add(onTabSelectedListener);
        }
    }

    public void a(@NonNull ah ahVar) {
        a(ahVar, this.o.isEmpty());
    }

    public void a(@NonNull ah ahVar, int i, boolean z) {
        if (ahVar.a != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        a(ahVar, i);
        d(ahVar);
        if (z) {
            ahVar.f();
        }
    }

    public void a(@NonNull ah ahVar, boolean z) {
        a(ahVar, this.o.size(), z);
    }

    public void a(@Nullable ViewPager viewPager, boolean z) {
        a(viewPager, z, false);
    }

    void a(@Nullable n nVar, boolean z) {
        if (!(this.z == null || this.A == null)) {
            this.z.b(this.A);
        }
        this.z = nVar;
        if (z && nVar != null) {
            if (this.A == null) {
                this.A = new af(this);
            }
            nVar.a(this.A);
        }
        c();
    }

    void a(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.q.getChildCount()) {
                View childAt = this.q.getChildAt(i2);
                childAt.setMinimumWidth(getTabMinWidth());
                a((LinearLayout.LayoutParams) childAt.getLayoutParams());
                if (z) {
                    childAt.requestLayout();
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void addView(View view) {
        a(view);
    }

    public void addView(View view, int i) {
        a(view);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        a(view);
    }

    int b(int i) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i));
    }

    public void b() {
        for (int childCount = this.q.getChildCount() - 1; childCount >= 0; childCount--) {
            c(childCount);
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ah ahVar = (ah) it.next();
            it.remove();
            ahVar.j();
            n.release(ahVar);
        }
        this.p = null;
    }

    public void b(@NonNull OnTabSelectedListener onTabSelectedListener) {
        this.w.remove(onTabSelectedListener);
    }

    void b(ah ahVar) {
        b(ahVar, true);
    }

    void b(ah ahVar, boolean z) {
        ah ahVar2 = this.p;
        if (ahVar2 != ahVar) {
            int d = ahVar != null ? ahVar.d() : -1;
            if (z) {
                if ((ahVar2 == null || ahVar2.d() == -1) && d != -1) {
                    a(d, 0.0f, true);
                } else {
                    d(d);
                }
                if (d != -1) {
                    setSelectedTabView(d);
                }
            }
            if (ahVar2 != null) {
                f(ahVar2);
            }
            this.p = ahVar;
            if (ahVar != null) {
                e(ahVar);
            }
        } else if (ahVar2 != null) {
            g(ahVar);
            d(ahVar.d());
        }
    }

    void c() {
        b();
        if (this.z != null) {
            int i;
            int b = this.z.b();
            for (i = 0; i < b; i++) {
                a(a().a(this.z.c(i)), false);
            }
            if (this.m != null && b > 0) {
                i = this.m.getCurrentItem();
                if (i != getSelectedTabPosition() && i < getTabCount()) {
                    b(a(i));
                }
            }
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        return this.p != null ? this.p.d() : -1;
    }

    public int getTabCount() {
        return this.o.size();
    }

    public int getTabGravity() {
        return this.k;
    }

    int getTabMaxWidth() {
        return this.j;
    }

    public int getTabMode() {
        return this.l;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.f;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.m == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                a((ViewPager) parent, true, true);
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.D) {
            setupWithViewPager(null);
            this.D = false;
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1;
        int b = (b(getDefaultHeight()) + getPaddingTop()) + getPaddingBottom();
        switch (MeasureSpec.getMode(i2)) {
            case Integer.MIN_VALUE:
                i2 = MeasureSpec.makeMeasureSpec(Math.min(b, MeasureSpec.getSize(i2)), 1073741824);
                break;
            case 0:
                i2 = MeasureSpec.makeMeasureSpec(b, 1073741824);
                break;
        }
        b = MeasureSpec.getSize(i);
        if (MeasureSpec.getMode(i) != 0) {
            this.j = this.s > 0 ? this.s : b - b(56);
        }
        super.onMeasure(i, i2);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            switch (this.l) {
                case 0:
                    if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                        b = 0;
                        break;
                    } else {
                        b = 1;
                        break;
                    }
                case 1:
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        i3 = 0;
                    }
                    b = i3;
                    break;
                default:
                    b = 0;
                    break;
            }
            if (b != 0) {
                childAt.measure(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            }
        }
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        if (this.v != null) {
            b(this.v);
        }
        this.v = onTabSelectedListener;
        if (onTabSelectedListener != null) {
            a(onTabSelectedListener);
        }
    }

    void setScrollAnimatorListener(AnimatorListener animatorListener) {
        f();
        this.y.addListener(animatorListener);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.q.a(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.q.b(i);
    }

    public void setTabGravity(int i) {
        if (this.k != i) {
            this.k = i;
            g();
        }
    }

    public void setTabMode(int i) {
        if (i != this.l) {
            this.l = i;
            g();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.f != colorStateList) {
            this.f = colorStateList;
            d();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable n nVar) {
        a(nVar, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        a(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }
}
