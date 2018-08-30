package android.support.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PathMeasure;
import android.support.v4.util.a;

class q {
    private static final Matrix k = new Matrix();
    final o a;
    float b;
    float c;
    float d;
    float e;
    int f;
    String g;
    final a<String, Object> h;
    private final Path i;
    private final Path j;
    private final Matrix l;
    private Paint m;
    private Paint n;
    private PathMeasure o;
    private int p;

    public q() {
        this.l = new Matrix();
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 255;
        this.g = null;
        this.h = new a();
        this.a = new o();
        this.i = new Path();
        this.j = new Path();
    }

    public q(q qVar) {
        this.l = new Matrix();
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 255;
        this.g = null;
        this.h = new a();
        this.a = new o(qVar.a, this.h);
        this.i = new Path(qVar.i);
        this.j = new Path(qVar.j);
        this.b = qVar.b;
        this.c = qVar.c;
        this.d = qVar.d;
        this.e = qVar.e;
        this.p = qVar.p;
        this.f = qVar.f;
        this.g = qVar.g;
        if (qVar.g != null) {
            this.h.put(qVar.g, this);
        }
    }

    private static float a(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    private float a(Matrix matrix) {
        float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
        matrix.mapVectors(fArr);
        float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
        float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
        float a = a(fArr[0], fArr[1], fArr[2], fArr[3]);
        hypot = Math.max(hypot, hypot2);
        return hypot > 0.0f ? Math.abs(a) / hypot : 0.0f;
    }

    private void a(o oVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        oVar.d.set(matrix);
        oVar.d.preConcat(oVar.k);
        canvas.save();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < oVar.a.size()) {
                Object obj = oVar.a.get(i4);
                if (obj instanceof o) {
                    a((o) obj, oVar.d, canvas, i, i2, colorFilter);
                } else if (obj instanceof p) {
                    a(oVar, (p) obj, canvas, i, i2, colorFilter);
                }
                i3 = i4 + 1;
            } else {
                canvas.restore();
                return;
            }
        }
    }

    private void a(o oVar, p pVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        float f = ((float) i) / this.d;
        float f2 = ((float) i2) / this.e;
        float min = Math.min(f, f2);
        Matrix a = oVar.d;
        this.l.set(a);
        this.l.postScale(f, f2);
        f2 = a(a);
        if (f2 != 0.0f) {
            pVar.a(this.i);
            Path path = this.i;
            this.j.reset();
            if (pVar.a()) {
                this.j.addPath(path, this.l);
                canvas.clipPath(this.j);
                return;
            }
            n nVar = (n) pVar;
            if (!(nVar.g == 0.0f && nVar.h == 1.0f)) {
                float f3 = (nVar.g + nVar.i) % 1.0f;
                float f4 = (nVar.h + nVar.i) % 1.0f;
                if (this.o == null) {
                    this.o = new PathMeasure();
                }
                this.o.setPath(this.i, false);
                float length = this.o.getLength();
                f3 *= length;
                f4 *= length;
                path.reset();
                if (f3 > f4) {
                    this.o.getSegment(f3, length, path, true);
                    this.o.getSegment(0.0f, f4, path, true);
                } else {
                    this.o.getSegment(f3, f4, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.j.addPath(path, this.l);
            if (nVar.c != 0) {
                if (this.n == null) {
                    this.n = new Paint();
                    this.n.setStyle(Style.FILL);
                    this.n.setAntiAlias(true);
                }
                Paint paint = this.n;
                paint.setColor(l.a(nVar.c, nVar.f));
                paint.setColorFilter(colorFilter);
                this.j.setFillType(nVar.e == 0 ? FillType.WINDING : FillType.EVEN_ODD);
                canvas.drawPath(this.j, paint);
            }
            if (nVar.a != 0) {
                if (this.m == null) {
                    this.m = new Paint();
                    this.m.setStyle(Style.STROKE);
                    this.m.setAntiAlias(true);
                }
                Paint paint2 = this.m;
                if (nVar.k != null) {
                    paint2.setStrokeJoin(nVar.k);
                }
                if (nVar.j != null) {
                    paint2.setStrokeCap(nVar.j);
                }
                paint2.setStrokeMiter(nVar.l);
                paint2.setColor(l.a(nVar.a, nVar.d));
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth((f2 * min) * nVar.b);
                canvas.drawPath(this.j, paint2);
            }
        }
    }

    public void a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        a(this.a, k, canvas, i, i2, colorFilter);
    }

    public float getAlpha() {
        return ((float) getRootAlpha()) / 255.0f;
    }

    public int getRootAlpha() {
        return this.f;
    }

    public void setAlpha(float f) {
        setRootAlpha((int) (255.0f * f));
    }

    public void setRootAlpha(int i) {
        this.f = i;
    }
}
