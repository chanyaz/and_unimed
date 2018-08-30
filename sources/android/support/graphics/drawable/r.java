package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

class r extends ConstantState {
    int a;
    q b;
    ColorStateList c;
    Mode d;
    boolean e;
    Bitmap f;
    ColorStateList g;
    Mode h;
    int i;
    boolean j;
    boolean k;
    Paint l;

    public r() {
        this.c = null;
        this.d = l.a;
        this.b = new q();
    }

    public r(r rVar) {
        this.c = null;
        this.d = l.a;
        if (rVar != null) {
            this.a = rVar.a;
            this.b = new q(rVar.b);
            if (rVar.b.n != null) {
                this.b.n = new Paint(rVar.b.n);
            }
            if (rVar.b.m != null) {
                this.b.m = new Paint(rVar.b.m);
            }
            this.c = rVar.c;
            this.d = rVar.d;
            this.e = rVar.e;
        }
    }

    public Paint a(ColorFilter colorFilter) {
        if (!a() && colorFilter == null) {
            return null;
        }
        if (this.l == null) {
            this.l = new Paint();
            this.l.setFilterBitmap(true);
        }
        this.l.setAlpha(this.b.getRootAlpha());
        this.l.setColorFilter(colorFilter);
        return this.l;
    }

    public void a(int i, int i2) {
        this.f.eraseColor(0);
        this.b.a(new Canvas(this.f), i, i2, null);
    }

    public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        canvas.drawBitmap(this.f, null, rect, a(colorFilter));
    }

    public boolean a() {
        return this.b.getRootAlpha() < 255;
    }

    public void b(int i, int i2) {
        if (this.f == null || !c(i, i2)) {
            this.f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.k = true;
        }
    }

    public boolean b() {
        return !this.k && this.g == this.c && this.h == this.d && this.j == this.e && this.i == this.b.getRootAlpha();
    }

    public void c() {
        this.g = this.c;
        this.h = this.d;
        this.i = this.b.getRootAlpha();
        this.j = this.e;
        this.k = false;
    }

    public boolean c(int i, int i2) {
        return i == this.f.getWidth() && i2 == this.f.getHeight();
    }

    public int getChangingConfigurations() {
        return this.a;
    }

    public Drawable newDrawable() {
        return new l(this);
    }

    public Drawable newDrawable(Resources resources) {
        return new l(this);
    }
}
