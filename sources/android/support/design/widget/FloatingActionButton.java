package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.e;
import android.support.design.k;
import android.support.design.l;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.au;
import android.support.v7.widget.y;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@DefaultBehavior(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    int a;
    boolean b;
    final Rect c;
    private ColorStateList d;
    private Mode e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private final Rect k;
    private y l;
    private FloatingActionButtonImpl m;

    public class Behavior extends android.support.design.widget.CoordinatorLayout.Behavior<FloatingActionButton> {
        private Rect a;
        private q b;
        private boolean c;

        public Behavior() {
            this.c = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.FloatingActionButton_Behavior_Layout);
            this.c = obtainStyledAttributes.getBoolean(l.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i = 0;
            Rect rect = floatingActionButton.c;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                m mVar = (m) floatingActionButton.getLayoutParams();
                int i2 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - mVar.rightMargin ? rect.right : floatingActionButton.getLeft() <= mVar.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - mVar.bottomMargin) {
                    i = rect.bottom;
                } else if (floatingActionButton.getTop() <= mVar.topMargin) {
                    i = -rect.top;
                }
                if (i != 0) {
                    ViewCompat.d(floatingActionButton, i);
                }
                if (i2 != 0) {
                    ViewCompat.e(floatingActionButton, i2);
                }
            }
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!a((View) appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            au.b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        private static boolean a(@NonNull View view) {
            LayoutParams layoutParams = view.getLayoutParams();
            return layoutParams instanceof m ? ((m) layoutParams).b() instanceof BottomSheetBehavior : false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return !this.c ? false : ((m) floatingActionButton.getLayoutParams()).a() != view.getId() ? false : floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (!a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < ((m) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                floatingActionButton.b(this.b, false);
            } else {
                floatingActionButton.a(this.b, false);
            }
            return true;
        }

        public void a(@NonNull m mVar) {
            if (mVar.h == 0) {
                mVar.h = 80;
            }
        }

        public boolean a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List c = coordinatorLayout.c((View) floatingActionButton);
            int size = c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) c.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (a(view) && b(view, floatingActionButton)) {
                        break;
                    }
                } else if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.a((View) floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        public boolean a(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.c;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: a */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            } else if (a(view)) {
                b(view, floatingActionButton);
            }
            return false;
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Rect();
        this.k = new Rect();
        am.a(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.FloatingActionButton, i, k.Widget_Design_FloatingActionButton);
        this.d = obtainStyledAttributes.getColorStateList(l.FloatingActionButton_backgroundTint);
        this.e = ao.a(obtainStyledAttributes.getInt(l.FloatingActionButton_backgroundTintMode, -1), null);
        this.g = obtainStyledAttributes.getColor(l.FloatingActionButton_rippleColor, 0);
        this.h = obtainStyledAttributes.getInt(l.FloatingActionButton_fabSize, -1);
        this.i = obtainStyledAttributes.getDimensionPixelSize(l.FloatingActionButton_fabCustomSize, 0);
        this.f = obtainStyledAttributes.getDimensionPixelSize(l.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(l.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(l.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.b = obtainStyledAttributes.getBoolean(l.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.l = new y(this);
        this.l.a(attributeSet, i);
        this.j = (int) getResources().getDimension(e.design_fab_image_size);
        getImpl().a(this.d, this.e, this.g, this.f);
        getImpl().a(dimension);
        getImpl().b(dimension2);
    }

    private int a(int i) {
        Resources resources = getResources();
        if (this.i != 0) {
            return this.i;
        }
        switch (i) {
            case -1:
                return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? a(1) : a(0);
            case 1:
                return resources.getDimensionPixelSize(e.design_fab_size_mini);
            default:
                return resources.getDimensionPixelSize(e.design_fab_size_normal);
        }
    }

    private static int a(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    @Nullable
    private InternalVisibilityChangedListener a(@Nullable final q qVar) {
        return qVar == null ? null : new InternalVisibilityChangedListener() {
            public void onHidden() {
                qVar.b(FloatingActionButton.this);
            }

            public void onShown() {
                qVar.a(FloatingActionButton.this);
            }
        };
    }

    private FloatingActionButtonImpl a() {
        return VERSION.SDK_INT >= 21 ? new w(this, new r(this)) : new FloatingActionButtonImpl(this, new r(this));
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.m == null) {
            this.m = a();
        }
        return this.m;
    }

    void a(q qVar, boolean z) {
        getImpl().b(a(qVar), z);
    }

    public boolean a(@NonNull Rect rect) {
        if (!ViewCompat.y(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        rect.left += this.c.left;
        rect.top += this.c.top;
        rect.right -= this.c.right;
        rect.bottom -= this.c.bottom;
        return true;
    }

    void b(@Nullable q qVar, boolean z) {
        getImpl().a(a(qVar), z);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().a(getDrawableState());
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.d;
    }

    @Nullable
    public Mode getBackgroundTintMode() {
        return this.e;
    }

    public float getCompatElevation() {
        return getImpl().a();
    }

    @NonNull
    public Drawable getContentBackground() {
        return getImpl().c();
    }

    public int getCustomSize() {
        return this.i;
    }

    @ColorInt
    public int getRippleColor() {
        return this.g;
    }

    public int getSize() {
        return this.h;
    }

    int getSizeDimension() {
        return a(this.h);
    }

    public boolean getUseCompatPadding() {
        return this.b;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().b();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().f();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().g();
    }

    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.a = (sizeDimension - this.j) / 2;
        getImpl().e();
        sizeDimension = Math.min(a(sizeDimension, i), a(sizeDimension, i2));
        setMeasuredDimension((this.c.left + sizeDimension) + this.c.right, (sizeDimension + this.c.top) + this.c.bottom);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                if (a(this.k) && !this.k.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.d != colorStateList) {
            this.d = colorStateList;
            getImpl().a(colorStateList);
        }
    }

    public void setBackgroundTintMode(@Nullable Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            getImpl().a(mode);
        }
    }

    public void setCompatElevation(float f) {
        getImpl().a(f);
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size should be non-negative.");
        }
        this.i = i;
    }

    public void setImageResource(@DrawableRes int i) {
        this.l.a(i);
    }

    public void setRippleColor(@ColorInt int i) {
        if (this.g != i) {
            this.g = i;
            getImpl().a(i);
        }
    }

    public void setSize(int i) {
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.b != z) {
            this.b = z;
            getImpl().d();
        }
    }
}
