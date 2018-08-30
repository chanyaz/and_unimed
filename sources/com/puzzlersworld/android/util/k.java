package com.puzzlersworld.android.util;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.TypedValue;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class k extends Drawable {
    private static final int[] i = new int[]{16842804};
    private static final int[] j = new int[]{16842901, 16842902, 16842903, 16842904};
    private Resources a;
    private TextPaint b;
    private StaticLayout c;
    private Alignment d = Alignment.ALIGN_CENTER;
    private Path e;
    private ColorStateList f;
    private Rect g;
    private CharSequence h = "";

    public k(Context context) {
        ColorStateList colorStateList;
        Typeface typeface = null;
        int i = -1;
        this.a = context.getResources();
        this.g = new Rect();
        this.b = new TextPaint(1);
        this.b.density = this.a.getDisplayMetrics().density;
        this.b.setDither(true);
        int i2 = 15;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = resourceId != -1 ? context.obtainStyledAttributes(resourceId, j) : null;
        if (obtainStyledAttributes2 != null) {
            ColorStateList colorStateList2 = null;
            int i3 = -1;
            for (int i4 = 0; i4 < obtainStyledAttributes2.getIndexCount(); i4++) {
                int index = obtainStyledAttributes2.getIndex(i4);
                switch (index) {
                    case 0:
                        i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                        break;
                    case 1:
                        i3 = obtainStyledAttributes.getInt(index, i3);
                        break;
                    case 2:
                        i = obtainStyledAttributes.getInt(index, i);
                        break;
                    case 3:
                        colorStateList2 = obtainStyledAttributes.getColorStateList(index);
                        break;
                    default:
                        break;
                }
            }
            obtainStyledAttributes2.recycle();
            int i5 = i3;
            colorStateList = colorStateList2;
            resourceId = i;
            i = i5;
        } else {
            resourceId = -1;
            colorStateList = null;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(CtaButton.BACKGROUND_COLOR);
        }
        a(colorStateList);
        b((float) i2);
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        a(typeface, resourceId);
    }

    private void a() {
        if (this.e != null) {
            this.c = null;
            this.g.setEmpty();
        } else {
            this.c = new StaticLayout(this.h, this.b, (int) Math.ceil((double) Layout.getDesiredWidth(this.h, this.b)), this.d, 1.0f, 0.0f, false);
            this.g.set(0, 0, this.c.getWidth(), this.c.getHeight());
        }
        invalidateSelf();
    }

    private boolean a(int[] iArr) {
        int colorForState = this.f.getColorForState(iArr, -1);
        if (this.b.getColor() == colorForState) {
            return false;
        }
        this.b.setColor(colorForState);
        return true;
    }

    private void b(float f) {
        if (f != this.b.getTextSize()) {
            this.b.setTextSize(f);
            a();
        }
    }

    public void a(float f) {
        a(2, f);
    }

    public void a(int i) {
        a(ColorStateList.valueOf(i));
    }

    public void a(int i, float f) {
        b(TypedValue.applyDimension(i, f, this.a.getDisplayMetrics()));
    }

    public void a(ColorStateList colorStateList) {
        this.f = colorStateList;
        a(getState());
    }

    public void a(Typeface typeface) {
        if (this.b.getTypeface() != typeface) {
            this.b.setTypeface(typeface);
            a();
        }
    }

    public void a(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            a(defaultFromStyle);
            int style = ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ -1) & i;
            TextPaint textPaint = this.b;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            this.b.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.b.setFakeBoldText(false);
        this.b.setTextSkewX(0.0f);
        a(typeface);
    }

    public void a(Alignment alignment) {
        if (this.d != alignment) {
            this.d = alignment;
            a();
        }
    }

    public void a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        this.h = charSequence;
        a();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        if (this.e == null) {
            this.c.draw(canvas);
        } else {
            canvas.drawTextOnPath(this.h.toString(), this.e, 0.0f, 0.0f, this.b);
        }
        canvas.restoreToCount(save);
    }

    public int getIntrinsicHeight() {
        return this.g.isEmpty() ? -1 : this.g.bottom - this.g.top;
    }

    public int getIntrinsicWidth() {
        return this.g.isEmpty() ? -1 : this.g.right - this.g.left;
    }

    public int getOpacity() {
        return this.b.getAlpha();
    }

    public boolean isStateful() {
        return this.f.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.g.set(rect);
    }

    protected boolean onStateChange(int[] iArr) {
        return a(iArr);
    }

    public void setAlpha(int i) {
        if (this.b.getAlpha() != i) {
            this.b.setAlpha(i);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.b.getColorFilter() != colorFilter) {
            this.b.setColorFilter(colorFilter);
        }
    }
}
