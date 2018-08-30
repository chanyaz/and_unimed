package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.a;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
    static final SlidingPanelLayoutImpl h;
    View a;
    float b;
    int c;
    boolean d;
    final as e;
    boolean f;
    final ArrayList<ag> g;
    private int i;
    private int j;
    private Drawable k;
    private Drawable l;
    private final int m;
    private boolean n;
    private float o;
    private int p;
    private float q;
    private float r;
    private PanelSlideListener s;
    private boolean t;
    private final Rect u;

    public class LayoutParams extends MarginLayoutParams {
        private static final int[] e = new int[]{16843137};
        public float a = 0.0f;
        boolean b;
        boolean c;
        Paint d;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e);
            this.a = obtainStyledAttributes.getFloat(0, 0.0f);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@NonNull android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public interface PanelSlideListener {
        void onPanelClosed(@NonNull View view);

        void onPanelOpened(@NonNull View view);

        void onPanelSlide(@NonNull View view, float f);
    }

    class SavedState extends AbsSavedState {
        public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.a = parcel.readInt() != 0;
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a ? 1 : 0);
        }
    }

    interface SlidingPanelLayoutImpl {
        void invalidateChildRegion(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            h = new ak();
        } else if (VERSION.SDK_INT >= 16) {
            h = new aj();
        } else {
            h = new ai();
        }
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = -858993460;
        this.t = true;
        this.u = new Rect();
        this.g = new ArrayList();
        float f = context.getResources().getDisplayMetrics().density;
        this.m = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.a((View) this, new af(this));
        ViewCompat.b((View) this, 1);
        this.e = as.a((ViewGroup) this, 0.5f, new ah(this));
        this.e.a(f * 400.0f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    private void a(float r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = r9.f();
        r0 = r9.a;
        r0 = r0.getLayoutParams();
        r0 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r0;
        r2 = r0.c;
        if (r2 == 0) goto L_0x0030;
    L_0x0013:
        if (r3 == 0) goto L_0x002d;
    L_0x0015:
        r0 = r0.rightMargin;
    L_0x0017:
        if (r0 > 0) goto L_0x0030;
    L_0x0019:
        r0 = 1;
    L_0x001a:
        r4 = r9.getChildCount();
        r2 = r1;
    L_0x001f:
        if (r2 >= r4) goto L_0x005d;
    L_0x0021:
        r5 = r9.getChildAt(r2);
        r1 = r9.a;
        if (r5 != r1) goto L_0x0032;
    L_0x0029:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x001f;
    L_0x002d:
        r0 = r0.leftMargin;
        goto L_0x0017;
    L_0x0030:
        r0 = r1;
        goto L_0x001a;
    L_0x0032:
        r1 = r9.o;
        r1 = r8 - r1;
        r6 = r9.p;
        r6 = (float) r6;
        r1 = r1 * r6;
        r1 = (int) r1;
        r9.o = r10;
        r6 = r8 - r10;
        r7 = r9.p;
        r7 = (float) r7;
        r6 = r6 * r7;
        r6 = (int) r6;
        r1 = r1 - r6;
        if (r3 == 0) goto L_0x0048;
    L_0x0047:
        r1 = -r1;
    L_0x0048:
        r5.offsetLeftAndRight(r1);
        if (r0 == 0) goto L_0x0029;
    L_0x004d:
        if (r3 == 0) goto L_0x0058;
    L_0x004f:
        r1 = r9.o;
        r1 = r1 - r8;
    L_0x0052:
        r6 = r9.j;
        r9.a(r5, r1, r6);
        goto L_0x0029;
    L_0x0058:
        r1 = r9.o;
        r1 = r8 - r1;
        goto L_0x0052;
    L_0x005d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.a(float):void");
    }

    private void a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > 0.0f && i != 0) {
            int i2 = (((int) (((float) ((CtaButton.BACKGROUND_COLOR & i) >>> 24)) * f)) << 24) | (16777215 & i);
            if (layoutParams.d == null) {
                layoutParams.d = new Paint();
            }
            layoutParams.d.setColorFilter(new PorterDuffColorFilter(i2, Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.d);
            }
            e(view);
        } else if (view.getLayerType() != 0) {
            if (layoutParams.d != null) {
                layoutParams.d.setColorFilter(null);
            }
            Runnable agVar = new ag(this, view);
            this.g.add(agVar);
            ViewCompat.a((View) this, agVar);
        }
    }

    private boolean a(View view, int i) {
        if (!this.t && !a(0.0f, i)) {
            return false;
        }
        this.f = false;
        return true;
    }

    private boolean b(View view, int i) {
        if (!this.t && !a(1.0f, i)) {
            return false;
        }
        this.f = true;
        return true;
    }

    private static boolean g(View view) {
        if (view.isOpaque()) {
            return true;
        }
        if (VERSION.SDK_INT >= 18) {
            return false;
        }
        Drawable background = view.getBackground();
        return background != null ? background.getOpacity() == -1 : false;
    }

    void a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    void a(int i) {
        if (this.a == null) {
            this.b = 0.0f;
            return;
        }
        boolean f = f();
        LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
        int width = this.a.getWidth();
        if (f) {
            i = (getWidth() - i) - width;
        }
        this.b = ((float) (i - ((f ? layoutParams.rightMargin : layoutParams.leftMargin) + (f ? getPaddingRight() : getPaddingLeft())))) / ((float) this.c);
        if (this.p != 0) {
            a(this.b);
        }
        if (layoutParams.c) {
            a(this.a, this.b, this.i);
        }
        a(this.a);
    }

    void a(View view) {
        if (this.s != null) {
            this.s.onPanelSlide(view, this.b);
        }
    }

    boolean a(float f, int i) {
        if (!this.n) {
            return false;
        }
        int width;
        LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
        if (f()) {
            width = (int) (((float) getWidth()) - ((((float) (layoutParams.rightMargin + getPaddingRight())) + (((float) this.c) * f)) + ((float) this.a.getWidth())));
        } else {
            width = (int) (((float) (layoutParams.leftMargin + getPaddingLeft())) + (((float) this.c) * f));
        }
        if (!this.e.a(this.a, width, this.a.getTop())) {
            return false;
        }
        a();
        ViewCompat.d(this);
        return true;
    }

    void b(View view) {
        if (this.s != null) {
            this.s.onPanelOpened(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean b() {
        return b(this.a, 0);
    }

    void c(View view) {
        if (this.s != null) {
            this.s.onPanelClosed(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean c() {
        return a(this.a, 0);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        if (!this.e.a(true)) {
            return;
        }
        if (this.n) {
            ViewCompat.d(this);
        } else {
            this.e.f();
        }
    }

    void d(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean f = f();
        int width = f ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view == null || !g(view)) {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        } else {
            i4 = view.getLeft();
            i3 = view.getRight();
            i2 = view.getTop();
            i = view.getBottom();
        }
        int childCount = getChildCount();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    int i6 = (Math.max(f ? paddingLeft : width, childAt.getLeft()) < i4 || Math.max(paddingTop, childAt.getTop()) < i2 || Math.min(f ? width : paddingLeft, childAt.getRight()) > i3 || Math.min(height, childAt.getBottom()) > i) ? 0 : 4;
                    childAt.setVisibility(i6);
                }
                i5++;
            } else {
                return;
            }
        }
    }

    public boolean d() {
        return !this.n || this.b == 1.0f;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = f() ? this.l : this.k;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int right;
            int i;
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (f()) {
                right = childAt.getRight();
                i = right + intrinsicWidth;
            } else {
                i = childAt.getLeft();
                right = i - intrinsicWidth;
            }
            drawable.setBounds(right, top, i, bottom);
            drawable.draw(canvas);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int save = canvas.save();
        if (!(!this.n || layoutParams.b || this.a == null)) {
            canvas.getClipBounds(this.u);
            if (f()) {
                this.u.left = Math.max(this.u.left, this.a.getRight());
            } else {
                this.u.right = Math.min(this.u.right, this.a.getLeft());
            }
            canvas.clipRect(this.u);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        return drawChild;
    }

    void e(View view) {
        h.invalidateChildRegion(this, view);
    }

    public boolean e() {
        return this.n;
    }

    boolean f() {
        return ViewCompat.f(this) == 1;
    }

    boolean f(View view) {
        if (view == null) {
            return false;
        }
        boolean z = this.n && ((LayoutParams) view.getLayoutParams()).c && this.b > 0.0f;
        return z;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @ColorInt
    public int getCoveredFadeColor() {
        return this.j;
    }

    public int getParallaxDistance() {
        return this.p;
    }

    @ColorInt
    public int getSliderFadeColor() {
        return this.i;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.t = true;
        int size = this.g.size();
        for (int i = 0; i < size; i++) {
            ((ag) this.g.get(i)).run();
        }
        this.g.clear();
    }

    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
        r7 = this;
        r2 = 0;
        r1 = 1;
        r3 = r8.getActionMasked();
        r0 = r7.n;
        if (r0 != 0) goto L_0x002d;
    L_0x000a:
        if (r3 != 0) goto L_0x002d;
    L_0x000c:
        r0 = r7.getChildCount();
        if (r0 <= r1) goto L_0x002d;
    L_0x0012:
        r0 = r7.getChildAt(r1);
        if (r0 == 0) goto L_0x002d;
    L_0x0018:
        r4 = r7.e;
        r5 = r8.getX();
        r5 = (int) r5;
        r6 = r8.getY();
        r6 = (int) r6;
        r0 = r4.b(r0, r5, r6);
        if (r0 != 0) goto L_0x0041;
    L_0x002a:
        r0 = r1;
    L_0x002b:
        r7.f = r0;
    L_0x002d:
        r0 = r7.n;
        if (r0 == 0) goto L_0x0037;
    L_0x0031:
        r0 = r7.d;
        if (r0 == 0) goto L_0x0043;
    L_0x0035:
        if (r3 == 0) goto L_0x0043;
    L_0x0037:
        r0 = r7.e;
        r0.e();
        r2 = super.onInterceptTouchEvent(r8);
    L_0x0040:
        return r2;
    L_0x0041:
        r0 = r2;
        goto L_0x002b;
    L_0x0043:
        r0 = 3;
        if (r3 == r0) goto L_0x0048;
    L_0x0046:
        if (r3 != r1) goto L_0x004e;
    L_0x0048:
        r0 = r7.e;
        r0.e();
        goto L_0x0040;
    L_0x004e:
        switch(r3) {
            case 0: goto L_0x005e;
            case 1: goto L_0x0051;
            case 2: goto L_0x0082;
            default: goto L_0x0051;
        };
    L_0x0051:
        r0 = r2;
    L_0x0052:
        r3 = r7.e;
        r3 = r3.a(r8);
        if (r3 != 0) goto L_0x005c;
    L_0x005a:
        if (r0 == 0) goto L_0x0040;
    L_0x005c:
        r2 = r1;
        goto L_0x0040;
    L_0x005e:
        r7.d = r2;
        r0 = r8.getX();
        r3 = r8.getY();
        r7.q = r0;
        r7.r = r3;
        r4 = r7.e;
        r5 = r7.a;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r4.b(r5, r0, r3);
        if (r0 == 0) goto L_0x0051;
    L_0x0078:
        r0 = r7.a;
        r0 = r7.f(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0080:
        r0 = r1;
        goto L_0x0052;
    L_0x0082:
        r0 = r8.getX();
        r3 = r8.getY();
        r4 = r7.q;
        r0 = r0 - r4;
        r0 = java.lang.Math.abs(r0);
        r4 = r7.r;
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r4 = r7.e;
        r4 = r4.d();
        r4 = (float) r4;
        r4 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x0051;
    L_0x00a3:
        r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0051;
    L_0x00a7:
        r0 = r7.e;
        r0.e();
        r7.d = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean f = f();
        if (f) {
            this.e.a(2);
        } else {
            this.e.a(1);
        }
        int i6 = i3 - i;
        int paddingRight = f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.t) {
            float f2 = (this.n && this.f) ? 1.0f : 0.0f;
            this.b = f2;
        }
        int i7 = 0;
        int i8 = paddingRight;
        while (i7 < childCount) {
            int i9;
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                i5 = paddingRight;
                i9 = i8;
            } else {
                int i10;
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.b) {
                    int min = (Math.min(paddingRight, (i6 - paddingLeft) - this.m) - i8) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.c = min;
                    i9 = f ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.c = ((i8 + i9) + min) + (measuredWidth / 2) > i6 - paddingLeft;
                    i5 = (int) (((float) min) * this.b);
                    i10 = i8 + (i9 + i5);
                    this.b = ((float) i5) / ((float) this.c);
                    i5 = 0;
                } else if (!this.n || this.p == 0) {
                    i5 = 0;
                    i10 = paddingRight;
                } else {
                    i5 = (int) ((1.0f - this.b) * ((float) this.p));
                    i10 = paddingRight;
                }
                if (f) {
                    i9 = (i6 - i10) + i5;
                    i5 = i9 - measuredWidth;
                } else {
                    i5 = i10 - i5;
                    i9 = i5 + measuredWidth;
                }
                childAt.layout(i5, paddingTop, i9, childAt.getMeasuredHeight() + paddingTop);
                i5 = childAt.getWidth() + paddingRight;
                i9 = i10;
            }
            i7++;
            paddingRight = i5;
            i8 = i9;
        }
        if (this.t) {
            if (this.n) {
                if (this.p != 0) {
                    a(this.b);
                }
                if (((LayoutParams) this.a.getLayoutParams()).c) {
                    a(this.a, this.b, this.i);
                }
            } else {
                for (i5 = 0; i5 < childCount; i5++) {
                    a(getChildAt(i5), 0.0f, this.i);
                }
            }
            d(this.a);
        }
        this.t = false;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        LayoutParams layoutParams;
        int i5;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            if (mode2 == 0) {
                if (!isInEditMode()) {
                    throw new IllegalStateException("Height must not be UNSPECIFIED");
                } else if (mode2 == 0) {
                    i3 = Integer.MIN_VALUE;
                    i4 = size;
                    size = 300;
                }
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        } else if (!isInEditMode()) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode == Integer.MIN_VALUE) {
            i3 = mode2;
            i4 = size;
            size = size2;
        } else {
            if (mode == 0) {
                i3 = mode2;
                i4 = 300;
                size = size2;
            }
            i3 = mode2;
            i4 = size;
            size = size2;
        }
        switch (i3) {
            case Integer.MIN_VALUE:
                size2 = 0;
                mode2 = (size - getPaddingTop()) - getPaddingBottom();
                break;
            case 1073741824:
                size2 = (size - getPaddingTop()) - getPaddingBottom();
                mode2 = size2;
                break;
            default:
                size2 = 0;
                mode2 = 0;
                break;
        }
        boolean z = false;
        int paddingLeft = (i4 - getPaddingLeft()) - getPaddingRight();
        int childCount = getChildCount();
        if (childCount > 2) {
            Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.a = null;
        int i6 = 0;
        int i7 = paddingLeft;
        int i8 = size2;
        float f = 0.0f;
        while (i6 < childCount) {
            float f2;
            boolean z2;
            View childAt = getChildAt(i6);
            layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() == 8) {
                layoutParams.c = false;
                size2 = i7;
                f2 = f;
                i5 = i8;
                z2 = z;
            } else {
                if (layoutParams.a > 0.0f) {
                    f += layoutParams.a;
                    if (layoutParams.width == 0) {
                        size2 = i7;
                        f2 = f;
                        i5 = i8;
                        z2 = z;
                    }
                }
                mode = layoutParams.leftMargin + layoutParams.rightMargin;
                mode = layoutParams.width == -2 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, Integer.MIN_VALUE) : layoutParams.width == -1 ? MeasureSpec.makeMeasureSpec(paddingLeft - mode, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                i5 = layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                childAt.measure(mode, i5);
                mode = childAt.getMeasuredWidth();
                i5 = childAt.getMeasuredHeight();
                if (i3 == Integer.MIN_VALUE && i5 > i8) {
                    i8 = Math.min(i5, mode2);
                }
                i5 = i7 - mode;
                boolean z3 = i5 < 0;
                layoutParams.b = z3;
                z3 |= z;
                if (layoutParams.b) {
                    this.a = childAt;
                }
                size2 = i5;
                i5 = i8;
                float f3 = f;
                z2 = z3;
                f2 = f3;
            }
            i6++;
            z = z2;
            i8 = i5;
            f = f2;
            i7 = size2;
        }
        if (z || f > 0.0f) {
            int i9 = paddingLeft - this.m;
            for (i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getVisibility() != 8) {
                    layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8) {
                        Object obj = (layoutParams.width != 0 || layoutParams.a <= 0.0f) ? null : 1;
                        i5 = obj != null ? 0 : childAt2.getMeasuredWidth();
                        if (!z || childAt2 == this.a) {
                            if (layoutParams.a > 0.0f) {
                                mode = layoutParams.width == 0 ? layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                                if (z) {
                                    size2 = paddingLeft - (layoutParams.rightMargin + layoutParams.leftMargin);
                                    i6 = MeasureSpec.makeMeasureSpec(size2, 1073741824);
                                    if (i5 != size2) {
                                        childAt2.measure(i6, mode);
                                    }
                                } else {
                                    childAt2.measure(MeasureSpec.makeMeasureSpec(((int) ((layoutParams.a * ((float) Math.max(0, i7))) / f)) + i5, 1073741824), mode);
                                }
                            }
                        } else if (layoutParams.width < 0 && (i5 > i9 || layoutParams.a > 0.0f)) {
                            size2 = obj != null ? layoutParams.height == -2 ? MeasureSpec.makeMeasureSpec(mode2, Integer.MIN_VALUE) : layoutParams.height == -1 ? MeasureSpec.makeMeasureSpec(mode2, 1073741824) : MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(childAt2.getMeasuredHeight(), 1073741824);
                            childAt2.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), size2);
                        }
                    }
                }
            }
        }
        setMeasuredDimension(i4, (getPaddingTop() + i8) + getPaddingBottom());
        this.n = z;
        if (this.e.a() != 0 && !z) {
            this.e.f();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.a());
            if (savedState.a) {
                b();
            } else {
                c();
            }
            this.f = savedState.a;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = e() ? d() : this.f;
        return savedState;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.t = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.n) {
            return super.onTouchEvent(motionEvent);
        }
        this.e.b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.q = x;
                this.r = y;
                return true;
            case 1:
                if (!f(this.a)) {
                    return true;
                }
                x = motionEvent.getX();
                y = motionEvent.getY();
                float f = x - this.q;
                float f2 = y - this.r;
                int d = this.e.d();
                if ((f * f) + (f2 * f2) >= ((float) (d * d)) || !this.e.b(this.a, (int) x, (int) y)) {
                    return true;
                }
                a(this.a, 0);
                return true;
            default:
                return true;
        }
    }

    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.n) {
            this.f = view == this.a;
        }
    }

    public void setCoveredFadeColor(@ColorInt int i) {
        this.j = i;
    }

    public void setPanelSlideListener(@Nullable PanelSlideListener panelSlideListener) {
        this.s = panelSlideListener;
    }

    public void setParallaxDistance(int i) {
        this.p = i;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(@Nullable Drawable drawable) {
        this.k = drawable;
    }

    public void setShadowDrawableRight(@Nullable Drawable drawable) {
        this.l = drawable;
    }

    @Deprecated
    public void setShadowResource(@DrawableRes int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(a.a(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(a.a(getContext(), i));
    }

    public void setSliderFadeColor(@ColorInt int i) {
        this.i = i;
    }
}
