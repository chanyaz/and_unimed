package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.v4.os.h;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ac;
import android.support.v4.view.accessibility.a;
import android.support.v4.view.accessibility.b;
import android.support.v4.view.accessibility.e;
import android.support.v4.view.k;
import android.support.v4.view.l;
import android.support.v4.widget.r;
import android.support.v7.d.d;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class RecyclerView extends ViewGroup implements NestedScrollingChild2, ScrollingView {
    static final Interpolator I = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private static final int[] J = new int[]{16843830};
    private static final int[] K = new int[]{16842987};
    private static final boolean L = (VERSION.SDK_INT >= 21);
    private static final boolean M = (VERSION.SDK_INT <= 15);
    private static final boolean N = (VERSION.SDK_INT <= 15);
    private static final Class<?>[] O = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    static final boolean a;
    static final boolean b = (VERSION.SDK_INT >= 23);
    static final boolean c = (VERSION.SDK_INT >= 16);
    aw A;
    ax B;
    final State C;
    boolean D;
    boolean E;
    boolean F;
    cf G;
    @VisibleForTesting
    final List<ce> H;
    private final ca P;
    private SavedState Q;
    private final Rect R;
    private final ArrayList<OnItemTouchListener> S;
    private OnItemTouchListener T;
    private int U;
    private boolean V;
    private int W;
    private ChildDrawingOrderCallback aA;
    private final int[] aB;
    private l aC;
    private final int[] aD;
    private final int[] aE;
    private final int[] aF;
    private Runnable aG;
    private final ProcessCallback aH;
    private final AccessibilityManager aa;
    private List<OnChildAttachStateChangeListener> ab;
    private int ac;
    private int ad;
    @NonNull
    private EdgeEffectFactory ae;
    private EdgeEffect af;
    private EdgeEffect ag;
    private EdgeEffect ah;
    private EdgeEffect ai;
    private int aj;
    private int ak;
    private VelocityTracker al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    private int aq;
    private bv ar;
    private final int as;
    private final int at;
    private float au;
    private float av;
    private boolean aw;
    private bw ax;
    private List<bw> ay;
    private ItemAnimatorListener az;
    final bz d;
    AdapterHelper e;
    ChildHelper f;
    final ViewInfoStore g;
    boolean h;
    final Runnable i;
    final Rect j;
    final RectF k;
    bo l;
    @VisibleForTesting
    LayoutManager m;
    RecyclerListener n;
    final ArrayList<bt> o;
    boolean p;
    boolean q;
    boolean r;
    @VisibleForTesting
    boolean s;
    boolean t;
    boolean u;
    boolean v;
    boolean w;
    boolean x;
    ItemAnimator y;
    final cd z;

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

        void onRequestDisallowInterceptTouchEvent(boolean z);

        void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public class LayoutParams extends MarginLayoutParams {
        ce c;
        final Rect d = new Rect();
        boolean e = true;
        boolean f = false;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean c() {
            return this.c.i();
        }

        public boolean d() {
            return this.c.l();
        }

        public boolean e() {
            return this.c.r();
        }

        public int f() {
            return this.c.getLayoutPosition();
        }
    }

    public abstract class LayoutManager {
        private final Callback a = new Callback() {
            public View getChildAt(int i) {
                return LayoutManager.this.h(i);
            }

            public int getChildCount() {
                return LayoutManager.this.w();
            }

            public int getChildEnd(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + LayoutManager.this.j(view);
            }

            public int getChildStart(View view) {
                return LayoutManager.this.h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public View getParent() {
                return LayoutManager.this.q;
            }

            public int getParentEnd() {
                return LayoutManager.this.z() - LayoutManager.this.D();
            }

            public int getParentStart() {
                return LayoutManager.this.B();
            }
        };
        private final Callback b = new Callback() {
            public View getChildAt(int i) {
                return LayoutManager.this.h(i);
            }

            public int getChildCount() {
                return LayoutManager.this.w();
            }

            public int getChildEnd(View view) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + LayoutManager.this.k(view);
            }

            public int getChildStart(View view) {
                return LayoutManager.this.i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
            }

            public View getParent() {
                return LayoutManager.this.q;
            }

            public int getParentEnd() {
                return LayoutManager.this.A() - LayoutManager.this.E();
            }

            public int getParentStart() {
                return LayoutManager.this.C();
            }
        };
        private boolean c = true;
        private boolean d = true;
        private int e;
        private int f;
        private int g;
        private int h;
        ChildHelper p;
        RecyclerView q;
        ViewBoundsCheck r = new ViewBoundsCheck(this.a);
        ViewBoundsCheck s = new ViewBoundsCheck(this.b);
        @Nullable
        SmoothScroller t;
        boolean u = false;
        boolean v = false;
        boolean w = false;
        int x;
        boolean y;

        public interface LayoutPrefetchRegistry {
            void addPosition(int i, int i2);
        }

        public static int a(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i);
            int size = MeasureSpec.getSize(i);
            switch (mode) {
                case Integer.MIN_VALUE:
                    return Math.min(size, Math.max(i2, i3));
                case 1073741824:
                    return size;
                default:
                    return Math.max(i2, i3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5 = 0;
            int max = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i5 = 1073741824;
                    max = i4;
                } else if (i4 == -1) {
                    switch (i2) {
                        case Integer.MIN_VALUE:
                        case 1073741824:
                            i5 = max;
                            break;
                        case 0:
                            i2 = 0;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    max = i5;
                    i5 = i2;
                } else {
                    if (i4 == -2) {
                        max = 0;
                    }
                    max = 0;
                }
            } else if (i4 >= 0) {
                i5 = 1073741824;
                max = i4;
            } else if (i4 == -1) {
                i5 = i2;
            } else {
                if (i4 == -2) {
                    if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                        i5 = Integer.MIN_VALUE;
                    }
                }
                max = 0;
            }
            return MeasureSpec.makeMeasureSpec(max, i5);
        }

        public static bu a(Context context, AttributeSet attributeSet, int i, int i2) {
            bu buVar = new bu();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.RecyclerView, i, i2);
            buVar.a = obtainStyledAttributes.getInt(d.RecyclerView_android_orientation, 1);
            buVar.b = obtainStyledAttributes.getInt(d.RecyclerView_spanCount, 1);
            buVar.c = obtainStyledAttributes.getBoolean(d.RecyclerView_reverseLayout, false);
            buVar.d = obtainStyledAttributes.getBoolean(d.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return buVar;
        }

        private void a(int i, View view) {
            this.p.e(i);
        }

        private void a(bz bzVar, int i, View view) {
            ce e = RecyclerView.e(view);
            if (!e.c()) {
                if (!e.i() || e.l() || this.q.l.hasStableIds()) {
                    g(i);
                    bzVar.c(view);
                    this.q.g.h(e);
                    return;
                }
                f(i);
                bzVar.b(e);
            }
        }

        private void a(View view, int i, boolean z) {
            ce e = RecyclerView.e(view);
            if (z || e.l()) {
                this.q.g.e(e);
            } else {
                this.q.g.f(e);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (e.f() || e.d()) {
                if (e.d()) {
                    e.e();
                } else {
                    e.g();
                }
                this.p.a(view, i, view.getLayoutParams(), false);
            } else if (view.getParent() == this.q) {
                int b = this.p.b(view);
                if (i == -1) {
                    i = this.p.b();
                }
                if (b == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(view) + this.q.a());
                } else if (b != i) {
                    this.q.m.f(b, i);
                }
            } else {
                this.p.a(view, i, false);
                layoutParams.e = true;
                if (this.t != null && this.t.h()) {
                    this.t.b(view);
                }
            }
            if (layoutParams.f) {
                e.itemView.invalidate();
                layoutParams.f = false;
            }
        }

        private void b(SmoothScroller smoothScroller) {
            if (this.t == smoothScroller) {
                this.t = null;
            }
        }

        private static boolean b(int i, int i2, int i3) {
            int mode = MeasureSpec.getMode(i2);
            int size = MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            switch (mode) {
                case Integer.MIN_VALUE:
                    return size >= i;
                case 0:
                    return true;
                case 1073741824:
                    return size == i;
                default:
                    return false;
            }
        }

        private int[] b(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int B = B();
            int C = C();
            int z2 = z() - D();
            int A = A() - E();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = left + rect.width();
            int height = top + rect.height();
            int min = Math.min(0, left - B);
            int min2 = Math.min(0, top - C);
            int max = Math.max(0, width - z2);
            A = Math.max(0, height - A);
            if (u() == 1) {
                if (max == 0) {
                    max = Math.max(min, width - z2);
                }
                min = max;
            } else {
                min = min != 0 ? min : Math.min(left - B, max);
            }
            max = min2 != 0 ? min2 : Math.min(top - C, A);
            iArr[0] = min;
            iArr[1] = max;
            return iArr;
        }

        private boolean d(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int B = B();
            int C = C();
            int z = z() - D();
            int A = A() - E();
            Rect rect = this.q.j;
            a(focusedChild, rect);
            return rect.left - i < z && rect.right - i > B && rect.top - i2 < A && rect.bottom - i2 > C;
        }

        public int A() {
            return this.h;
        }

        public int B() {
            return this.q != null ? this.q.getPaddingLeft() : 0;
        }

        public int C() {
            return this.q != null ? this.q.getPaddingTop() : 0;
        }

        public int D() {
            return this.q != null ? this.q.getPaddingRight() : 0;
        }

        public int E() {
            return this.q != null ? this.q.getPaddingBottom() : 0;
        }

        public View F() {
            if (this.q == null) {
                return null;
            }
            View focusedChild = this.q.getFocusedChild();
            return (focusedChild == null || this.p.c(focusedChild)) ? null : focusedChild;
        }

        public int G() {
            return ViewCompat.j(this.q);
        }

        public int H() {
            return ViewCompat.k(this.q);
        }

        void I() {
            if (this.t != null) {
                this.t.f();
            }
        }

        public void J() {
            this.u = true;
        }

        boolean K() {
            int w = w();
            for (int i = 0; i < w; i++) {
                android.view.ViewGroup.LayoutParams layoutParams = h(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int a(int i, bz bzVar, State state) {
            return 0;
        }

        public int a(bz bzVar, State state) {
            return (this.q == null || this.q.l == null || !f()) ? 1 : this.q.l.getItemCount();
        }

        public abstract LayoutParams a();

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public LayoutParams a(android.view.ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        @Nullable
        public View a(View view, int i, bz bzVar, State state) {
            return null;
        }

        public void a(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void a(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        }

        public void a(int i, bz bzVar) {
            View h = h(i);
            f(i);
            bzVar.a(h);
        }

        public void a(Rect rect, int i, int i2) {
            g(a(i, (rect.width() + B()) + D(), G()), a(i2, (rect.height() + C()) + E(), H()));
        }

        public void a(Parcelable parcelable) {
        }

        void a(b bVar) {
            a(this.q.d, this.q.C, bVar);
        }

        public void a(SmoothScroller smoothScroller) {
            if (!(this.t == null || smoothScroller == this.t || !this.t.h())) {
                this.t.f();
            }
            this.t = smoothScroller;
            this.t.a(this.q, this);
        }

        public void a(State state) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i, int i2) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void a(RecyclerView recyclerView, int i, int i2, Object obj) {
            c(recyclerView, i, i2);
        }

        public void a(RecyclerView recyclerView, State state, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @CallSuper
        public void a(RecyclerView recyclerView, bz bzVar) {
            e(recyclerView);
        }

        public void a(bo boVar, bo boVar2) {
        }

        public void a(bz bzVar) {
            for (int w = w() - 1; w >= 0; w--) {
                a(bzVar, w, h(w));
            }
        }

        public void a(bz bzVar, State state, int i, int i2) {
            this.q.e(i, i2);
        }

        public void a(bz bzVar, State state, b bVar) {
            if (this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1)) {
                bVar.a(8192);
                bVar.k(true);
            }
            if (this.q.canScrollVertically(1) || this.q.canScrollHorizontally(1)) {
                bVar.a(4096);
                bVar.k(true);
            }
            bVar.a(android.support.v4.view.accessibility.d.a(a(bzVar, state), b(bzVar, state), e(bzVar, state), d(bzVar, state)));
        }

        public void a(bz bzVar, State state, View view, b bVar) {
            bVar.b(e.a(f() ? d(view) : 0, 1, e() ? d(view) : 0, 1, false, false));
        }

        public void a(bz bzVar, State state, AccessibilityEvent accessibilityEvent) {
            boolean z = true;
            if (this.q != null && accessibilityEvent != null) {
                if (!(this.q.canScrollVertically(1) || this.q.canScrollVertically(-1) || this.q.canScrollHorizontally(-1) || this.q.canScrollHorizontally(1))) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                if (this.q.l != null) {
                    accessibilityEvent.setItemCount(this.q.l.getItemCount());
                }
            }
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public void a(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect k = this.q.k(view);
            int i3 = (k.left + k.right) + i;
            int i4 = (k.bottom + k.top) + i2;
            i3 = a(z(), x(), i3 + (((B() + D()) + layoutParams.leftMargin) + layoutParams.rightMargin), layoutParams.width, e());
            i4 = a(A(), y(), i4 + (((C() + E()) + layoutParams.topMargin) + layoutParams.bottomMargin), layoutParams.height, f());
            if (b(view, i3, i4, layoutParams)) {
                view.measure(i3, i4);
            }
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.d;
            view.layout((rect.left + i) + layoutParams.leftMargin, (rect.top + i2) + layoutParams.topMargin, (i3 - rect.right) - layoutParams.rightMargin, (i4 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void a(View view, int i, LayoutParams layoutParams) {
            ce e = RecyclerView.e(view);
            if (e.l()) {
                this.q.g.e(e);
            } else {
                this.q.g.f(e);
            }
            this.p.a(view, i, layoutParams, e.l());
        }

        public void a(View view, Rect rect) {
            RecyclerView.a(view, rect);
        }

        void a(View view, b bVar) {
            ce e = RecyclerView.e(view);
            if (e != null && !e.l() && !this.p.c(e.itemView)) {
                a(this.q.d, this.q.C, view, bVar);
            }
        }

        public void a(View view, bz bzVar) {
            c(view);
            bzVar.a(view);
        }

        public void a(View view, boolean z, Rect rect) {
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, rect2.bottom + view.getHeight());
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.q != null) {
                Matrix matrix = view.getMatrix();
                if (!(matrix == null || matrix.isIdentity())) {
                    RectF rectF = this.q.k;
                    rectF.set(rect);
                    matrix.mapRect(rectF);
                    rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
                }
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.q.d, this.q.C, accessibilityEvent);
        }

        public void a(String str) {
            if (this.q != null) {
                this.q.a(str);
            }
        }

        boolean a(int i, Bundle bundle) {
            return a(this.q.d, this.q.C, i, bundle);
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public boolean a(RecyclerView recyclerView, State state, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return a(recyclerView, view, rect, z, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] b = b(recyclerView, view, rect, z);
            int i = b[0];
            int i2 = b[1];
            if (z2 && !d(recyclerView, i, i2)) {
                return false;
            }
            if (i == 0 && i2 == 0) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.a(i, i2);
            }
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return t() || recyclerView.o();
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        /* JADX WARNING: Missing block: B:19:0x007a, code:
            r3 = r0;
            r0 = 0;
     */
        public boolean a(android.support.v7.widget.bz r7, android.support.v7.widget.RecyclerView.State r8, int r9, android.os.Bundle r10) {
            /*
            r6 = this;
            r4 = -1;
            r2 = 1;
            r1 = 0;
            r0 = r6.q;
            if (r0 != 0) goto L_0x0008;
        L_0x0007:
            return r1;
        L_0x0008:
            switch(r9) {
                case 4096: goto L_0x004a;
                case 8192: goto L_0x0018;
                default: goto L_0x000b;
            };
        L_0x000b:
            r0 = r1;
            r3 = r1;
        L_0x000d:
            if (r3 != 0) goto L_0x0011;
        L_0x000f:
            if (r0 == 0) goto L_0x0007;
        L_0x0011:
            r1 = r6.q;
            r1.scrollBy(r0, r3);
            r1 = r2;
            goto L_0x0007;
        L_0x0018:
            r0 = r6.q;
            r0 = r0.canScrollVertically(r4);
            if (r0 == 0) goto L_0x007f;
        L_0x0020:
            r0 = r6.A();
            r3 = r6.C();
            r0 = r0 - r3;
            r3 = r6.E();
            r0 = r0 - r3;
            r0 = -r0;
        L_0x002f:
            r3 = r6.q;
            r3 = r3.canScrollHorizontally(r4);
            if (r3 == 0) goto L_0x007a;
        L_0x0037:
            r3 = r6.z();
            r4 = r6.B();
            r3 = r3 - r4;
            r4 = r6.D();
            r3 = r3 - r4;
            r3 = -r3;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x004a:
            r0 = r6.q;
            r0 = r0.canScrollVertically(r2);
            if (r0 == 0) goto L_0x007d;
        L_0x0052:
            r0 = r6.A();
            r3 = r6.C();
            r0 = r0 - r3;
            r3 = r6.E();
            r0 = r0 - r3;
        L_0x0060:
            r3 = r6.q;
            r3 = r3.canScrollHorizontally(r2);
            if (r3 == 0) goto L_0x007a;
        L_0x0068:
            r3 = r6.z();
            r4 = r6.B();
            r3 = r3 - r4;
            r4 = r6.D();
            r3 = r3 - r4;
            r5 = r3;
            r3 = r0;
            r0 = r5;
            goto L_0x000d;
        L_0x007a:
            r3 = r0;
            r0 = r1;
            goto L_0x000d;
        L_0x007d:
            r0 = r1;
            goto L_0x0060;
        L_0x007f:
            r0 = r1;
            goto L_0x002f;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.LayoutManager.a(android.support.v7.widget.bz, android.support.v7.widget.RecyclerView$State, int, android.os.Bundle):boolean");
        }

        public boolean a(bz bzVar, State state, View view, int i, Bundle bundle) {
            return false;
        }

        boolean a(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.c && b(view.getMeasuredWidth(), i, layoutParams.width) && b(view.getMeasuredHeight(), i2, layoutParams.height)) ? false : true;
        }

        boolean a(View view, int i, Bundle bundle) {
            return a(this.q.d, this.q.C, view, i, bundle);
        }

        public boolean a(@NonNull View view, boolean z, boolean z2) {
            boolean z3 = this.r.a(view, 24579) && this.s.a(view, 24579);
            return z ? z3 : !z3;
        }

        public boolean a(Runnable runnable) {
            return this.q != null ? this.q.removeCallbacks(runnable) : false;
        }

        public int b(int i, bz bzVar, State state) {
            return 0;
        }

        public int b(bz bzVar, State state) {
            return (this.q == null || this.q.l == null || !e()) ? 1 : this.q.l.getItemCount();
        }

        void b(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.q = null;
                this.p = null;
                this.g = 0;
                this.h = 0;
            } else {
                this.q = recyclerView;
                this.p = recyclerView.f;
                this.g = recyclerView.getWidth();
                this.h = recyclerView.getHeight();
            }
            this.e = 1073741824;
            this.f = 1073741824;
        }

        public void b(RecyclerView recyclerView, int i, int i2) {
        }

        void b(RecyclerView recyclerView, bz bzVar) {
            this.v = false;
            a(recyclerView, bzVar);
        }

        void b(bz bzVar) {
            int e = bzVar.e();
            for (int i = e - 1; i >= 0; i--) {
                View e2 = bzVar.e(i);
                ce e3 = RecyclerView.e(e2);
                if (!e3.c()) {
                    e3.setIsRecyclable(false);
                    if (e3.m()) {
                        this.q.removeDetachedView(e2, false);
                    }
                    if (this.q.y != null) {
                        this.q.y.d(e3);
                    }
                    e3.setIsRecyclable(true);
                    bzVar.b(e2);
                }
            }
            bzVar.f();
            if (e > 0) {
                this.q.invalidate();
            }
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        public void b(View view, Rect rect) {
            if (this.q == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(this.q.k(view));
            }
        }

        public boolean b() {
            return false;
        }

        boolean b(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.c && b(view.getWidth(), i, layoutParams.width) && b(view.getHeight(), i2, layoutParams.height)) ? false : true;
        }

        public int c(State state) {
            return 0;
        }

        public View c(int i) {
            int w = w();
            for (int i2 = 0; i2 < w; i2++) {
                View h = h(i2);
                ce e = RecyclerView.e(h);
                if (e != null && e.getLayoutPosition() == i && !e.c() && (this.q.C.a() || !e.l())) {
                    return h;
                }
            }
            return null;
        }

        void c(RecyclerView recyclerView) {
            this.v = true;
            d(recyclerView);
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }

        public void c(bz bzVar) {
            for (int w = w() - 1; w >= 0; w--) {
                if (!RecyclerView.e(h(w)).c()) {
                    a(w, bzVar);
                }
            }
        }

        public void c(bz bzVar, State state) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void c(View view) {
            this.p.a(view);
        }

        public void c(View view, int i) {
            a(view, i, (LayoutParams) view.getLayoutParams());
        }

        public boolean c() {
            return this.w;
        }

        public int d(State state) {
            return 0;
        }

        public int d(bz bzVar, State state) {
            return 0;
        }

        public int d(View view) {
            return ((LayoutParams) view.getLayoutParams()).f();
        }

        public Parcelable d() {
            return null;
        }

        public View d(View view, int i) {
            return null;
        }

        public void d(int i) {
        }

        void d(int i, int i2) {
            this.g = MeasureSpec.getSize(i);
            this.e = MeasureSpec.getMode(i);
            if (this.e == 0 && !RecyclerView.b) {
                this.g = 0;
            }
            this.h = MeasureSpec.getSize(i2);
            this.f = MeasureSpec.getMode(i2);
            if (this.f == 0 && !RecyclerView.b) {
                this.h = 0;
            }
        }

        @CallSuper
        public void d(RecyclerView recyclerView) {
        }

        public int e(State state) {
            return 0;
        }

        @Nullable
        public View e(View view) {
            if (this.q == null) {
                return null;
            }
            View c = this.q.c(view);
            return (c == null || this.p.c(c)) ? null : c;
        }

        void e(int i, int i2) {
            int i3 = MoPubClientPositioning.NO_REPEAT;
            int i4 = Integer.MIN_VALUE;
            int w = w();
            if (w == 0) {
                this.q.e(i, i2);
                return;
            }
            int i5 = Integer.MIN_VALUE;
            int i6 = MoPubClientPositioning.NO_REPEAT;
            for (int i7 = 0; i7 < w; i7++) {
                View h = h(i7);
                Rect rect = this.q.j;
                a(h, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i5) {
                    i5 = rect.right;
                }
                if (rect.top < i3) {
                    i3 = rect.top;
                }
                if (rect.bottom > i4) {
                    i4 = rect.bottom;
                }
            }
            this.q.j.set(i6, i3, i5, i4);
            a(this.q.j, i, i2);
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e() {
            return false;
        }

        public boolean e(bz bzVar, State state) {
            return false;
        }

        public int f(State state) {
            return 0;
        }

        public int f(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).d;
            return rect.right + (view.getMeasuredWidth() + rect.left);
        }

        public void f(int i) {
            if (h(i) != null) {
                this.p.a(i);
            }
        }

        public void f(int i, int i2) {
            View h = h(i);
            if (h == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.q.toString());
            }
            g(i);
            c(h, i2);
        }

        void f(RecyclerView recyclerView) {
            d(MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public boolean f() {
            return false;
        }

        public int g(State state) {
            return 0;
        }

        public int g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).d;
            return rect.bottom + (view.getMeasuredHeight() + rect.top);
        }

        public void g(int i) {
            a(i, h(i));
        }

        public void g(int i, int i2) {
            this.q.setMeasuredDimension(i, i2);
        }

        public int h(State state) {
            return 0;
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public View h(int i) {
            return this.p != null ? this.p.b(i) : null;
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public void i(int i) {
            if (this.q != null) {
                this.q.g(i);
            }
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public void j(int i) {
            if (this.q != null) {
                this.q.f(i);
            }
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void k(int i) {
        }

        public int l(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.top;
        }

        public int m(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.bottom;
        }

        boolean m() {
            return false;
        }

        public int n(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.left;
        }

        public int o(View view) {
            return ((LayoutParams) view.getLayoutParams()).d.right;
        }

        public void p() {
            if (this.q != null) {
                this.q.requestLayout();
            }
        }

        public final boolean q() {
            return this.d;
        }

        public boolean r() {
            return this.v;
        }

        public boolean s() {
            return this.q != null && this.q.h;
        }

        public boolean t() {
            return this.t != null && this.t.h();
        }

        public int u() {
            return ViewCompat.f(this.q);
        }

        public int v() {
            return -1;
        }

        public int w() {
            return this.p != null ? this.p.b() : 0;
        }

        public int x() {
            return this.e;
        }

        public int y() {
            return this.f;
        }

        public int z() {
            return this.g;
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int i, int i2);
    }

    public class EdgeEffectFactory {

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        @NonNull
        protected EdgeEffect a(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public abstract class ItemAnimator {
        private ItemAnimatorListener a = null;
        private ArrayList<ItemAnimatorFinishedListener> b = new ArrayList();
        private long c = 120;
        private long d = 120;
        private long e = 250;
        private long f = 250;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAnimationFinished(ce ceVar);
        }

        static int e(ce ceVar) {
            int d = ceVar.m & 14;
            if (ceVar.i()) {
                return 4;
            }
            if ((d & 4) != 0) {
                return d;
            }
            int oldPosition = ceVar.getOldPosition();
            int adapterPosition = ceVar.getAdapterPosition();
            return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? d : d | 2048;
        }

        @NonNull
        public br a(@NonNull State state, @NonNull ce ceVar) {
            return j().a(ceVar);
        }

        @NonNull
        public br a(@NonNull State state, @NonNull ce ceVar, int i, @NonNull List<Object> list) {
            return j().a(ceVar);
        }

        public abstract void a();

        void a(ItemAnimatorListener itemAnimatorListener) {
            this.a = itemAnimatorListener;
        }

        public final boolean a(ItemAnimatorFinishedListener itemAnimatorFinishedListener) {
            boolean b = b();
            if (itemAnimatorFinishedListener != null) {
                if (b) {
                    this.b.add(itemAnimatorFinishedListener);
                } else {
                    itemAnimatorFinishedListener.onAnimationsFinished();
                }
            }
            return b;
        }

        public abstract boolean a(@NonNull ce ceVar, @NonNull br brVar, @Nullable br brVar2);

        public abstract boolean a(@NonNull ce ceVar, @NonNull ce ceVar2, @NonNull br brVar, @NonNull br brVar2);

        public boolean a(@NonNull ce ceVar, @NonNull List<Object> list) {
            return h(ceVar);
        }

        public abstract boolean b();

        public abstract boolean b(@NonNull ce ceVar, @Nullable br brVar, @NonNull br brVar2);

        public abstract boolean c(@NonNull ce ceVar, @NonNull br brVar, @NonNull br brVar2);

        public abstract void d();

        public abstract void d(ce ceVar);

        public long e() {
            return this.e;
        }

        public long f() {
            return this.c;
        }

        public final void f(ce ceVar) {
            g(ceVar);
            if (this.a != null) {
                this.a.onAnimationFinished(ceVar);
            }
        }

        public long g() {
            return this.d;
        }

        public void g(ce ceVar) {
        }

        public long h() {
            return this.f;
        }

        public boolean h(@NonNull ce ceVar) {
            return true;
        }

        public final void i() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                ((ItemAnimatorFinishedListener) this.b.get(i)).onAnimationsFinished();
            }
            this.b.clear();
        }

        public br j() {
            return new br();
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View view);

        void onChildViewDetachedFromWindow(View view);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public interface RecyclerListener {
        void onViewRecycled(ce ceVar);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Parcelable a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = LayoutManager.class.getClassLoader();
            }
            this.a = parcel.readParcelable(classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        void a(SavedState savedState) {
            this.a = savedState.a;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.a, 0);
        }
    }

    public abstract class SmoothScroller {
        private int a = -1;
        private RecyclerView b;
        private LayoutManager c;
        private boolean d;
        private boolean e;
        private View f;
        private final cb g = new cb(0, 0);

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int i);
        }

        private void a(int i, int i2) {
            RecyclerView recyclerView = this.b;
            if (!this.e || this.a == -1 || recyclerView == null) {
                f();
            }
            this.d = false;
            if (this.f != null) {
                if (a(this.f) == this.a) {
                    a(this.f, recyclerView.C, this.g);
                    this.g.a(recyclerView);
                    f();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f = null;
                }
            }
            if (this.e) {
                a(i, i2, recyclerView.C, this.g);
                boolean a = this.g.a();
                this.g.a(recyclerView);
                if (!a) {
                    return;
                }
                if (this.e) {
                    this.d = true;
                    recyclerView.z.a();
                    return;
                }
                f();
            }
        }

        public int a(View view) {
            return this.b.h(view);
        }

        protected abstract void a();

        protected abstract void a(int i, int i2, State state, cb cbVar);

        protected void a(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        void a(RecyclerView recyclerView, LayoutManager layoutManager) {
            this.b = recyclerView;
            this.c = layoutManager;
            if (this.a == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            this.b.C.p = this.a;
            this.e = true;
            this.d = true;
            this.f = e(i());
            a();
            this.b.z.a();
        }

        protected abstract void a(View view, State state, cb cbVar);

        protected abstract void b();

        protected void b(View view) {
            if (a(view) == i()) {
                this.f = view;
            }
        }

        public void d(int i) {
            this.a = i;
        }

        @Nullable
        public LayoutManager e() {
            return this.c;
        }

        public View e(int i) {
            return this.b.m.c(i);
        }

        protected final void f() {
            if (this.e) {
                this.e = false;
                b();
                this.b.C.p = -1;
                this.f = null;
                this.a = -1;
                this.d = false;
                this.c.b(this);
                this.c = null;
                this.b = null;
            }
        }

        public boolean g() {
            return this.d;
        }

        public boolean h() {
            return this.e;
        }

        public int i() {
            return this.a;
        }

        public int j() {
            return this.b.m.w();
        }
    }

    public class State {
        int a = 0;
        int b = 0;
        int c = 1;
        int d = 0;
        boolean e = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        int k;
        long l;
        int m;
        int n;
        int o;
        private int p = -1;
        private SparseArray<Object> q;

        @Retention(RetentionPolicy.SOURCE)
        @interface LayoutState {
        }

        void a(int i) {
            if ((this.c & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.c));
            }
        }

        void a(bo boVar) {
            this.c = 1;
            this.d = boVar.getItemCount();
            this.f = false;
            this.g = false;
            this.h = false;
        }

        public boolean a() {
            return this.f;
        }

        public boolean b() {
            return this.j;
        }

        public int c() {
            return this.p;
        }

        public boolean d() {
            return this.p != -1;
        }

        public int e() {
            return this.f ? this.a - this.b : this.d;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.p + ", mData=" + this.q + ", mItemCount=" + this.d + ", mIsMeasuring=" + this.h + ", mPreviousLayoutItemCount=" + this.a + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.b + ", mStructureChanged=" + this.e + ", mInPreLayout=" + this.f + ", mRunSimpleAnimations=" + this.i + ", mRunPredictiveAnimations=" + this.j + '}';
        }
    }

    static {
        boolean z = VERSION.SDK_INT == 18 || VERSION.SDK_INT == 19 || VERSION.SDK_INT == 20;
        a = z;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes;
        boolean z = true;
        super(context, attributeSet, i);
        this.P = new ca(this);
        this.d = new bz(this);
        this.g = new ViewInfoStore();
        this.i = new Runnable() {
            public void run() {
                if (RecyclerView.this.s && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.p) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.u) {
                        RecyclerView.this.t = true;
                    } else {
                        RecyclerView.this.d();
                    }
                }
            }
        };
        this.j = new Rect();
        this.R = new Rect();
        this.k = new RectF();
        this.o = new ArrayList();
        this.S = new ArrayList();
        this.U = 0;
        this.w = false;
        this.x = false;
        this.ac = 0;
        this.ad = 0;
        this.ae = new EdgeEffectFactory();
        this.y = new ak();
        this.aj = 0;
        this.ak = -1;
        this.au = Float.MIN_VALUE;
        this.av = Float.MIN_VALUE;
        this.aw = true;
        this.z = new cd(this);
        this.B = L ? new ax() : null;
        this.C = new State();
        this.D = false;
        this.E = false;
        this.az = new bs(this);
        this.F = false;
        this.aB = new int[2];
        this.aD = new int[2];
        this.aE = new int[2];
        this.aF = new int[2];
        this.H = new ArrayList();
        this.aG = new Runnable() {
            public void run() {
                if (RecyclerView.this.y != null) {
                    RecyclerView.this.y.a();
                }
                RecyclerView.this.F = false;
            }
        };
        this.aH = new ProcessCallback() {
            public void processAppeared(ce ceVar, br brVar, br brVar2) {
                RecyclerView.this.a(ceVar, brVar, brVar2);
            }

            public void processDisappeared(ce ceVar, @NonNull br brVar, @Nullable br brVar2) {
                RecyclerView.this.d.c(ceVar);
                RecyclerView.this.b(ceVar, brVar, brVar2);
            }

            public void processPersistent(ce ceVar, @NonNull br brVar, @NonNull br brVar2) {
                ceVar.setIsRecyclable(false);
                if (RecyclerView.this.w) {
                    if (RecyclerView.this.y.a(ceVar, ceVar, brVar, brVar2)) {
                        RecyclerView.this.p();
                    }
                } else if (RecyclerView.this.y.c(ceVar, brVar, brVar2)) {
                    RecyclerView.this.p();
                }
            }

            public void unused(ce ceVar) {
                RecyclerView.this.m.a(ceVar.itemView, RecyclerView.this.d);
            }
        };
        if (attributeSet != null) {
            obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, K, i, 0);
            this.h = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
        } else {
            this.h = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.aq = viewConfiguration.getScaledTouchSlop();
        this.au = ac.a(viewConfiguration, context);
        this.av = ac.b(viewConfiguration, context);
        this.as = viewConfiguration.getScaledMinimumFlingVelocity();
        this.at = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.y.a(this.az);
        b();
        z();
        if (ViewCompat.e(this) == 0) {
            ViewCompat.b((View) this, 1);
        }
        this.aa = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new cf(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, d.RecyclerView, i, 0);
            String string = obtainStyledAttributes2.getString(d.RecyclerView_layoutManager);
            if (obtainStyledAttributes2.getInt(d.RecyclerView_android_descendantFocusability, -1) == -1) {
                setDescendantFocusability(262144);
            }
            this.r = obtainStyledAttributes2.getBoolean(d.RecyclerView_fastScrollEnabled, false);
            if (this.r) {
                a((StateListDrawable) obtainStyledAttributes2.getDrawable(d.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes2.getDrawable(d.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes2.getDrawable(d.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes2.getDrawable(d.RecyclerView_fastScrollHorizontalTrackDrawable));
            }
            obtainStyledAttributes2.recycle();
            a(context, string, attributeSet, i, 0);
            if (VERSION.SDK_INT >= 21) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, J, i, 0);
                z = obtainStyledAttributes.getBoolean(0, true);
                obtainStyledAttributes.recycle();
            }
        } else {
            setDescendantFocusability(262144);
        }
        setNestedScrollingEnabled(z);
    }

    private boolean A() {
        int b = this.f.b();
        for (int i = 0; i < b; i++) {
            ce e = e(this.f.b(i));
            if (e != null && !e.c() && e.r()) {
                return true;
            }
        }
        return false;
    }

    private void B() {
        this.z.b();
        if (this.m != null) {
            this.m.I();
        }
    }

    private void C() {
        int i = 0;
        if (this.af != null) {
            this.af.onRelease();
            i = this.af.isFinished();
        }
        if (this.ag != null) {
            this.ag.onRelease();
            i |= this.ag.isFinished();
        }
        if (this.ah != null) {
            this.ah.onRelease();
            i |= this.ah.isFinished();
        }
        if (this.ai != null) {
            this.ai.onRelease();
            i |= this.ai.isFinished();
        }
        if (i != 0) {
            ViewCompat.d(this);
        }
    }

    private void D() {
        if (this.al != null) {
            this.al.clear();
        }
        stopNestedScroll(0);
        C();
    }

    private void E() {
        D();
        setScrollState(0);
    }

    private void F() {
        int i = this.W;
        this.W = 0;
        if (i != 0 && n()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            a.a(obtain, i);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private boolean G() {
        return this.y != null && this.m.b();
    }

    private void H() {
        boolean z = true;
        if (this.w) {
            this.e.a();
            if (this.x) {
                this.m.a(this);
            }
        }
        if (G()) {
            this.e.b();
        } else {
            this.e.e();
        }
        boolean z2 = this.D || this.E;
        State state = this.C;
        boolean z3 = this.s && this.y != null && ((this.w || z2 || this.m.u) && (!this.w || this.l.hasStableIds()));
        state.i = z3;
        State state2 = this.C;
        if (!(this.C.i && z2 && !this.w && G())) {
            z = false;
        }
        state2.j = z;
    }

    private void I() {
        View focusedChild = (this.aw && hasFocus() && this.l != null) ? getFocusedChild() : null;
        ce d = focusedChild == null ? null : d(focusedChild);
        if (d == null) {
            J();
            return;
        }
        this.C.l = this.l.hasStableIds() ? d.getItemId() : -1;
        State state = this.C;
        int adapterPosition = this.w ? -1 : d.l() ? d.c : d.getAdapterPosition();
        state.k = adapterPosition;
        this.C.m = o(d.itemView);
    }

    private void J() {
        this.C.l = -1;
        this.C.k = -1;
        this.C.m = -1;
    }

    @Nullable
    private View K() {
        int i = this.C.k != -1 ? this.C.k : 0;
        int e = this.C.e();
        int i2 = i;
        while (i2 < e) {
            ce e2 = e(i2);
            if (e2 == null) {
                break;
            } else if (e2.itemView.hasFocusable()) {
                return e2.itemView;
            } else {
                i2++;
            }
        }
        for (i = Math.min(e, i) - 1; i >= 0; i--) {
            ce e3 = e(i);
            if (e3 == null) {
                return null;
            }
            if (e3.itemView.hasFocusable()) {
                return e3.itemView;
            }
        }
        return null;
    }

    /* JADX WARNING: Missing block: B:44:0x00a7, code:
            if (r0.isFocusable() != false) goto L_0x00a9;
     */
    private void L() {
        /*
        r6 = this;
        r4 = -1;
        r1 = 0;
        r0 = r6.aw;
        if (r0 == 0) goto L_0x0027;
    L_0x0007:
        r0 = r6.l;
        if (r0 == 0) goto L_0x0027;
    L_0x000b:
        r0 = r6.hasFocus();
        if (r0 == 0) goto L_0x0027;
    L_0x0011:
        r0 = r6.getDescendantFocusability();
        r2 = 393216; // 0x60000 float:5.51013E-40 double:1.942745E-318;
        if (r0 == r2) goto L_0x0027;
    L_0x0019:
        r0 = r6.getDescendantFocusability();
        r2 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        if (r0 != r2) goto L_0x0028;
    L_0x0021:
        r0 = r6.isFocused();
        if (r0 == 0) goto L_0x0028;
    L_0x0027:
        return;
    L_0x0028:
        r0 = r6.isFocused();
        if (r0 != 0) goto L_0x0056;
    L_0x002e:
        r0 = r6.getFocusedChild();
        r2 = N;
        if (r2 == 0) goto L_0x004e;
    L_0x0036:
        r2 = r0.getParent();
        if (r2 == 0) goto L_0x0042;
    L_0x003c:
        r2 = r0.hasFocus();
        if (r2 != 0) goto L_0x004e;
    L_0x0042:
        r0 = r6.f;
        r0 = r0.b();
        if (r0 != 0) goto L_0x0056;
    L_0x004a:
        r6.requestFocus();
        goto L_0x0027;
    L_0x004e:
        r2 = r6.f;
        r0 = r2.c(r0);
        if (r0 == 0) goto L_0x0027;
    L_0x0056:
        r0 = r6.C;
        r2 = r0.l;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00b3;
    L_0x005e:
        r0 = r6.l;
        r0 = r0.hasStableIds();
        if (r0 == 0) goto L_0x00b3;
    L_0x0066:
        r0 = r6.C;
        r2 = r0.l;
        r0 = r6.a(r2);
    L_0x006e:
        if (r0 == 0) goto L_0x0082;
    L_0x0070:
        r2 = r6.f;
        r3 = r0.itemView;
        r2 = r2.c(r3);
        if (r2 != 0) goto L_0x0082;
    L_0x007a:
        r2 = r0.itemView;
        r2 = r2.hasFocusable();
        if (r2 != 0) goto L_0x00ae;
    L_0x0082:
        r0 = r6.f;
        r0 = r0.b();
        if (r0 <= 0) goto L_0x008e;
    L_0x008a:
        r1 = r6.K();
    L_0x008e:
        if (r1 == 0) goto L_0x0027;
    L_0x0090:
        r0 = r6.C;
        r0 = r0.m;
        r2 = (long) r0;
        r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r0 == 0) goto L_0x00b1;
    L_0x0099:
        r0 = r6.C;
        r0 = r0.m;
        r0 = r1.findViewById(r0);
        if (r0 == 0) goto L_0x00b1;
    L_0x00a3:
        r2 = r0.isFocusable();
        if (r2 == 0) goto L_0x00b1;
    L_0x00a9:
        r0.requestFocus();
        goto L_0x0027;
    L_0x00ae:
        r1 = r0.itemView;
        goto L_0x008e;
    L_0x00b1:
        r0 = r1;
        goto L_0x00a9;
    L_0x00b3:
        r0 = r1;
        goto L_0x006e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.L():void");
    }

    private void M() {
        int b;
        int i;
        ce e;
        boolean z = true;
        this.C.a(1);
        a(this.C);
        this.C.h = false;
        e();
        this.g.a();
        l();
        H();
        I();
        State state = this.C;
        if (!(this.C.i && this.E)) {
            z = false;
        }
        state.g = z;
        this.E = false;
        this.D = false;
        this.C.f = this.C.j;
        this.C.d = this.l.getItemCount();
        a(this.aB);
        if (this.C.i) {
            b = this.f.b();
            for (i = 0; i < b; i++) {
                e = e(this.f.b(i));
                if (!e.c() && (!e.i() || this.l.hasStableIds())) {
                    this.g.a(e, this.y.a(this.C, e, ItemAnimator.e(e), e.p()));
                    if (!(!this.C.g || !e.r() || e.l() || e.c() || e.i())) {
                        this.g.a(a(e), e);
                    }
                }
            }
        }
        if (this.C.j) {
            s();
            z = this.C.e;
            this.C.e = false;
            this.m.c(this.d, this.C);
            this.C.e = z;
            for (i = 0; i < this.f.b(); i++) {
                e = e(this.f.b(i));
                if (!(e.c() || this.g.d(e))) {
                    b = ItemAnimator.e(e);
                    boolean a = e.a(8192);
                    if (!a) {
                        b |= 4096;
                    }
                    br a2 = this.y.a(this.C, e, b, e.p());
                    if (a) {
                        a(e, a2);
                    } else {
                        this.g.b(e, a2);
                    }
                }
            }
            t();
        } else {
            t();
        }
        m();
        a(false);
        this.C.c = 2;
    }

    private void N() {
        e();
        l();
        this.C.a(6);
        this.e.e();
        this.C.d = this.l.getItemCount();
        this.C.b = 0;
        this.C.f = false;
        this.m.c(this.d, this.C);
        this.C.e = false;
        this.Q = null;
        State state = this.C;
        boolean z = this.C.i && this.y != null;
        state.i = z;
        this.C.c = 4;
        m();
        a(false);
    }

    private void O() {
        this.C.a(4);
        e();
        l();
        this.C.c = 1;
        if (this.C.i) {
            for (int b = this.f.b() - 1; b >= 0; b--) {
                ce e = e(this.f.b(b));
                if (!e.c()) {
                    long a = a(e);
                    br a2 = this.y.a(this.C, e);
                    ce a3 = this.g.a(a);
                    if (a3 == null || a3.c()) {
                        this.g.c(e, a2);
                    } else {
                        boolean a4 = this.g.a(a3);
                        boolean a5 = this.g.a(e);
                        if (a4 && a3 == e) {
                            this.g.c(e, a2);
                        } else {
                            br b2 = this.g.b(a3);
                            this.g.c(e, a2);
                            br c = this.g.c(e);
                            if (b2 == null) {
                                a(a, e, a3);
                            } else {
                                a(a3, e, b2, c, a4, a5);
                            }
                        }
                    }
                }
            }
            this.g.a(this.aH);
        }
        this.m.b(this.d);
        this.C.a = this.C.d;
        this.w = false;
        this.x = false;
        this.C.i = false;
        this.C.j = false;
        this.m.u = false;
        if (this.d.b != null) {
            this.d.b.clear();
        }
        if (this.m.y) {
            this.m.x = 0;
            this.m.y = false;
            this.d.b();
        }
        this.m.a(this.C);
        m();
        a(false);
        this.g.a();
        if (j(this.aB[0], this.aB[1])) {
            i(0, 0);
        }
        L();
        J();
    }

    private String a(Context context, String str) {
        return str.charAt(0) == '.' ? context.getPackageName() + str : !str.contains(".") ? RecyclerView.class.getPackage().getName() + '.' + str : str;
    }

    private void a(float f, float f2, float f3, float f4) {
        Object obj = 1;
        Object obj2 = null;
        if (f2 < 0.0f) {
            g();
            r.a(this.af, (-f2) / ((float) getWidth()), 1.0f - (f3 / ((float) getHeight())));
            obj2 = 1;
        } else if (f2 > 0.0f) {
            h();
            r.a(this.ah, f2 / ((float) getWidth()), f3 / ((float) getHeight()));
            int obj22 = 1;
        }
        if (f4 < 0.0f) {
            i();
            r.a(this.ag, (-f4) / ((float) getHeight()), f / ((float) getWidth()));
        } else if (f4 > 0.0f) {
            j();
            r.a(this.ai, f4 / ((float) getHeight()), 1.0f - (f / ((float) getWidth())));
        } else {
            obj = obj22;
        }
        if (obj != null || f2 != 0.0f || f4 != 0.0f) {
            ViewCompat.d(this);
        }
    }

    private void a(long j, ce ceVar, ce ceVar2) {
        int b = this.f.b();
        int i = 0;
        while (i < b) {
            ce e = e(this.f.b(i));
            if (e == ceVar || a(e) != j) {
                i++;
            } else if (this.l == null || !this.l.hasStableIds()) {
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e + " \n View Holder 2:" + ceVar + a());
            } else {
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e + " \n View Holder 2:" + ceVar + a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + ceVar2 + " cannot be found but it is necessary for " + ceVar + a());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a = a(context, trim);
                try {
                    Object[] objArr;
                    Constructor constructor;
                    Class asSubclass = (isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).loadClass(a).asSubclass(LayoutManager.class);
                    try {
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                        constructor = asSubclass.getConstructor(O);
                    } catch (Throwable e) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                        objArr = null;
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((LayoutManager) constructor.newInstance(objArr));
                } catch (Throwable e2) {
                    e2.initCause(e);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a, e2);
                } catch (Throwable e3) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a, e3);
                } catch (Throwable e32) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e32);
                } catch (Throwable e322) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a, e322);
                } catch (Throwable e3222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a, e3222);
                } catch (Throwable e32222) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a, e32222);
                }
            }
        }
    }

    private void a(bo boVar, boolean z, boolean z2) {
        if (this.l != null) {
            this.l.unregisterAdapterDataObserver(this.P);
            this.l.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            c();
        }
        this.e.a();
        bo boVar2 = this.l;
        this.l = boVar;
        if (boVar != null) {
            boVar.registerAdapterDataObserver(this.P);
            boVar.onAttachedToRecyclerView(this);
        }
        if (this.m != null) {
            this.m.a(boVar2, this.l);
        }
        this.d.a(boVar2, this.l, z);
        this.C.e = true;
    }

    private void a(@NonNull ce ceVar, @NonNull ce ceVar2, @NonNull br brVar, @NonNull br brVar2, boolean z, boolean z2) {
        ceVar.setIsRecyclable(false);
        if (z) {
            e(ceVar);
        }
        if (ceVar != ceVar2) {
            if (z2) {
                e(ceVar2);
            }
            ceVar.g = ceVar2;
            e(ceVar);
            this.d.c(ceVar);
            ceVar2.setIsRecyclable(false);
            ceVar2.h = ceVar;
        }
        if (this.y.a(ceVar, ceVar2, brVar, brVar2)) {
            p();
        }
    }

    static void a(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.d;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, (view.getRight() + rect2.right) + layoutParams.rightMargin, layoutParams.bottomMargin + (rect2.bottom + view.getBottom()));
    }

    private void a(@NonNull View view, @Nullable View view2) {
        boolean z = true;
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        android.view.ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.e) {
                Rect rect = layoutParams2.d;
                Rect rect2 = this.j;
                rect2.left -= rect.left;
                rect2 = this.j;
                rect2.right += rect.right;
                rect2 = this.j;
                rect2.top -= rect.top;
                rect2 = this.j;
                rect2.bottom = rect.bottom + rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        LayoutManager layoutManager = this.m;
        Rect rect3 = this.j;
        boolean z2 = !this.s;
        if (view2 != null) {
            z = false;
        }
        layoutManager.a(this, view, rect3, z2, z);
    }

    private void a(int[] iArr) {
        int b = this.f.b();
        if (b == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = MoPubClientPositioning.NO_REPEAT;
        int i2 = Integer.MIN_VALUE;
        int i3 = 0;
        while (i3 < b) {
            ce e = e(this.f.b(i3));
            if (!e.c()) {
                int layoutPosition = e.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
            i3++;
            i = i;
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    private boolean a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.T = null;
        }
        int size = this.S.size();
        int i = 0;
        while (i < size) {
            OnItemTouchListener onItemTouchListener = (OnItemTouchListener) this.S.get(i);
            if (!onItemTouchListener.onInterceptTouchEvent(this, motionEvent) || action == 3) {
                i++;
            } else {
                this.T = onItemTouchListener;
                return true;
            }
        }
        return false;
    }

    private boolean a(View view, View view2, int i) {
        boolean z = true;
        boolean z2 = false;
        if (view2 == null || view2 == this) {
            return false;
        }
        if (c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.j.set(0, 0, view.getWidth(), view.getHeight());
        this.R.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.j);
        offsetDescendantRectToMyCoords(view2, this.R);
        int i2 = this.m.u() == 1 ? -1 : 1;
        int i3 = ((this.j.left < this.R.left || this.j.right <= this.R.left) && this.j.right < this.R.right) ? 1 : ((this.j.right > this.R.right || this.j.left >= this.R.right) && this.j.left > this.R.left) ? -1 : 0;
        if ((this.j.top < this.R.top || this.j.bottom <= this.R.top) && this.j.bottom < this.R.bottom) {
            z = true;
        } else if ((this.j.bottom <= this.R.bottom && this.j.top < this.R.bottom) || this.j.top <= this.R.top) {
            z = false;
        }
        switch (i) {
            case 1:
                if (z >= false || (!z && i2 * i3 <= 0)) {
                    z2 = true;
                }
                return z2;
            case 2:
                if (z <= false || (!z && i2 * i3 >= 0)) {
                    z2 = true;
                }
                return z2;
            case 17:
                return i3 < 0;
            case 33:
                return z >= false;
            case 66:
                return i3 > 0;
            case 130:
                return z <= false;
            default:
                throw new IllegalArgumentException("Invalid direction: " + i + a());
        }
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.T != null) {
            if (action == 0) {
                this.T = null;
            } else {
                this.T.onTouchEvent(this, motionEvent);
                if (action == 3 || action == 1) {
                    this.T = null;
                }
                return true;
            }
        }
        if (action != 0) {
            int size = this.S.size();
            for (int i = 0; i < size; i++) {
                OnItemTouchListener onItemTouchListener = (OnItemTouchListener) this.S.get(i);
                if (onItemTouchListener.onInterceptTouchEvent(this, motionEvent)) {
                    this.T = onItemTouchListener;
                    return true;
                }
            }
        }
        return false;
    }

    static void c(@NonNull ce ceVar) {
        if (ceVar.a != null) {
            View view = (View) ceVar.a.get();
            while (view != null) {
                if (view != ceVar.itemView) {
                    ViewParent parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            ceVar.a = null;
        }
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.ak) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.ak = motionEvent.getPointerId(actionIndex);
            int x = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.ao = x;
            this.am = x;
            actionIndex = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.ap = actionIndex;
            this.an = actionIndex;
        }
    }

    static ce e(View view) {
        return view == null ? null : ((LayoutParams) view.getLayoutParams()).c;
    }

    private void e(ce ceVar) {
        View view = ceVar.itemView;
        boolean z = view.getParent() == this;
        this.d.c(b(view));
        if (ceVar.m()) {
            this.f.a(view, -1, view.getLayoutParams(), true);
        } else if (z) {
            this.f.d(view);
        } else {
            this.f.a(view, true);
        }
    }

    private l getScrollingChildHelper() {
        if (this.aC == null) {
            this.aC = new l(this);
        }
        return this.aC;
    }

    private boolean j(int i, int i2) {
        a(this.aB);
        return (this.aB[0] == i && this.aB[1] == i2) ? false : true;
    }

    @Nullable
    static RecyclerView l(@NonNull View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView l = l(viewGroup.getChildAt(i));
            if (l != null) {
                return l;
            }
        }
        return null;
    }

    private int o(View view) {
        int i;
        int id = view.getId();
        while (true) {
            i = id;
            View view2 = view;
            if (view2.isFocused() || !(view2 instanceof ViewGroup) || !view2.hasFocus()) {
                return i;
            }
            view = ((ViewGroup) view2).getFocusedChild();
            id = view.getId() != -1 ? view.getId() : i;
        }
        return i;
    }

    private void z() {
        this.f = new ChildHelper(new Callback() {
            public void addView(View view, int i) {
                RecyclerView.this.addView(view, i);
                RecyclerView.this.n(view);
            }

            public void attachViewToParent(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
                ce e = RecyclerView.e(view);
                if (e != null) {
                    if (e.m() || e.c()) {
                        e.h();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + e + RecyclerView.this.a());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i, layoutParams);
            }

            public void detachViewFromParent(int i) {
                View childAt = getChildAt(i);
                if (childAt != null) {
                    ce e = RecyclerView.e(childAt);
                    if (e != null) {
                        if (!e.m() || e.c()) {
                            e.b(256);
                        } else {
                            throw new IllegalArgumentException("called detach on an already detached child " + e + RecyclerView.this.a());
                        }
                    }
                }
                RecyclerView.this.detachViewFromParent(i);
            }

            public View getChildAt(int i) {
                return RecyclerView.this.getChildAt(i);
            }

            public int getChildCount() {
                return RecyclerView.this.getChildCount();
            }

            public ce getChildViewHolder(View view) {
                return RecyclerView.e(view);
            }

            public int indexOfChild(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void onEnteredHiddenState(View view) {
                ce e = RecyclerView.e(view);
                if (e != null) {
                    e.a(RecyclerView.this);
                }
            }

            public void onLeftHiddenState(View view) {
                ce e = RecyclerView.e(view);
                if (e != null) {
                    e.b(RecyclerView.this);
                }
            }

            public void removeAllViews() {
                int childCount = getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = getChildAt(i);
                    RecyclerView.this.m(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public void removeViewAt(int i) {
                View childAt = RecyclerView.this.getChildAt(i);
                if (childAt != null) {
                    RecyclerView.this.m(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i);
            }
        });
    }

    long a(ce ceVar) {
        return this.l.hasStableIds() ? ceVar.getItemId() : (long) ceVar.b;
    }

    ce a(int i, boolean z) {
        int c = this.f.c();
        ce ceVar = null;
        for (int i2 = 0; i2 < c; i2++) {
            ce e = e(this.f.d(i2));
            if (!(e == null || e.l())) {
                if (z) {
                    if (e.b != i) {
                        continue;
                    }
                } else if (e.getLayoutPosition() != i) {
                    continue;
                }
                if (!this.f.c(e.itemView)) {
                    return e;
                }
                ceVar = e;
            }
        }
        return ceVar;
    }

    public ce a(long j) {
        if (this.l == null || !this.l.hasStableIds()) {
            return null;
        }
        int c = this.f.c();
        int i = 0;
        ce ceVar = null;
        while (i < c) {
            ce e = e(this.f.d(i));
            if (e == null || e.l() || e.getItemId() != j) {
                e = ceVar;
            } else if (!this.f.c(e.itemView)) {
                return e;
            }
            i++;
            ceVar = e;
        }
        return ceVar;
    }

    String a() {
        return " " + super.toString() + ", adapter:" + this.l + ", layout:" + this.m + ", context:" + getContext();
    }

    public void a(int i) {
        if (!this.u) {
            f();
            if (this.m == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            this.m.d(i);
            awakenScrollBars();
        }
    }

    public void a(int i, int i2) {
        a(i, i2, null);
    }

    public void a(int i, int i2, Interpolator interpolator) {
        int i3 = 0;
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            if (!this.m.e()) {
                i = 0;
            }
            if (this.m.f()) {
                i3 = i2;
            }
            if (i != 0 || i3 != 0) {
                this.z.a(i, i3, interpolator);
            }
        }
    }

    void a(int i, int i2, Object obj) {
        int c = this.f.c();
        int i3 = i + i2;
        for (int i4 = 0; i4 < c; i4++) {
            View d = this.f.d(i4);
            ce e = e(d);
            if (e != null && !e.c() && e.b >= i && e.b < i3) {
                e.b(2);
                e.a(obj);
                ((LayoutParams) d.getLayoutParams()).e = true;
            }
        }
        this.d.c(i, i2);
    }

    void a(int i, int i2, boolean z) {
        int i3 = i + i2;
        int c = this.f.c();
        for (int i4 = 0; i4 < c; i4++) {
            ce e = e(this.f.d(i4));
            if (!(e == null || e.c())) {
                if (e.b >= i3) {
                    e.a(-i2, z);
                    this.C.e = true;
                } else if (e.b >= i) {
                    e.a(i - 1, -i2, z);
                    this.C.e = true;
                }
            }
        }
        this.d.a(i, i2, z);
        requestLayout();
    }

    @VisibleForTesting
    void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + a());
        }
        Resources resources = getContext().getResources();
        FastScroller fastScroller = new FastScroller(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(android.support.v7.d.b.fastscroll_default_thickness), resources.getDimensionPixelSize(android.support.v7.d.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(android.support.v7.d.b.fastscroll_margin));
    }

    public void a(OnItemTouchListener onItemTouchListener) {
        this.S.add(onItemTouchListener);
    }

    final void a(State state) {
        if (getScrollState() == 2) {
            OverScroller a = this.z.e;
            state.n = a.getFinalX() - a.getCurrX();
            state.o = a.getFinalY() - a.getCurrY();
            return;
        }
        state.n = 0;
        state.o = 0;
    }

    public void a(bt btVar) {
        a(btVar, -1);
    }

    public void a(bt btVar, int i) {
        if (this.m != null) {
            this.m.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.o.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.o.add(btVar);
        } else {
            this.o.add(i, btVar);
        }
        r();
        requestLayout();
    }

    public void a(bw bwVar) {
        if (this.ay == null) {
            this.ay = new ArrayList();
        }
        this.ay.add(bwVar);
    }

    void a(ce ceVar, br brVar) {
        ceVar.a(0, 8192);
        if (this.C.g && ceVar.r() && !ceVar.l() && !ceVar.c()) {
            this.g.a(a(ceVar), ceVar);
        }
        this.g.a(ceVar, brVar);
    }

    void a(@NonNull ce ceVar, @Nullable br brVar, @NonNull br brVar2) {
        ceVar.setIsRecyclable(false);
        if (this.y.b(ceVar, brVar, brVar2)) {
            p();
        }
    }

    void a(String str) {
        if (o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + a());
            }
            throw new IllegalStateException(str);
        } else if (this.ad > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + a()));
        }
    }

    void a(boolean z) {
        if (this.U < 1) {
            this.U = 1;
        }
        if (!(z || this.u)) {
            this.t = false;
        }
        if (this.U == 1) {
            if (!(!z || !this.t || this.u || this.m == null || this.l == null)) {
                q();
            }
            if (!this.u) {
                this.t = false;
            }
        }
        this.U--;
    }

    boolean a(int i, int i2, MotionEvent motionEvent) {
        int a;
        int i3;
        int i4;
        int i5;
        d();
        if (this.l != null) {
            int b;
            e();
            l();
            h.a("RV Scroll");
            a(this.C);
            if (i != 0) {
                a = this.m.a(i, this.d, this.C);
                i3 = i - a;
            } else {
                a = 0;
                i3 = 0;
            }
            if (i2 != 0) {
                b = this.m.b(i2, this.d, this.C);
                i4 = i2 - b;
            } else {
                b = 0;
                i4 = 0;
            }
            h.a();
            w();
            m();
            a(false);
            i5 = i4;
            i4 = a;
            a = b;
        } else {
            a = 0;
            i4 = 0;
            i5 = 0;
            i3 = 0;
        }
        if (!this.o.isEmpty()) {
            invalidate();
        }
        if (dispatchNestedScroll(i4, a, i3, i5, this.aD, 0)) {
            this.ao -= this.aD[0];
            this.ap -= this.aD[1];
            if (motionEvent != null) {
                motionEvent.offsetLocation((float) this.aD[0], (float) this.aD[1]);
            }
            int[] iArr = this.aF;
            iArr[0] = iArr[0] + this.aD[0];
            iArr = this.aF;
            iArr[1] = iArr[1] + this.aD[1];
        } else if (getOverScrollMode() != 2) {
            if (!(motionEvent == null || k.e(motionEvent, 8194))) {
                a(motionEvent.getX(), (float) i3, motionEvent.getY(), (float) i5);
            }
            c(i, i2);
        }
        if (!(i4 == 0 && a == 0)) {
            i(i4, a);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i4 == 0 && a == 0) ? false : true;
    }

    @VisibleForTesting
    boolean a(ce ceVar, int i) {
        if (o()) {
            ceVar.k = i;
            this.H.add(ceVar);
            return false;
        }
        ViewCompat.b(ceVar.itemView, i);
        return true;
    }

    boolean a(View view) {
        e();
        boolean f = this.f.f(view);
        if (f) {
            ce e = e(view);
            this.d.c(e);
            this.d.b(e);
        }
        a(!f);
        return f;
    }

    boolean a(AccessibilityEvent accessibilityEvent) {
        int i = 0;
        if (!o()) {
            return false;
        }
        int a = accessibilityEvent != null ? a.a(accessibilityEvent) : 0;
        if (a != 0) {
            i = a;
        }
        this.W = i | this.W;
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (this.m == null || !this.m.a(this, (ArrayList) arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public ce b(View view) {
        Object parent = view.getParent();
        if (parent == null || parent == this) {
            return e(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    void b() {
        this.e = new AdapterHelper(new Callback() {
            void a(s sVar) {
                switch (sVar.a) {
                    case 1:
                        RecyclerView.this.m.a(RecyclerView.this, sVar.b, sVar.d);
                        return;
                    case 2:
                        RecyclerView.this.m.b(RecyclerView.this, sVar.b, sVar.d);
                        return;
                    case 4:
                        RecyclerView.this.m.a(RecyclerView.this, sVar.b, sVar.d, sVar.c);
                        return;
                    case 8:
                        RecyclerView.this.m.a(RecyclerView.this, sVar.b, sVar.d, 1);
                        return;
                    default:
                        return;
                }
            }

            public ce findViewHolder(int i) {
                ce a = RecyclerView.this.a(i, true);
                return (a == null || RecyclerView.this.f.c(a.itemView)) ? null : a;
            }

            public void markViewHoldersUpdated(int i, int i2, Object obj) {
                RecyclerView.this.a(i, i2, obj);
                RecyclerView.this.E = true;
            }

            public void offsetPositionsForAdd(int i, int i2) {
                RecyclerView.this.g(i, i2);
                RecyclerView.this.D = true;
            }

            public void offsetPositionsForMove(int i, int i2) {
                RecyclerView.this.f(i, i2);
                RecyclerView.this.D = true;
            }

            public void offsetPositionsForRemovingInvisible(int i, int i2) {
                RecyclerView.this.a(i, i2, true);
                RecyclerView.this.D = true;
                State state = RecyclerView.this.C;
                state.b += i2;
            }

            public void offsetPositionsForRemovingLaidOutOrNewView(int i, int i2) {
                RecyclerView.this.a(i, i2, false);
                RecyclerView.this.D = true;
            }

            public void onDispatchFirstPass(s sVar) {
                a(sVar);
            }

            public void onDispatchSecondPass(s sVar) {
                a(sVar);
            }
        });
    }

    void b(int i) {
        if (this.m != null) {
            this.m.d(i);
            awakenScrollBars();
        }
    }

    public void b(OnItemTouchListener onItemTouchListener) {
        this.S.remove(onItemTouchListener);
        if (this.T == onItemTouchListener) {
            this.T = null;
        }
    }

    public void b(bt btVar) {
        if (this.m != null) {
            this.m.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.o.remove(btVar);
        if (this.o.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void b(bw bwVar) {
        if (this.ay != null) {
            this.ay.remove(bwVar);
        }
    }

    void b(@NonNull ce ceVar, @NonNull br brVar, @Nullable br brVar2) {
        e(ceVar);
        ceVar.setIsRecyclable(false);
        if (this.y.a(ceVar, brVar, brVar2)) {
            p();
        }
    }

    void b(boolean z) {
        this.ac--;
        if (this.ac < 1) {
            this.ac = 0;
            if (z) {
                F();
                x();
            }
        }
    }

    public boolean b(int i, int i2) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.u) {
            return false;
        } else {
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (!e || Math.abs(i) < this.as) {
                i = 0;
            }
            if (!f || Math.abs(i2) < this.as) {
                i2 = 0;
            }
            if ((i == 0 && i2 == 0) || dispatchNestedPreFling((float) i, (float) i2)) {
                return false;
            }
            boolean z = e || f;
            dispatchNestedFling((float) i, (float) i2, z);
            if (this.ar != null && this.ar.a(i, i2)) {
                return true;
            }
            if (!z) {
                return false;
            }
            int i3 = e ? 1 : 0;
            if (f) {
                i3 |= 2;
            }
            startNestedScroll(i3, 1);
            this.z.a(Math.max(-this.at, Math.min(i, this.at)), Math.max(-this.at, Math.min(i2, this.at)));
            return true;
        }
    }

    boolean b(ce ceVar) {
        return this.y == null || this.y.a(ceVar, ceVar.p());
    }

    @Nullable
    public View c(View view) {
        RecyclerView parent = view.getParent();
        View view2 = view;
        while (parent != null && parent != this && (parent instanceof View)) {
            View view3 = parent;
            view2 = view3;
            ViewParent parent2 = view3.getParent();
        }
        return parent2 == this ? view2 : null;
    }

    void c() {
        if (this.y != null) {
            this.y.d();
        }
        if (this.m != null) {
            this.m.c(this.d);
            this.m.b(this.d);
        }
        this.d.a();
    }

    public void c(int i) {
        if (!this.u) {
            if (this.m == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                this.m.a(this, this.C, i);
            }
        }
    }

    void c(int i, int i2) {
        int i3 = 0;
        if (!(this.af == null || this.af.isFinished() || i <= 0)) {
            this.af.onRelease();
            i3 = this.af.isFinished();
        }
        if (!(this.ah == null || this.ah.isFinished() || i >= 0)) {
            this.ah.onRelease();
            i3 |= this.ah.isFinished();
        }
        if (!(this.ag == null || this.ag.isFinished() || i2 <= 0)) {
            this.ag.onRelease();
            i3 |= this.ag.isFinished();
        }
        if (!(this.ai == null || this.ai.isFinished() || i2 >= 0)) {
            this.ai.onRelease();
            i3 |= this.ai.isFinished();
        }
        if (i3 != 0) {
            ViewCompat.d(this);
        }
    }

    void c(boolean z) {
        this.x |= z;
        this.w = true;
        u();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.m.a((LayoutParams) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        return (this.m != null && this.m.e()) ? this.m.e(this.C) : 0;
    }

    public int computeHorizontalScrollOffset() {
        return (this.m != null && this.m.e()) ? this.m.c(this.C) : 0;
    }

    public int computeHorizontalScrollRange() {
        return (this.m != null && this.m.e()) ? this.m.g(this.C) : 0;
    }

    public int computeVerticalScrollExtent() {
        return (this.m != null && this.m.f()) ? this.m.f(this.C) : 0;
    }

    public int computeVerticalScrollOffset() {
        return (this.m != null && this.m.f()) ? this.m.d(this.C) : 0;
    }

    public int computeVerticalScrollRange() {
        return (this.m != null && this.m.f()) ? this.m.h(this.C) : 0;
    }

    int d(ce ceVar) {
        return (ceVar.a(524) || !ceVar.k()) ? -1 : this.e.c(ceVar.b);
    }

    public ce d(int i) {
        return a(i, false);
    }

    @Nullable
    public ce d(View view) {
        View c = c(view);
        return c == null ? null : b(c);
    }

    void d() {
        if (!this.s || this.w) {
            h.a("RV FullInvalidate");
            q();
            h.a();
        } else if (!this.e.d()) {
        } else {
            if (this.e.a(4) && !this.e.a(11)) {
                h.a("RV PartialInvalidate");
                e();
                l();
                this.e.b();
                if (!this.t) {
                    if (A()) {
                        q();
                    } else {
                        this.e.c();
                    }
                }
                a(true);
                m();
                h.a();
            } else if (this.e.d()) {
                h.a("RV FullInvalidate");
                q();
                h.a();
            }
        }
    }

    void d(int i, int i2) {
        if (i < 0) {
            g();
            this.af.onAbsorb(-i);
        } else if (i > 0) {
            h();
            this.ah.onAbsorb(i);
        }
        if (i2 < 0) {
            i();
            this.ag.onAbsorb(-i2);
        } else if (i2 > 0) {
            j();
            this.ai.onAbsorb(i2);
        }
        if (i != 0 || i2 != 0) {
            ViewCompat.d(this);
        }
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().a(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().a(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().a(i, i2, i3, i4, iArr, i5);
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    protected void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        int i3 = 1;
        int i4 = 0;
        super.draw(canvas);
        int size = this.o.size();
        for (i = 0; i < size; i++) {
            ((bt) this.o.get(i)).a(canvas, this, this.C);
        }
        if (this.af == null || this.af.isFinished()) {
            i2 = 0;
        } else {
            i = canvas.save();
            i2 = this.h ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) (i2 + (-getHeight())), 0.0f);
            i2 = (this.af == null || !this.af.draw(canvas)) ? 0 : 1;
            canvas.restoreToCount(i);
        }
        if (!(this.ag == null || this.ag.isFinished())) {
            size = canvas.save();
            if (this.h) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            i = (this.ag == null || !this.ag.draw(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.ah == null || this.ah.isFinished())) {
            size = canvas.save();
            int width = getWidth();
            i = this.h ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) (-i), (float) (-width));
            i = (this.ah == null || !this.ah.draw(canvas)) ? 0 : 1;
            i2 |= i;
            canvas.restoreToCount(size);
        }
        if (!(this.ai == null || this.ai.isFinished())) {
            i = canvas.save();
            canvas.rotate(180.0f);
            if (this.h) {
                canvas.translate((float) ((-getWidth()) + getPaddingRight()), (float) ((-getHeight()) + getPaddingBottom()));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            if (this.ai != null && this.ai.draw(canvas)) {
                i4 = 1;
            }
            i2 |= i4;
            canvas.restoreToCount(i);
        }
        if (i2 != 0 || this.y == null || this.o.size() <= 0 || !this.y.b()) {
            i3 = i2;
        }
        if (i3 != 0) {
            ViewCompat.d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public ce e(int i) {
        if (this.w) {
            return null;
        }
        int c = this.f.c();
        int i2 = 0;
        ce ceVar = null;
        while (i2 < c) {
            ce e = e(this.f.d(i2));
            if (e == null || e.l() || d(e) != i) {
                e = ceVar;
            } else if (!this.f.c(e.itemView)) {
                return e;
            }
            i2++;
            ceVar = e;
        }
        return ceVar;
    }

    void e() {
        this.U++;
        if (this.U == 1 && !this.u) {
            this.t = false;
        }
    }

    void e(int i, int i2) {
        setMeasuredDimension(LayoutManager.a(i, getPaddingLeft() + getPaddingRight(), ViewCompat.j(this)), LayoutManager.a(i2, getPaddingTop() + getPaddingBottom(), ViewCompat.k(this)));
    }

    @Deprecated
    public int f(View view) {
        return g(view);
    }

    public void f() {
        setScrollState(0);
        B();
    }

    public void f(int i) {
        int b = this.f.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f.b(i2).offsetTopAndBottom(i);
        }
    }

    void f(int i, int i2) {
        int i3;
        int c = this.f.c();
        int i4;
        int i5;
        if (i < i2) {
            i3 = -1;
            i4 = i2;
            i5 = i;
        } else {
            i3 = 1;
            i4 = i;
            i5 = i2;
        }
        for (int i6 = 0; i6 < c; i6++) {
            ce e = e(this.f.d(i6));
            if (e != null && e.b >= i5 && e.b <= i4) {
                if (e.b == i) {
                    e.a(i2 - i, false);
                } else {
                    e.a(i3, false);
                }
                this.C.e = true;
            }
        }
        this.d.a(i, i2);
        requestLayout();
    }

    public View focusSearch(View view, int i) {
        boolean z = true;
        View d = this.m.d(view, i);
        if (d != null) {
            return d;
        }
        boolean z2 = (this.l == null || this.m == null || o() || this.u) ? false : true;
        FocusFinder instance = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            int i2;
            if (this.m.f()) {
                i2 = i == 2 ? 130 : 33;
                boolean z3 = instance.findNextFocus(this, view, i2) == null;
                if (M) {
                    i = i2;
                    z2 = z3;
                } else {
                    z2 = z3;
                }
            } else {
                z2 = false;
            }
            if (z2 || !this.m.e()) {
                z = z2;
            } else {
                i2 = ((i == 2 ? 1 : 0) ^ (this.m.u() == 1 ? 1 : 0)) != 0 ? 66 : 17;
                if (instance.findNextFocus(this, view, i2) != null) {
                    z = false;
                }
                if (M) {
                    i = i2;
                }
            }
            if (z) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.m.a(view, i, this.d, this.C);
                a(false);
            }
            d = instance.findNextFocus(this, view, i);
        } else {
            View findNextFocus = instance.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                d = this.m.a(view, i, this.d, this.C);
                a(false);
            } else {
                d = findNextFocus;
            }
        }
        if (d == null || d.hasFocusable()) {
            if (!a(view, d, i)) {
                d = super.focusSearch(view, i);
            }
            return d;
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            a(d, null);
            return view;
        }
    }

    public int g(View view) {
        ce e = e(view);
        return e != null ? e.getAdapterPosition() : -1;
    }

    void g() {
        if (this.af == null) {
            this.af = this.ae.a(this, 0);
            if (this.h) {
                this.af.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.af.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void g(int i) {
        int b = this.f.b();
        for (int i2 = 0; i2 < b; i2++) {
            this.f.b(i2).offsetLeftAndRight(i);
        }
    }

    void g(int i, int i2) {
        int c = this.f.c();
        for (int i3 = 0; i3 < c; i3++) {
            ce e = e(this.f.d(i3));
            if (!(e == null || e.c() || e.b < i)) {
                e.a(i2, false);
                this.C.e = true;
            }
        }
        this.d.b(i, i2);
        requestLayout();
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        if (this.m != null) {
            return this.m.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (this.m != null) {
            return this.m.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (this.m != null) {
            return this.m.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public bo getAdapter() {
        return this.l;
    }

    public int getBaseline() {
        return this.m != null ? this.m.v() : super.getBaseline();
    }

    protected int getChildDrawingOrder(int i, int i2) {
        return this.aA == null ? super.getChildDrawingOrder(i, i2) : this.aA.onGetChildDrawingOrder(i, i2);
    }

    public boolean getClipToPadding() {
        return this.h;
    }

    public cf getCompatAccessibilityDelegate() {
        return this.G;
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.ae;
    }

    public ItemAnimator getItemAnimator() {
        return this.y;
    }

    public int getItemDecorationCount() {
        return this.o.size();
    }

    public LayoutManager getLayoutManager() {
        return this.m;
    }

    public int getMaxFlingVelocity() {
        return this.at;
    }

    public int getMinFlingVelocity() {
        return this.as;
    }

    long getNanoTime() {
        return L ? System.nanoTime() : 0;
    }

    @Nullable
    public bv getOnFlingListener() {
        return this.ar;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.aw;
    }

    public bx getRecycledViewPool() {
        return this.d.g();
    }

    public int getScrollState() {
        return this.aj;
    }

    public int h(View view) {
        ce e = e(view);
        return e != null ? e.getLayoutPosition() : -1;
    }

    void h() {
        if (this.ah == null) {
            this.ah = this.ae.a(this, 2);
            if (this.h) {
                this.ah.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                this.ah.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void h(int i) {
    }

    public void h(int i, int i2) {
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().a(i);
    }

    void i() {
        if (this.ag == null) {
            this.ag = this.ae.a(this, 1);
            if (this.h) {
                this.ag.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ag.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    void i(int i) {
        if (this.m != null) {
            this.m.k(i);
        }
        h(i);
        if (this.ax != null) {
            this.ax.a(this, i);
        }
        if (this.ay != null) {
            for (int size = this.ay.size() - 1; size >= 0; size--) {
                ((bw) this.ay.get(size)).a(this, i);
            }
        }
    }

    void i(int i, int i2) {
        this.ad++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        h(i, i2);
        if (this.ax != null) {
            this.ax.a(this, i, i2);
        }
        if (this.ay != null) {
            for (scrollY = this.ay.size() - 1; scrollY >= 0; scrollY--) {
                ((bw) this.ay.get(scrollY)).a(this, i, i2);
            }
        }
        this.ad--;
    }

    public void i(View view) {
    }

    public boolean isAttachedToWindow() {
        return this.p;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    void j() {
        if (this.ai == null) {
            this.ai = this.ae.a(this, 3);
            if (this.h) {
                this.ai.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                this.ai.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void j(View view) {
    }

    Rect k(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.e) {
            return layoutParams.d;
        }
        if (this.C.a() && (layoutParams.e() || layoutParams.c())) {
            return layoutParams.d;
        }
        Rect rect = layoutParams.d;
        rect.set(0, 0, 0, 0);
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            this.j.set(0, 0, 0, 0);
            ((bt) this.o.get(i)).a(this.j, view, this, this.C);
            rect.left += this.j.left;
            rect.top += this.j.top;
            rect.right += this.j.right;
            rect.bottom += this.j.bottom;
        }
        layoutParams.e = false;
        return rect;
    }

    void k() {
        this.ai = null;
        this.ag = null;
        this.ah = null;
        this.af = null;
    }

    void l() {
        this.ac++;
    }

    void m() {
        b(true);
    }

    void m(View view) {
        ce e = e(view);
        j(view);
        if (!(this.l == null || e == null)) {
            this.l.onViewDetachedFromWindow(e);
        }
        if (this.ab != null) {
            for (int size = this.ab.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.ab.get(size)).onChildViewDetachedFromWindow(view);
            }
        }
    }

    void n(View view) {
        ce e = e(view);
        i(view);
        if (!(this.l == null || e == null)) {
            this.l.onViewAttachedToWindow(e);
        }
        if (this.ab != null) {
            for (int size = this.ab.size() - 1; size >= 0; size--) {
                ((OnChildAttachStateChangeListener) this.ab.get(size)).onChildViewAttachedToWindow(view);
            }
        }
    }

    boolean n() {
        return this.aa != null && this.aa.isEnabled();
    }

    public boolean o() {
        return this.ac > 0;
    }

    /* JADX WARNING: Missing block: B:15:0x004f, code:
            if (r0 >= 30.0f) goto L_0x0051;
     */
    protected void onAttachedToWindow() {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        super.onAttachedToWindow();
        r4.ac = r1;
        r4.p = r0;
        r2 = r4.s;
        if (r2 == 0) goto L_0x0068;
    L_0x000d:
        r2 = r4.isLayoutRequested();
        if (r2 != 0) goto L_0x0068;
    L_0x0013:
        r4.s = r0;
        r0 = r4.m;
        if (r0 == 0) goto L_0x001e;
    L_0x0019:
        r0 = r4.m;
        r0.c(r4);
    L_0x001e:
        r4.F = r1;
        r0 = L;
        if (r0 == 0) goto L_0x0067;
    L_0x0024:
        r0 = android.support.v7.widget.aw.a;
        r0 = r0.get();
        r0 = (android.support.v7.widget.aw) r0;
        r4.A = r0;
        r0 = r4.A;
        if (r0 != 0) goto L_0x0062;
    L_0x0032:
        r0 = new android.support.v7.widget.aw;
        r0.<init>();
        r4.A = r0;
        r0 = android.support.v4.view.ViewCompat.D(r4);
        r1 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r2 = r4.isInEditMode();
        if (r2 != 0) goto L_0x006a;
    L_0x0045:
        if (r0 == 0) goto L_0x006a;
    L_0x0047:
        r0 = r0.getRefreshRate();
        r2 = 1106247680; // 0x41f00000 float:30.0 double:5.465589745E-315;
        r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x006a;
    L_0x0051:
        r1 = r4.A;
        r2 = 1315859240; // 0x4e6e6b28 float:1.0E9 double:6.50120845E-315;
        r0 = r2 / r0;
        r2 = (long) r0;
        r1.d = r2;
        r0 = android.support.v7.widget.aw.a;
        r1 = r4.A;
        r0.set(r1);
    L_0x0062:
        r0 = r4.A;
        r0.a(r4);
    L_0x0067:
        return;
    L_0x0068:
        r0 = r1;
        goto L_0x0013;
    L_0x006a:
        r0 = r1;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.RecyclerView.onAttachedToWindow():void");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.y != null) {
            this.y.d();
        }
        f();
        this.p = false;
        if (this.m != null) {
            this.m.b(this, this.d);
        }
        this.H.clear();
        removeCallbacks(this.aG);
        this.g.b();
        if (L && this.A != null) {
            this.A.b(this);
            this.A = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.o.size();
        for (int i = 0; i < size; i++) {
            ((bt) this.o.get(i)).b(canvas, this, this.C);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (!(this.m == null || this.u || motionEvent.getAction() != 8)) {
            float f;
            float f2;
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.m.f() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.m.e()) {
                    f2 = f;
                    f = motionEvent.getAxisValue(10);
                } else {
                    f2 = f;
                    f = 0.0f;
                }
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                f = motionEvent.getAxisValue(26);
                if (this.m.f()) {
                    f2 = -f;
                    f = 0.0f;
                } else if (this.m.e()) {
                    f2 = 0.0f;
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                }
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            if (!(f2 == 0.0f && f == 0.0f)) {
                a((int) (f * this.au), (int) (this.av * f2), motionEvent);
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.u) {
            return false;
        }
        if (a(motionEvent)) {
            E();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (this.al == null) {
                this.al = VelocityTracker.obtain();
            }
            this.al.addMovement(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            int i;
            switch (actionMasked) {
                case 0:
                    if (this.V) {
                        this.V = false;
                    }
                    this.ak = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.ao = actionMasked;
                    this.am = actionMasked;
                    actionMasked = (int) (motionEvent.getY() + 0.5f);
                    this.ap = actionMasked;
                    this.an = actionMasked;
                    if (this.aj == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                    int[] iArr = this.aF;
                    this.aF[1] = 0;
                    iArr[0] = 0;
                    i = e ? 1 : 0;
                    if (f) {
                        i |= 2;
                    }
                    startNestedScroll(i, 0);
                    break;
                case 1:
                    this.al.clear();
                    stopNestedScroll(0);
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.ak);
                    if (actionMasked >= 0) {
                        actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        actionMasked = (int) (motionEvent.getY(actionMasked) + 0.5f);
                        if (this.aj != 1) {
                            int i2 = actionIndex - this.am;
                            int i3 = actionMasked - this.an;
                            if (!e || Math.abs(i2) <= this.aq) {
                                e = false;
                            } else {
                                this.ao = actionIndex;
                                e = true;
                            }
                            if (f && Math.abs(i3) > this.aq) {
                                this.ap = actionMasked;
                                e = true;
                            }
                            if (e) {
                                setScrollState(1);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ak + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    E();
                    break;
                case 5:
                    this.ak = motionEvent.getPointerId(actionIndex);
                    i = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.ao = i;
                    this.am = i;
                    i = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.ap = i;
                    this.an = i;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            return this.aj == 1;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        h.a("RV OnLayout");
        q();
        h.a();
        this.s = true;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        if (this.m == null) {
            e(i, i2);
        } else if (this.m.c()) {
            int mode = MeasureSpec.getMode(i);
            int mode2 = MeasureSpec.getMode(i2);
            this.m.a(this.d, this.C, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (!z && this.l != null) {
                if (this.C.c == 1) {
                    M();
                }
                this.m.d(i, i2);
                this.C.h = true;
                N();
                this.m.e(i, i2);
                if (this.m.m()) {
                    this.m.d(MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                    this.C.h = true;
                    N();
                    this.m.e(i, i2);
                }
            }
        } else if (this.q) {
            this.m.a(this.d, this.C, i, i2);
        } else {
            if (this.v) {
                e();
                l();
                H();
                m();
                if (this.C.j) {
                    this.C.f = true;
                } else {
                    this.e.e();
                    this.C.f = false;
                }
                this.v = false;
                a(false);
            } else if (this.C.j) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            if (this.l != null) {
                this.C.d = this.l.getItemCount();
            } else {
                this.C.d = 0;
            }
            e();
            this.m.a(this.d, this.C, i, i2);
            a(false);
            this.C.f = false;
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        return o() ? false : super.onRequestFocusInDescendants(i, rect);
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.Q = (SavedState) parcelable;
            super.onRestoreInstanceState(this.Q.a());
            if (this.m != null && this.Q.a != null) {
                this.m.a(this.Q.a);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.Q != null) {
            savedState.a(this.Q);
        } else if (this.m != null) {
            savedState.a = this.m.d();
        } else {
            savedState.a = null;
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 || i2 != i4) {
            k();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.u || this.V) {
            return false;
        }
        if (b(motionEvent)) {
            E();
            return true;
        } else if (this.m == null) {
            return false;
        } else {
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (this.al == null) {
                this.al = VelocityTracker.obtain();
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            int actionIndex = motionEvent.getActionIndex();
            if (actionMasked == 0) {
                int[] iArr = this.aF;
                this.aF[1] = 0;
                iArr[0] = 0;
            }
            obtain.offsetLocation((float) this.aF[0], (float) this.aF[1]);
            switch (actionMasked) {
                case 0:
                    this.ak = motionEvent.getPointerId(0);
                    actionMasked = (int) (motionEvent.getX() + 0.5f);
                    this.ao = actionMasked;
                    this.am = actionMasked;
                    actionMasked = (int) (motionEvent.getY() + 0.5f);
                    this.ap = actionMasked;
                    this.an = actionMasked;
                    actionMasked = e ? 1 : 0;
                    if (f) {
                        actionMasked |= 2;
                    }
                    startNestedScroll(actionMasked, 0);
                    break;
                case 1:
                    this.al.addMovement(obtain);
                    this.al.computeCurrentVelocity(1000, (float) this.at);
                    float f2 = e ? -this.al.getXVelocity(this.ak) : 0.0f;
                    float f3 = f ? -this.al.getYVelocity(this.ak) : 0.0f;
                    if ((f2 == 0.0f && f3 == 0.0f) || !b((int) f2, (int) f3)) {
                        setScrollState(0);
                    }
                    D();
                    z = true;
                    break;
                case 2:
                    actionMasked = motionEvent.findPointerIndex(this.ak);
                    if (actionMasked >= 0) {
                        int x = (int) (motionEvent.getX(actionMasked) + 0.5f);
                        int y = (int) (motionEvent.getY(actionMasked) + 0.5f);
                        int i = this.ao - x;
                        actionIndex = this.ap - y;
                        if (dispatchNestedPreScroll(i, actionIndex, this.aE, this.aD, 0)) {
                            i -= this.aE[0];
                            actionIndex -= this.aE[1];
                            obtain.offsetLocation((float) this.aD[0], (float) this.aD[1]);
                            int[] iArr2 = this.aF;
                            iArr2[0] = iArr2[0] + this.aD[0];
                            iArr2 = this.aF;
                            iArr2[1] = iArr2[1] + this.aD[1];
                        }
                        if (this.aj != 1) {
                            boolean z2;
                            if (!e || Math.abs(i) <= this.aq) {
                                z2 = false;
                            } else {
                                i = i > 0 ? i - this.aq : this.aq + i;
                                z2 = true;
                            }
                            if (f && Math.abs(actionIndex) > this.aq) {
                                actionIndex = actionIndex > 0 ? actionIndex - this.aq : this.aq + actionIndex;
                                z2 = true;
                            }
                            if (z2) {
                                setScrollState(1);
                            }
                        }
                        if (this.aj == 1) {
                            this.ao = x - this.aD[0];
                            this.ap = y - this.aD[1];
                            if (a(e ? i : 0, f ? actionIndex : 0, obtain)) {
                                getParent().requestDisallowInterceptTouchEvent(true);
                            }
                            if (!(this.A == null || (i == 0 && actionIndex == 0))) {
                                this.A.a(this, i, actionIndex);
                                break;
                            }
                        }
                    }
                    Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.ak + " not found. Did any MotionEvents get skipped?");
                    return false;
                    break;
                case 3:
                    E();
                    break;
                case 5:
                    this.ak = motionEvent.getPointerId(actionIndex);
                    actionMasked = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.ao = actionMasked;
                    this.am = actionMasked;
                    actionMasked = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.ap = actionMasked;
                    this.an = actionMasked;
                    break;
                case 6:
                    c(motionEvent);
                    break;
            }
            if (!z) {
                this.al.addMovement(obtain);
            }
            obtain.recycle();
            return true;
        }
    }

    void p() {
        if (!this.F && this.p) {
            ViewCompat.a((View) this, this.aG);
            this.F = true;
        }
    }

    void q() {
        if (this.l == null) {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.m == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.C.h = false;
            if (this.C.c == 1) {
                M();
                this.m.f(this);
                N();
            } else if (!this.e.f() && this.m.z() == getWidth() && this.m.A() == getHeight()) {
                this.m.f(this);
            } else {
                this.m.f(this);
                N();
            }
            O();
        }
    }

    void r() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            ((LayoutParams) this.f.d(i).getLayoutParams()).e = true;
        }
        this.d.j();
    }

    protected void removeDetachedView(View view, boolean z) {
        ce e = e(view);
        if (e != null) {
            if (e.m()) {
                e.h();
            } else if (!e.c()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e + a());
            }
        }
        view.clearAnimation();
        m(view);
        super.removeDetachedView(view, z);
    }

    public void requestChildFocus(View view, View view2) {
        if (!(this.m.a(this, this.C, view, view2) || view2 == null)) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.m.a(this, view, rect, z);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.S.size();
        for (int i = 0; i < size; i++) {
            ((OnItemTouchListener) this.S.get(i)).onRequestDisallowInterceptTouchEvent(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public void requestLayout() {
        if (this.U != 0 || this.u) {
            this.t = true;
        } else {
            super.requestLayout();
        }
    }

    void s() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            ce e = e(this.f.d(i));
            if (!e.c()) {
                e.b();
            }
        }
    }

    public void scrollBy(int i, int i2) {
        if (this.m == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.u) {
            boolean e = this.m.e();
            boolean f = this.m.f();
            if (e || f) {
                if (!e) {
                    i = 0;
                }
                if (!f) {
                    i2 = 0;
                }
                a(i, i2, null);
            }
        }
    }

    public void scrollTo(int i, int i2) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(cf cfVar) {
        this.G = cfVar;
        ViewCompat.a((View) this, this.G);
    }

    public void setAdapter(bo boVar) {
        setLayoutFrozen(false);
        a(boVar, false, true);
        c(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback childDrawingOrderCallback) {
        if (childDrawingOrderCallback != this.aA) {
            this.aA = childDrawingOrderCallback;
            setChildrenDrawingOrderEnabled(this.aA != null);
        }
    }

    public void setClipToPadding(boolean z) {
        if (z != this.h) {
            k();
        }
        this.h = z;
        super.setClipToPadding(z);
        if (this.s) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory edgeEffectFactory) {
        android.support.v4.util.r.a(edgeEffectFactory);
        this.ae = edgeEffectFactory;
        k();
    }

    public void setHasFixedSize(boolean z) {
        this.q = z;
    }

    public void setItemAnimator(ItemAnimator itemAnimator) {
        if (this.y != null) {
            this.y.d();
            this.y.a(null);
        }
        this.y = itemAnimator;
        if (this.y != null) {
            this.y.a(this.az);
        }
    }

    public void setItemViewCacheSize(int i) {
        this.d.a(i);
    }

    public void setLayoutFrozen(boolean z) {
        if (z != this.u) {
            a("Do not setLayoutFrozen in layout or scroll");
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
                this.u = true;
                this.V = true;
                f();
                return;
            }
            this.u = false;
            if (!(!this.t || this.m == null || this.l == null)) {
                requestLayout();
            }
            this.t = false;
        }
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        if (layoutManager != this.m) {
            f();
            if (this.m != null) {
                if (this.y != null) {
                    this.y.d();
                }
                this.m.c(this.d);
                this.m.b(this.d);
                this.d.a();
                if (this.p) {
                    this.m.b(this, this.d);
                }
                this.m.b(null);
                this.m = null;
            } else {
                this.d.a();
            }
            this.f.a();
            this.m = layoutManager;
            if (layoutManager != null) {
                if (layoutManager.q != null) {
                    throw new IllegalArgumentException("LayoutManager " + layoutManager + " is already attached to a RecyclerView:" + layoutManager.q.a());
                }
                this.m.b(this);
                if (this.p) {
                    this.m.c(this);
                }
            }
            this.d.b();
            requestLayout();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        getScrollingChildHelper().a(z);
    }

    public void setOnFlingListener(@Nullable bv bvVar) {
        this.ar = bvVar;
    }

    @Deprecated
    public void setOnScrollListener(bw bwVar) {
        this.ax = bwVar;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.aw = z;
    }

    public void setRecycledViewPool(bx bxVar) {
        this.d.a(bxVar);
    }

    public void setRecyclerListener(RecyclerListener recyclerListener) {
        this.n = recyclerListener;
    }

    void setScrollState(int i) {
        if (i != this.aj) {
            this.aj = i;
            if (i != 2) {
                B();
            }
            i(i);
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        switch (i) {
            case 0:
                break;
            case 1:
                this.aq = viewConfiguration.getScaledPagingTouchSlop();
                return;
            default:
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
                break;
        }
        this.aq = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(cc ccVar) {
        this.d.a(ccVar);
    }

    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().b(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().a(i, i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().c(i);
    }

    void t() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            ce e = e(this.f.d(i));
            if (!e.c()) {
                e.a();
            }
        }
        this.d.i();
    }

    void u() {
        int c = this.f.c();
        for (int i = 0; i < c; i++) {
            ce e = e(this.f.d(i));
            if (!(e == null || e.c())) {
                e.b(6);
            }
        }
        r();
        this.d.h();
    }

    public boolean v() {
        return !this.s || this.w || this.e.d();
    }

    void w() {
        int b = this.f.b();
        for (int i = 0; i < b; i++) {
            View b2 = this.f.b(i);
            ce b3 = b(b2);
            if (!(b3 == null || b3.h == null)) {
                View view = b3.h.itemView;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    void x() {
        for (int size = this.H.size() - 1; size >= 0; size--) {
            ce ceVar = (ce) this.H.get(size);
            if (ceVar.itemView.getParent() == this && !ceVar.c()) {
                int i = ceVar.k;
                if (i != -1) {
                    ViewCompat.b(ceVar.itemView, i);
                    ceVar.k = -1;
                }
            }
        }
        this.H.clear();
    }
}
