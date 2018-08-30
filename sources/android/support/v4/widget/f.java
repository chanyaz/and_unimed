package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;

class f {
    final RectF a = new RectF();
    final Paint b = new Paint();
    final Paint c = new Paint();
    final Paint d = new Paint();
    float e = 0.0f;
    float f = 0.0f;
    float g = 0.0f;
    float h = 5.0f;
    int[] i;
    int j;
    float k;
    float l;
    float m;
    boolean n;
    Path o;
    float p = 1.0f;
    float q;
    int r;
    int s;
    int t = 255;
    int u;

    f() {
        this.b.setStrokeCap(Cap.SQUARE);
        this.b.setAntiAlias(true);
        this.b.setStyle(Style.STROKE);
        this.c.setStyle(Style.FILL);
        this.c.setAntiAlias(true);
        this.d.setColor(0);
    }

    int a() {
        return this.i[b()];
    }

    void a(float f) {
        this.h = f;
        this.b.setStrokeWidth(f);
    }

    void a(float f, float f2) {
        this.r = (int) f;
        this.s = (int) f2;
    }

    void a(int i) {
        this.u = i;
    }

    void a(Canvas canvas, float f, float f2, RectF rectF) {
        if (this.n) {
            if (this.o == null) {
                this.o = new Path();
                this.o.setFillType(FillType.EVEN_ODD);
            } else {
                this.o.reset();
            }
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f3 = (((float) this.r) * this.p) / 2.0f;
            this.o.moveTo(0.0f, 0.0f);
            this.o.lineTo(((float) this.r) * this.p, 0.0f);
            this.o.lineTo((((float) this.r) * this.p) / 2.0f, ((float) this.s) * this.p);
            this.o.offset((min + rectF.centerX()) - f3, rectF.centerY() + (this.h / 2.0f));
            this.o.close();
            this.c.setColor(this.u);
            this.c.setAlpha(this.t);
            canvas.save();
            canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
            canvas.drawPath(this.o, this.c);
            canvas.restore();
        }
    }

    void a(Canvas canvas, Rect rect) {
        RectF rectF = this.a;
        float f = this.q + (this.h / 2.0f);
        if (this.q <= 0.0f) {
            f = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.r) * this.p) / 2.0f, this.h / 2.0f);
        }
        rectF.set(((float) rect.centerX()) - f, ((float) rect.centerY()) - f, ((float) rect.centerX()) + f, f + ((float) rect.centerY()));
        float f2 = (this.e + this.g) * 360.0f;
        float f3 = ((this.f + this.g) * 360.0f) - f2;
        this.b.setColor(this.u);
        this.b.setAlpha(this.t);
        f = this.h / 2.0f;
        rectF.inset(f, f);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.d);
        rectF.inset(-f, -f);
        canvas.drawArc(rectF, f2, f3, false, this.b);
        a(canvas, f2, f3, rectF);
    }

    void a(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }

    void a(boolean z) {
        if (this.n != z) {
            this.n = z;
        }
    }

    void a(@NonNull int[] iArr) {
        this.i = iArr;
        b(0);
    }

    int b() {
        return (this.j + 1) % this.i.length;
    }

    void b(float f) {
        this.e = f;
    }

    void b(int i) {
        this.j = i;
        this.u = this.i[this.j];
    }

    void c() {
        b(b());
    }

    void c(float f) {
        this.f = f;
    }

    void c(int i) {
        this.t = i;
    }

    int d() {
        return this.t;
    }

    void d(float f) {
        this.g = f;
    }

    float e() {
        return this.e;
    }

    void e(float f) {
        this.q = f;
    }

    float f() {
        return this.k;
    }

    void f(float f) {
        if (f != this.p) {
            this.p = f;
        }
    }

    float g() {
        return this.l;
    }

    int h() {
        return this.i[this.j];
    }

    float i() {
        return this.f;
    }

    float j() {
        return this.m;
    }

    void k() {
        this.k = this.e;
        this.l = this.f;
        this.m = this.g;
    }

    void l() {
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        b(0.0f);
        c(0.0f);
        d(0.0f);
    }
}
