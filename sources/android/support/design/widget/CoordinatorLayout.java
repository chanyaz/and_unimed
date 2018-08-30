package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
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
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.b.b;
import android.support.b.c;
import android.support.b.d;
import android.support.v4.a.a;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.q;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.as;
import android.support.v4.view.m;
import android.support.v4.widget.au;
import android.support.v4.widget.n;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {
    static final String a;
    static final Class<?>[] b = new Class[]{Context.class, AttributeSet.class};
    static final ThreadLocal<Map<String, Constructor<Behavior>>> c = new ThreadLocal();
    static final Comparator<View> d;
    private static final Pool<Rect> f = new q(12);
    OnHierarchyChangeListener e;
    private final List<View> g;
    private final n<View> h;
    private final List<View> i;
    private final List<View> j;
    private final int[] k;
    private Paint l;
    private boolean m;
    private boolean n;
    private int[] o;
    private View p;
    private View q;
    private n r;
    private boolean s;
    private as t;
    private boolean u;
    private Drawable v;
    private OnApplyWindowInsetsListener w;
    private final m x;

    public abstract class Behavior<V extends View> {
        public Behavior(Context context, AttributeSet attributeSet) {
        }

        @NonNull
        public as a(CoordinatorLayout coordinatorLayout, V v, as asVar) {
            return asVar;
        }

        public void a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i) {
            if (i == 0) {
                c(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, int i3, int i4) {
        }

        public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                a(coordinatorLayout, (View) v, view, i, i2, i3, i4);
            }
        }

        @Deprecated
        public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        }

        public void a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
            if (i3 == 0) {
                a(coordinatorLayout, (View) v, view, i, i2, iArr);
            }
        }

        public void a(@NonNull m mVar) {
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2) {
            return false;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2, boolean z) {
            return false;
        }

        @Deprecated
        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i) {
            return false;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
            return i2 == 0 ? a(coordinatorLayout, (View) v, view, view2, i) : false;
        }

        public Parcelable b(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i) {
        }

        public void b(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
            if (i2 == 0) {
                b(coordinatorLayout, v, view, view2, i);
            }
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @ColorInt
        public int c(CoordinatorLayout coordinatorLayout, V v) {
            return CtaButton.BACKGROUND_COLOR;
        }

        public void c() {
        }

        @Deprecated
        public void c(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float d(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public void d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public boolean e(CoordinatorLayout coordinatorLayout, V v) {
            return d(coordinatorLayout, v) > 0.0f;
        }
    }

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    @Deprecated
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
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
        SparseArray<Parcelable> a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
            this.a = new SparseArray(readInt);
            for (int i = 0; i < readInt; i++) {
                this.a.append(iArr[i], readParcelableArray[i]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 0;
            super.writeToParcel(parcel, i);
            int size = this.a != null ? this.a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.a.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.a.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        a = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            d = new o();
        } else {
            d = null;
        }
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.coordinatorLayoutStyle);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        super(context, attributeSet, i);
        this.g = new ArrayList();
        this.h = new n();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new int[2];
        this.x = new m(this);
        TypedArray obtainStyledAttributes = i == 0 ? context.obtainStyledAttributes(attributeSet, d.CoordinatorLayout, 0, c.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, d.CoordinatorLayout, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(d.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.o = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.o.length;
            while (i2 < length) {
                this.o[i2] = (int) (((float) this.o[i2]) * f);
                i2++;
            }
        }
        this.v = obtainStyledAttributes.getDrawable(d.CoordinatorLayout_statusBarBackground);
        obtainStyledAttributes.recycle();
        g();
        super.setOnHierarchyChangeListener(new l(this));
    }

    static Behavior a(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(a)) {
            str = a + '.' + str;
        }
        try {
            Map map;
            Map map2 = (Map) c.get();
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                c.set(hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Throwable e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    private static void a(@NonNull Rect rect) {
        rect.setEmpty();
        f.release(rect);
    }

    private void a(m mVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + mVar.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - mVar.rightMargin));
        height = Math.max(getPaddingTop() + mVar.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - mVar.bottomMargin));
        rect.set(width, height, width + i, height + i2);
    }

    private void a(View view, int i, Rect rect, Rect rect2, m mVar, int i2, int i3) {
        int a = android.support.v4.view.d.a(e(mVar.c), i);
        int a2 = android.support.v4.view.d.a(c(mVar.d), i);
        int i4 = a & 7;
        int i5 = a & 112;
        int i6 = a2 & 112;
        switch (a2 & 7) {
            case 1:
                a2 = (rect.width() / 2) + rect.left;
                break;
            case 5:
                a2 = rect.right;
                break;
            default:
                a2 = rect.left;
                break;
        }
        switch (i6) {
            case 16:
                a = rect.top + (rect.height() / 2);
                break;
            case 80:
                a = rect.bottom;
                break;
            default:
                a = rect.top;
                break;
        }
        switch (i4) {
            case 1:
                a2 -= i2 / 2;
                break;
            case 5:
                break;
            default:
                a2 -= i2;
                break;
        }
        switch (i5) {
            case 16:
                a -= i3 / 2;
                break;
            case 80:
                break;
            default:
                a -= i3;
                break;
        }
        rect2.set(a2, a, a2 + i2, a + i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ff  */
    private void a(android.view.View r11, android.graphics.Rect r12, int r13) {
        /*
        r10 = this;
        r1 = 1;
        r3 = 0;
        r0 = android.support.v4.view.ViewCompat.y(r11);
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r11.getWidth();
        if (r0 <= 0) goto L_0x0008;
    L_0x000f:
        r0 = r11.getHeight();
        if (r0 <= 0) goto L_0x0008;
    L_0x0015:
        r0 = r11.getLayoutParams();
        r0 = (android.support.design.widget.m) r0;
        r2 = r0.b();
        r4 = e();
        r5 = e();
        r6 = r11.getLeft();
        r7 = r11.getTop();
        r8 = r11.getRight();
        r9 = r11.getBottom();
        r5.set(r6, r7, r8, r9);
        if (r2 == 0) goto L_0x0073;
    L_0x003c:
        r2 = r2.a(r10, r11, r4);
        if (r2 == 0) goto L_0x0073;
    L_0x0042:
        r2 = r5.contains(r4);
        if (r2 != 0) goto L_0x0076;
    L_0x0048:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Rect should be within the child's bounds. Rect:";
        r1 = r1.append(r2);
        r2 = r4.toShortString();
        r1 = r1.append(r2);
        r2 = " | Bounds:";
        r1 = r1.append(r2);
        r2 = r5.toShortString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0073:
        r4.set(r5);
    L_0x0076:
        a(r5);
        r2 = r4.isEmpty();
        if (r2 == 0) goto L_0x0083;
    L_0x007f:
        a(r4);
        goto L_0x0008;
    L_0x0083:
        r2 = r0.h;
        r5 = android.support.v4.view.d.a(r2, r13);
        r2 = r5 & 48;
        r6 = 48;
        if (r2 != r6) goto L_0x010b;
    L_0x008f:
        r2 = r4.top;
        r6 = r0.topMargin;
        r2 = r2 - r6;
        r6 = r0.j;
        r2 = r2 - r6;
        r6 = r12.top;
        if (r2 >= r6) goto L_0x010b;
    L_0x009b:
        r6 = r12.top;
        r2 = r6 - r2;
        r10.e(r11, r2);
        r2 = r1;
    L_0x00a3:
        r6 = r5 & 80;
        r7 = 80;
        if (r6 != r7) goto L_0x00c2;
    L_0x00a9:
        r6 = r10.getHeight();
        r7 = r4.bottom;
        r6 = r6 - r7;
        r7 = r0.bottomMargin;
        r6 = r6 - r7;
        r7 = r0.j;
        r6 = r6 + r7;
        r7 = r12.bottom;
        if (r6 >= r7) goto L_0x00c2;
    L_0x00ba:
        r2 = r12.bottom;
        r2 = r6 - r2;
        r10.e(r11, r2);
        r2 = r1;
    L_0x00c2:
        if (r2 != 0) goto L_0x00c7;
    L_0x00c4:
        r10.e(r11, r3);
    L_0x00c7:
        r2 = r5 & 3;
        r6 = 3;
        if (r2 != r6) goto L_0x0109;
    L_0x00cc:
        r2 = r4.left;
        r6 = r0.leftMargin;
        r2 = r2 - r6;
        r6 = r0.i;
        r2 = r2 - r6;
        r6 = r12.left;
        if (r2 >= r6) goto L_0x0109;
    L_0x00d8:
        r6 = r12.left;
        r2 = r6 - r2;
        r10.d(r11, r2);
        r2 = r1;
    L_0x00e0:
        r5 = r5 & 5;
        r6 = 5;
        if (r5 != r6) goto L_0x0107;
    L_0x00e5:
        r5 = r10.getWidth();
        r6 = r4.right;
        r5 = r5 - r6;
        r6 = r0.rightMargin;
        r5 = r5 - r6;
        r0 = r0.i;
        r0 = r0 + r5;
        r5 = r12.right;
        if (r0 >= r5) goto L_0x0107;
    L_0x00f6:
        r2 = r12.right;
        r0 = r0 - r2;
        r10.d(r11, r0);
        r0 = r1;
    L_0x00fd:
        if (r0 != 0) goto L_0x0102;
    L_0x00ff:
        r10.d(r11, r3);
    L_0x0102:
        a(r4);
        goto L_0x0008;
    L_0x0107:
        r0 = r2;
        goto L_0x00fd;
    L_0x0109:
        r2 = r3;
        goto L_0x00e0;
    L_0x010b:
        r2 = r3;
        goto L_0x00a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.a(android.view.View, android.graphics.Rect, int):void");
    }

    private void a(View view, View view2, int i) {
        m mVar = (m) view.getLayoutParams();
        Rect e = e();
        Rect e2 = e();
        try {
            a(view2, e);
            a(view, i, e, e2);
            view.layout(e2.left, e2.top, e2.right, e2.bottom);
        } finally {
            a(e);
            a(e2);
        }
    }

    private void a(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (d != null) {
            Collections.sort(list, d);
        }
    }

    private void a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior b = ((m) childAt.getLayoutParams()).b();
            if (b != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    b.a(this, childAt, obtain);
                } else {
                    b.b(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((m) getChildAt(i2).getLayoutParams()).f();
        }
        this.p = null;
        this.m = false;
    }

    private boolean a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2 = false;
        Object obj = null;
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.i;
        a(list);
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj2;
            MotionEvent motionEvent3;
            View view = (View) list.get(i2);
            m mVar = (m) view.getLayoutParams();
            Behavior b = mVar.b();
            if ((!z2 && obj == null) || actionMasked == 0) {
                if (!(z2 || b == null)) {
                    switch (i) {
                        case 0:
                            z2 = b.a(this, view, motionEvent);
                            break;
                        case 1:
                            z2 = b.b(this, view, motionEvent);
                            break;
                    }
                    if (z2) {
                        this.p = view;
                    }
                }
                z = z2;
                boolean e = mVar.e();
                boolean a = mVar.a(this, view);
                Object obj3 = (!a || e) ? null : 1;
                if (a && obj3 == null) {
                    list.clear();
                    return z;
                }
                MotionEvent motionEvent4 = motionEvent2;
                obj2 = obj3;
                motionEvent3 = motionEvent4;
            } else if (b != null) {
                if (motionEvent2 == null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                } else {
                    motionEvent3 = motionEvent2;
                }
                switch (i) {
                    case 0:
                        b.a(this, view, motionEvent3);
                        break;
                    case 1:
                        b.b(this, view, motionEvent3);
                        break;
                }
                obj2 = obj;
                z = z2;
            } else {
                motionEvent3 = motionEvent2;
                z = z2;
                obj2 = obj;
            }
            i2++;
            obj = obj2;
            z2 = z;
            motionEvent2 = motionEvent3;
        }
        z = z2;
        list.clear();
        return z;
    }

    private int b(int i) {
        if (this.o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        } else if (i >= 0 && i < this.o.length) {
            return this.o[i];
        } else {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
    }

    private as b(as asVar) {
        if (asVar.f()) {
            return asVar;
        }
        as a;
        int childCount = getChildCount();
        int i = 0;
        as asVar2 = asVar;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (ViewCompat.r(childAt)) {
                Behavior b = ((m) childAt.getLayoutParams()).b();
                if (b != null) {
                    a = b.a(this, childAt, asVar2);
                    if (a.f()) {
                        break;
                    }
                    i++;
                    asVar2 = a;
                }
            }
            a = asVar2;
            i++;
            asVar2 = a;
        }
        a = asVar2;
        return a;
    }

    private void b(View view, int i, int i2) {
        m mVar = (m) view.getLayoutParams();
        int a = android.support.v4.view.d.a(d(mVar.c), i2);
        int i3 = a & 7;
        int i4 = a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int b = b(i) - measuredWidth;
        a = 0;
        switch (i3) {
            case 1:
                b += measuredWidth / 2;
                break;
            case 5:
                b += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                a = 0 + (measuredHeight / 2);
                break;
            case 80:
                a = 0 + measuredHeight;
                break;
        }
        b = Math.max(getPaddingLeft() + mVar.leftMargin, Math.min(b, ((width - getPaddingRight()) - measuredWidth) - mVar.rightMargin));
        int max = Math.max(getPaddingTop() + mVar.topMargin, Math.min(a, ((height - getPaddingBottom()) - measuredHeight) - mVar.bottomMargin));
        view.layout(b, max, b + measuredWidth, max + measuredHeight);
    }

    private static int c(int i) {
        int i2 = (i & 7) == 0 ? 8388611 | i : i;
        return (i2 & 112) == 0 ? i2 | 48 : i2;
    }

    private void c(View view, int i) {
        m mVar = (m) view.getLayoutParams();
        Rect e = e();
        e.set(getPaddingLeft() + mVar.leftMargin, getPaddingTop() + mVar.topMargin, (getWidth() - getPaddingRight()) - mVar.rightMargin, (getHeight() - getPaddingBottom()) - mVar.bottomMargin);
        if (!(this.t == null || !ViewCompat.r(this) || ViewCompat.r(view))) {
            e.left += this.t.a();
            e.top += this.t.b();
            e.right -= this.t.c();
            e.bottom -= this.t.d();
        }
        Rect e2 = e();
        android.support.v4.view.d.a(c(mVar.c), view.getMeasuredWidth(), view.getMeasuredHeight(), e, e2, i);
        view.layout(e2.left, e2.top, e2.right, e2.bottom);
        a(e);
        a(e2);
    }

    private static int d(int i) {
        return i == 0 ? 8388661 : i;
    }

    private void d(View view, int i) {
        m mVar = (m) view.getLayoutParams();
        if (mVar.i != i) {
            ViewCompat.e(view, i - mVar.i);
            mVar.i = i;
        }
    }

    private static int e(int i) {
        return i == 0 ? 17 : i;
    }

    @NonNull
    private static Rect e() {
        Rect rect = (Rect) f.acquire();
        return rect == null ? new Rect() : rect;
    }

    private void e(View view, int i) {
        m mVar = (m) view.getLayoutParams();
        if (mVar.j != i) {
            ViewCompat.d(view, i - mVar.j);
            mVar.j = i;
        }
    }

    private boolean e(View view) {
        return this.h.e(view);
    }

    private void f() {
        this.g.clear();
        this.h.a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            Object childAt = getChildAt(i);
            m a = a((View) childAt);
            a.b(this, (View) childAt);
            this.h.a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    Object childAt2 = getChildAt(i2);
                    if (a.a(this, childAt, childAt2)) {
                        if (!this.h.b(childAt2)) {
                            this.h.a(childAt2);
                        }
                        this.h.a(childAt2, childAt);
                    }
                }
            }
        }
        this.g.addAll(this.h.b());
        Collections.reverse(this.g);
    }

    private void g() {
        if (VERSION.SDK_INT >= 21) {
            if (ViewCompat.r(this)) {
                if (this.w == null) {
                    this.w = new OnApplyWindowInsetsListener() {
                        public as onApplyWindowInsets(View view, as asVar) {
                            return CoordinatorLayout.this.a(asVar);
                        }
                    };
                }
                ViewCompat.a((View) this, this.w);
                setSystemUiVisibility(1280);
                return;
            }
            ViewCompat.a((View) this, null);
        }
    }

    /* renamed from: a */
    public m generateLayoutParams(AttributeSet attributeSet) {
        return new m(getContext(), attributeSet);
    }

    m a(View view) {
        m mVar = (m) view.getLayoutParams();
        if (!mVar.b) {
            if (view instanceof AttachedBehavior) {
                Behavior behavior = ((AttachedBehavior) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                mVar.a(behavior);
                mVar.b = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) cls.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                DefaultBehavior defaultBehavior2 = defaultBehavior;
                if (defaultBehavior2 != null) {
                    try {
                        mVar.a((Behavior) defaultBehavior2.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Throwable e) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior2.value().getName() + " could not be instantiated. Did you forget" + " a default constructor?", e);
                    }
                }
                mVar.b = true;
            }
        }
        return mVar;
    }

    /* renamed from: a */
    protected m generateLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof m ? new m((m) layoutParams) : layoutParams instanceof MarginLayoutParams ? new m((MarginLayoutParams) layoutParams) : new m(layoutParams);
    }

    final as a(as asVar) {
        boolean z = true;
        if (android.support.v4.util.n.a(this.t, asVar)) {
            return asVar;
        }
        this.t = asVar;
        boolean z2 = asVar != null && asVar.b() > 0;
        this.u = z2;
        if (this.u || getBackground() != null) {
            z = false;
        }
        setWillNotDraw(z);
        asVar = b(asVar);
        requestLayout();
        return asVar;
    }

    void a() {
        boolean z = false;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (e(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z == this.s) {
            return;
        }
        if (z) {
            b();
        } else {
            c();
        }
    }

    final void a(int i) {
        int f = ViewCompat.f(this);
        int size = this.g.size();
        Rect e = e();
        Rect e2 = e();
        Rect e3 = e();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.g.get(i2);
            m mVar = (m) view.getLayoutParams();
            if (i != 0 || view.getVisibility() != 8) {
                int i3;
                for (i3 = 0; i3 < i2; i3++) {
                    if (mVar.l == ((View) this.g.get(i3))) {
                        b(view, f);
                    }
                }
                a(view, true, e2);
                if (!(mVar.g == 0 || e2.isEmpty())) {
                    int a = android.support.v4.view.d.a(mVar.g, f);
                    switch (a & 112) {
                        case 48:
                            e.top = Math.max(e.top, e2.bottom);
                            break;
                        case 80:
                            e.bottom = Math.max(e.bottom, getHeight() - e2.top);
                            break;
                    }
                    switch (a & 7) {
                        case 3:
                            e.left = Math.max(e.left, e2.right);
                            break;
                        case 5:
                            e.right = Math.max(e.right, getWidth() - e2.left);
                            break;
                    }
                }
                if (mVar.h != 0 && view.getVisibility() == 0) {
                    a(view, e, f);
                }
                if (i != 2) {
                    c(view, e3);
                    if (!e3.equals(e2)) {
                        b(view, e2);
                    }
                }
                for (i3 = i2 + 1; i3 < size; i3++) {
                    View view2 = (View) this.g.get(i3);
                    m mVar2 = (m) view2.getLayoutParams();
                    Behavior b = mVar2.b();
                    if (b != null && b.a(this, view2, view)) {
                        if (i == 0 && mVar2.g()) {
                            mVar2.h();
                        } else {
                            boolean z;
                            switch (i) {
                                case 2:
                                    b.d(this, view2, view);
                                    z = true;
                                    break;
                                default:
                                    z = b.b(this, view2, view);
                                    break;
                            }
                            if (i == 1) {
                                mVar2.a(z);
                            }
                        }
                    }
                }
            }
        }
        a(e);
        a(e2);
        a(e3);
    }

    public void a(View view, int i) {
        m mVar = (m) view.getLayoutParams();
        if (mVar.d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (mVar.k != null) {
            a(view, mVar.k, i);
        } else if (mVar.e >= 0) {
            b(view, mVar.e, i);
        } else {
            c(view, i);
        }
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    void a(View view, int i, Rect rect, Rect rect2) {
        m mVar = (m) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        a(view, i, rect, rect2, mVar, measuredWidth, measuredHeight);
        a(mVar, rect2, measuredWidth, measuredHeight);
    }

    void a(View view, Rect rect) {
        au.b(this, view, rect);
    }

    void a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public boolean a(View view, int i, int i2) {
        Rect e = e();
        a(view, e);
        try {
            boolean contains = e.contains(i, i2);
            return contains;
        } finally {
            a(e);
        }
    }

    void b() {
        if (this.n) {
            if (this.r == null) {
                this.r = new n(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        this.s = true;
    }

    public void b(View view) {
        List c = this.h.c(view);
        if (c != null && !c.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < c.size()) {
                    View view2 = (View) c.get(i2);
                    Behavior b = ((m) view2.getLayoutParams()).b();
                    if (b != null) {
                        b.b(this, view2, view);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    void b(View view, int i) {
        m mVar = (m) view.getLayoutParams();
        if (mVar.k != null) {
            Rect e = e();
            Rect e2 = e();
            Rect e3 = e();
            a(mVar.k, e);
            a(view, false, e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            a(view, i, e, e3, mVar, measuredWidth, measuredHeight);
            boolean z = (e3.left == e2.left && e3.top == e2.top) ? false : true;
            a(mVar, e3, measuredWidth, measuredHeight);
            int i2 = e3.left - e2.left;
            int i3 = e3.top - e2.top;
            if (i2 != 0) {
                ViewCompat.e(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.d(view, i3);
            }
            if (z) {
                Behavior b = mVar.b();
                if (b != null) {
                    b.b(this, view, mVar.k);
                }
            }
            a(e);
            a(e2);
            a(e3);
        }
    }

    void b(View view, Rect rect) {
        ((m) view.getLayoutParams()).a(rect);
    }

    @NonNull
    public List<View> c(@NonNull View view) {
        Collection d = this.h.d(view);
        this.j.clear();
        if (d != null) {
            this.j.addAll(d);
        }
        return this.j;
    }

    void c() {
        if (this.n && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        this.s = false;
    }

    void c(View view, Rect rect) {
        rect.set(((m) view.getLayoutParams()).c());
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof m) && super.checkLayoutParams(layoutParams);
    }

    /* renamed from: d */
    protected m generateDefaultLayoutParams() {
        return new m(-2, -2);
    }

    @NonNull
    public List<View> d(@NonNull View view) {
        Collection c = this.h.c(view);
        this.j.clear();
        if (c != null) {
            this.j.addAll(c);
        }
        return this.j;
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        m mVar = (m) view.getLayoutParams();
        if (mVar.a != null) {
            float d = mVar.a.d(this, view);
            if (d > 0.0f) {
                if (this.l == null) {
                    this.l = new Paint();
                }
                this.l.setColor(mVar.a.c(this, view));
                this.l.setAlpha(a.a(Math.round(d * 255.0f), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.l);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.v;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    @VisibleForTesting
    final List<View> getDependencySortedChildren() {
        f();
        return Collections.unmodifiableList(this.g);
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public final as getLastWindowInsets() {
        return this.t;
    }

    public int getNestedScrollAxes() {
        return this.x.a();
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.v;
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(false);
        if (this.s) {
            if (this.r == null) {
                this.r = new n(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.r);
        }
        if (this.t == null && ViewCompat.r(this)) {
            ViewCompat.q(this);
        }
        this.n = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a(false);
        if (this.s && this.r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.r);
        }
        if (this.q != null) {
            onStopNestedScroll(this.q);
        }
        this.n = false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.u && this.v != null) {
            int b = this.t != null ? this.t.b() : 0;
            if (b > 0) {
                this.v.setBounds(0, 0, getWidth(), b);
                this.v.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            a(true);
        }
        boolean a = a(motionEvent, 0);
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            a(true);
        }
        return a;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int f = ViewCompat.f(this);
        int size = this.g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) this.g.get(i5);
            if (view.getVisibility() != 8) {
                Behavior b = ((m) view.getLayoutParams()).b();
                if (b == null || !b.a(this, view, f)) {
                    a(view, f);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        f();
        a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int f = ViewCompat.f(this);
        Object obj = f == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i3 = paddingLeft + paddingRight;
        int i4 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i5 = 0;
        Object obj2 = (this.t == null || !ViewCompat.r(this)) ? null : 1;
        int size3 = this.g.size();
        int i6 = 0;
        while (i6 < size3) {
            int i7;
            View view = (View) this.g.get(i6);
            if (view.getVisibility() == 8) {
                i7 = i5;
                paddingTop = suggestedMinimumHeight;
                paddingBottom = suggestedMinimumWidth;
            } else {
                int i8;
                int i9;
                m mVar = (m) view.getLayoutParams();
                int i10 = 0;
                if (mVar.e >= 0 && mode != 0) {
                    i7 = b(mVar.e);
                    paddingTop = android.support.v4.view.d.a(d(mVar.c), f) & 7;
                    if ((paddingTop == 3 && obj == null) || (paddingTop == 5 && obj != null)) {
                        i10 = Math.max(0, (size - paddingRight) - i7);
                    } else if ((paddingTop == 5 && obj == null) || (paddingTop == 3 && obj != null)) {
                        i10 = Math.max(0, i7 - paddingLeft);
                    }
                }
                if (obj2 == null || ViewCompat.r(view)) {
                    i8 = i2;
                    i9 = i;
                } else {
                    paddingTop = this.t.b() + this.t.d();
                    i9 = MeasureSpec.makeMeasureSpec(size - (this.t.a() + this.t.c()), mode);
                    i8 = MeasureSpec.makeMeasureSpec(size2 - paddingTop, mode2);
                }
                Behavior b = mVar.b();
                if (b == null || !b.a(this, view, i9, i10, i8, 0)) {
                    a(view, i9, i10, i8, 0);
                }
                i9 = Math.max(suggestedMinimumWidth, ((view.getMeasuredWidth() + i3) + mVar.leftMargin) + mVar.rightMargin);
                paddingTop = Math.max(suggestedMinimumHeight, ((view.getMeasuredHeight() + i4) + mVar.topMargin) + mVar.bottomMargin);
                i7 = View.combineMeasuredStates(i5, view.getMeasuredState());
                paddingBottom = i9;
            }
            i6++;
            i5 = i7;
            suggestedMinimumHeight = paddingTop;
            suggestedMinimumWidth = paddingBottom;
        }
        setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, CtaButton.BACKGROUND_COLOR & i5), View.resolveSizeAndState(suggestedMinimumHeight, i2, i5 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            boolean z3;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z3 = z2;
            } else {
                m mVar = (m) childAt.getLayoutParams();
                if (mVar.b(0)) {
                    Behavior b = mVar.b();
                    z3 = b != null ? b.a(this, childAt, view, f, f2, z) | z2 : z2;
                } else {
                    z3 = z2;
                }
            }
            i++;
            z2 = z3;
        }
        if (z2) {
            a(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            boolean z2;
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                m mVar = (m) childAt.getLayoutParams();
                if (mVar.b(0)) {
                    Behavior b = mVar.b();
                    z2 = b != null ? b.a(this, childAt, view, f, f2) | z : z;
                } else {
                    z2 = z;
                }
            }
            i++;
            z = z2;
        }
        return z;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        int i4 = 0;
        int i5 = 0;
        Object obj = null;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            Object obj2;
            int i7;
            int i8;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
                i7 = i4;
                i8 = i5;
            } else {
                m mVar = (m) childAt.getLayoutParams();
                if (mVar.b(i3)) {
                    Behavior b = mVar.b();
                    if (b != null) {
                        int[] iArr2 = this.k;
                        this.k[1] = 0;
                        iArr2[0] = 0;
                        b.a(this, childAt, view, i, i2, this.k, i3);
                        i7 = i > 0 ? Math.max(i4, this.k[0]) : Math.min(i4, this.k[0]);
                        i8 = i2 > 0 ? Math.max(i5, this.k[1]) : Math.min(i5, this.k[1]);
                        int obj22 = 1;
                    } else {
                        obj22 = obj;
                        i7 = i4;
                        i8 = i5;
                    }
                } else {
                    obj22 = obj;
                    i7 = i4;
                    i8 = i5;
                }
            }
            i6++;
            i5 = i8;
            i4 = i7;
            obj = obj22;
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (obj != null) {
            a(1);
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        Object obj = null;
        int i6 = 0;
        while (i6 < childCount) {
            Object obj2;
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                obj2 = obj;
            } else {
                m mVar = (m) childAt.getLayoutParams();
                if (mVar.b(i5)) {
                    Behavior b = mVar.b();
                    if (b != null) {
                        b.a(this, childAt, view, i, i2, i3, i4, i5);
                        obj2 = 1;
                    } else {
                        obj2 = obj;
                    }
                } else {
                    obj2 = obj;
                }
            }
            i6++;
            obj = obj2;
        }
        if (obj != null) {
            a(1);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.x.a(view, view2, i, i2);
        this.q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            m mVar = (m) childAt.getLayoutParams();
            if (mVar.b(i2)) {
                Behavior b = mVar.b();
                if (b != null) {
                    b.b(this, childAt, view, view2, i, i2);
                }
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            SparseArray sparseArray = savedState.a;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior b = a(childAt).b();
                if (!(id == -1 || b == null)) {
                    Parcelable parcelable2 = (Parcelable) sparseArray.get(id);
                    if (parcelable2 != null) {
                        b.a(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior b = ((m) childAt.getLayoutParams()).b();
            if (!(id == -1 || b == null)) {
                Parcelable b2 = b.b(this, childAt);
                if (b2 != null) {
                    sparseArray.append(id, b2);
                }
            }
        }
        savedState.a = sparseArray;
        return savedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        boolean z = false;
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            boolean z2;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                z2 = z;
            } else {
                m mVar = (m) childAt.getLayoutParams();
                Behavior b = mVar.b();
                if (b != null) {
                    boolean a = b.a(this, childAt, view, view2, i, i2);
                    z2 = z | a;
                    mVar.a(i2, a);
                } else {
                    mVar.a(i2, false);
                    z2 = z;
                }
            }
            i3++;
            z = z2;
        }
        return z;
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.x.a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            m mVar = (m) childAt.getLayoutParams();
            if (mVar.b(i)) {
                Behavior b = mVar.b();
                if (b != null) {
                    b.a(this, childAt, view, i);
                }
                mVar.a(i);
                mVar.h();
            }
        }
        this.q = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
        r11 = this;
        r4 = 3;
        r10 = 1;
        r5 = 0;
        r7 = 0;
        r2 = 0;
        r9 = r12.getActionMasked();
        r0 = r11.p;
        if (r0 != 0) goto L_0x005d;
    L_0x000d:
        r0 = r11.a(r12, r10);
        if (r0 == 0) goto L_0x005a;
    L_0x0013:
        r1 = r0;
    L_0x0014:
        r0 = r11.p;
        r0 = r0.getLayoutParams();
        r0 = (android.support.design.widget.m) r0;
        r0 = r0.b();
        if (r0 == 0) goto L_0x0058;
    L_0x0022:
        r3 = r11.p;
        r0 = r0.b(r11, r3, r12);
        r8 = r0;
    L_0x0029:
        r0 = r11.p;
        if (r0 != 0) goto L_0x0043;
    L_0x002d:
        r0 = super.onTouchEvent(r12);
        r8 = r8 | r0;
    L_0x0032:
        if (r8 != 0) goto L_0x0036;
    L_0x0034:
        if (r9 != 0) goto L_0x0036;
    L_0x0036:
        if (r2 == 0) goto L_0x003b;
    L_0x0038:
        r2.recycle();
    L_0x003b:
        if (r9 == r10) goto L_0x003f;
    L_0x003d:
        if (r9 != r4) goto L_0x0042;
    L_0x003f:
        r11.a(r7);
    L_0x0042:
        return r8;
    L_0x0043:
        if (r1 == 0) goto L_0x0032;
    L_0x0045:
        if (r2 != 0) goto L_0x0056;
    L_0x0047:
        r0 = android.os.SystemClock.uptimeMillis();
        r2 = r0;
        r6 = r5;
        r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7);
    L_0x0051:
        super.onTouchEvent(r0);
        r2 = r0;
        goto L_0x0032;
    L_0x0056:
        r0 = r2;
        goto L_0x0051;
    L_0x0058:
        r8 = r7;
        goto L_0x0029;
    L_0x005a:
        r1 = r0;
        r8 = r7;
        goto L_0x0029;
    L_0x005d:
        r1 = r7;
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior b = ((m) view.getLayoutParams()).b();
        return (b == null || !b.a(this, view, rect, z)) ? super.requestChildRectangleOnScreen(view, rect, z) : true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.m) {
            a(false);
            this.m = true;
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        g();
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.e = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2 = null;
        if (this.v != drawable) {
            if (this.v != null) {
                this.v.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.v = drawable2;
            if (this.v != null) {
                if (this.v.isStateful()) {
                    this.v.setState(getDrawableState());
                }
                android.support.v4.graphics.drawable.a.b(this.v, ViewCompat.f(this));
                this.v.setVisible(getVisibility() == 0, false);
                this.v.setCallback(this);
            }
            ViewCompat.d(this);
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i) {
        setStatusBarBackground(i != 0 ? android.support.v4.content.a.a(getContext(), i) : null);
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.v != null && this.v.isVisible() != z) {
            this.v.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.v;
    }
}
