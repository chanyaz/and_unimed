package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.design.e;
import android.support.design.l;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.a.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.as;
import android.support.v4.widget.at;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    int a;
    int b;
    boolean c;
    int d = 4;
    as e;
    int f;
    WeakReference<V> g;
    WeakReference<View> h;
    int i;
    boolean j;
    private float k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;
    private e s;
    private VelocityTracker t;
    private int u;
    private final at v = new at() {
        public int a(View view) {
            return BottomSheetBehavior.this.c ? BottomSheetBehavior.this.f - BottomSheetBehavior.this.a : BottomSheetBehavior.this.b - BottomSheetBehavior.this.a;
        }

        public int a(View view, int i, int i2) {
            return a.a(i, BottomSheetBehavior.this.a, BottomSheetBehavior.this.c ? BottomSheetBehavior.this.f : BottomSheetBehavior.this.b);
        }

        public void a(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.c(1);
            }
        }

        public void a(View view, float f, float f2) {
            int i;
            int i2 = 3;
            if (f2 < 0.0f) {
                i = BottomSheetBehavior.this.a;
            } else if (BottomSheetBehavior.this.c && BottomSheetBehavior.this.a(view, f2)) {
                i = BottomSheetBehavior.this.f;
                i2 = 5;
            } else if (f2 == 0.0f) {
                int top = view.getTop();
                if (Math.abs(top - BottomSheetBehavior.this.a) < Math.abs(top - BottomSheetBehavior.this.b)) {
                    i = BottomSheetBehavior.this.a;
                } else {
                    i = BottomSheetBehavior.this.b;
                    i2 = 4;
                }
            } else {
                i = BottomSheetBehavior.this.b;
                i2 = 4;
            }
            if (BottomSheetBehavior.this.e.a(view.getLeft(), i)) {
                BottomSheetBehavior.this.c(2);
                ViewCompat.a(view, new f(BottomSheetBehavior.this, view, i2));
                return;
            }
            BottomSheetBehavior.this.c(i2);
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.d(i2);
        }

        public boolean a(View view, int i) {
            if (BottomSheetBehavior.this.d == 1 || BottomSheetBehavior.this.j) {
                return false;
            }
            if (BottomSheetBehavior.this.d == 3 && BottomSheetBehavior.this.i == i) {
                View view2 = (View) BottomSheetBehavior.this.h.get();
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            boolean z = BottomSheetBehavior.this.g != null && BottomSheetBehavior.this.g.get() == view;
            return z;
        }

        public int b(View view, int i, int i2) {
            return view.getLeft();
        }
    };

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
        final int a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.a = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.BottomSheetBehavior_Layout);
        TypedValue peekValue = obtainStyledAttributes.peekValue(l.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            a(obtainStyledAttributes.getDimensionPixelSize(l.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            a(peekValue.data);
        }
        a(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_hideable, false));
        b(obtainStyledAttributes.getBoolean(l.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        obtainStyledAttributes.recycle();
        this.k = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    private void a() {
        this.i = -1;
        if (this.t != null) {
            this.t.recycle();
            this.t = null;
        }
    }

    private float b() {
        this.t.computeCurrentVelocity(1000, this.k);
        return this.t.getYVelocity(this.i);
    }

    public static <V extends View> BottomSheetBehavior<V> b(V v) {
        LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof m) {
            Behavior b = ((m) layoutParams).b();
            if (b instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) b;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    @VisibleForTesting
    View a(View view) {
        if (ViewCompat.w(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View a = a(viewGroup.getChildAt(i));
                if (a != null) {
                    return a;
                }
            }
        }
        return null;
    }

    public final void a(int i) {
        boolean z = true;
        if (i == -1) {
            if (!this.m) {
                this.m = true;
            }
            z = false;
        } else {
            if (this.m || this.l != i) {
                this.m = false;
                this.l = Math.max(0, i);
                this.b = this.f - i;
            }
            z = false;
        }
        if (z && this.d == 4 && this.g != null) {
            View view = (View) this.g.get();
            if (view != null) {
                view.requestLayout();
            }
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.a(coordinatorLayout, (View) v, savedState.a());
        if (savedState.a == 1 || savedState.a == 2) {
            this.d = 4;
        } else {
            this.d = savedState.a;
        }
    }

    public void a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.h.get())) {
            int top = v.getTop();
            int i3 = top - i2;
            if (i2 > 0) {
                if (i3 < this.a) {
                    iArr[1] = top - this.a;
                    ViewCompat.d(v, -iArr[1]);
                    c(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.d(v, -i2);
                    c(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                if (i3 <= this.b || this.c) {
                    iArr[1] = i2;
                    ViewCompat.d(v, -i2);
                    c(1);
                } else {
                    iArr[1] = top - this.b;
                    ViewCompat.d(v, -iArr[1]);
                    c(4);
                }
            }
            d(v.getTop());
            this.q = i2;
            this.r = true;
        }
    }

    public void a(e eVar) {
        this.s = eVar;
    }

    void a(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.b;
        } else if (i == 3) {
            i2 = this.a;
        } else if (this.c && i == 5) {
            i2 = this.f;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        if (this.e.a(view, view.getLeft(), i2)) {
            c(2);
            ViewCompat.a(view, new f(this, view, i));
            return;
        }
        c(i);
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        int max;
        if (ViewCompat.r(coordinatorLayout) && !ViewCompat.r(v)) {
            ViewCompat.b((View) v, true);
        }
        int top = v.getTop();
        coordinatorLayout.a((View) v, i);
        this.f = coordinatorLayout.getHeight();
        if (this.m) {
            if (this.n == 0) {
                this.n = coordinatorLayout.getResources().getDimensionPixelSize(e.design_bottom_sheet_peek_height_min);
            }
            max = Math.max(this.n, this.f - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            max = this.l;
        }
        this.a = Math.max(0, this.f - v.getHeight());
        this.b = Math.max(this.f - max, this.a);
        if (this.d == 3) {
            ViewCompat.d(v, this.a);
        } else if (this.c && this.d == 5) {
            ViewCompat.d(v, this.f);
        } else if (this.d == 4) {
            ViewCompat.d(v, this.b);
        } else if (this.d == 1 || this.d == 2) {
            ViewCompat.d(v, top - v.getTop());
        }
        if (this.e == null) {
            this.e = as.a((ViewGroup) coordinatorLayout, this.v);
        }
        this.g = new WeakReference(v);
        this.h = new WeakReference(a((View) v));
        return true;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = true;
        if (v.isShown()) {
            View view;
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                a();
            }
            if (this.t == null) {
                this.t = VelocityTracker.obtain();
            }
            this.t.addMovement(motionEvent);
            switch (actionMasked) {
                case 0:
                    int x = (int) motionEvent.getX();
                    this.u = (int) motionEvent.getY();
                    view = this.h != null ? (View) this.h.get() : null;
                    if (view != null && coordinatorLayout.a(view, x, this.u)) {
                        this.i = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.j = true;
                    }
                    boolean z2 = this.i == -1 && !coordinatorLayout.a((View) v, x, this.u);
                    this.p = z2;
                    break;
                case 1:
                case 3:
                    this.j = false;
                    this.i = -1;
                    if (this.p) {
                        this.p = false;
                        return false;
                    }
                    break;
            }
            if (!this.p && this.e.a(motionEvent)) {
                return true;
            }
            view = (View) this.h.get();
            if (actionMasked != 2 || view == null || this.p || this.d == 1 || coordinatorLayout.a(view, (int) motionEvent.getX(), (int) motionEvent.getY()) || Math.abs(((float) this.u) - motionEvent.getY()) <= ((float) this.e.d())) {
                z = false;
            }
            return z;
        }
        this.p = true;
        return false;
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.h.get() && (this.d != 3 || super.a(coordinatorLayout, (View) v, view, f, f2));
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.q = 0;
        this.r = false;
        return (i & 2) != 0;
    }

    boolean a(View view, float f) {
        return this.o ? true : view.getTop() < this.b ? false : Math.abs((((float) view.getTop()) + (0.1f * f)) - ((float) this.b)) / ((float) this.l) > 0.5f;
    }

    public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.b(coordinatorLayout, v), this.d);
    }

    public final void b(final int i) {
        if (i != this.d) {
            if (this.g != null) {
                final View view = (View) this.g.get();
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent != null && parent.isLayoutRequested() && ViewCompat.B(view)) {
                        view.post(new Runnable() {
                            public void run() {
                                BottomSheetBehavior.this.a(view, i);
                            }
                        });
                    } else {
                        a(view, i);
                    }
                }
            } else if (i == 4 || i == 3 || (this.c && i == 5)) {
                this.d = i;
            }
        }
    }

    public void b(boolean z) {
        this.o = z;
    }

    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.d == 1 && actionMasked == 0) {
            return true;
        }
        if (this.e != null) {
            this.e.b(motionEvent);
        }
        if (actionMasked == 0) {
            a();
        }
        if (this.t == null) {
            this.t = VelocityTracker.obtain();
        }
        this.t.addMovement(motionEvent);
        if (actionMasked == 2 && !this.p && Math.abs(((float) this.u) - motionEvent.getY()) > ((float) this.e.d())) {
            this.e.a((View) v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.p;
    }

    void c(int i) {
        if (this.d != i) {
            this.d = i;
            View view = (View) this.g.get();
            if (view != null && this.s != null) {
                this.s.a(view, i);
            }
        }
    }

    public void c(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.a) {
            c(3);
        } else if (this.h != null && view == this.h.get() && this.r) {
            int i2;
            if (this.q > 0) {
                i2 = this.a;
            } else if (this.c && a((View) v, b())) {
                i2 = this.f;
                i = 5;
            } else if (this.q == 0) {
                int top = v.getTop();
                if (Math.abs(top - this.a) < Math.abs(top - this.b)) {
                    i2 = this.a;
                } else {
                    i2 = this.b;
                    i = 4;
                }
            } else {
                i2 = this.b;
                i = 4;
            }
            if (this.e.a((View) v, v.getLeft(), i2)) {
                c(2);
                ViewCompat.a((View) v, new f(this, v, i));
            } else {
                c(i);
            }
            this.r = false;
        }
    }

    void d(int i) {
        View view = (View) this.g.get();
        if (view != null && this.s != null) {
            if (i > this.b) {
                this.s.a(view, ((float) (this.b - i)) / ((float) (this.f - this.b)));
            } else {
                this.s.a(view, ((float) (this.b - i)) / ((float) (this.b - this.a)));
            }
        }
    }
}
