package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.b.b;
import android.support.v7.b.c;
import android.support.v7.b.e;
import android.support.v7.b.f;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class CardView extends FrameLayout {
    private static final int[] e = new int[]{16842801};
    private static final CardViewImpl f;
    int a;
    int b;
    final Rect c;
    final Rect d;
    private boolean g;
    private boolean h;
    private final CardViewDelegate i;

    static {
        if (VERSION.SDK_INT >= 21) {
            f = new ah();
        } else if (VERSION.SDK_INT >= 17) {
            f = new ag();
        } else {
            f = new ai();
        }
        f.initStatic();
    }

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, b.cardViewStyle);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        super(context, attributeSet, i);
        this.c = new Rect();
        this.d = new Rect();
        this.i = new CardViewDelegate() {
            private Drawable b;

            public Drawable getCardBackground() {
                return this.b;
            }

            public View getCardView() {
                return CardView.this;
            }

            public boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            public boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            public void setCardBackground(Drawable drawable) {
                this.b = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            public void setMinWidthHeightInternal(int i, int i2) {
                if (i > CardView.this.a) {
                    super.setMinimumWidth(i);
                }
                if (i2 > CardView.this.b) {
                    super.setMinimumHeight(i2);
                }
            }

            public void setShadowPadding(int i, int i2, int i3, int i4) {
                CardView.this.d.set(i, i2, i3, i4);
                super.setPadding(CardView.this.c.left + i, CardView.this.c.top + i2, CardView.this.c.right + i3, CardView.this.c.bottom + i4);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.CardView, i, e.CardView);
        if (obtainStyledAttributes.hasValue(f.CardView_cardBackgroundColor)) {
            colorStateList = obtainStyledAttributes.getColorStateList(f.CardView_cardBackgroundColor);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(e);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateList = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(c.cardview_light_background) : getResources().getColor(c.cardview_dark_background));
        }
        float dimension = obtainStyledAttributes.getDimension(f.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(f.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(f.CardView_cardMaxElevation, 0.0f);
        this.g = obtainStyledAttributes.getBoolean(f.CardView_cardUseCompatPadding, false);
        this.h = obtainStyledAttributes.getBoolean(f.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(f.CardView_contentPadding, 0);
        this.c.left = obtainStyledAttributes.getDimensionPixelSize(f.CardView_contentPaddingLeft, dimensionPixelSize);
        this.c.top = obtainStyledAttributes.getDimensionPixelSize(f.CardView_contentPaddingTop, dimensionPixelSize);
        this.c.right = obtainStyledAttributes.getDimensionPixelSize(f.CardView_contentPaddingRight, dimensionPixelSize);
        this.c.bottom = obtainStyledAttributes.getDimensionPixelSize(f.CardView_contentPaddingBottom, dimensionPixelSize);
        if (dimension2 > dimension3) {
            dimension3 = dimension2;
        }
        this.a = obtainStyledAttributes.getDimensionPixelSize(f.CardView_android_minWidth, 0);
        this.b = obtainStyledAttributes.getDimensionPixelSize(f.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        f.initialize(this.i, context, colorStateList, dimension, dimension2, dimension3);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return f.getBackgroundColor(this.i);
    }

    public float getCardElevation() {
        return f.getElevation(this.i);
    }

    public int getContentPaddingBottom() {
        return this.c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.c.left;
    }

    public int getContentPaddingRight() {
        return this.c.right;
    }

    public int getContentPaddingTop() {
        return this.c.top;
    }

    public float getMaxCardElevation() {
        return f.getMaxElevation(this.i);
    }

    public boolean getPreventCornerOverlap() {
        return this.h;
    }

    public float getRadius() {
        return f.getRadius(this.i);
    }

    public boolean getUseCompatPadding() {
        return this.g;
    }

    protected void onMeasure(int i, int i2) {
        if (f instanceof ah) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f.getMinWidth(this.i)), MeasureSpec.getSize(i)), mode);
                break;
        }
        mode = MeasureSpec.getMode(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
            case 1073741824:
                i2 = MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil((double) f.getMinHeight(this.i)), MeasureSpec.getSize(i2)), mode);
                break;
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(@ColorInt int i) {
        f.setBackgroundColor(this.i, ColorStateList.valueOf(i));
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        f.setBackgroundColor(this.i, colorStateList);
    }

    public void setCardElevation(float f) {
        f.setElevation(this.i, f);
    }

    public void setMaxCardElevation(float f) {
        f.setMaxElevation(this.i, f);
    }

    public void setMinimumHeight(int i) {
        this.b = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.a = i;
        super.setMinimumWidth(i);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
    }

    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.h) {
            this.h = z;
            f.onPreventCornerOverlapChanged(this.i);
        }
    }

    public void setRadius(float f) {
        f.setRadius(this.i, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.g != z) {
            this.g = z;
            f.onCompatPaddingChanged(this.i);
        }
    }
}
