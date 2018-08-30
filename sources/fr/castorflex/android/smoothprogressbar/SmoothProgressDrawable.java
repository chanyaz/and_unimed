package fr.castorflex.android.smoothprogressbar;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.animation.Interpolator;

public class SmoothProgressDrawable extends Drawable implements Animatable {
    private int[] A;
    private float[] B;
    private final Runnable C;
    private final Rect a;
    private Callbacks b;
    private Interpolator c;
    private Rect d;
    private Paint e;
    private int[] f;
    private int g;
    private boolean h;
    private float i;
    private float j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private boolean p;
    private boolean q;
    private boolean r;
    private float s;
    private boolean t;
    private boolean u;
    private int v;
    private int w;
    private float x;
    private Drawable y;
    private boolean z;

    public interface Callbacks {
        void onStart();

        void onStop();
    }

    private SmoothProgressDrawable(Interpolator interpolator, int i, int i2, int[] iArr, float f, float f2, float f3, float f4, boolean z, boolean z2, Callbacks callbacks, boolean z3, Drawable drawable, boolean z4) {
        this.a = new Rect();
        this.C = new Runnable() {
            public void run() {
                if (SmoothProgressDrawable.this.c()) {
                    SmoothProgressDrawable.a(SmoothProgressDrawable.this, SmoothProgressDrawable.this.o * 0.01f);
                    SmoothProgressDrawable.b(SmoothProgressDrawable.this, SmoothProgressDrawable.this.o * 0.01f);
                    if (SmoothProgressDrawable.this.j >= 1.0f) {
                        SmoothProgressDrawable.this.stop();
                    }
                } else if (SmoothProgressDrawable.this.b()) {
                    SmoothProgressDrawable.b(SmoothProgressDrawable.this, SmoothProgressDrawable.this.n * 0.01f);
                } else {
                    SmoothProgressDrawable.b(SmoothProgressDrawable.this, SmoothProgressDrawable.this.m * 0.01f);
                }
                if (SmoothProgressDrawable.this.i >= SmoothProgressDrawable.this.s) {
                    SmoothProgressDrawable.this.q = true;
                    SmoothProgressDrawable.c(SmoothProgressDrawable.this, SmoothProgressDrawable.this.s);
                }
                if (SmoothProgressDrawable.this.isRunning()) {
                    SmoothProgressDrawable.this.scheduleSelf(SmoothProgressDrawable.this.C, SystemClock.uptimeMillis() + 16);
                }
                SmoothProgressDrawable.this.invalidateSelf();
            }
        };
        this.h = false;
        this.c = interpolator;
        this.l = i;
        this.v = 0;
        this.w = this.l;
        this.k = i2;
        this.m = f2;
        this.n = f3;
        this.o = f4;
        this.p = z;
        this.f = iArr;
        this.g = 0;
        this.r = z2;
        this.t = false;
        this.y = drawable;
        this.x = f;
        this.s = 1.0f / ((float) this.l);
        this.e = new Paint();
        this.e.setStrokeWidth(f);
        this.e.setStyle(Style.STROKE);
        this.e.setDither(false);
        this.e.setAntiAlias(false);
        this.u = z3;
        this.b = callbacks;
        this.z = z4;
        a();
    }

    /* synthetic */ SmoothProgressDrawable(Interpolator interpolator, int i, int i2, int[] iArr, float f, float f2, float f3, float f4, boolean z, boolean z2, Callbacks callbacks, boolean z3, Drawable drawable, boolean z4, AnonymousClass1 anonymousClass1) {
        this(interpolator, i, i2, iArr, f, f2, f3, f4, z, z2, callbacks, z3, drawable, z4);
    }

    private void a(Canvas canvas) {
        float abs;
        float f = 1.0f / ((float) this.l);
        int i = this.g;
        this.B[0] = 0.0f;
        this.B[this.B.length - 1] = 1.0f;
        int i2 = i - 1;
        if (i2 < 0) {
            i2 += this.f.length;
        }
        this.A[0] = this.f[i2];
        int i3 = i;
        for (i2 = 0; i2 < this.l; i2++) {
            this.B[i2 + 1] = this.c.getInterpolation((((float) i2) * f) + this.i);
            this.A[i2 + 1] = this.f[i3];
            i3 = (i3 + 1) % this.f.length;
        }
        this.A[this.A.length - 1] = this.f[i3];
        if (this.p) {
            abs = (float) (this.r ? Math.abs(this.d.left - this.d.right) / 2 : this.d.left);
        } else {
            abs = (float) this.d.left;
        }
        if (this.r) {
            f = (float) (this.p ? this.d.left : Math.abs(this.d.left - this.d.right) / 2);
        } else {
            f = (float) this.d.right;
        }
        this.e.setShader(new LinearGradient(abs, ((float) this.d.centerY()) - (this.x / 2.0f), f, (this.x / 2.0f) + ((float) this.d.centerY()), this.A, this.B, this.r ? TileMode.MIRROR : TileMode.CLAMP));
    }

    private void a(Canvas canvas, float f, float f2) {
        if (this.y != null) {
            this.a.top = (int) ((((float) canvas.getHeight()) - this.x) / 2.0f);
            this.a.bottom = (int) ((((float) canvas.getHeight()) + this.x) / 2.0f);
            this.a.left = 0;
            this.a.right = this.r ? canvas.getWidth() / 2 : canvas.getWidth();
            this.y.setBounds(this.a);
            if (isRunning()) {
                if (c() || b()) {
                    if (f <= f2) {
                        float f3 = f2;
                        f2 = f;
                        f = f3;
                    }
                    if (f2 > 0.0f) {
                        if (this.r) {
                            canvas.save();
                            canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                            if (this.p) {
                                b(canvas, 0.0f, f2);
                                canvas.scale(-1.0f, 1.0f);
                                b(canvas, 0.0f, f2);
                            } else {
                                b(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                                canvas.scale(-1.0f, 1.0f);
                                b(canvas, ((float) (canvas.getWidth() / 2)) - f2, (float) (canvas.getWidth() / 2));
                            }
                            canvas.restore();
                        } else {
                            b(canvas, 0.0f, f2);
                        }
                    }
                    if (f > ((float) canvas.getWidth())) {
                        return;
                    }
                    if (this.r) {
                        canvas.save();
                        canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                        if (this.p) {
                            b(canvas, f, (float) (canvas.getWidth() / 2));
                            canvas.scale(-1.0f, 1.0f);
                            b(canvas, f, (float) (canvas.getWidth() / 2));
                        } else {
                            b(canvas, 0.0f, ((float) (canvas.getWidth() / 2)) - f);
                            canvas.scale(-1.0f, 1.0f);
                            b(canvas, 0.0f, ((float) (canvas.getWidth() / 2)) - f);
                        }
                        canvas.restore();
                        return;
                    }
                    b(canvas, f, (float) canvas.getWidth());
                }
            } else if (this.r) {
                canvas.save();
                canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
                b(canvas, 0.0f, (float) this.a.width());
                canvas.scale(-1.0f, 1.0f);
                b(canvas, 0.0f, (float) this.a.width());
                canvas.restore();
            } else {
                b(canvas, 0.0f, (float) this.a.width());
            }
        }
    }

    private void a(Canvas canvas, int i, float f, float f2, float f3, float f4, int i2) {
        this.e.setColor(this.f[i2]);
        if (!this.r) {
            canvas.drawLine(f, f2, f3, f4, this.e);
        } else if (this.p) {
            canvas.drawLine(((float) i) + f, f2, ((float) i) + f3, f4, this.e);
            canvas.drawLine(((float) i) - f, f2, ((float) i) - f3, f4, this.e);
        } else {
            canvas.drawLine(f, f2, f3, f4, this.e);
            canvas.drawLine(((float) (i * 2)) - f, f2, ((float) (i * 2)) - f3, f4, this.e);
        }
    }

    static /* synthetic */ float b(SmoothProgressDrawable smoothProgressDrawable, float f) {
        float f2 = smoothProgressDrawable.i + f;
        smoothProgressDrawable.i = f2;
        return f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0110  */
    private void b(android.graphics.Canvas r21) {
        /*
        r20 = this;
        r0 = r20;
        r2 = r0.p;
        if (r2 == 0) goto L_0x001e;
    L_0x0006:
        r0 = r20;
        r2 = r0.d;
        r2 = r2.width();
        r2 = (float) r2;
        r3 = 0;
        r0 = r21;
        r0.translate(r2, r3);
        r2 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r21;
        r0.scale(r2, r3);
    L_0x001e:
        r6 = 0;
        r0 = r20;
        r2 = r0.d;
        r4 = r2.width();
        r0 = r20;
        r2 = r0.r;
        if (r2 == 0) goto L_0x002f;
    L_0x002d:
        r4 = r4 / 2;
    L_0x002f:
        r0 = r20;
        r2 = r0.k;
        r2 = r2 + r4;
        r0 = r20;
        r3 = r0.l;
        r15 = r2 + r3;
        r0 = r20;
        r2 = r0.d;
        r16 = r2.centerY();
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r20;
        r3 = r0.l;
        r3 = (float) r3;
        r17 = r2 / r3;
        r2 = 0;
        r5 = 0;
        r0 = r20;
        r9 = r0.g;
        r0 = r20;
        r3 = r0.v;
        r0 = r20;
        r7 = r0.w;
        if (r3 != r7) goto L_0x006a;
    L_0x005b:
        r0 = r20;
        r3 = r0.w;
        r0 = r20;
        r7 = r0.l;
        if (r3 != r7) goto L_0x006a;
    L_0x0065:
        r2 = r21.getWidth();
        r2 = (float) r2;
    L_0x006a:
        r3 = 0;
        r10 = r3;
        r11 = r5;
        r12 = r2;
        r13 = r6;
    L_0x006f:
        r0 = r20;
        r2 = r0.w;
        if (r10 > r2) goto L_0x0127;
    L_0x0075:
        r2 = (float) r10;
        r2 = r2 * r17;
        r0 = r20;
        r3 = r0.i;
        r2 = r2 + r3;
        r3 = 0;
        r5 = r2 - r17;
        r3 = java.lang.Math.max(r3, r5);
        r0 = r20;
        r5 = r0.c;
        r5 = r5.getInterpolation(r3);
        r0 = r20;
        r6 = r0.c;
        r7 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2 = java.lang.Math.min(r2, r7);
        r2 = r6.getInterpolation(r2);
        r2 = r5 - r2;
        r2 = java.lang.Math.abs(r2);
        r5 = (float) r15;
        r2 = r2 * r5;
        r2 = (int) r2;
        r0 = (float) r2;
        r18 = r0;
        r2 = r18 + r3;
        r3 = (float) r15;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 >= 0) goto L_0x0122;
    L_0x00ad:
        r0 = r20;
        r2 = r0.k;
        r2 = (float) r2;
        r0 = r18;
        r2 = java.lang.Math.min(r0, r2);
        r14 = r2;
    L_0x00b9:
        r2 = (r18 > r14 ? 1 : (r18 == r14 ? 0 : -1));
        if (r2 <= 0) goto L_0x0125;
    L_0x00bd:
        r2 = r18 - r14;
    L_0x00bf:
        r19 = r13 + r2;
        r2 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1));
        if (r2 <= 0) goto L_0x0131;
    L_0x00c5:
        r0 = r20;
        r2 = r0.v;
        if (r10 < r2) goto L_0x0131;
    L_0x00cb:
        r0 = r20;
        r2 = r0.c;
        r0 = r20;
        r3 = r0.j;
        r5 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r3 = java.lang.Math.min(r3, r5);
        r2 = r2.getInterpolation(r3);
        r3 = (float) r15;
        r2 = r2 * r3;
        r3 = (float) r4;
        r3 = java.lang.Math.min(r3, r13);
        r5 = java.lang.Math.max(r2, r3);
        r2 = (float) r4;
        r0 = r19;
        r7 = java.lang.Math.min(r2, r0);
        r0 = r16;
        r6 = (float) r0;
        r0 = r16;
        r8 = (float) r0;
        r2 = r20;
        r3 = r21;
        r2.a(r3, r4, r5, r6, r7, r8, r9);
        r0 = r20;
        r2 = r0.v;
        if (r10 != r2) goto L_0x0131;
    L_0x0102:
        r0 = r20;
        r2 = r0.k;
        r2 = (float) r2;
        r12 = r5 - r2;
        r5 = r12;
    L_0x010a:
        r0 = r20;
        r2 = r0.w;
        if (r10 != r2) goto L_0x012f;
    L_0x0110:
        r3 = r13 + r18;
    L_0x0112:
        r6 = r19 + r14;
        r0 = r20;
        r9 = r0.d(r9);
        r2 = r10 + 1;
        r10 = r2;
        r11 = r3;
        r12 = r5;
        r13 = r6;
        goto L_0x006f;
    L_0x0122:
        r2 = 0;
        r14 = r2;
        goto L_0x00b9;
    L_0x0125:
        r2 = 0;
        goto L_0x00bf;
    L_0x0127:
        r0 = r20;
        r1 = r21;
        r0.a(r1, r12, r11);
        return;
    L_0x012f:
        r3 = r11;
        goto L_0x0112;
    L_0x0131:
        r5 = r12;
        goto L_0x010a;
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable.b(android.graphics.Canvas):void");
    }

    private void b(Canvas canvas, float f, float f2) {
        int save = canvas.save();
        canvas.clipRect(f, (float) ((int) ((((float) canvas.getHeight()) - this.x) / 2.0f)), f2, (float) ((int) ((((float) canvas.getHeight()) + this.x) / 2.0f)));
        this.y.draw(canvas);
        canvas.restoreToCount(save);
    }

    static /* synthetic */ float c(SmoothProgressDrawable smoothProgressDrawable, float f) {
        float f2 = smoothProgressDrawable.i - f;
        smoothProgressDrawable.i = f2;
        return f2;
    }

    private int d(int i) {
        int i2 = i + 1;
        return i2 >= this.f.length ? 0 : i2;
    }

    private int e(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.f.length - 1 : i2;
    }

    private void f(int i) {
        g(i);
        this.i = 0.0f;
        this.t = false;
        this.j = 0.0f;
        this.v = 0;
        this.w = 0;
        this.g = i;
    }

    private void g(int i) {
        if (i < 0 || i >= this.f.length) {
            throw new IllegalArgumentException(String.format("Index %d not valid", new Object[]{Integer.valueOf(i)}));
        }
    }

    protected void a() {
        if (this.z) {
            this.A = new int[(this.l + 2)];
            this.B = new float[(this.l + 2)];
            return;
        }
        this.e.setShader(null);
        this.A = null;
        this.B = null;
    }

    public void a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Speed must be >= 0");
        }
        this.m = f;
        invalidateSelf();
    }

    public void a(int i) {
        a(new int[]{i});
    }

    public void a(Drawable drawable) {
        if (this.y != drawable) {
            this.y = drawable;
            invalidateSelf();
        }
    }

    public void a(Interpolator interpolator) {
        if (interpolator == null) {
            throw new IllegalArgumentException("Interpolator cannot be null");
        }
        this.c = interpolator;
        invalidateSelf();
    }

    public void a(Callbacks callbacks) {
        this.b = callbacks;
    }

    public void a(boolean z) {
        if (this.p != z) {
            this.p = z;
            invalidateSelf();
        }
    }

    public void a(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("Colors cannot be null or empty");
        }
        this.g = 0;
        this.f = iArr;
        a();
        invalidateSelf();
    }

    public void b(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStart must be >= 0");
        }
        this.n = f;
        invalidateSelf();
    }

    public void b(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("SectionsCount must be > 0");
        }
        this.l = i;
        this.s = 1.0f / ((float) this.l);
        this.i %= this.s;
        a();
        invalidateSelf();
    }

    public void b(boolean z) {
        if (this.r != z) {
            this.r = z;
            invalidateSelf();
        }
    }

    public boolean b() {
        return this.w < this.l;
    }

    public void c(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("SpeedProgressiveStop must be >= 0");
        }
        this.o = f;
        invalidateSelf();
    }

    public void c(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("SeparatorLength must be >= 0");
        }
        this.k = i;
        invalidateSelf();
    }

    public void c(boolean z) {
        this.u = z;
    }

    public boolean c() {
        return this.t;
    }

    public void d(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("The strokeWidth must be >= 0");
        }
        this.e.setStrokeWidth(f);
        invalidateSelf();
    }

    public void d(boolean z) {
        if (this.z != z) {
            this.z = z;
            a();
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        this.d = getBounds();
        canvas.clipRect(this.d);
        if (this.q) {
            this.g = e(this.g);
            this.q = false;
            if (c()) {
                this.v++;
                if (this.v > this.l) {
                    stop();
                    return;
                }
            }
            if (this.w < this.l) {
                this.w++;
            }
        }
        if (this.z) {
            a(canvas);
        }
        b(canvas);
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.h;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        this.h = true;
        super.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.e.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.e.setColorFilter(colorFilter);
    }

    public void start() {
        if (this.u) {
            f(0);
        }
        if (!isRunning()) {
            if (this.b != null) {
                this.b.onStart();
            }
            scheduleSelf(this.C, SystemClock.uptimeMillis() + 16);
            invalidateSelf();
        }
    }

    public void stop() {
        if (isRunning()) {
            if (this.b != null) {
                this.b.onStop();
            }
            this.h = false;
            unscheduleSelf(this.C);
        }
    }
}
