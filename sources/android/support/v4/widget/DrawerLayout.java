package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.graphics.drawable.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.d;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
    static final int[] a = new int[]{16842931};
    static final boolean b = (VERSION.SDK_INT >= 19);
    private static final int[] c = new int[]{16843828};
    private static final boolean d;
    private float A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private CharSequence E;
    private CharSequence F;
    private Object G;
    private boolean H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private Drawable L;
    private final ArrayList<View> M;
    private final p e;
    private float f;
    private int g;
    private int h;
    private float i;
    private Paint j;
    private final as k;
    private final as l;
    private final q m;
    private final q n;
    private int o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private int u;
    private boolean v;
    private boolean w;
    @Nullable
    private DrawerListener x;
    private List<DrawerListener> y;
    private float z;

    public interface DrawerListener {
        void onDrawerClosed(@NonNull View view);

        void onDrawerOpened(@NonNull View view);

        void onDrawerSlide(@NonNull View view, float f);

        void onDrawerStateChanged(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface EdgeGravity {
    }

    public class LayoutParams extends MarginLayoutParams {
        public int a = 0;
        float b;
        boolean c;
        int d;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.a);
            this.a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.a = layoutParams.a;
        }

        public LayoutParams(@NonNull android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface LockMode {
    }

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
        int a = 0;
        int b;
        int c;
        int e;
        int f;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface State {
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 21) {
            z = false;
        }
        d = z;
    }

    public DrawerLayout(@NonNull Context context) {
        this(context, null);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new p();
        this.h = -1728053248;
        this.j = new Paint();
        this.q = true;
        this.r = 3;
        this.s = 3;
        this.t = 3;
        this.u = 3;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.m = new q(this, 3);
        this.n = new q(this, 5);
        this.k = as.a((ViewGroup) this, 1.0f, this.m);
        this.k.a(1);
        this.k.a(f2);
        this.m.a(this.k);
        this.l = as.a((ViewGroup) this, 1.0f, this.n);
        this.l.a(2);
        this.l.a(f2);
        this.n.a(this.l);
        setFocusableInTouchMode(true);
        ViewCompat.b((View) this, 1);
        ViewCompat.a((View) this, new o(this));
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.r(this)) {
            if (VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                    @TargetApi(21)
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).a((Object) windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c);
                try {
                    this.B = obtainStyledAttributes.getDrawable(0);
                } finally {
                    obtainStyledAttributes.recycle();
                }
            } else {
                this.B = null;
            }
        }
        this.f = f * 10.0f;
        this.M = new ArrayList();
    }

    private boolean b(Drawable drawable, int i) {
        if (drawable == null || !a.b(drawable)) {
            return false;
        }
        a.b(drawable, i);
        return true;
    }

    private void c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || g(childAt)) && !(z && childAt == view)) {
                ViewCompat.b(childAt, 4);
            } else {
                ViewCompat.b(childAt, 1);
            }
        }
    }

    static String d(int i) {
        return (i & 3) == 3 ? "LEFT" : (i & 5) == 5 ? "RIGHT" : Integer.toHexString(i);
    }

    private void e() {
        if (!d) {
            this.C = f();
            this.D = g();
        }
    }

    private Drawable f() {
        int f = ViewCompat.f(this);
        if (f == 0) {
            if (this.I != null) {
                b(this.I, f);
                return this.I;
            }
        } else if (this.J != null) {
            b(this.J, f);
            return this.J;
        }
        return this.K;
    }

    private Drawable g() {
        int f = ViewCompat.f(this);
        if (f == 0) {
            if (this.J != null) {
                b(this.J, f);
                return this.J;
            }
        } else if (this.I != null) {
            b(this.I, f);
            return this.I;
        }
        return this.L;
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).c) {
                return true;
            }
        }
        return false;
    }

    private boolean i() {
        return c() != null;
    }

    static boolean l(View view) {
        return (ViewCompat.e(view) == 4 || ViewCompat.e(view) == 2) ? false : true;
    }

    private static boolean m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public int a(int i) {
        int f = ViewCompat.f(this);
        switch (i) {
            case 3:
                if (this.r != 3) {
                    return this.r;
                }
                f = f == 0 ? this.t : this.u;
                if (f != 3) {
                    return f;
                }
                break;
            case 5:
                if (this.s != 3) {
                    return this.s;
                }
                f = f == 0 ? this.u : this.t;
                if (f != 3) {
                    return f;
                }
                break;
            case 8388611:
                if (this.t != 3) {
                    return this.t;
                }
                f = f == 0 ? this.r : this.s;
                if (f != 3) {
                    return f;
                }
                break;
            case 8388613:
                if (this.u != 3) {
                    return this.u;
                }
                f = f == 0 ? this.s : this.r;
                if (f != 3) {
                    return f;
                }
                break;
        }
        return 0;
    }

    public int a(@NonNull View view) {
        if (g(view)) {
            return a(((LayoutParams) view.getLayoutParams()).a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    View a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public void a(@DrawableRes int i, int i2) {
        a(android.support.v4.content.a.a(getContext(), i), i2);
    }

    void a(int i, int i2, View view) {
        int a = this.k.a();
        int a2 = this.l.a();
        a = (a == 1 || a2 == 1) ? 1 : (a == 2 || a2 == 2) ? 2 : 0;
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.b == 0.0f) {
                b(view);
            } else if (layoutParams.b == 1.0f) {
                c(view);
            }
        }
        if (a != this.o) {
            this.o = a;
            if (this.y != null) {
                for (int size = this.y.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.y.get(size)).onDrawerStateChanged(a);
                }
            }
        }
    }

    public void a(int i, boolean z) {
        View c = c(i);
        if (c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + d(i));
        }
        a(c, z);
    }

    public void a(Drawable drawable, int i) {
        if (!d) {
            if ((i & 8388611) == 8388611) {
                this.I = drawable;
            } else if ((i & 8388613) == 8388613) {
                this.J = drawable;
            } else if ((i & 3) == 3) {
                this.K = drawable;
            } else if ((i & 5) == 5) {
                this.L = drawable;
            } else {
                return;
            }
            e();
            invalidate();
        }
    }

    public void a(@NonNull DrawerListener drawerListener) {
        if (drawerListener != null) {
            if (this.y == null) {
                this.y = new ArrayList();
            }
            this.y.add(drawerListener);
        }
    }

    void a(View view, float f) {
        if (this.y != null) {
            for (int size = this.y.size() - 1; size >= 0; size--) {
                ((DrawerListener) this.y.get(size)).onDrawerSlide(view, f);
            }
        }
    }

    public void a(@NonNull View view, boolean z) {
        if (g(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.q) {
                layoutParams.b = 1.0f;
                layoutParams.d = 1;
                c(view, true);
            } else if (z) {
                layoutParams.d |= 2;
                if (a(view, 3)) {
                    this.k.a(view, 0, view.getTop());
                } else {
                    this.l.a(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                c(view, 1.0f);
                a(layoutParams.a, 0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void a(Object obj, boolean z) {
        this.G = obj;
        this.H = z;
        boolean z2 = !z && getBackground() == null;
        setWillNotDraw(z2);
        requestLayout();
    }

    void a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (g(childAt) && (!z || layoutParams.c)) {
                i = a(childAt, 3) ? i | this.k.a(childAt, -childAt.getWidth(), childAt.getTop()) : i | this.l.a(childAt, getWidth(), childAt.getTop());
                layoutParams.c = false;
            }
        }
        this.m.a();
        this.n.a();
        if (i != 0) {
            invalidate();
        }
    }

    boolean a(View view, int i) {
        return (e(view) & i) == i;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int i3 = 0;
        if (getDescendantFocusability() != 393216) {
            int i4;
            int childCount = getChildCount();
            int i5 = 0;
            for (i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (!g(childAt)) {
                    this.M.add(childAt);
                } else if (j(childAt)) {
                    i5 = 1;
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
            if (i5 == 0) {
                i4 = this.M.size();
                while (i3 < i4) {
                    View view = (View) this.M.get(i3);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                    i3++;
                }
            }
            this.M.clear();
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (a() != null || g(view)) {
            ViewCompat.b(view, 4);
        } else {
            ViewCompat.b(view, 1);
        }
        if (!b) {
            ViewCompat.a(view, this.e);
        }
    }

    @Nullable
    public CharSequence b(int i) {
        int a = d.a(i, ViewCompat.f(this));
        return a == 3 ? this.E : a == 5 ? this.F : null;
    }

    public void b() {
        a(false);
    }

    public void b(int i, int i2) {
        int a = d.a(i2, ViewCompat.f(this));
        switch (i2) {
            case 3:
                this.r = i;
                break;
            case 5:
                this.s = i;
                break;
            case 8388611:
                this.t = i;
                break;
            case 8388613:
                this.u = i;
                break;
        }
        if (i != 0) {
            (a == 3 ? this.k : this.l).e();
        }
        View c;
        switch (i) {
            case 1:
                c = c(a);
                if (c != null) {
                    i(c);
                    return;
                }
                return;
            case 2:
                c = c(a);
                if (c != null) {
                    h(c);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void b(int i, boolean z) {
        View c = c(i);
        if (c == null) {
            throw new IllegalArgumentException("No drawer view found with gravity " + d(i));
        }
        b(c, z);
    }

    public void b(@NonNull DrawerListener drawerListener) {
        if (drawerListener != null && this.y != null) {
            this.y.remove(drawerListener);
        }
    }

    void b(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 1) {
            layoutParams.d = 0;
            if (this.y != null) {
                for (int size = this.y.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.y.get(size)).onDrawerClosed(view);
                }
            }
            c(view, false);
            if (hasWindowFocus()) {
                View rootView = getRootView();
                if (rootView != null) {
                    rootView.sendAccessibilityEvent(32);
                }
            }
        }
    }

    void b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.b) {
            layoutParams.b = f;
            a(view, f);
        }
    }

    public void b(@NonNull View view, boolean z) {
        if (g(view)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.q) {
                layoutParams.b = 0.0f;
                layoutParams.d = 0;
            } else if (z) {
                layoutParams.d |= 4;
                if (a(view, 3)) {
                    this.k.a(view, -view.getWidth(), view.getTop());
                } else {
                    this.l.a(view, getWidth(), view.getTop());
                }
            } else {
                c(view, 0.0f);
                a(layoutParams.a, 0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    View c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (g(childAt) && k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    View c(int i) {
        int a = d.a(i, ViewCompat.f(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((e(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    void c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.d & 1) == 0) {
            layoutParams.d = 1;
            if (this.y != null) {
                for (int size = this.y.size() - 1; size >= 0; size--) {
                    ((DrawerListener) this.y.get(size)).onDrawerOpened(view);
                }
            }
            c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void c(View view, float f) {
        float d = d(view);
        int width = view.getWidth();
        int i = ((int) (((float) width) * f)) - ((int) (d * ((float) width)));
        if (!a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        b(view, f);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).b);
        }
        this.i = f;
        boolean a = this.k.a(true);
        boolean a2 = this.l.a(true);
        if (a || a2) {
            ViewCompat.d(this);
        }
    }

    float d(View view) {
        return ((LayoutParams) view.getLayoutParams()).b;
    }

    void d() {
        int i = 0;
        if (!this.w) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            while (i < childCount) {
                getChildAt(i).dispatchTouchEvent(obtain);
                i++;
            }
            obtain.recycle();
            this.w = true;
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int i;
        int height = getHeight();
        boolean f = f(view);
        int i2 = 0;
        int width = getWidth();
        int save = canvas.save();
        if (f) {
            int childCount = getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && m(childAt) && g(childAt)) {
                    if (childAt.getHeight() < height) {
                        i = width;
                    } else if (a(childAt, 3)) {
                        i = childAt.getRight();
                        if (i <= i2) {
                            i = i2;
                        }
                        i2 = i;
                        i = width;
                    } else {
                        i = childAt.getLeft();
                        if (i < width) {
                        }
                    }
                    i3++;
                    width = i;
                }
                i = width;
                i3++;
                width = i;
            }
            canvas.clipRect(i2, 0, width, getHeight());
        }
        i = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float max;
        if (this.i > 0.0f && f) {
            this.j.setColor((((int) (((float) ((this.h & CtaButton.BACKGROUND_COLOR) >>> 24)) * this.i)) << 24) | (this.h & 16777215));
            canvas.drawRect((float) i2, 0.0f, (float) i, (float) getHeight(), this.j);
        } else if (this.C != null && a(view, 3)) {
            i = this.C.getIntrinsicWidth();
            i2 = view.getRight();
            max = Math.max(0.0f, Math.min(((float) i2) / ((float) this.k.b()), 1.0f));
            this.C.setBounds(i2, view.getTop(), i + i2, view.getBottom());
            this.C.setAlpha((int) (255.0f * max));
            this.C.draw(canvas);
        } else if (this.D != null && a(view, 5)) {
            i = this.D.getIntrinsicWidth();
            i2 = view.getLeft();
            max = Math.max(0.0f, Math.min(((float) (getWidth() - i2)) / ((float) this.l.b()), 1.0f));
            this.D.setBounds(i2 - i, view.getTop(), i2, view.getBottom());
            this.D.setAlpha((int) (255.0f * max));
            this.D.draw(canvas);
        }
        return drawChild;
    }

    int e(View view) {
        return d.a(((LayoutParams) view.getLayoutParams()).a, ViewCompat.f(this));
    }

    public void e(int i) {
        a(i, true);
    }

    public void f(int i) {
        b(i, true);
    }

    boolean f(View view) {
        return ((LayoutParams) view.getLayoutParams()).a == 0;
    }

    public boolean g(int i) {
        View c = c(i);
        return c != null ? j(c) : false;
    }

    boolean g(View view) {
        int a = d.a(((LayoutParams) view.getLayoutParams()).a, ViewCompat.f(view));
        return (a & 3) != 0 ? true : (a & 5) != 0;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getDrawerElevation() {
        return d ? this.f : 0.0f;
    }

    @Nullable
    public Drawable getStatusBarBackgroundDrawable() {
        return this.B;
    }

    public void h(@NonNull View view) {
        a(view, true);
    }

    public boolean h(int i) {
        View c = c(i);
        return c != null ? k(c) : false;
    }

    public void i(@NonNull View view) {
        b(view, true);
    }

    public boolean j(@NonNull View view) {
        if (g(view)) {
            return (((LayoutParams) view.getLayoutParams()).d & 1) == 1;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    public boolean k(@NonNull View view) {
        if (g(view)) {
            return ((LayoutParams) view.getLayoutParams()).b > 0.0f;
        } else {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.q = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q = true;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.H && this.B != null) {
            int systemWindowInsetTop = VERSION.SDK_INT >= 21 ? this.G != null ? ((WindowInsets) this.G).getSystemWindowInsetTop() : 0 : 0;
            if (systemWindowInsetTop > 0) {
                this.B.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.B.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r1 = 1;
        r2 = 0;
        r0 = r8.getActionMasked();
        r3 = r7.k;
        r3 = r3.a(r8);
        r4 = r7.l;
        r4 = r4.a(r8);
        r3 = r3 | r4;
        switch(r0) {
            case 0: goto L_0x0027;
            case 1: goto L_0x0065;
            case 2: goto L_0x0050;
            case 3: goto L_0x0065;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r3 != 0) goto L_0x0025;
    L_0x0019:
        if (r0 != 0) goto L_0x0025;
    L_0x001b:
        r0 = r7.h();
        if (r0 != 0) goto L_0x0025;
    L_0x0021:
        r0 = r7.w;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        r2 = r1;
    L_0x0026:
        return r2;
    L_0x0027:
        r0 = r8.getX();
        r4 = r8.getY();
        r7.z = r0;
        r7.A = r4;
        r5 = r7.i;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x006d;
    L_0x003a:
        r5 = r7.k;
        r0 = (int) r0;
        r4 = (int) r4;
        r0 = r5.d(r0, r4);
        if (r0 == 0) goto L_0x006d;
    L_0x0044:
        r0 = r7.f(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x004a:
        r0 = r1;
    L_0x004b:
        r7.v = r2;
        r7.w = r2;
        goto L_0x0017;
    L_0x0050:
        r0 = r7.k;
        r4 = 3;
        r0 = r0.d(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0059:
        r0 = r7.m;
        r0.a();
        r0 = r7.n;
        r0.a();
        r0 = r2;
        goto L_0x0017;
    L_0x0065:
        r7.a(r1);
        r7.v = r2;
        r7.w = r2;
        goto L_0x0016;
    L_0x006d:
        r0 = r2;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !i()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View c = c();
        if (c != null && a(c) == 0) {
            b();
        }
        return c != null;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.p = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.b ? 1 : null;
                    int i8;
                    switch (layoutParams.a & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        b(childAt, f);
                    }
                    int i10 = layoutParams.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.p = false;
        this.q = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0049  */
    protected void onMeasure(int r18, int r19) {
        /*
        r17 = this;
        r3 = android.view.View.MeasureSpec.getMode(r18);
        r4 = android.view.View.MeasureSpec.getMode(r19);
        r2 = android.view.View.MeasureSpec.getSize(r18);
        r1 = android.view.View.MeasureSpec.getSize(r19);
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r3 != r5) goto L_0x0018;
    L_0x0014:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r4 == r5) goto L_0x01fe;
    L_0x0018:
        r5 = r17.isInEditMode();
        if (r5 == 0) goto L_0x0067;
    L_0x001e:
        r5 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r3 != r5) goto L_0x005b;
    L_0x0022:
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        if (r4 != r3) goto L_0x0060;
    L_0x0026:
        r3 = r1;
        r4 = r2;
    L_0x0028:
        r0 = r17;
        r0.setMeasuredDimension(r4, r3);
        r0 = r17;
        r1 = r0.G;
        if (r1 == 0) goto L_0x006f;
    L_0x0033:
        r1 = android.support.v4.view.ViewCompat.r(r17);
        if (r1 == 0) goto L_0x006f;
    L_0x0039:
        r1 = 1;
        r5 = r1;
    L_0x003b:
        r9 = android.support.v4.view.ViewCompat.f(r17);
        r7 = 0;
        r6 = 0;
        r10 = r17.getChildCount();
        r1 = 0;
        r8 = r1;
    L_0x0047:
        if (r8 >= r10) goto L_0x01fd;
    L_0x0049:
        r0 = r17;
        r11 = r0.getChildAt(r8);
        r1 = r11.getVisibility();
        r2 = 8;
        if (r1 != r2) goto L_0x0072;
    L_0x0057:
        r1 = r8 + 1;
        r8 = r1;
        goto L_0x0047;
    L_0x005b:
        if (r3 != 0) goto L_0x0022;
    L_0x005d:
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        goto L_0x0022;
    L_0x0060:
        if (r4 != 0) goto L_0x01fe;
    L_0x0062:
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r3 = r1;
        r4 = r2;
        goto L_0x0028;
    L_0x0067:
        r1 = new java.lang.IllegalArgumentException;
        r2 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r1.<init>(r2);
        throw r1;
    L_0x006f:
        r1 = 0;
        r5 = r1;
        goto L_0x003b;
    L_0x0072:
        r1 = r11.getLayoutParams();
        r1 = (android.support.v4.widget.DrawerLayout.LayoutParams) r1;
        if (r5 == 0) goto L_0x00a9;
    L_0x007a:
        r2 = r1.a;
        r12 = android.support.v4.view.d.a(r2, r9);
        r2 = android.support.v4.view.ViewCompat.r(r11);
        if (r2 == 0) goto L_0x00e5;
    L_0x0086:
        r2 = android.os.Build.VERSION.SDK_INT;
        r13 = 21;
        if (r2 < r13) goto L_0x00a9;
    L_0x008c:
        r0 = r17;
        r2 = r0.G;
        r2 = (android.view.WindowInsets) r2;
        r13 = 3;
        if (r12 != r13) goto L_0x00d0;
    L_0x0095:
        r12 = r2.getSystemWindowInsetLeft();
        r13 = r2.getSystemWindowInsetTop();
        r14 = 0;
        r15 = r2.getSystemWindowInsetBottom();
        r2 = r2.replaceSystemWindowInsets(r12, r13, r14, r15);
    L_0x00a6:
        r11.dispatchApplyWindowInsets(r2);
    L_0x00a9:
        r0 = r17;
        r2 = r0.f(r11);
        if (r2 == 0) goto L_0x0133;
    L_0x00b1:
        r2 = r1.leftMargin;
        r2 = r4 - r2;
        r12 = r1.rightMargin;
        r2 = r2 - r12;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r12);
        r12 = r1.topMargin;
        r12 = r3 - r12;
        r1 = r1.bottomMargin;
        r1 = r12 - r1;
        r12 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r12);
        r11.measure(r2, r1);
        goto L_0x0057;
    L_0x00d0:
        r13 = 5;
        if (r12 != r13) goto L_0x00a6;
    L_0x00d3:
        r12 = 0;
        r13 = r2.getSystemWindowInsetTop();
        r14 = r2.getSystemWindowInsetRight();
        r15 = r2.getSystemWindowInsetBottom();
        r2 = r2.replaceSystemWindowInsets(r12, r13, r14, r15);
        goto L_0x00a6;
    L_0x00e5:
        r2 = android.os.Build.VERSION.SDK_INT;
        r13 = 21;
        if (r2 < r13) goto L_0x00a9;
    L_0x00eb:
        r0 = r17;
        r2 = r0.G;
        r2 = (android.view.WindowInsets) r2;
        r13 = 3;
        if (r12 != r13) goto L_0x011e;
    L_0x00f4:
        r12 = r2.getSystemWindowInsetLeft();
        r13 = r2.getSystemWindowInsetTop();
        r14 = 0;
        r15 = r2.getSystemWindowInsetBottom();
        r2 = r2.replaceSystemWindowInsets(r12, r13, r14, r15);
    L_0x0105:
        r12 = r2.getSystemWindowInsetLeft();
        r1.leftMargin = r12;
        r12 = r2.getSystemWindowInsetTop();
        r1.topMargin = r12;
        r12 = r2.getSystemWindowInsetRight();
        r1.rightMargin = r12;
        r2 = r2.getSystemWindowInsetBottom();
        r1.bottomMargin = r2;
        goto L_0x00a9;
    L_0x011e:
        r13 = 5;
        if (r12 != r13) goto L_0x0105;
    L_0x0121:
        r12 = 0;
        r13 = r2.getSystemWindowInsetTop();
        r14 = r2.getSystemWindowInsetRight();
        r15 = r2.getSystemWindowInsetBottom();
        r2 = r2.replaceSystemWindowInsets(r12, r13, r14, r15);
        goto L_0x0105;
    L_0x0133:
        r0 = r17;
        r2 = r0.g(r11);
        if (r2 == 0) goto L_0x01ce;
    L_0x013b:
        r2 = d;
        if (r2 == 0) goto L_0x0152;
    L_0x013f:
        r2 = android.support.v4.view.ViewCompat.m(r11);
        r0 = r17;
        r12 = r0.f;
        r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r2 == 0) goto L_0x0152;
    L_0x014b:
        r0 = r17;
        r2 = r0.f;
        android.support.v4.view.ViewCompat.a(r11, r2);
    L_0x0152:
        r0 = r17;
        r2 = r0.e(r11);
        r12 = r2 & 7;
        r2 = 3;
        if (r12 != r2) goto L_0x019b;
    L_0x015d:
        r2 = 1;
    L_0x015e:
        if (r2 == 0) goto L_0x0162;
    L_0x0160:
        if (r7 != 0) goto L_0x0166;
    L_0x0162:
        if (r2 != 0) goto L_0x019d;
    L_0x0164:
        if (r6 == 0) goto L_0x019d;
    L_0x0166:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Child drawer has absolute gravity ";
        r2 = r2.append(r3);
        r3 = d(r12);
        r2 = r2.append(r3);
        r3 = " but this ";
        r2 = r2.append(r3);
        r3 = "DrawerLayout";
        r2 = r2.append(r3);
        r3 = " already has a ";
        r2 = r2.append(r3);
        r3 = "drawer view along that edge";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x019b:
        r2 = 0;
        goto L_0x015e;
    L_0x019d:
        if (r2 == 0) goto L_0x01cb;
    L_0x019f:
        r2 = 1;
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x01a5:
        r0 = r17;
        r7 = r0.g;
        r12 = r1.leftMargin;
        r7 = r7 + r12;
        r12 = r1.rightMargin;
        r7 = r7 + r12;
        r12 = r1.width;
        r0 = r18;
        r7 = getChildMeasureSpec(r0, r7, r12);
        r12 = r1.topMargin;
        r13 = r1.bottomMargin;
        r12 = r12 + r13;
        r1 = r1.height;
        r0 = r19;
        r1 = getChildMeasureSpec(r0, r12, r1);
        r11.measure(r7, r1);
        r7 = r6;
        r6 = r2;
        goto L_0x0057;
    L_0x01cb:
        r2 = 1;
        r6 = r7;
        goto L_0x01a5;
    L_0x01ce:
        r1 = new java.lang.IllegalStateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Child ";
        r2 = r2.append(r3);
        r2 = r2.append(r11);
        r3 = " at index ";
        r2 = r2.append(r3);
        r2 = r2.append(r8);
        r3 = " does not have a valid layout_gravity - must be Gravity.LEFT, ";
        r2 = r2.append(r3);
        r3 = "Gravity.RIGHT or Gravity.NO_GRAVITY";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        throw r1;
    L_0x01fd:
        return;
    L_0x01fe:
        r3 = r1;
        r4 = r2;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            if (savedState.a != 0) {
                View c = c(savedState.a);
                if (c != null) {
                    h(c);
                }
            }
            if (savedState.b != 3) {
                b(savedState.b, 3);
            }
            if (savedState.c != 3) {
                b(savedState.c, 5);
            }
            if (savedState.e != 3) {
                b(savedState.e, 8388611);
            }
            if (savedState.f != 3) {
                b(savedState.f, 8388613);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onRtlPropertiesChanged(int i) {
        e();
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            Object obj = layoutParams.d == 1 ? 1 : null;
            Object obj2 = layoutParams.d == 2 ? 1 : null;
            if (obj != null || obj2 != null) {
                savedState.a = layoutParams.a;
                break;
            }
        }
        savedState.b = this.r;
        savedState.c = this.s;
        savedState.e = this.t;
        savedState.f = this.u;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.k.b(motionEvent);
        this.l.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.z = x;
                this.A = y;
                this.v = false;
                this.w = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View d = this.k.d((int) x, (int) y);
                if (d != null && f(d)) {
                    x -= this.z;
                    y -= this.A;
                    int d2 = this.k.d();
                    if ((x * x) + (y * y) < ((float) (d2 * d2))) {
                        View a = a();
                        if (a != null) {
                            z = a(a) == 2;
                            a(z);
                            this.v = false;
                            break;
                        }
                    }
                }
                z = true;
                a(z);
                this.v = false;
            case 3:
                a(true);
                this.v = false;
                this.w = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.v = z;
        if (z) {
            a(true);
        }
    }

    public void requestLayout() {
        if (!this.p) {
            super.requestLayout();
        }
    }

    public void setDrawerElevation(float f) {
        this.f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (g(childAt)) {
                ViewCompat.a(childAt, this.f);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        if (this.x != null) {
            b(this.x);
        }
        if (drawerListener != null) {
            a(drawerListener);
        }
        this.x = drawerListener;
    }

    public void setDrawerLockMode(int i) {
        b(i, 3);
        b(i, 5);
    }

    public void setScrimColor(@ColorInt int i) {
        this.h = i;
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.B = i != 0 ? android.support.v4.content.a.a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        this.B = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        this.B = new ColorDrawable(i);
        invalidate();
    }
}
