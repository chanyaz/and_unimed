package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.b.c;
import android.support.v7.b.d;

class RoundRectDrawableWithShadow extends Drawable {
    static RoundRectHelper a;
    private static final double b = Math.cos(Math.toRadians(45.0d));
    private final int c;
    private Paint d;
    private Paint e;
    private Paint f;
    private final RectF g;
    private float h;
    private Path i;
    private float j;
    private float k;
    private float l;
    private ColorStateList m;
    private boolean n = true;
    private final int o;
    private final int p;
    private boolean q = true;
    private boolean r = false;

    interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.o = resources.getColor(c.cardview_shadow_start_color);
        this.p = resources.getColor(c.cardview_shadow_end_color);
        this.c = resources.getDimensionPixelSize(d.cardview_compat_inset_shadow);
        this.d = new Paint(5);
        b(colorStateList);
        this.e = new Paint(5);
        this.e.setStyle(Style.FILL);
        this.h = (float) ((int) (0.5f + f));
        this.g = new RectF();
        this.f = new Paint(this.e);
        this.f.setAntiAlias(false);
        a(f2, f3);
    }

    static float a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - b) * ((double) f2))) : 1.5f * f;
    }

    private void a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        } else if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        } else {
            float d = (float) d(f);
            float d2 = (float) d(f2);
            if (d > d2) {
                if (!this.r) {
                    this.r = true;
                }
                d = d2;
            }
            if (this.l != d || this.j != d2) {
                this.l = d;
                this.j = d2;
                this.k = (float) ((int) (((d * 1.5f) + ((float) this.c)) + 0.5f));
                this.n = true;
                invalidateSelf();
            }
        }
    }

    private void a(Canvas canvas) {
        float f = (-this.h) - this.k;
        float f2 = (this.h + ((float) this.c)) + (this.l / 2.0f);
        Object obj = this.g.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.g.height() - (2.0f * f2) > 0.0f ? 1 : null;
        int save = canvas.save();
        canvas.translate(this.g.left + f2, this.g.top + f2);
        canvas.drawPath(this.i, this.e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.g.width() - (2.0f * f2), -this.h, this.f);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.g.right - f2, this.g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.i, this.e);
        if (obj != null) {
            canvas.drawRect(0.0f, f, this.g.width() - (2.0f * f2), this.k + (-this.h), this.f);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        canvas.translate(this.g.left + f2, this.g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.i, this.e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.g.height() - (2.0f * f2), -this.h, this.f);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.g.right - f2, this.g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.i, this.e);
        if (obj2 != null) {
            canvas.drawRect(0.0f, f, this.g.height() - (2.0f * f2), -this.h, this.f);
        }
        canvas.restoreToCount(save2);
    }

    static float b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - b) * ((double) f2))) : f;
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.m = colorStateList;
        this.d.setColor(this.m.getColorForState(getState(), this.m.getDefaultColor()));
    }

    private void b(Rect rect) {
        float f = this.j * 1.5f;
        this.g.set(((float) rect.left) + this.j, ((float) rect.top) + f, ((float) rect.right) - this.j, ((float) rect.bottom) - f);
        g();
    }

    private int d(float f) {
        int i = (int) (0.5f + f);
        return i % 2 == 1 ? i - 1 : i;
    }

    private void g() {
        RectF rectF = new RectF(-this.h, -this.h, this.h, this.h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.k, -this.k);
        if (this.i == null) {
            this.i = new Path();
        } else {
            this.i.reset();
        }
        this.i.setFillType(FillType.EVEN_ODD);
        this.i.moveTo(-this.h, 0.0f);
        this.i.rLineTo(-this.k, 0.0f);
        this.i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.i.arcTo(rectF, 270.0f, -90.0f, false);
        this.i.close();
        float f = this.h / (this.h + this.k);
        float[] fArr = new float[]{0.0f, f, 1.0f};
        f = 0.0f;
        this.e.setShader(new RadialGradient(0.0f, f, this.h + this.k, new int[]{this.o, this.o, this.p}, fArr, TileMode.CLAMP));
        float f2 = 0.0f;
        this.f.setShader(new LinearGradient(0.0f, (-this.h) + this.k, f2, (-this.h) - this.k, new int[]{this.o, this.o, this.p}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f.setAntiAlias(false);
    }

    float a() {
        return this.h;
    }

    void a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (float) ((int) (0.5f + f));
        if (this.h != f2) {
            this.h = f2;
            this.n = true;
            invalidateSelf();
        }
    }

    void a(@Nullable ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    void a(Rect rect) {
        getPadding(rect);
    }

    void a(boolean z) {
        this.q = z;
        invalidateSelf();
    }

    float b() {
        return this.l;
    }

    void b(float f) {
        a(f, this.j);
    }

    float c() {
        return this.j;
    }

    void c(float f) {
        a(this.l, f);
    }

    float d() {
        return (Math.max(this.j, (this.h + ((float) this.c)) + (this.j / 2.0f)) * 2.0f) + ((this.j + ((float) this.c)) * 2.0f);
    }

    public void draw(Canvas canvas) {
        if (this.n) {
            b(getBounds());
            this.n = false;
        }
        canvas.translate(0.0f, this.l / 2.0f);
        a(canvas);
        canvas.translate(0.0f, (-this.l) / 2.0f);
        a.drawRoundRect(canvas, this.g, this.h, this.d);
    }

    float e() {
        return (Math.max(this.j, (this.h + ((float) this.c)) + ((this.j * 1.5f) / 2.0f)) * 2.0f) + (((this.j * 1.5f) + ((float) this.c)) * 2.0f);
    }

    ColorStateList f() {
        return this.m;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.j, this.h, this.q));
        int ceil2 = (int) Math.ceil((double) b(this.j, this.h, this.q));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public boolean isStateful() {
        return (this.m != null && this.m.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.n = true;
    }

    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.m.getColorForState(iArr, this.m.getDefaultColor());
        if (this.d.getColor() == colorForState) {
            return false;
        }
        this.d.setColor(colorForState);
        this.n = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i) {
        this.d.setAlpha(i);
        this.e.setAlpha(i);
        this.f.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.d.setColorFilter(colorFilter);
    }
}
