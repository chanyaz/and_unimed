package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    static final int[] a = new int[]{16842931};
    private static final ak ai = new ak();
    private static final Comparator<ah> e = new Comparator<ah>() {
        /* renamed from: a */
        public int compare(ah ahVar, ah ahVar2) {
            return ahVar.b - ahVar2.b;
        }
    };
    private static final Interpolator f = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private int A = 1;
    private boolean B;
    private boolean C;
    private int D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private float J;
    private int K = -1;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private EdgeEffect R;
    private EdgeEffect S;
    private boolean T = true;
    private boolean U = false;
    private boolean V;
    private int W;
    private List<OnPageChangeListener> aa;
    private OnPageChangeListener ab;
    private OnPageChangeListener ac;
    private List<OnAdapterChangeListener> ad;
    private PageTransformer ae;
    private int af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.c();
        }
    };
    private int ak = 0;
    n b;
    int c;
    private int d;
    private final ArrayList<ah> g = new ArrayList();
    private final ah h = new ah();
    private final Rect i = new Rect();
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private boolean n;
    private aj o;
    private int p;
    private Drawable q;
    private int r;
    private int s;
    private float t = -3.4028235E38f;
    private float u = Float.MAX_VALUE;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable n nVar, @Nullable n nVar2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean a;
        public int b;
        float c = 0.0f;
        boolean d;
        int e;
        int f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.a);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    public interface PageTransformer {
        void transformPage(@NonNull View view, float f);
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
        int a;
        Parcelable b;
        ClassLoader c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }

        public SavedState(@NonNull Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
            parcel.writeParcelable(this.b, i);
        }
    }

    public ViewPager(@NonNull Context context) {
        super(context);
        a();
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.O || Math.abs(i2) <= this.M) {
            i += (int) ((i >= this.c ? 0.4f : 0.6f) + f);
        } else if (i2 <= 0) {
            i++;
        }
        if (this.g.size() <= 0) {
            return i;
        }
        return Math.max(((ah) this.g.get(0)).b, Math.min(i, ((ah) this.g.get(this.g.size() - 1)).b));
    }

    private Rect a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.g.isEmpty()) {
            ah b = b(this.c);
            int min = (int) ((b != null ? Math.min(b.e, this.u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int max;
        ah b = b(i);
        if (b != null) {
            max = (int) (Math.max(this.t, Math.min(b.e, this.u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            a(max, 0, i2);
            if (z2) {
                e(i);
                return;
            }
            return;
        }
        if (z2) {
            e(i);
        }
        a(false);
        scrollTo(max, 0);
        d(max);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A:{LOOP_END, LOOP:2: B:18:0x0058->B:20:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a3 A:{LOOP_END, LOOP:5: B:33:0x009f->B:35:0x00a3} */
    private void a(android.support.v4.view.ah r12, int r13, android.support.v4.view.ah r14) {
        /*
        r11 = this;
        r4 = 0;
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r11.b;
        r7 = r0.b();
        r0 = r11.getClientWidth();
        if (r0 <= 0) goto L_0x0055;
    L_0x000f:
        r1 = r11.p;
        r1 = (float) r1;
        r0 = (float) r0;
        r0 = r1 / r0;
        r6 = r0;
    L_0x0016:
        if (r14 == 0) goto L_0x00b7;
    L_0x0018:
        r0 = r14.b;
        r1 = r12.b;
        if (r0 >= r1) goto L_0x0070;
    L_0x001e:
        r1 = r14.e;
        r2 = r14.d;
        r1 = r1 + r2;
        r3 = r1 + r6;
        r2 = r0 + 1;
        r1 = r4;
    L_0x0028:
        r0 = r12.b;
        if (r2 > r0) goto L_0x00b7;
    L_0x002c:
        r0 = r11.g;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x00b7;
    L_0x0034:
        r0 = r11.g;
        r0 = r0.get(r1);
        r0 = (android.support.v4.view.ah) r0;
    L_0x003c:
        r5 = r0.b;
        if (r2 <= r5) goto L_0x0058;
    L_0x0040:
        r5 = r11.g;
        r5 = r5.size();
        r5 = r5 + -1;
        if (r1 >= r5) goto L_0x0058;
    L_0x004a:
        r1 = r1 + 1;
        r0 = r11.g;
        r0 = r0.get(r1);
        r0 = (android.support.v4.view.ah) r0;
        goto L_0x003c;
    L_0x0055:
        r0 = 0;
        r6 = r0;
        goto L_0x0016;
    L_0x0058:
        r5 = r0.b;
        if (r2 >= r5) goto L_0x0067;
    L_0x005c:
        r5 = r11.b;
        r5 = r5.d(r2);
        r5 = r5 + r6;
        r3 = r3 + r5;
        r2 = r2 + 1;
        goto L_0x0058;
    L_0x0067:
        r0.e = r3;
        r0 = r0.d;
        r0 = r0 + r6;
        r3 = r3 + r0;
        r2 = r2 + 1;
        goto L_0x0028;
    L_0x0070:
        r1 = r12.b;
        if (r0 <= r1) goto L_0x00b7;
    L_0x0074:
        r1 = r11.g;
        r1 = r1.size();
        r1 = r1 + -1;
        r3 = r14.e;
        r2 = r0 + -1;
    L_0x0080:
        r0 = r12.b;
        if (r2 < r0) goto L_0x00b7;
    L_0x0084:
        if (r1 < 0) goto L_0x00b7;
    L_0x0086:
        r0 = r11.g;
        r0 = r0.get(r1);
        r0 = (android.support.v4.view.ah) r0;
    L_0x008e:
        r5 = r0.b;
        if (r2 >= r5) goto L_0x009f;
    L_0x0092:
        if (r1 <= 0) goto L_0x009f;
    L_0x0094:
        r1 = r1 + -1;
        r0 = r11.g;
        r0 = r0.get(r1);
        r0 = (android.support.v4.view.ah) r0;
        goto L_0x008e;
    L_0x009f:
        r5 = r0.b;
        if (r2 <= r5) goto L_0x00ae;
    L_0x00a3:
        r5 = r11.b;
        r5 = r5.d(r2);
        r5 = r5 + r6;
        r3 = r3 - r5;
        r2 = r2 + -1;
        goto L_0x009f;
    L_0x00ae:
        r5 = r0.d;
        r5 = r5 + r6;
        r3 = r3 - r5;
        r0.e = r3;
        r2 = r2 + -1;
        goto L_0x0080;
    L_0x00b7:
        r0 = r11.g;
        r8 = r0.size();
        r2 = r12.e;
        r0 = r12.b;
        r1 = r0 + -1;
        r0 = r12.b;
        if (r0 != 0) goto L_0x00f9;
    L_0x00c7:
        r0 = r12.e;
    L_0x00c9:
        r11.t = r0;
        r0 = r12.b;
        r3 = r7 + -1;
        if (r0 != r3) goto L_0x00fd;
    L_0x00d1:
        r0 = r12.e;
        r3 = r12.d;
        r0 = r0 + r3;
        r0 = r0 - r10;
    L_0x00d7:
        r11.u = r0;
        r0 = r13 + -1;
        r5 = r0;
    L_0x00dc:
        if (r5 < 0) goto L_0x0114;
    L_0x00de:
        r0 = r11.g;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.ah) r0;
        r3 = r2;
    L_0x00e7:
        r2 = r0.b;
        if (r1 <= r2) goto L_0x0101;
    L_0x00eb:
        r9 = r11.b;
        r2 = r1 + -1;
        r1 = r9.d(r1);
        r1 = r1 + r6;
        r1 = r3 - r1;
        r3 = r1;
        r1 = r2;
        goto L_0x00e7;
    L_0x00f9:
        r0 = -8388609; // 0xffffffffff7fffff float:-3.4028235E38 double:NaN;
        goto L_0x00c9;
    L_0x00fd:
        r0 = 2139095039; // 0x7f7fffff float:3.4028235E38 double:1.056853372E-314;
        goto L_0x00d7;
    L_0x0101:
        r2 = r0.d;
        r2 = r2 + r6;
        r2 = r3 - r2;
        r0.e = r2;
        r0 = r0.b;
        if (r0 != 0) goto L_0x010e;
    L_0x010c:
        r11.t = r2;
    L_0x010e:
        r0 = r5 + -1;
        r1 = r1 + -1;
        r5 = r0;
        goto L_0x00dc;
    L_0x0114:
        r0 = r12.e;
        r1 = r12.d;
        r0 = r0 + r1;
        r2 = r0 + r6;
        r0 = r12.b;
        r1 = r0 + 1;
        r0 = r13 + 1;
        r5 = r0;
    L_0x0122:
        if (r5 >= r8) goto L_0x0157;
    L_0x0124:
        r0 = r11.g;
        r0 = r0.get(r5);
        r0 = (android.support.v4.view.ah) r0;
        r3 = r2;
    L_0x012d:
        r2 = r0.b;
        if (r1 >= r2) goto L_0x013e;
    L_0x0131:
        r9 = r11.b;
        r2 = r1 + 1;
        r1 = r9.d(r1);
        r1 = r1 + r6;
        r1 = r1 + r3;
        r3 = r1;
        r1 = r2;
        goto L_0x012d;
    L_0x013e:
        r2 = r0.b;
        r9 = r7 + -1;
        if (r2 != r9) goto L_0x014a;
    L_0x0144:
        r2 = r0.d;
        r2 = r2 + r3;
        r2 = r2 - r10;
        r11.u = r2;
    L_0x014a:
        r0.e = r3;
        r0 = r0.d;
        r0 = r0 + r6;
        r2 = r3 + r0;
        r0 = r5 + 1;
        r1 = r1 + 1;
        r5 = r0;
        goto L_0x0122;
    L_0x0157:
        r11.U = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(android.support.v4.view.ah, int, android.support.v4.view.ah):void");
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.K) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.G = motionEvent.getX(actionIndex);
            this.K = motionEvent.getPointerId(actionIndex);
            if (this.L != null) {
                this.L.clear();
            }
        }
    }

    private void a(boolean z) {
        int scrollX;
        int scrollY;
        int i = this.ak == 2 ? 1 : 0;
        if (i != 0) {
            setScrollingCacheEnabled(false);
            if (!this.m.isFinished()) {
                this.m.abortAnimation();
                scrollX = getScrollX();
                scrollY = getScrollY();
                int currX = this.m.getCurrX();
                int currY = this.m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        d(currX);
                    }
                }
            }
        }
        this.z = false;
        scrollX = 0;
        while (true) {
            scrollY = i;
            if (scrollX >= this.g.size()) {
                break;
            }
            ah ahVar = (ah) this.g.get(scrollX);
            if (ahVar.c) {
                ahVar.c = false;
                scrollY = 1;
            }
            i = scrollX + 1;
        }
        if (scrollY == 0) {
            return;
        }
        if (z) {
            ViewCompat.a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean a(float f, float f2) {
        return (f < ((float) this.E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.E)) && f2 < 0.0f);
    }

    private void b(int i, float f, int i2) {
        if (this.ab != null) {
            this.ab.onPageScrolled(i, f, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.aa.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.onPageScrolled(i, f, i2);
        }
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.af : 0, null);
        }
    }

    private boolean b(float f) {
        int i;
        float f2;
        int i2;
        boolean z = true;
        float f3 = this.G - f;
        this.G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.t;
        float f5 = ((float) clientWidth) * this.u;
        ah ahVar = (ah) this.g.get(0);
        ah ahVar2 = (ah) this.g.get(this.g.size() - 1);
        if (ahVar.b != 0) {
            f4 = ahVar.e * ((float) clientWidth);
            i = 0;
        } else {
            boolean i3 = true;
        }
        if (ahVar2.b != this.b.b() - 1) {
            f2 = ahVar2.e * ((float) clientWidth);
            i2 = 0;
        } else {
            f2 = f5;
            boolean i22 = true;
        }
        if (scrollX < f4) {
            if (i3 != 0) {
                this.R.onPull(Math.abs(f4 - scrollX) / ((float) clientWidth));
            } else {
                z = false;
            }
        } else if (scrollX > f2) {
            if (i22 != 0) {
                this.S.onPull(Math.abs(scrollX - f2) / ((float) clientWidth));
            } else {
                z = false;
            }
            f4 = f2;
        } else {
            f4 = scrollX;
            z = false;
        }
        this.G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        d((int) f4);
        return z;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private static boolean c(@NonNull View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    private boolean d(int i) {
        if (this.g.size() != 0) {
            ah i2 = i();
            int clientWidth = getClientWidth();
            int i3 = this.p + clientWidth;
            float f = ((float) this.p) / ((float) clientWidth);
            int i4 = i2.b;
            float f2 = ((((float) i) / ((float) clientWidth)) - i2.e) / (i2.d + f);
            clientWidth = (int) (((float) i3) * f2);
            this.V = false;
            a(i4, f2, clientWidth);
            if (this.V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.T) {
            return false;
        } else {
            this.V = false;
            a(0, 0.0f, 0);
            if (this.V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private void e(int i) {
        if (this.ab != null) {
            this.ab.onPageSelected(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.onPageSelected(i);
        }
    }

    private void f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).a) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private void f(int i) {
        if (this.ab != null) {
            this.ab.onPageScrollStateChanged(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.onPageScrollStateChanged(i);
        }
    }

    private void g() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private boolean h() {
        this.K = -1;
        j();
        this.R.onRelease();
        this.S.onRelease();
        return this.R.isFinished() || this.S.isFinished();
    }

    private ah i() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.p) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        ah ahVar = null;
        while (i2 < this.g.size()) {
            int i3;
            ah ahVar2;
            ah ahVar3 = (ah) this.g.get(i2);
            ah ahVar4;
            if (obj != null || ahVar3.b == i + 1) {
                ahVar4 = ahVar3;
                i3 = i2;
                ahVar2 = ahVar4;
            } else {
                ahVar3 = this.h;
                ahVar3.e = (f2 + f3) + f;
                ahVar3.b = i + 1;
                ahVar3.d = this.b.d(ahVar3.b);
                ahVar4 = ahVar3;
                i3 = i2 - 1;
                ahVar2 = ahVar4;
            }
            f2 = ahVar2.e;
            f3 = (ahVar2.d + f2) + f;
            if (obj == null && scrollX < f2) {
                return ahVar;
            }
            if (scrollX < f3 || i3 == this.g.size() - 1) {
                return ahVar2;
            }
            f3 = f2;
            i = ahVar2.b;
            obj = null;
            f2 = ahVar2.d;
            ahVar = ahVar2;
            i2 = i3 + 1;
        }
        return ahVar;
    }

    private void j() {
        this.B = false;
        this.C = false;
        if (this.L != null) {
            this.L.recycle();
            this.L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.y != z) {
            this.y = z;
        }
    }

    float a(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    ah a(int i, int i2) {
        ah ahVar = new ah();
        ahVar.b = i;
        ahVar.a = this.b.a((ViewGroup) this, i);
        ahVar.d = this.b.d(i);
        if (i2 < 0 || i2 >= this.g.size()) {
            this.g.add(ahVar);
        } else {
            this.g.add(i2, ahVar);
        }
        return ahVar;
    }

    ah a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.g.size()) {
                return null;
            }
            ah ahVar = (ah) this.g.get(i2);
            if (this.b.a(view, ahVar.a)) {
                return ahVar;
            }
            i = i2 + 1;
        }
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.F = viewConfiguration.getScaledPagingTouchSlop();
        this.M = (int) (400.0f * f);
        this.N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.R = new EdgeEffect(context);
        this.S = new EdgeEffect(context);
        this.O = (int) (25.0f * f);
        this.P = (int) (2.0f * f);
        this.D = (int) (16.0f * f);
        ViewCompat.a((View) this, new ai(this));
        if (ViewCompat.e(this) == 0) {
            ViewCompat.b((View) this, 1);
        }
        ViewCompat.a((View) this, new OnApplyWindowInsetsListener() {
            private final Rect b = new Rect();

            public as onApplyWindowInsets(View view, as asVar) {
                as a = ViewCompat.a(view, asVar);
                if (a.f()) {
                    return a;
                }
                Rect rect = this.b;
                rect.left = a.a();
                rect.top = a.b();
                rect.right = a.c();
                rect.bottom = a.d();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    as b = ViewCompat.b(ViewPager.this.getChildAt(i), a);
                    rect.left = Math.min(b.a(), rect.left);
                    rect.top = Math.min(b.b(), rect.top);
                    rect.right = Math.min(b.c(), rect.right);
                    rect.bottom = Math.min(b.d(), rect.bottom);
                }
                return a.a(rect.left, rect.top, rect.right, rect.bottom);
            }
        });
    }

    /* JADX WARNING: Missing block: B:25:0x00f0, code:
            if (r2.b == r17.c) goto L_0x00f2;
     */
    void a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.c;
        r0 = r18;
        if (r3 == r0) goto L_0x031e;
    L_0x0009:
        r0 = r17;
        r2 = r0.c;
        r0 = r17;
        r2 = r0.b(r2);
        r0 = r18;
        r1 = r17;
        r1.c = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.b;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.g();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.g();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.b;
        r0 = r17;
        r2.a(r0);
        r0 = r17;
        r2 = r0.A;
        r4 = 0;
        r0 = r17;
        r5 = r0.c;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.b;
        r11 = r4.b();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.c;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.d;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.d;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.b;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x031b;
    L_0x00d8:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ah) r2;
        r6 = r2.b;
        r0 = r17;
        r7 = r0.c;
        if (r6 < r7) goto L_0x01ba;
    L_0x00ea:
        r6 = r2.b;
        r0 = r17;
        r7 = r0.c;
        if (r6 != r7) goto L_0x031b;
    L_0x00f2:
        if (r2 != 0) goto L_0x0318;
    L_0x00f4:
        if (r11 <= 0) goto L_0x0318;
    L_0x00f6:
        r0 = r17;
        r2 = r0.c;
        r0 = r17;
        r2 = r0.a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x017c;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01bf;
    L_0x0108:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ah) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c2;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.c;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0201;
    L_0x012d:
        if (r8 >= r10) goto L_0x0201;
    L_0x012f:
        if (r2 != 0) goto L_0x01d1;
    L_0x0131:
        r5 = r9.d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0237;
    L_0x0145:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ah) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023a;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.c;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0281;
    L_0x0164:
        if (r8 <= r12) goto L_0x0281;
    L_0x0166:
        if (r2 != 0) goto L_0x0247;
    L_0x0168:
        r0 = r17;
        r0.a(r9, r7, r3);
        r0 = r17;
        r2 = r0.b;
        r0 = r17;
        r3 = r0.c;
        r4 = r9.a;
        r0 = r17;
        r2.b(r0, r3, r4);
    L_0x017c:
        r0 = r17;
        r2 = r0.b;
        r0 = r17;
        r2.b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018b:
        if (r3 >= r4) goto L_0x02cb;
    L_0x018d:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.LayoutParams) r2;
        r2.f = r3;
        r6 = r2.a;
        if (r6 != 0) goto L_0x01b6;
    L_0x019f:
        r6 = r2.c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b6;
    L_0x01a6:
        r0 = r17;
        r5 = r0.a(r5);
        if (r5 == 0) goto L_0x01b6;
    L_0x01ae:
        r6 = r5.d;
        r2.c = r6;
        r5 = r5.b;
        r2.e = r5;
    L_0x01b6:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018b;
    L_0x01ba:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01bf:
        r2 = 0;
        goto L_0x0112;
    L_0x01c2:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d1:
        r14 = r2.b;
        if (r8 != r14) goto L_0x01fb;
    L_0x01d5:
        r14 = r2.c;
        if (r14 != 0) goto L_0x01fb;
    L_0x01d9:
        r0 = r17;
        r14 = r0.g;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.b;
        r2 = r2.a;
        r0 = r17;
        r14.a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x01ff;
    L_0x01f1:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ah) r2;
    L_0x01fb:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x01ff:
        r2 = 0;
        goto L_0x01fb;
    L_0x0201:
        if (r2 == 0) goto L_0x021b;
    L_0x0203:
        r14 = r2.b;
        if (r8 != r14) goto L_0x021b;
    L_0x0207:
        r2 = r2.d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x0219;
    L_0x020e:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ah) r2;
        goto L_0x01fb;
    L_0x0219:
        r2 = 0;
        goto L_0x01fb;
    L_0x021b:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.a(r8, r2);
        r2 = r2.d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0235;
    L_0x022a:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ah) r2;
        goto L_0x01fb;
    L_0x0235:
        r2 = 0;
        goto L_0x01fb;
    L_0x0237:
        r6 = 0;
        goto L_0x0150;
    L_0x023a:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0247:
        r10 = r2.b;
        if (r8 != r10) goto L_0x0313;
    L_0x024b:
        r10 = r2.c;
        if (r10 != 0) goto L_0x0313;
    L_0x024f:
        r0 = r17;
        r10 = r0.g;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.b;
        r2 = r2.a;
        r0 = r17;
        r10.a(r0, r8, r2);
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x027f;
    L_0x026b:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ah) r2;
    L_0x0275:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x0278:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x027f:
        r2 = 0;
        goto L_0x0275;
    L_0x0281:
        if (r2 == 0) goto L_0x02a6;
    L_0x0283:
        r10 = r2.b;
        if (r8 != r10) goto L_0x02a6;
    L_0x0287:
        r2 = r2.d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a4;
    L_0x0296:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ah) r2;
    L_0x02a0:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x0278;
    L_0x02a4:
        r2 = 0;
        goto L_0x02a0;
    L_0x02a6:
        r0 = r17;
        r2 = r0.a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.g;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02c9;
    L_0x02bb:
        r0 = r17;
        r2 = r0.g;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ah) r2;
    L_0x02c5:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x0278;
    L_0x02c9:
        r2 = 0;
        goto L_0x02c5;
    L_0x02cb:
        r17.g();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d4:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0311;
    L_0x02da:
        r0 = r17;
        r2 = r0.b(r2);
    L_0x02e0:
        if (r2 == 0) goto L_0x02ea;
    L_0x02e2:
        r2 = r2.b;
        r0 = r17;
        r3 = r0.c;
        if (r2 == r3) goto L_0x0023;
    L_0x02ea:
        r2 = 0;
    L_0x02eb:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f1:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.a(r3);
        if (r4 == 0) goto L_0x030e;
    L_0x02ff:
        r4 = r4.b;
        r0 = r17;
        r5 = r0.c;
        if (r4 != r5) goto L_0x030e;
    L_0x0307:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x030e:
        r2 = r2 + 1;
        goto L_0x02eb;
    L_0x0311:
        r2 = 0;
        goto L_0x02e0;
    L_0x0313:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x0278;
    L_0x0318:
        r9 = r2;
        goto L_0x0101;
    L_0x031b:
        r2 = r5;
        goto L_0x00f2;
    L_0x031e:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    @CallSuper
    protected void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int max;
                    switch (layoutParams.b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        b(i, f, i2);
        if (this.ae != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).a) {
                    this.ae.transformPage(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.V = true;
    }

    void a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int currX;
        int i4;
        boolean z = (this.m == null || this.m.isFinished()) ? false : true;
        if (z) {
            currX = this.n ? this.m.getCurrX() : this.m.getStartX();
            this.m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        i7 = Math.min(abs > 0 ? Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4 : (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.b.d(this.c)) + ((float) this.p))) + 1.0f) * 100.0f), 600);
        this.n = false;
        this.m.startScroll(i4, scrollY, i5, i6, i7);
        ViewCompat.d(this);
    }

    public void a(int i, boolean z) {
        this.z = false;
        a(i, z, false);
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.b == null || this.b.b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.c != i || this.g.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.b.b()) {
                i = this.b.b() - 1;
            }
            int i3 = this.A;
            if (i > this.c + i3 || i < this.c - i3) {
                for (int i4 = 0; i4 < this.g.size(); i4++) {
                    ((ah) this.g.get(i4)).c = true;
                }
            }
            if (this.c != i) {
                z3 = true;
            }
            if (this.T) {
                this.c = i;
                if (z3) {
                    e(i);
                }
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void a(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.ad == null) {
            this.ad = new ArrayList();
        }
        this.ad.add(onAdapterChangeListener);
    }

    public void a(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.aa == null) {
            this.aa = new ArrayList();
        }
        this.aa.add(onPageChangeListener);
    }

    public boolean a(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return keyEvent.hasModifiers(2) ? d() : c(17);
            case 22:
                return keyEvent.hasModifiers(2) ? e() : c(66);
            case 61:
                return keyEvent.hasNoModifiers() ? c(2) : keyEvent.hasModifiers(1) ? c(1) : false;
            default:
                return false;
        }
    }

    protected boolean a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ah a = a(childAt);
                    if (a != null && a.b == this.c) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ah a = a(childAt);
                if (a != null && a.b == this.c) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.a |= c(view);
        if (!this.x) {
            super.addView(view, i, generateLayoutParams);
        } else if (layoutParams2 == null || !layoutParams2.a) {
            layoutParams2.d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    ah b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.g.size()) {
                return null;
            }
            ah ahVar = (ah) this.g.get(i3);
            if (ahVar.b == i) {
                return ahVar;
            }
            i2 = i3 + 1;
        }
    }

    ah b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    void b() {
        int i;
        int b = this.b.b();
        this.d = b;
        boolean z = this.g.size() < (this.A * 2) + 1 && this.g.size() < b;
        boolean z2 = false;
        int i2 = this.c;
        boolean z3 = z;
        int i3 = 0;
        while (i3 < this.g.size()) {
            int i4;
            boolean z4;
            boolean z5;
            ah ahVar = (ah) this.g.get(i3);
            int a = this.b.a(ahVar.a);
            if (a == -1) {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            } else if (a == -2) {
                this.g.remove(i3);
                i3--;
                if (!z2) {
                    this.b.a((ViewGroup) this);
                    z2 = true;
                }
                this.b.a((ViewGroup) this, ahVar.b, ahVar.a);
                if (this.c == ahVar.b) {
                    i4 = i3;
                    z4 = z2;
                    i = Math.max(0, Math.min(this.c, b - 1));
                    z5 = true;
                } else {
                    i4 = i3;
                    z4 = z2;
                    i = i2;
                    z5 = true;
                }
            } else if (ahVar.b != a) {
                if (ahVar.b == this.c) {
                    i2 = a;
                }
                ahVar.b = a;
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = true;
            } else {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            }
            z3 = z5;
            i2 = i;
            z2 = z4;
            i3 = i4 + 1;
        }
        if (z2) {
            this.b.b((ViewGroup) this);
        }
        Collections.sort(this.g, e);
        if (z3) {
            i = getChildCount();
            for (i3 = 0; i3 < i; i3++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                if (!layoutParams.a) {
                    layoutParams.c = 0.0f;
                }
            }
            a(i2, false, true);
            requestLayout();
        }
    }

    public void b(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.ad != null) {
            this.ad.remove(onAdapterChangeListener);
        }
    }

    public void b(@NonNull OnPageChangeListener onPageChangeListener) {
        if (this.aa != null) {
            this.aa.remove(onPageChangeListener);
        }
    }

    OnPageChangeListener c(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.ac;
        this.ac = onPageChangeListener;
        return onPageChangeListener2;
    }

    void c() {
        a(this.c);
    }

    public boolean c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = d();
            } else {
                if (i == 66 || i == 2) {
                    d = e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || a(this.i, findNextFocus).left < a(this.i, view).left) ? findNextFocus.requestFocus() : d();
        } else {
            if (i == 66) {
                d = (view == null || a(this.i, findNextFocus).left > a(this.i, view).left) ? findNextFocus.requestFocus() : e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        this.n = true;
        if (this.m.isFinished() || !this.m.computeScrollOffset()) {
            a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.m.getCurrX();
        int currY = this.m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!d(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.d(this);
    }

    boolean d() {
        if (this.c <= 0) {
            return false;
        }
        a(this.c - 1, true);
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || a(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ah a = a(childAt);
                if (a != null && a.b == this.c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.b != null && this.b.b() > 1)) {
            int height;
            int width;
            if (!this.R.isFinished()) {
                overScrollMode = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.t * ((float) width));
                this.R.setSize(height, width);
                i = 0 | this.R.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
            if (!this.S.isFinished()) {
                overScrollMode = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.u + 1.0f)) * ((float) height));
                this.S.setSize(width, height);
                i |= this.S.draw(canvas);
                canvas.restoreToCount(overScrollMode);
            }
        } else {
            this.R.finish();
            this.S.finish();
        }
        if (i != 0) {
            ViewCompat.d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean e() {
        if (this.b == null || this.c >= this.b.b() - 1) {
            return false;
        }
        a(this.c + 1, true);
        return true;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public n getAdapter() {
        return this.b;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.ah.get(i2)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.c;
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getPageMargin() {
        return this.p;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.T = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (!(this.m == null || this.m.isFinished())) {
            this.m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.p > 0 && this.q != null && this.g.size() > 0 && this.b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.p) / ((float) width);
            ah ahVar = (ah) this.g.get(0);
            float f2 = ahVar.e;
            int size = this.g.size();
            int i = ahVar.b;
            int i2 = ((ah) this.g.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > ahVar.b && i3 < size) {
                    i3++;
                    ahVar = (ah) this.g.get(i3);
                }
                if (i4 == ahVar.b) {
                    f3 = (ahVar.e + ahVar.d) * ((float) width);
                    f2 = (ahVar.e + ahVar.d) + f;
                } else {
                    float d = this.b.d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.p) + f3 > ((float) scrollX)) {
                    this.q.setBounds(Math.round(f3), this.r, Math.round(((float) this.p) + f3), this.s);
                    this.q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            h();
            return false;
        }
        if (action != 0) {
            if (this.B) {
                return true;
            }
            if (this.C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.I = x;
                this.G = x;
                x = motionEvent.getY();
                this.J = x;
                this.H = x;
                this.K = motionEvent.getPointerId(0);
                this.C = false;
                this.n = true;
                this.m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                    this.m.abortAnimation();
                    this.z = false;
                    c();
                    this.B = true;
                    c(true);
                    setScrollState(1);
                    break;
                }
                a(false);
                this.B = false;
                break;
            case 2:
                action = this.K;
                if (action != -1) {
                    action = motionEvent.findPointerIndex(action);
                    float x2 = motionEvent.getX(action);
                    float f = x2 - this.G;
                    float abs = Math.abs(f);
                    float y = motionEvent.getY(action);
                    float abs2 = Math.abs(y - this.J);
                    if (!(f == 0.0f || a(this.G, f))) {
                        if (a(this, false, (int) f, (int) x2, (int) y)) {
                            this.G = x2;
                            this.H = y;
                            this.C = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.F) && 0.5f * abs > abs2) {
                        this.B = true;
                        c(true);
                        setScrollState(1);
                        this.G = f > 0.0f ? this.I + ((float) this.F) : this.I - ((float) this.F);
                        this.H = y;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.F)) {
                        this.C = true;
                    }
                    if (this.B && b(x2)) {
                        ViewCompat.d(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        return this.B;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.a) {
                    int i9 = layoutParams.b & 112;
                    switch (layoutParams.b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    i8++;
                    paddingLeft = paddingLeft;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            paddingBottom = paddingTop;
            paddingTop = paddingRight;
            i8++;
            paddingLeft = paddingLeft;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams.a) {
                    ah a = a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.e * ((float) max))) + paddingLeft;
                        if (layoutParams.d) {
                            layoutParams.d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (layoutParams.c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.r = paddingTop;
        this.s = i6 - paddingBottom;
        this.W = i7;
        if (this.T) {
            a(this.c, false, 0, false);
        }
        this.T = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a0  */
    protected void onMeasure(int r14, int r15) {
        /*
        r13 = this;
        r0 = 0;
        r0 = getDefaultSize(r0, r14);
        r1 = 0;
        r1 = getDefaultSize(r1, r15);
        r13.setMeasuredDimension(r0, r1);
        r0 = r13.getMeasuredWidth();
        r1 = r0 / 10;
        r2 = r13.D;
        r1 = java.lang.Math.min(r1, r2);
        r13.E = r1;
        r1 = r13.getPaddingLeft();
        r0 = r0 - r1;
        r1 = r13.getPaddingRight();
        r3 = r0 - r1;
        r0 = r13.getMeasuredHeight();
        r1 = r13.getPaddingTop();
        r0 = r0 - r1;
        r1 = r13.getPaddingBottom();
        r5 = r0 - r1;
        r9 = r13.getChildCount();
        r0 = 0;
        r8 = r0;
    L_0x003b:
        if (r8 >= r9) goto L_0x00bc;
    L_0x003d:
        r10 = r13.getChildAt(r8);
        r0 = r10.getVisibility();
        r1 = 8;
        if (r0 == r1) goto L_0x00a5;
    L_0x0049:
        r0 = r10.getLayoutParams();
        r0 = (android.support.v4.view.ViewPager.LayoutParams) r0;
        if (r0 == 0) goto L_0x00a5;
    L_0x0051:
        r1 = r0.a;
        if (r1 == 0) goto L_0x00a5;
    L_0x0055:
        r1 = r0.b;
        r6 = r1 & 7;
        r1 = r0.b;
        r4 = r1 & 112;
        r2 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r1 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r7 = 48;
        if (r4 == r7) goto L_0x0069;
    L_0x0065:
        r7 = 80;
        if (r4 != r7) goto L_0x00a9;
    L_0x0069:
        r4 = 1;
        r7 = r4;
    L_0x006b:
        r4 = 3;
        if (r6 == r4) goto L_0x0071;
    L_0x006e:
        r4 = 5;
        if (r6 != r4) goto L_0x00ac;
    L_0x0071:
        r4 = 1;
        r6 = r4;
    L_0x0073:
        if (r7 == 0) goto L_0x00af;
    L_0x0075:
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
    L_0x0077:
        r4 = r0.width;
        r11 = -2;
        if (r4 == r11) goto L_0x010f;
    L_0x007c:
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r0.width;
        r11 = -1;
        if (r2 == r11) goto L_0x010c;
    L_0x0083:
        r2 = r0.width;
    L_0x0085:
        r11 = r0.height;
        r12 = -2;
        if (r11 == r12) goto L_0x010a;
    L_0x008a:
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r11 = r0.height;
        r12 = -1;
        if (r11 == r12) goto L_0x010a;
    L_0x0091:
        r0 = r0.height;
    L_0x0093:
        r2 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4);
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1);
        r10.measure(r2, r0);
        if (r7 == 0) goto L_0x00b4;
    L_0x00a0:
        r0 = r10.getMeasuredHeight();
        r5 = r5 - r0;
    L_0x00a5:
        r0 = r8 + 1;
        r8 = r0;
        goto L_0x003b;
    L_0x00a9:
        r4 = 0;
        r7 = r4;
        goto L_0x006b;
    L_0x00ac:
        r4 = 0;
        r6 = r4;
        goto L_0x0073;
    L_0x00af:
        if (r6 == 0) goto L_0x0077;
    L_0x00b1:
        r1 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        goto L_0x0077;
    L_0x00b4:
        if (r6 == 0) goto L_0x00a5;
    L_0x00b6:
        r0 = r10.getMeasuredWidth();
        r3 = r3 - r0;
        goto L_0x00a5;
    L_0x00bc:
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r0);
        r13.v = r0;
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0);
        r13.w = r0;
        r0 = 1;
        r13.x = r0;
        r13.c();
        r0 = 0;
        r13.x = r0;
        r2 = r13.getChildCount();
        r0 = 0;
        r1 = r0;
    L_0x00db:
        if (r1 >= r2) goto L_0x0109;
    L_0x00dd:
        r4 = r13.getChildAt(r1);
        r0 = r4.getVisibility();
        r5 = 8;
        if (r0 == r5) goto L_0x0105;
    L_0x00e9:
        r0 = r4.getLayoutParams();
        r0 = (android.support.v4.view.ViewPager.LayoutParams) r0;
        if (r0 == 0) goto L_0x00f5;
    L_0x00f1:
        r5 = r0.a;
        if (r5 != 0) goto L_0x0105;
    L_0x00f5:
        r5 = (float) r3;
        r0 = r0.c;
        r0 = r0 * r5;
        r0 = (int) r0;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5);
        r5 = r13.w;
        r4.measure(r0, r5);
    L_0x0105:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00db;
    L_0x0109:
        return;
    L_0x010a:
        r0 = r5;
        goto L_0x0093;
    L_0x010c:
        r2 = r3;
        goto L_0x0085;
    L_0x010f:
        r4 = r2;
        r2 = r3;
        goto L_0x0085;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onMeasure(int, int):void");
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                ah a = a(childAt);
                if (a != null && a.b == this.c && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            if (this.b != null) {
                this.b.a(savedState.b, savedState.c);
                a(savedState.a, false, true);
                return;
            }
            this.j = savedState.a;
            this.k = savedState.b;
            this.l = savedState.c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.c;
        if (this.b != null) {
            savedState.b = this.b.a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.p, this.p);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.b == null || this.b.b() == 0) {
            return false;
        }
        if (this.L == null) {
            this.L = VelocityTracker.obtain();
        }
        this.L.addMovement(motionEvent);
        float x;
        int xVelocity;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.z = false;
                c();
                x = motionEvent.getX();
                this.I = x;
                this.G = x;
                x = motionEvent.getY();
                this.J = x;
                this.H = x;
                this.K = motionEvent.getPointerId(0);
                break;
            case 1:
                if (this.B) {
                    VelocityTracker velocityTracker = this.L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.N);
                    xVelocity = (int) velocityTracker.getXVelocity(this.K);
                    this.z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    ah i = i();
                    a(a(i.b, ((((float) scrollX) / ((float) clientWidth)) - i.e) / (i.d + (((float) this.p) / ((float) clientWidth))), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.K)) - this.I)), true, true, xVelocity);
                    z = h();
                    break;
                }
                break;
            case 2:
                if (!this.B) {
                    xVelocity = motionEvent.findPointerIndex(this.K);
                    if (xVelocity == -1) {
                        z = h();
                        break;
                    }
                    float x2 = motionEvent.getX(xVelocity);
                    float abs = Math.abs(x2 - this.G);
                    float y = motionEvent.getY(xVelocity);
                    x = Math.abs(y - this.H);
                    if (abs > ((float) this.F) && abs > x) {
                        this.B = true;
                        c(true);
                        this.G = x2 - this.I > 0.0f ? this.I + ((float) this.F) : this.I - ((float) this.F);
                        this.H = y;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.B) {
                    z = false | b(motionEvent.getX(motionEvent.findPointerIndex(this.K)));
                    break;
                }
                break;
            case 3:
                if (this.B) {
                    a(this.c, true, 0, false);
                    z = h();
                    break;
                }
                break;
            case 5:
                xVelocity = motionEvent.getActionIndex();
                this.G = motionEvent.getX(xVelocity);
                this.K = motionEvent.getPointerId(xVelocity);
                break;
            case 6:
                a(motionEvent);
                this.G = motionEvent.getX(motionEvent.findPointerIndex(this.K));
                break;
        }
        if (z) {
            ViewCompat.d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable n nVar) {
        int i = false;
        if (this.b != null) {
            this.b.c(null);
            this.b.a((ViewGroup) this);
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                ah ahVar = (ah) this.g.get(i2);
                this.b.a((ViewGroup) this, ahVar.b, ahVar.a);
            }
            this.b.b((ViewGroup) this);
            this.g.clear();
            f();
            this.c = 0;
            scrollTo(0, 0);
        }
        n nVar2 = this.b;
        this.b = nVar;
        this.d = 0;
        if (this.b != null) {
            if (this.o == null) {
                this.o = new aj(this);
            }
            this.b.c(this.o);
            this.z = false;
            boolean z = this.T;
            this.T = true;
            this.d = this.b.b();
            if (this.j >= 0) {
                this.b.a(this.k, this.l);
                a(this.j, false, true);
                this.j = -1;
                this.k = null;
                this.l = null;
            } else if (z) {
                requestLayout();
            } else {
                c();
            }
        }
        if (this.ad != null && !this.ad.isEmpty()) {
            int size = this.ad.size();
            while (i < size) {
                ((OnAdapterChangeListener) this.ad.get(i)).onAdapterChanged(this, nVar2, nVar);
                i++;
            }
        }
    }

    public void setCurrentItem(int i) {
        this.z = false;
        a(i, !this.T, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.A) {
            this.A = i;
            c();
        }
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.ab = onPageChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.p;
        this.p = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(a.a(getContext(), i));
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    void setScrollState(int i) {
        if (this.ak != i) {
            this.ak = i;
            if (this.ae != null) {
                b(i != 0);
            }
            f(i);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }
}
