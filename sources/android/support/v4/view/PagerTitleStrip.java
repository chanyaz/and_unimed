package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager.DecorView;
import android.support.v4.widget.TextViewCompat;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;

@DecorView
public class PagerTitleStrip extends ViewGroup {
    private static final int[] n = new int[]{16842804, 16842901, 16842904, 16842927};
    private static final int[] o = new int[]{16843660};
    ViewPager a;
    TextView b;
    TextView c;
    TextView d;
    float e = -1.0f;
    int f;
    private int g = -1;
    private int h;
    private int i;
    private boolean j;
    private boolean k;
    private final o l = new o(this);
    private WeakReference<n> m;
    private int p;

    public PagerTitleStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        boolean z = false;
        super(context, attributeSet);
        View textView = new TextView(context);
        this.b = textView;
        addView(textView);
        textView = new TextView(context);
        this.c = textView;
        addView(textView);
        textView = new TextView(context);
        this.d = textView;
        addView(textView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            TextViewCompat.a(this.b, resourceId);
            TextViewCompat.a(this.c, resourceId);
            TextViewCompat.a(this.d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            dimensionPixelSize = obtainStyledAttributes.getColor(2, 0);
            this.b.setTextColor(dimensionPixelSize);
            this.c.setTextColor(dimensionPixelSize);
            this.d.setTextColor(dimensionPixelSize);
        }
        this.i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f = this.c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.b.setEllipsize(TruncateAt.END);
        this.c.setEllipsize(TruncateAt.END);
        this.d.setEllipsize(TruncateAt.END);
        if (resourceId != 0) {
            obtainStyledAttributes = context.obtainStyledAttributes(resourceId, o);
            z = obtainStyledAttributes.getBoolean(0, false);
            obtainStyledAttributes.recycle();
        }
        if (z) {
            setSingleLineAllCaps(this.b);
            setSingleLineAllCaps(this.c);
            setSingleLineAllCaps(this.d);
        } else {
            this.b.setSingleLine();
            this.c.setSingleLine();
            this.d.setSingleLine();
        }
        this.h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new p(textView.getContext()));
    }

    public void a(int i, float f) {
        this.b.setTextSize(i, f);
        this.c.setTextSize(i, f);
        this.d.setTextSize(i, f);
    }

    void a(int i, float f, boolean z) {
        if (i != this.g) {
            a(i, this.a.getAdapter());
        } else if (!z && f == this.e) {
            return;
        }
        this.k = true;
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredWidth2 = this.c.getMeasuredWidth();
        int measuredWidth3 = this.d.getMeasuredWidth();
        int i2 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i3 = paddingRight + i2;
        int i4 = (width - (paddingLeft + i2)) - i3;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        i4 = ((width - i3) - ((int) (f2 * ((float) i4)))) - (measuredWidth2 / 2);
        i3 = i4 + measuredWidth2;
        i2 = this.b.getBaseline();
        measuredWidth2 = this.c.getBaseline();
        int baseline = this.d.getBaseline();
        int max = Math.max(Math.max(i2, measuredWidth2), baseline);
        i2 = max - i2;
        measuredWidth2 = max - measuredWidth2;
        baseline = max - baseline;
        int measuredHeight = this.d.getMeasuredHeight() + baseline;
        max = Math.max(Math.max(this.b.getMeasuredHeight() + i2, this.c.getMeasuredHeight() + measuredWidth2), measuredHeight);
        switch (this.i & 112) {
            case 16:
                paddingTop = (((height - paddingTop) - paddingBottom) - max) / 2;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            case 80:
                paddingTop = (height - paddingBottom) - max;
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
            default:
                height = paddingTop + i2;
                measuredWidth2 += paddingTop;
                i2 = paddingTop + baseline;
                break;
        }
        this.c.layout(i4, measuredWidth2, i3, this.c.getMeasuredHeight() + measuredWidth2);
        measuredWidth2 = Math.min(paddingLeft, (i4 - this.h) - measuredWidth);
        this.b.layout(measuredWidth2, height, measuredWidth + measuredWidth2, this.b.getMeasuredHeight() + height);
        measuredWidth2 = Math.max((width - paddingRight) - measuredWidth3, this.h + i3);
        this.d.layout(measuredWidth2, i2, measuredWidth2 + measuredWidth3, this.d.getMeasuredHeight() + i2);
        this.e = f;
        this.k = false;
    }

    void a(int i, n nVar) {
        CharSequence charSequence = null;
        int b = nVar != null ? nVar.b() : 0;
        this.j = true;
        CharSequence c = (i < 1 || nVar == null) ? null : nVar.c(i - 1);
        this.b.setText(c);
        TextView textView = this.c;
        c = (nVar == null || i >= b) ? null : nVar.c(i);
        textView.setText(c);
        if (i + 1 < b && nVar != null) {
            charSequence = nVar.c(i + 1);
        }
        this.d.setText(charSequence);
        b = MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.b.measure(b, makeMeasureSpec);
        this.c.measure(b, makeMeasureSpec);
        this.d.measure(b, makeMeasureSpec);
        this.g = i;
        if (!this.k) {
            a(i, this.e, false);
        }
        this.j = false;
    }

    void a(n nVar, n nVar2) {
        if (nVar != null) {
            nVar.b(this.l);
            this.m = null;
        }
        if (nVar2 != null) {
            nVar2.a(this.l);
            this.m = new WeakReference(nVar2);
        }
        if (this.a != null) {
            this.g = -1;
            this.e = -1.0f;
            a(this.a.getCurrentItem(), nVar2);
            requestLayout();
        }
    }

    int getMinHeight() {
        Drawable background = getBackground();
        return background != null ? background.getIntrinsicHeight() : 0;
    }

    public int getTextSpacing() {
        return this.h;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            n adapter = viewPager.getAdapter();
            viewPager.c(this.l);
            viewPager.a(this.l);
            this.a = viewPager;
            a(this.m != null ? (n) this.m.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            a(this.a.getAdapter(), null);
            this.a.c(null);
            this.a.b(this.l);
            this.a = null;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f = 0.0f;
        if (this.a != null) {
            if (this.e >= 0.0f) {
                f = this.e;
            }
            a(this.g, f, true);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int size = MeasureSpec.getSize(i);
        int childMeasureSpec2 = getChildMeasureSpec(i, (int) (((float) size) * 0.2f), -2);
        this.b.measure(childMeasureSpec2, childMeasureSpec);
        this.c.measure(childMeasureSpec2, childMeasureSpec);
        this.d.measure(childMeasureSpec2, childMeasureSpec);
        if (MeasureSpec.getMode(i2) == 1073741824) {
            paddingTop = MeasureSpec.getSize(i2);
        } else {
            paddingTop = Math.max(getMinHeight(), paddingTop + this.c.getMeasuredHeight());
        }
        setMeasuredDimension(size, View.resolveSizeAndState(paddingTop, i2, this.c.getMeasuredState() << 16));
    }

    public void requestLayout() {
        if (!this.j) {
            super.requestLayout();
        }
    }

    public void setGravity(int i) {
        this.i = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.p = ((int) (255.0f * f)) & 255;
        int i = (this.p << 24) | (this.f & 16777215);
        this.b.setTextColor(i);
        this.d.setTextColor(i);
    }

    public void setTextColor(@ColorInt int i) {
        this.f = i;
        this.c.setTextColor(i);
        int i2 = (this.p << 24) | (this.f & 16777215);
        this.b.setTextColor(i2);
        this.d.setTextColor(i2);
    }

    public void setTextSpacing(int i) {
        this.h = i;
        requestLayout();
    }
}
