package com.mikepenz.iconics;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.NonNull;
import android.support.v4.content.a;
import android.text.TextPaint;
import android.util.Log;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.iconics.typeface.ITypeface;
import com.mikepenz.iconics.utils.e;

public class d extends Drawable {
    private ColorFilter A;
    private Context a;
    private int b = -1;
    private int c = -1;
    private boolean d = false;
    private int e;
    private Paint f;
    private int g;
    private Paint h;
    private int i;
    private Paint j;
    private int k = -1;
    private int l = -1;
    private Rect m;
    private RectF n;
    private Path o;
    private int p;
    private int q;
    private int r = 0;
    private int s = 0;
    private int t = 255;
    private boolean u;
    private IIcon v;
    private String w;
    private ColorStateList x;
    private Mode y = Mode.SRC_IN;
    private ColorFilter z;

    public d(Context context) {
        this.a = context.getApplicationContext();
        c();
        a(Character.valueOf(' '));
    }

    public d(Context context, IIcon iIcon) {
        this.a = context.getApplicationContext();
        c();
        a(iIcon);
    }

    public d(Context context, Character ch) {
        this.a = context.getApplicationContext();
        c();
        a(ch);
    }

    public d(Context context, String str) {
        this.a = context.getApplicationContext();
        c();
        try {
            ITypeface a = a.a(context, str.substring(0, 3));
            str = str.replace("-", "_");
            a(a.getIcon(str));
        } catch (Exception e) {
            Log.e(a.a, "Wrong icon name: " + str);
        }
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void a(Rect rect) {
        if (this.p >= 0 && this.p * 2 <= rect.width() && this.p * 2 <= rect.height()) {
            this.m.set(rect.left + this.p, rect.top + this.p, rect.right - this.p, rect.bottom - this.p);
        }
    }

    private void b(Rect rect) {
        float height = ((float) rect.height()) * ((float) (this.d ? 1 : 2));
        this.f.setTextSize(height);
        String valueOf = this.v != null ? String.valueOf(this.v.getCharacter()) : String.valueOf(this.w);
        this.f.getTextPath(valueOf, 0, valueOf.length(), 0.0f, (float) rect.height(), this.o);
        this.o.computeBounds(this.n, true);
        if (!this.d) {
            float width = ((float) this.m.width()) / this.n.width();
            float height2 = ((float) this.m.height()) / this.n.height();
            if (width >= height2) {
                width = height2;
            }
            this.f.setTextSize(width * height);
            this.f.getTextPath(valueOf, 0, valueOf.length(), 0.0f, (float) rect.height(), this.o);
            this.o.computeBounds(this.n, true);
        }
    }

    private void c() {
        this.f = new TextPaint(1);
        this.f.setStyle(Style.FILL);
        this.f.setTextAlign(Align.CENTER);
        this.f.setUnderlineText(false);
        this.f.setAntiAlias(true);
        this.j = new Paint(1);
        this.h = new Paint(1);
        this.h.setStyle(Style.STROKE);
        this.o = new Path();
        this.n = new RectF();
        this.m = new Rect();
    }

    private void c(Rect rect) {
        this.o.offset(((((float) rect.centerX()) - (this.n.width() / 2.0f)) - this.n.left) + ((float) this.r), ((((float) rect.centerY()) - (this.n.height() / 2.0f)) - this.n.top) + ((float) this.s));
    }

    public d a() {
        i(24);
        f(1);
        return this;
    }

    public d a(@ColorInt int i) {
        this.f.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.e = i;
        setAlpha(Color.alpha(i));
        invalidateSelf();
        return this;
    }

    public d a(Typeface typeface) {
        this.f.setTypeface(typeface);
        return this;
    }

    public d a(IIcon iIcon) {
        this.v = iIcon;
        this.w = null;
        this.f.setTypeface(iIcon.getTypeface().getTypeface(this.a));
        invalidateSelf();
        return this;
    }

    public d a(Character ch) {
        return a(ch.toString());
    }

    public d a(String str) {
        this.w = str;
        this.v = null;
        this.f.setTypeface(Typeface.DEFAULT);
        invalidateSelf();
        return this;
    }

    public d a(boolean z) {
        if (this.u != z) {
            this.u = z;
            if (this.u) {
                this.p += this.q;
            } else {
                this.p -= this.q;
            }
            invalidateSelf();
        }
        return this;
    }

    /* renamed from: b */
    public d clone() {
        d a = new d(this.a).g(this.p).q(this.k).r(this.l).k(this.b).l(this.c).c(this.r).d(this.s).m(this.g).w(this.q).o(this.i).a(this.e).x(this.t).a(this.u).a(this.f.getTypeface());
        if (this.v != null) {
            a.a(this.v);
        } else if (this.w != null) {
            a.a(this.w);
        }
        return a;
    }

    public d b(@ColorRes int i) {
        return a(a.c(this.a, i));
    }

    public d c(@Dimension(unit = 1) int i) {
        this.r = i;
        return this;
    }

    public void clearColorFilter() {
        this.A = null;
        invalidateSelf();
    }

    public d d(@Dimension(unit = 1) int i) {
        this.s = i;
        return this;
    }

    public void draw(Canvas canvas) {
        if (this.v != null || this.w != null) {
            Rect bounds = getBounds();
            a(bounds);
            b(bounds);
            c(bounds);
            if (this.j != null && this.l > -1 && this.k > -1) {
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bounds.width(), (float) bounds.height()), (float) this.k, (float) this.l, this.j);
            }
            this.o.close();
            if (this.u) {
                canvas.drawPath(this.o, this.h);
            }
            this.f.setAlpha(this.t);
            this.f.setColorFilter(this.A == null ? this.z : this.A);
            canvas.drawPath(this.o, this.f);
        }
    }

    public d e(@DimenRes int i) {
        return g(this.a.getResources().getDimensionPixelSize(i));
    }

    public d f(@Dimension(unit = 0) int i) {
        return g(e.a(this.a, (float) i));
    }

    public d g(@Dimension(unit = 1) int i) {
        if (this.p != i) {
            this.p = i;
            if (this.u) {
                this.p += this.q;
            }
            invalidateSelf();
        }
        return this;
    }

    public int getAlpha() {
        return this.t;
    }

    public int getIntrinsicHeight() {
        return this.c;
    }

    public int getIntrinsicWidth() {
        return this.b;
    }

    public int getOpacity() {
        return this.t;
    }

    public d h(@DimenRes int i) {
        return j(this.a.getResources().getDimensionPixelSize(i));
    }

    public d i(@Dimension(unit = 0) int i) {
        return j(e.a(this.a, (float) i));
    }

    public boolean isStateful() {
        return true;
    }

    public d j(@Dimension(unit = 1) int i) {
        this.b = i;
        this.c = i;
        setBounds(0, 0, i, i);
        invalidateSelf();
        return this;
    }

    public d k(@Dimension(unit = 1) int i) {
        this.b = i;
        setBounds(0, 0, this.b, this.c);
        invalidateSelf();
        return this;
    }

    public d l(@Dimension(unit = 1) int i) {
        this.c = i;
        setBounds(0, 0, this.b, this.c);
        invalidateSelf();
        return this;
    }

    public d m(@ColorInt int i) {
        this.h.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.h.setAlpha(Color.alpha(i));
        this.g = i;
        invalidateSelf();
        return this;
    }

    public d n(@ColorRes int i) {
        return m(a.c(this.a, i));
    }

    public d o(@ColorInt int i) {
        this.j.setColor(i);
        this.i = i;
        this.k = 0;
        this.l = 0;
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        c(rect);
        this.o.close();
        super.onBoundsChange(rect);
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.x == null || this.y == null) {
            return false;
        }
        this.z = a(this.x, this.y);
        invalidateSelf();
        return true;
    }

    public d p(@ColorRes int i) {
        return o(a.c(this.a, i));
    }

    public d q(@Dimension(unit = 1) int i) {
        this.k = i;
        return this;
    }

    public d r(@Dimension(unit = 1) int i) {
        this.l = i;
        return this;
    }

    public d s(@Dimension(unit = 0) int i) {
        this.k = e.a(this.a, (float) i);
        this.l = this.k;
        return this;
    }

    public void setAlpha(int i) {
        this.f.setAlpha(i);
        this.t = i;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.A = colorFilter;
        invalidateSelf();
    }

    public boolean setState(int[] iArr) {
        setAlpha(this.t);
        return super.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.x = colorStateList;
        this.z = a(colorStateList, this.y);
        invalidateSelf();
    }

    public void setTintMode(@NonNull Mode mode) {
        this.y = mode;
        this.z = a(this.x, mode);
        invalidateSelf();
    }

    public d t(@Dimension(unit = 1) int i) {
        this.k = i;
        this.l = this.k;
        return this;
    }

    public d u(@DimenRes int i) {
        return w(this.a.getResources().getDimensionPixelSize(i));
    }

    public d v(@Dimension(unit = 0) int i) {
        return w(e.a(this.a, (float) i));
    }

    public d w(@Dimension(unit = 1) int i) {
        this.q = i;
        this.h.setStrokeWidth((float) this.q);
        a(true);
        invalidateSelf();
        return this;
    }

    public d x(int i) {
        setAlpha(i);
        return this;
    }
}
