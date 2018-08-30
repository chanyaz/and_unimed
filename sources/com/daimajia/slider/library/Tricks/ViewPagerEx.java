package com.daimajia.slider.library.Tricks;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.d;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ac;
import android.support.v4.view.k;
import android.support.v4.view.n;
import android.support.v4.widget.r;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ViewPagerEx extends ViewGroup {
    private static final int[] a = new int[]{16842931};
    private static final f ag = new f();
    private static final Comparator<c> c = new Comparator<c>() {
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return cVar.b - cVar2.b;
        }
    };
    private static final Interpolator d = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    private boolean A;
    private boolean B;
    private int C;
    private int D;
    private int E;
    private float F;
    private float G;
    private float H;
    private float I;
    private int J = -1;
    private VelocityTracker K;
    private int L;
    private int M;
    private int N;
    private int O;
    private boolean P;
    private r Q;
    private r R;
    private boolean S = true;
    private boolean T = false;
    private boolean U;
    private int V;
    private ArrayList<OnPageChangeListener> W = new ArrayList();
    private OnPageChangeListener aa;
    private OnAdapterChangeListener ab;
    private PageTransformer ac;
    private Method ad;
    private int ae;
    private ArrayList<View> af;
    private final Runnable ah = new Runnable() {
        public void run() {
            ViewPagerEx.this.setScrollState(0);
            ViewPagerEx.this.c();
        }
    };
    private int ai = 0;
    private int b;
    private final ArrayList<c> e = new ArrayList();
    private final c f = new c();
    private final Rect g = new Rect();
    private n h;
    private int i;
    private int j = -1;
    private Parcelable k = null;
    private ClassLoader l = null;
    private Scroller m;
    private e n;
    private int o;
    private Drawable p;
    private int q;
    private int r;
    private float s = -3.4028235E38f;
    private float t = Float.MAX_VALUE;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private boolean y;
    private int z = 1;

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    interface Decor {
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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPagerEx.a);
            this.b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    interface OnAdapterChangeListener {
        void onAdapterChanged(n nVar, n nVar2);
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = d.a(new ParcelableCompatCreatorCallbacks<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        });
        int a;
        Parcelable b;
        ClassLoader c;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.a = parcel.readInt();
            this.b = parcel.readParcelable(classLoader);
            this.c = classLoader;
        }

        public SavedState(Parcelable parcelable) {
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

    public ViewPagerEx(Context context) {
        super(context);
        a();
    }

    public ViewPagerEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private int a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.N || Math.abs(i2) <= this.L) {
            i = (int) ((i >= this.i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.e.size() <= 0) {
            return i;
        }
        return Math.max(((c) this.e.get(0)).b, Math.min(i, ((c) this.e.get(this.e.size() - 1)).b));
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
        ViewPagerEx parent = view.getParent();
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
        if (i2 <= 0 || this.e.isEmpty()) {
            c b = b(this.i);
            int min = (int) ((b != null ? Math.min(b.e, this.t) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                a(false);
                scrollTo(min, getScrollY());
                return;
            }
            return;
        }
        int paddingLeft = (int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))));
        scrollTo(paddingLeft, getScrollY());
        if (!this.m.isFinished()) {
            this.m.startScroll(paddingLeft, 0, (int) (b(this.i).e * ((float) i)), 0, this.m.getDuration() - this.m.timePassed());
        }
    }

    private void a(int i, boolean z, int i2, boolean z2) {
        int max;
        c b = b(i);
        if (b != null) {
            max = (int) (Math.max(this.s, Math.min(b.e, this.t)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            a(max, 0, i2);
            if (z2) {
                d(i);
                return;
            }
            return;
        }
        if (z2) {
            d(i);
        }
        a(false);
        scrollTo(max, 0);
        e(max);
    }

    private void a(MotionEvent motionEvent) {
        int a = k.a(motionEvent);
        if (k.b(motionEvent, a) == this.J) {
            a = a == 0 ? 1 : 0;
            this.F = k.c(motionEvent, a);
            this.J = k.b(motionEvent, a);
            if (this.K != null) {
                this.K.clear();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c A:{LOOP_END, LOOP:2: B:18:0x0058->B:20:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a3 A:{LOOP_END, LOOP:5: B:33:0x009f->B:35:0x00a3} */
    private void a(com.daimajia.slider.library.Tricks.c r12, int r13, com.daimajia.slider.library.Tricks.c r14) {
        /*
        r11 = this;
        r4 = 0;
        r10 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r11.h;
        r7 = r0.b();
        r0 = r11.getClientWidth();
        if (r0 <= 0) goto L_0x0055;
    L_0x000f:
        r1 = r11.o;
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
        r0 = r11.e;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x00b7;
    L_0x0034:
        r0 = r11.e;
        r0 = r0.get(r1);
        r0 = (com.daimajia.slider.library.Tricks.c) r0;
    L_0x003c:
        r5 = r0.b;
        if (r2 <= r5) goto L_0x0058;
    L_0x0040:
        r5 = r11.e;
        r5 = r5.size();
        r5 = r5 + -1;
        if (r1 >= r5) goto L_0x0058;
    L_0x004a:
        r1 = r1 + 1;
        r0 = r11.e;
        r0 = r0.get(r1);
        r0 = (com.daimajia.slider.library.Tricks.c) r0;
        goto L_0x003c;
    L_0x0055:
        r0 = 0;
        r6 = r0;
        goto L_0x0016;
    L_0x0058:
        r5 = r0.b;
        if (r2 >= r5) goto L_0x0067;
    L_0x005c:
        r5 = r11.h;
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
        r1 = r11.e;
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
        r0 = r11.e;
        r0 = r0.get(r1);
        r0 = (com.daimajia.slider.library.Tricks.c) r0;
    L_0x008e:
        r5 = r0.b;
        if (r2 >= r5) goto L_0x009f;
    L_0x0092:
        if (r1 <= 0) goto L_0x009f;
    L_0x0094:
        r1 = r1 + -1;
        r0 = r11.e;
        r0 = r0.get(r1);
        r0 = (com.daimajia.slider.library.Tricks.c) r0;
        goto L_0x008e;
    L_0x009f:
        r5 = r0.b;
        if (r2 <= r5) goto L_0x00ae;
    L_0x00a3:
        r5 = r11.h;
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
        r0 = r11.e;
        r8 = r0.size();
        r2 = r12.e;
        r0 = r12.b;
        r1 = r0 + -1;
        r0 = r12.b;
        if (r0 != 0) goto L_0x00f9;
    L_0x00c7:
        r0 = r12.e;
    L_0x00c9:
        r11.s = r0;
        r0 = r12.b;
        r3 = r7 + -1;
        if (r0 != r3) goto L_0x00fd;
    L_0x00d1:
        r0 = r12.e;
        r3 = r12.d;
        r0 = r0 + r3;
        r0 = r0 - r10;
    L_0x00d7:
        r11.t = r0;
        r0 = r13 + -1;
        r5 = r0;
    L_0x00dc:
        if (r5 < 0) goto L_0x0114;
    L_0x00de:
        r0 = r11.e;
        r0 = r0.get(r5);
        r0 = (com.daimajia.slider.library.Tricks.c) r0;
        r3 = r2;
    L_0x00e7:
        r2 = r0.b;
        if (r1 <= r2) goto L_0x0101;
    L_0x00eb:
        r9 = r11.h;
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
        r11.s = r2;
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
        r0 = r11.e;
        r0 = r0.get(r5);
        r0 = (com.daimajia.slider.library.Tricks.c) r0;
        r3 = r2;
    L_0x012d:
        r2 = r0.b;
        if (r1 >= r2) goto L_0x013e;
    L_0x0131:
        r9 = r11.h;
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
        r11.t = r2;
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
        r11.T = r4;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.slider.library.Tricks.ViewPagerEx.a(com.daimajia.slider.library.Tricks.c, int, com.daimajia.slider.library.Tricks.c):void");
    }

    private void a(boolean z) {
        int scrollX;
        int scrollY;
        int i = this.ai == 2 ? 1 : 0;
        if (i != 0) {
            setScrollingCacheEnabled(false);
            this.m.abortAnimation();
            scrollX = getScrollX();
            scrollY = getScrollY();
            int currX = this.m.getCurrX();
            int currY = this.m.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
        }
        this.y = false;
        scrollX = 0;
        while (true) {
            scrollY = i;
            if (scrollX >= this.e.size()) {
                break;
            }
            c cVar = (c) this.e.get(scrollX);
            if (cVar.c) {
                cVar.c = false;
                scrollY = 1;
            }
            i = scrollX + 1;
        }
        if (scrollY == 0) {
            return;
        }
        if (z) {
            ViewCompat.a((View) this, this.ah);
        } else {
            this.ah.run();
        }
    }

    private boolean a(float f, float f2) {
        return (f < ((float) this.D) && f2 > 0.0f) || (f > ((float) (getWidth() - this.D)) && f2 < 0.0f);
    }

    private void b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewCompat.a(getChildAt(i), z ? 2 : 0, null);
        }
    }

    private boolean b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.F - f;
        this.F = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.s;
        float f5 = ((float) clientWidth) * this.t;
        c cVar = (c) this.e.get(0);
        c cVar2 = (c) this.e.get(this.e.size() - 1);
        if (cVar.b != 0) {
            f4 = cVar.e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (cVar2.b != this.h.b() - 1) {
            f2 = cVar2.e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.Q.a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.R.a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.F += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        e((int) f4);
        return z3;
    }

    private void c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private void d(int i) {
        Iterator it = this.W.iterator();
        while (it.hasNext()) {
            OnPageChangeListener onPageChangeListener = (OnPageChangeListener) it.next();
            if (onPageChangeListener != null) {
                int b = this.h.b();
                if (this.h instanceof b) {
                    b = ((b) this.h).e();
                }
                if (b != 0) {
                    onPageChangeListener.onPageSelected(i % b);
                } else {
                    return;
                }
            }
        }
        if (this.aa != null) {
            this.aa.onPageSelected(i);
        }
    }

    private boolean e(int i) {
        if (this.e.size() == 0) {
            this.U = false;
            a(0, 0.0f, 0);
            if (this.U) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        c i2 = i();
        int clientWidth = getClientWidth();
        int i3 = this.o + clientWidth;
        float f = ((float) this.o) / ((float) clientWidth);
        int i4 = i2.b;
        float f2 = ((((float) i) / ((float) clientWidth)) - i2.e) / (i2.d + f);
        clientWidth = (int) (((float) i3) * f2);
        this.U = false;
        a(i4, f2, clientWidth);
        if (this.U) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private void g() {
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

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void h() {
        if (this.ae != 0) {
            if (this.af == null) {
                this.af = new ArrayList();
            } else {
                this.af.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.af.add(getChildAt(i));
            }
            Collections.sort(this.af, ag);
        }
    }

    private c i() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.o) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        c cVar = null;
        while (i2 < this.e.size()) {
            int i3;
            c cVar2;
            c cVar3 = (c) this.e.get(i2);
            c cVar4;
            if (obj != null || cVar3.b == i + 1) {
                cVar4 = cVar3;
                i3 = i2;
                cVar2 = cVar4;
            } else {
                cVar3 = this.f;
                cVar3.e = (f2 + f3) + f;
                cVar3.b = i + 1;
                cVar3.d = this.h.d(cVar3.b);
                cVar4 = cVar3;
                i3 = i2 - 1;
                cVar2 = cVar4;
            }
            f2 = cVar2.e;
            f3 = (cVar2.d + f2) + f;
            if (obj == null && scrollX < f2) {
                return cVar;
            }
            if (scrollX < f3 || i3 == this.e.size() - 1) {
                return cVar2;
            }
            f3 = f2;
            i = cVar2.b;
            obj = null;
            f2 = cVar2.d;
            cVar = cVar2;
            i2 = i3 + 1;
        }
        return cVar;
    }

    private void j() {
        this.A = false;
        this.B = false;
        if (this.K != null) {
            this.K.recycle();
            this.K = null;
        }
    }

    private void setScrollState(int i) {
        if (this.ai != i) {
            this.ai = i;
            if (this.ac != null) {
                b(i != 0);
            }
            Iterator it = this.W.iterator();
            while (it.hasNext()) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) it.next();
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.x != z) {
            this.x = z;
        }
    }

    float a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    c a(int i, int i2) {
        c cVar = new c();
        cVar.b = i;
        cVar.a = this.h.a((ViewGroup) this, i);
        cVar.d = this.h.d(i);
        if (i2 < 0 || i2 >= this.e.size()) {
            this.e.add(cVar);
        } else {
            this.e.add(i2, cVar);
        }
        return cVar;
    }

    c a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                return null;
            }
            c cVar = (c) this.e.get(i2);
            if (this.h.a(view, cVar.a)) {
                return cVar;
            }
            i = i2 + 1;
        }
    }

    void a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.m = new Scroller(context, d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.E = ac.a(viewConfiguration);
        this.L = (int) (400.0f * f);
        this.M = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = new r(context);
        this.R = new r(context);
        this.N = (int) (25.0f * f);
        this.O = (int) (2.0f * f);
        this.C = (int) (16.0f * f);
        ViewCompat.a((View) this, new d(this));
        if (ViewCompat.e(this) == 0) {
            ViewCompat.b((View) this, 1);
        }
    }

    /* JADX WARNING: Missing block: B:29:0x00ff, code:
            if (r2.b == r18.i) goto L_0x0101;
     */
    void a(int r19) {
        /*
        r18 = this;
        r3 = 0;
        r2 = 2;
        r0 = r18;
        r4 = r0.i;
        r0 = r19;
        if (r4 == r0) goto L_0x033f;
    L_0x000a:
        r0 = r18;
        r2 = r0.i;
        r0 = r19;
        if (r2 >= r0) goto L_0x0030;
    L_0x0012:
        r2 = 66;
    L_0x0014:
        r0 = r18;
        r3 = r0.i;
        r0 = r18;
        r3 = r0.b(r3);
        r0 = r19;
        r1 = r18;
        r1.i = r0;
        r4 = r3;
        r3 = r2;
    L_0x0026:
        r0 = r18;
        r2 = r0.h;
        if (r2 != 0) goto L_0x0033;
    L_0x002c:
        r18.h();
    L_0x002f:
        return;
    L_0x0030:
        r2 = 17;
        goto L_0x0014;
    L_0x0033:
        r0 = r18;
        r2 = r0.y;
        if (r2 == 0) goto L_0x003d;
    L_0x0039:
        r18.h();
        goto L_0x002f;
    L_0x003d:
        r2 = r18.getWindowToken();
        if (r2 == 0) goto L_0x002f;
    L_0x0043:
        r0 = r18;
        r2 = r0.h;
        r0 = r18;
        r2.a(r0);
        r0 = r18;
        r2 = r0.z;
        r5 = 0;
        r0 = r18;
        r6 = r0.i;
        r6 = r6 - r2;
        r11 = java.lang.Math.max(r5, r6);
        r0 = r18;
        r5 = r0.h;
        r12 = r5.b();
        r5 = r12 + -1;
        r0 = r18;
        r6 = r0.i;
        r2 = r2 + r6;
        r13 = java.lang.Math.min(r5, r2);
        r0 = r18;
        r2 = r0.b;
        if (r12 == r2) goto L_0x00da;
    L_0x0073:
        r2 = r18.getResources();	 Catch:{ NotFoundException -> 0x00d0 }
        r3 = r18.getId();	 Catch:{ NotFoundException -> 0x00d0 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00d0 }
    L_0x007f:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r18;
        r5 = r0.b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r12);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r18.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r18;
        r4 = r0.h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00d0:
        r2 = move-exception;
        r2 = r18.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x007f;
    L_0x00da:
        r6 = 0;
        r2 = 0;
        r5 = r2;
    L_0x00dd:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.size();
        if (r5 >= r2) goto L_0x033c;
    L_0x00e7:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r5);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
        r7 = r2.b;
        r0 = r18;
        r8 = r0.i;
        if (r7 < r8) goto L_0x01cf;
    L_0x00f9:
        r7 = r2.b;
        r0 = r18;
        r8 = r0.i;
        if (r7 != r8) goto L_0x033c;
    L_0x0101:
        if (r2 != 0) goto L_0x0339;
    L_0x0103:
        if (r12 <= 0) goto L_0x0339;
    L_0x0105:
        r0 = r18;
        r2 = r0.i;
        r0 = r18;
        r2 = r0.a(r2, r5);
        r10 = r2;
    L_0x0110:
        if (r10 == 0) goto L_0x0180;
    L_0x0112:
        r9 = 0;
        r8 = r5 + -1;
        if (r8 < 0) goto L_0x01d4;
    L_0x0117:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r8);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
    L_0x0121:
        r14 = r18.getClientWidth();
        if (r14 > 0) goto L_0x01d7;
    L_0x0127:
        r6 = 0;
    L_0x0128:
        r0 = r18;
        r7 = r0.i;
        r7 = r7 + -1;
        r16 = r7;
        r7 = r9;
        r9 = r16;
        r17 = r8;
        r8 = r5;
        r5 = r17;
    L_0x0138:
        if (r9 < 0) goto L_0x0142;
    L_0x013a:
        r15 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1));
        if (r15 < 0) goto L_0x0216;
    L_0x013e:
        if (r9 >= r11) goto L_0x0216;
    L_0x0140:
        if (r2 != 0) goto L_0x01e6;
    L_0x0142:
        r6 = r10.d;
        r9 = r8 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x017b;
    L_0x014c:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.size();
        if (r9 >= r2) goto L_0x024c;
    L_0x0156:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r9);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
        r7 = r2;
    L_0x0161:
        if (r14 > 0) goto L_0x024f;
    L_0x0163:
        r2 = 0;
        r5 = r2;
    L_0x0165:
        r0 = r18;
        r2 = r0.i;
        r2 = r2 + 1;
        r16 = r2;
        r2 = r7;
        r7 = r9;
        r9 = r16;
    L_0x0171:
        if (r9 >= r12) goto L_0x017b;
    L_0x0173:
        r11 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r11 < 0) goto L_0x029a;
    L_0x0177:
        if (r9 <= r13) goto L_0x029a;
    L_0x0179:
        if (r2 != 0) goto L_0x025c;
    L_0x017b:
        r0 = r18;
        r0.a(r10, r8, r4);
    L_0x0180:
        r0 = r18;
        r4 = r0.h;
        r0 = r18;
        r5 = r0.i;
        if (r10 == 0) goto L_0x02e8;
    L_0x018a:
        r2 = r10.a;
    L_0x018c:
        r0 = r18;
        r4.b(r0, r5, r2);
        r0 = r18;
        r2 = r0.h;
        r0 = r18;
        r2.b(r0);
        r5 = r18.getChildCount();
        r2 = 0;
        r4 = r2;
    L_0x01a0:
        if (r4 >= r5) goto L_0x02eb;
    L_0x01a2:
        r0 = r18;
        r6 = r0.getChildAt(r4);
        r2 = r6.getLayoutParams();
        r2 = (com.daimajia.slider.library.Tricks.ViewPagerEx.LayoutParams) r2;
        r2.f = r4;
        r7 = r2.a;
        if (r7 != 0) goto L_0x01cb;
    L_0x01b4:
        r7 = r2.c;
        r8 = 0;
        r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1));
        if (r7 != 0) goto L_0x01cb;
    L_0x01bb:
        r0 = r18;
        r6 = r0.a(r6);
        if (r6 == 0) goto L_0x01cb;
    L_0x01c3:
        r7 = r6.d;
        r2.c = r7;
        r6 = r6.b;
        r2.e = r6;
    L_0x01cb:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x01a0;
    L_0x01cf:
        r2 = r5 + 1;
        r5 = r2;
        goto L_0x00dd;
    L_0x01d4:
        r2 = 0;
        goto L_0x0121;
    L_0x01d7:
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r7 = r10.d;
        r6 = r6 - r7;
        r7 = r18.getPaddingLeft();
        r7 = (float) r7;
        r15 = (float) r14;
        r7 = r7 / r15;
        r6 = r6 + r7;
        goto L_0x0128;
    L_0x01e6:
        r15 = r2.b;
        if (r9 != r15) goto L_0x0210;
    L_0x01ea:
        r15 = r2.c;
        if (r15 != 0) goto L_0x0210;
    L_0x01ee:
        r0 = r18;
        r15 = r0.e;
        r15.remove(r5);
        r0 = r18;
        r15 = r0.h;
        r2 = r2.a;
        r0 = r18;
        r15.a(r0, r9, r2);
        r5 = r5 + -1;
        r8 = r8 + -1;
        if (r5 < 0) goto L_0x0214;
    L_0x0206:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r5);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
    L_0x0210:
        r9 = r9 + -1;
        goto L_0x0138;
    L_0x0214:
        r2 = 0;
        goto L_0x0210;
    L_0x0216:
        if (r2 == 0) goto L_0x0230;
    L_0x0218:
        r15 = r2.b;
        if (r9 != r15) goto L_0x0230;
    L_0x021c:
        r2 = r2.d;
        r7 = r7 + r2;
        r5 = r5 + -1;
        if (r5 < 0) goto L_0x022e;
    L_0x0223:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r5);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
        goto L_0x0210;
    L_0x022e:
        r2 = 0;
        goto L_0x0210;
    L_0x0230:
        r2 = r5 + 1;
        r0 = r18;
        r2 = r0.a(r9, r2);
        r2 = r2.d;
        r7 = r7 + r2;
        r8 = r8 + 1;
        if (r5 < 0) goto L_0x024a;
    L_0x023f:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r5);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
        goto L_0x0210;
    L_0x024a:
        r2 = 0;
        goto L_0x0210;
    L_0x024c:
        r7 = 0;
        goto L_0x0161;
    L_0x024f:
        r2 = r18.getPaddingRight();
        r2 = (float) r2;
        r5 = (float) r14;
        r2 = r2 / r5;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r5;
        r5 = r2;
        goto L_0x0165;
    L_0x025c:
        r11 = r2.b;
        if (r9 != r11) goto L_0x0332;
    L_0x0260:
        r11 = r2.c;
        if (r11 != 0) goto L_0x0332;
    L_0x0264:
        r0 = r18;
        r11 = r0.e;
        r11.remove(r7);
        r0 = r18;
        r11 = r0.h;
        r2 = r2.a;
        r0 = r18;
        r11.a(r0, r9, r2);
        r0 = r18;
        r2 = r0.e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x0298;
    L_0x0280:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r7);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
    L_0x028a:
        r16 = r6;
        r6 = r2;
        r2 = r16;
    L_0x028f:
        r9 = r9 + 1;
        r16 = r2;
        r2 = r6;
        r6 = r16;
        goto L_0x0171;
    L_0x0298:
        r2 = 0;
        goto L_0x028a;
    L_0x029a:
        if (r2 == 0) goto L_0x02c1;
    L_0x029c:
        r11 = r2.b;
        if (r9 != r11) goto L_0x02c1;
    L_0x02a0:
        r2 = r2.d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        r0 = r18;
        r2 = r0.e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02bf;
    L_0x02af:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r7);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
    L_0x02b9:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02bf:
        r2 = 0;
        goto L_0x02b9;
    L_0x02c1:
        r0 = r18;
        r2 = r0.a(r9, r7);
        r7 = r7 + 1;
        r2 = r2.d;
        r6 = r6 + r2;
        r0 = r18;
        r2 = r0.e;
        r2 = r2.size();
        if (r7 >= r2) goto L_0x02e6;
    L_0x02d6:
        r0 = r18;
        r2 = r0.e;
        r2 = r2.get(r7);
        r2 = (com.daimajia.slider.library.Tricks.c) r2;
    L_0x02e0:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x02e6:
        r2 = 0;
        goto L_0x02e0;
    L_0x02e8:
        r2 = 0;
        goto L_0x018c;
    L_0x02eb:
        r18.h();
        r2 = r18.hasFocus();
        if (r2 == 0) goto L_0x002f;
    L_0x02f4:
        r2 = r18.findFocus();
        if (r2 == 0) goto L_0x0330;
    L_0x02fa:
        r0 = r18;
        r2 = r0.b(r2);
    L_0x0300:
        if (r2 == 0) goto L_0x030a;
    L_0x0302:
        r2 = r2.b;
        r0 = r18;
        r4 = r0.i;
        if (r2 == r4) goto L_0x002f;
    L_0x030a:
        r2 = 0;
    L_0x030b:
        r4 = r18.getChildCount();
        if (r2 >= r4) goto L_0x002f;
    L_0x0311:
        r0 = r18;
        r4 = r0.getChildAt(r2);
        r0 = r18;
        r5 = r0.a(r4);
        if (r5 == 0) goto L_0x032d;
    L_0x031f:
        r5 = r5.b;
        r0 = r18;
        r6 = r0.i;
        if (r5 != r6) goto L_0x032d;
    L_0x0327:
        r4 = r4.requestFocus(r3);
        if (r4 != 0) goto L_0x002f;
    L_0x032d:
        r2 = r2 + 1;
        goto L_0x030b;
    L_0x0330:
        r2 = 0;
        goto L_0x0300;
    L_0x0332:
        r16 = r6;
        r6 = r2;
        r2 = r16;
        goto L_0x028f;
    L_0x0339:
        r10 = r2;
        goto L_0x0110;
    L_0x033c:
        r2 = r6;
        goto L_0x0101;
    L_0x033f:
        r4 = r3;
        r3 = r2;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.slider.library.Tricks.ViewPagerEx.a(int):void");
    }

    protected void a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.V > 0) {
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
        Iterator it = this.W.iterator();
        while (it.hasNext()) {
            OnPageChangeListener onPageChangeListener = (OnPageChangeListener) it.next();
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageScrolled(i, f, i2);
            }
        }
        if (this.aa != null) {
            this.aa.onPageScrolled(i, f, i2);
        }
        if (this.ac != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((LayoutParams) childAt2.getLayoutParams()).a) {
                    this.ac.transformPage(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.U = true;
    }

    void a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            a(false);
            c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float a = (((float) i6) * a(Math.min(1.0f, (((float) Math.abs(i4)) * 1.0f) / ((float) clientWidth)))) + ((float) i6);
        int abs = Math.abs(i3);
        if (abs > 0) {
            clientWidth = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            clientWidth = (int) (((((float) Math.abs(i4)) / ((((float) clientWidth) * this.h.d(this.i)) + ((float) this.o))) + 1.0f) * 100.0f);
        }
        this.m.startScroll(scrollX, scrollY, i4, i5, Math.min(clientWidth, 600));
        ViewCompat.d(this);
    }

    public void a(int i, boolean z) {
        this.y = false;
        a(i, z, false);
    }

    void a(int i, boolean z, boolean z2) {
        a(i, z, z2, 0);
    }

    void a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.h == null || this.h.b() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.i != i || this.e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.h.b()) {
                i = this.h.b() - 1;
            }
            int i3 = this.z;
            if (i > this.i + i3 || i < this.i - i3) {
                for (int i4 = 0; i4 < this.e.size(); i4++) {
                    ((c) this.e.get(i4)).c = true;
                }
            }
            if (this.i != i) {
                z3 = true;
            }
            if (this.S) {
                this.i = i;
                d(i);
                requestLayout();
                return;
            }
            a(i);
            a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void a(OnPageChangeListener onPageChangeListener) {
        if (!this.W.contains(onPageChangeListener)) {
            this.W.add(onPageChangeListener);
        }
    }

    public void a(boolean z, PageTransformer pageTransformer) {
        int i = 1;
        boolean z2 = pageTransformer != null;
        int i2 = z2 != (this.ac != null) ? 1 : 0;
        this.ac = pageTransformer;
        setChildrenDrawingOrderEnabledCompat(z2);
        if (z2) {
            if (z) {
                i = 2;
            }
            this.ae = i;
        } else {
            this.ae = 0;
        }
        if (i2 != 0) {
            c();
        }
    }

    public boolean a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return c(17);
            case 22:
                return c(66);
            case 61:
                return VERSION.SDK_INT >= 11 ? KeyEventCompat.hasNoModifiers(keyEvent) ? c(2) : KeyEventCompat.hasModifiers(keyEvent, 1) ? c(1) : false : false;
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
        return z && ViewCompat.a(view, -i);
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    c a = a(childAt);
                    if (a != null && a.b == this.i) {
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
                c a = a(childAt);
                if (a != null && a.b == this.i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams generateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) generateLayoutParams;
        layoutParams2.a |= view instanceof Decor;
        if (!this.w) {
            super.addView(view, i, generateLayoutParams);
        } else if (layoutParams2 == null || !layoutParams2.a) {
            layoutParams2.d = true;
            addViewInLayout(view, i, generateLayoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    c b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.e.size()) {
                return null;
            }
            c cVar = (c) this.e.get(i3);
            if (cVar.b == i) {
                return cVar;
            }
            i2 = i3 + 1;
        }
    }

    c b(View view) {
        while (true) {
            ViewPagerEx parent = view.getParent();
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
        int b = this.h.b();
        this.b = b;
        boolean z = this.e.size() < (this.z * 2) + 1 && this.e.size() < b;
        boolean z2 = false;
        int i2 = this.i;
        boolean z3 = z;
        int i3 = 0;
        while (i3 < this.e.size()) {
            int i4;
            boolean z4;
            boolean z5;
            c cVar = (c) this.e.get(i3);
            int a = this.h.a(cVar.a);
            if (a == -1) {
                i4 = i3;
                z4 = z2;
                i = i2;
                z5 = z3;
            } else if (a == -2) {
                this.e.remove(i3);
                i3--;
                if (!z2) {
                    this.h.a((ViewGroup) this);
                    z2 = true;
                }
                this.h.a((ViewGroup) this, cVar.b, cVar.a);
                if (this.i == cVar.b) {
                    i4 = i3;
                    z4 = z2;
                    i = Math.max(0, Math.min(this.i, b - 1));
                    z5 = true;
                } else {
                    i4 = i3;
                    z4 = z2;
                    i = i2;
                    z5 = true;
                }
            } else if (cVar.b != a) {
                if (cVar.b == this.i) {
                    i2 = a;
                }
                cVar.b = a;
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
            this.h.b((ViewGroup) this);
        }
        Collections.sort(this.e, c);
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

    void c() {
        a(this.i);
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
                for (ViewPagerEx parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
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
                    Log.e("ViewPagerEx", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
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
            d = (view == null || a(this.g, findNextFocus).left < a(this.g, view).left) ? findNextFocus.requestFocus() : d();
        } else {
            if (i == 66) {
                d = (view == null || a(this.g, findNextFocus).left > a(this.g, view).left) ? findNextFocus.requestFocus() : e();
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
        if (this.h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.s))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.t))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
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
            if (!e(currX)) {
                this.m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.d(this);
    }

    boolean d() {
        if (this.i <= 0) {
            return false;
        }
        a(this.i - 1, true);
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
                c a = a(childAt);
                if (a != null && a.b == this.i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ViewCompat.a(this);
        if (a == 0 || (a == 1 && this.h != null && this.h.b() > 1)) {
            int height;
            int width;
            if (!this.Q.a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-height) + getPaddingTop()), this.s * ((float) width));
                this.Q.a(height, width);
                i = 0 | this.Q.a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.R.a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.t + 1.0f)) * ((float) height));
                this.R.a(width, height);
                i |= this.R.a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.Q.b();
            this.R.b();
        }
        if (i != 0) {
            ViewCompat.d(this);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.p;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    boolean e() {
        if (this.h == null || this.i >= this.h.b() - 1) {
            return false;
        }
        a(this.i + 1, true);
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

    public n getAdapter() {
        return this.h;
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ae == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.af.get(i2)).getLayoutParams()).f;
    }

    public int getCurrentItem() {
        return this.i;
    }

    public int getOffscreenPageLimit() {
        return this.z;
    }

    public int getPageMargin() {
        return this.o;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.S = true;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.ah);
        super.onDetachedFromWindow();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.o > 0 && this.p != null && this.e.size() > 0 && this.h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.o) / ((float) width);
            c cVar = (c) this.e.get(0);
            float f2 = cVar.e;
            int size = this.e.size();
            int i = cVar.b;
            int i2 = ((c) this.e.get(size - 1)).b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > cVar.b && i3 < size) {
                    i3++;
                    cVar = (c) this.e.get(i3);
                }
                if (i4 == cVar.b) {
                    f3 = (cVar.e + cVar.d) * ((float) width);
                    f2 = (cVar.e + cVar.d) + f;
                } else {
                    float d = this.h.d(i4);
                    f3 = (f2 + d) * ((float) width);
                    f2 += d + f;
                }
                if (((float) this.o) + f3 > ((float) scrollX)) {
                    this.p.setBounds((int) f3, this.q, (int) ((((float) this.o) + f3) + 0.5f), this.r);
                    this.p.draw(canvas);
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
            this.A = false;
            this.B = false;
            this.J = -1;
            if (this.K == null) {
                return false;
            }
            this.K.recycle();
            this.K = null;
            return false;
        }
        if (action != 0) {
            if (this.A) {
                return true;
            }
            if (this.B) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.H = x;
                this.F = x;
                x = motionEvent.getY();
                this.I = x;
                this.G = x;
                this.J = k.b(motionEvent, 0);
                this.B = false;
                this.m.computeScrollOffset();
                if (this.ai == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.O) {
                    this.m.abortAnimation();
                    this.y = false;
                    c();
                    this.A = true;
                    c(true);
                    setScrollState(1);
                    break;
                }
                a(false);
                this.A = false;
                break;
                break;
            case 2:
                action = this.J;
                if (action != -1) {
                    action = k.a(motionEvent, action);
                    float c = k.c(motionEvent, action);
                    float f = c - this.F;
                    float abs = Math.abs(f);
                    float d = k.d(motionEvent, action);
                    float abs2 = Math.abs(d - this.I);
                    if (!(f == 0.0f || a(this.F, f))) {
                        if (a(this, false, (int) f, (int) c, (int) d)) {
                            this.F = c;
                            this.G = d;
                            this.B = true;
                            return false;
                        }
                    }
                    if (abs > ((float) this.E) && 0.5f * abs > abs2) {
                        this.A = true;
                        c(true);
                        setScrollState(1);
                        this.F = f > 0.0f ? this.H + ((float) this.E) : this.H - ((float) this.E);
                        this.G = d;
                        setScrollingCacheEnabled(true);
                    } else if (abs2 > ((float) this.E)) {
                        this.B = true;
                    }
                    if (this.A && b(c)) {
                        ViewCompat.d(this);
                        break;
                    }
                }
                break;
            case 6:
                a(motionEvent);
                break;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        return this.A;
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
                    c a = a(childAt2);
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
        this.q = paddingTop;
        this.r = i6 - paddingBottom;
        this.V = i7;
        if (this.S) {
            a(this.i, false, 0, false);
        }
        this.S = false;
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
        r2 = r13.C;
        r1 = java.lang.Math.min(r1, r2);
        r13.D = r1;
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
        r0 = (com.daimajia.slider.library.Tricks.ViewPagerEx.LayoutParams) r0;
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
        r13.u = r0;
        r0 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r0);
        r13.v = r0;
        r0 = 1;
        r13.w = r0;
        r13.c();
        r0 = 0;
        r13.w = r0;
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
        r0 = (com.daimajia.slider.library.Tricks.ViewPagerEx.LayoutParams) r0;
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
        r5 = r13.v;
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
        throw new UnsupportedOperationException("Method not decompiled: com.daimajia.slider.library.Tricks.ViewPagerEx.onMeasure(int, int):void");
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
                c a = a(childAt);
                if (a != null && a.b == this.i && childAt.requestFocus(i, rect)) {
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
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.h != null) {
                this.h.a(savedState.b, savedState.c);
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
        savedState.a = this.i;
        if (this.h != null) {
            savedState.b = this.h.a();
        }
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            a(i, i3, this.o, this.o);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.P) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.h == null || this.h.b() == 0) {
            return false;
        }
        if (this.K == null) {
            this.K = VelocityTracker.obtain();
        }
        this.K.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.m.abortAnimation();
                this.y = false;
                c();
                x = motionEvent.getX();
                this.H = x;
                this.F = x;
                x = motionEvent.getY();
                this.I = x;
                this.G = x;
                this.J = k.b(motionEvent, 0);
                break;
            case 1:
                if (this.A) {
                    VelocityTracker velocityTracker = this.K;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.M);
                    a = (int) android.support.v4.view.r.a(velocityTracker, this.J);
                    this.y = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    c i = i();
                    a(a(i.b, ((((float) scrollX) / ((float) clientWidth)) - i.e) / i.d, a, (int) (k.c(motionEvent, k.a(motionEvent, this.J)) - this.H)), true, true, a);
                    this.J = -1;
                    j();
                    z = this.R.c() | this.Q.c();
                    break;
                }
                break;
            case 2:
                if (!this.A) {
                    a = k.a(motionEvent, this.J);
                    float c = k.c(motionEvent, a);
                    float abs = Math.abs(c - this.F);
                    float d = k.d(motionEvent, a);
                    x = Math.abs(d - this.G);
                    if (abs > ((float) this.E) && abs > x) {
                        this.A = true;
                        c(true);
                        this.F = c - this.H > 0.0f ? this.H + ((float) this.E) : this.H - ((float) this.E);
                        this.G = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.A) {
                    z = false | b(k.c(motionEvent, k.a(motionEvent, this.J)));
                    break;
                }
                break;
            case 3:
                if (this.A) {
                    a(this.i, true, 0, false);
                    this.J = -1;
                    j();
                    z = this.R.c() | this.Q.c();
                    break;
                }
                break;
            case 5:
                a = k.a(motionEvent);
                this.F = k.c(motionEvent, a);
                this.J = k.b(motionEvent, a);
                break;
            case 6:
                a(motionEvent);
                this.F = k.c(motionEvent, k.a(motionEvent, this.J));
                break;
        }
        if (z) {
            ViewCompat.d(this);
        }
        return true;
    }

    public void removeView(View view) {
        if (this.w) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(n nVar) {
        if (this.h != null) {
            this.h.b(this.n);
            this.h.a((ViewGroup) this);
            for (int i = 0; i < this.e.size(); i++) {
                c cVar = (c) this.e.get(i);
                this.h.a((ViewGroup) this, cVar.b, cVar.a);
            }
            this.h.b((ViewGroup) this);
            this.e.clear();
            g();
            this.i = 0;
            scrollTo(0, 0);
        }
        n nVar2 = this.h;
        this.h = nVar;
        this.b = 0;
        if (this.h != null) {
            if (this.n == null) {
                this.n = new e(this, null);
            }
            this.h.a(this.n);
            this.y = false;
            boolean z = this.S;
            this.S = true;
            this.b = this.h.b();
            if (this.j >= 0) {
                this.h.a(this.k, this.l);
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
        if (this.ab != null && nVar2 != nVar) {
            this.ab.onAdapterChanged(nVar2, nVar);
        }
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.ad == null) {
                try {
                    this.ad = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPagerEx", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.ad.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPagerEx", "Error changing children drawing order", e2);
            }
        }
    }

    public void setCurrentItem(int i) {
        this.y = false;
        a(i, !this.S, false);
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPagerEx", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.z) {
            this.z = i;
            c();
        }
    }

    void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.ab = onAdapterChangeListener;
    }

    public void setPageMargin(int i) {
        int i2 = this.o;
        this.o = i;
        int width = getWidth();
        a(width, width, i, i2);
        requestLayout();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.p = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }
}
