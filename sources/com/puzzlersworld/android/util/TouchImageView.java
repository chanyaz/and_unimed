package com.puzzlersworld.android.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.ScaleGestureDetector;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class TouchImageView extends ImageView {
    private OnTouchListener A = null;
    private OnTouchImageViewListener B = null;
    private float a;
    private Matrix b;
    private Matrix c;
    private t d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float[] i;
    private Context j;
    private p k;
    private ScaleType l;
    private boolean m;
    private boolean n;
    private u o;
    private int p;
    private int q;
    private int r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private ScaleGestureDetector x;
    private GestureDetector y;
    private OnDoubleTapListener z = null;

    /* renamed from: com.puzzlersworld.android.util.TouchImageView$1 */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[ScaleType.values().length];

        static {
            try {
                a[ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public interface OnTouchImageViewListener {
        void onMove();
    }

    public TouchImageView(Context context) {
        super(context);
        a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private int a(int i, int i2, int i3) {
        switch (i) {
            case Integer.MIN_VALUE:
                return Math.min(i3, i2);
            case 0:
                return i3;
            default:
                return i2;
        }
    }

    private PointF a(float f, float f2) {
        this.b.getValues(this.i);
        float intrinsicWidth = f / ((float) getDrawable().getIntrinsicWidth());
        float intrinsicHeight = f2 / ((float) getDrawable().getIntrinsicHeight());
        return new PointF((intrinsicWidth * getImageWidth()) + this.i[2], (intrinsicHeight * getImageHeight()) + this.i[5]);
    }

    private PointF a(float f, float f2, boolean z) {
        this.b.getValues(this.i);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float f3 = this.i[2];
        float imageWidth = ((f - f3) * intrinsicWidth) / getImageWidth();
        f3 = ((f2 - this.i[5]) * intrinsicHeight) / getImageHeight();
        if (z) {
            imageWidth = Math.min(Math.max(imageWidth, 0.0f), intrinsicWidth);
            f3 = Math.min(Math.max(f3, 0.0f), intrinsicHeight);
        }
        return new PointF(imageWidth, f3);
    }

    private void a(double d, float f, float f2, boolean z) {
        float f3;
        float f4;
        if (z) {
            f3 = this.g;
            f4 = this.h;
        } else {
            f3 = this.e;
            f4 = this.f;
        }
        float f5 = this.a;
        this.a = (float) (((double) this.a) * d);
        if (this.a > f4) {
            this.a = f4;
            d = (double) (f4 / f5);
        } else if (this.a < f3) {
            this.a = f3;
            d = (double) (f3 / f5);
        }
        this.b.postScale((float) d, (float) d, f, f2);
        e();
    }

    private void a(int i, float f, float f2, float f3, int i2, int i3, int i4) {
        if (f3 < ((float) i3)) {
            this.i[i] = (((float) i3) - (((float) i4) * this.i[0])) * 0.5f;
        } else if (f > 0.0f) {
            this.i[i] = -((f3 - ((float) i3)) * 0.5f);
        } else {
            this.i[i] = -((((Math.abs(f) + (((float) i2) * 0.5f)) / f2) * f3) - (((float) i3) * 0.5f));
        }
    }

    private void a(Context context) {
        super.setClickable(true);
        this.j = context;
        this.x = new ScaleGestureDetector(context, new s(this, null));
        this.y = new GestureDetector(context, new q(this, null));
        this.b = new Matrix();
        this.c = new Matrix();
        this.i = new float[9];
        this.a = 1.0f;
        if (this.l == null) {
            this.l = ScaleType.FIT_CENTER;
        }
        this.e = 1.0f;
        this.f = 3.0f;
        this.g = 0.75f * this.e;
        this.h = 1.25f * this.f;
        setImageMatrix(this.b);
        setScaleType(ScaleType.MATRIX);
        setState(t.NONE);
        this.n = false;
        super.setOnTouchListener(new r(this, null));
    }

    @TargetApi(16)
    private void a(Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            postOnAnimation(runnable);
        } else {
            postDelayed(runnable, 16);
        }
    }

    private float b(float f, float f2, float f3) {
        float f4;
        float f5;
        if (f3 <= f2) {
            f4 = f2 - f3;
            f5 = 0.0f;
        } else {
            f5 = f2 - f3;
            f4 = 0.0f;
        }
        return f < f5 ? (-f) + f5 : f > f4 ? (-f) + f4 : 0.0f;
    }

    private float c(float f, float f2, float f3) {
        return f3 <= f2 ? 0.0f : f;
    }

    private void c() {
        if (this.b != null && this.q != 0 && this.p != 0) {
            this.b.getValues(this.i);
            this.c.setValues(this.i);
            this.w = this.u;
            this.v = this.t;
            this.s = this.q;
            this.r = this.p;
        }
    }

    private void d() {
        this.b.getValues(this.i);
        float f = this.i[2];
        float f2 = this.i[5];
        f = b(f, (float) this.p, getImageWidth());
        f2 = b(f2, (float) this.q, getImageHeight());
        if (f != 0.0f || f2 != 0.0f) {
            this.b.postTranslate(f, f2);
        }
    }

    private void e() {
        d();
        this.b.getValues(this.i);
        if (getImageWidth() < ((float) this.p)) {
            this.i[2] = (((float) this.p) - getImageWidth()) / 2.0f;
        }
        if (getImageHeight() < ((float) this.q)) {
            this.i[5] = (((float) this.q) - getImageHeight()) / 2.0f;
        }
        this.b.setValues(this.i);
    }

    private void f() {
        Drawable drawable = getDrawable();
        if (drawable != null && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0 && this.b != null && this.c != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            float f = ((float) this.p) / ((float) intrinsicWidth);
            float f2 = ((float) this.q) / ((float) intrinsicHeight);
            switch (AnonymousClass1.a[this.l.ordinal()]) {
                case 1:
                    f2 = 1.0f;
                    f = 1.0f;
                    break;
                case 2:
                    f2 = Math.max(f, f2);
                    f = f2;
                    break;
                case 3:
                    f2 = Math.min(1.0f, Math.min(f, f2));
                    f = f2;
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
            }
            f2 = Math.min(f, f2);
            f = f2;
            float f3 = ((float) this.p) - (((float) intrinsicWidth) * f);
            float f4 = ((float) this.q) - (((float) intrinsicHeight) * f2);
            this.t = ((float) this.p) - f3;
            this.u = ((float) this.q) - f4;
            if (a() || this.m) {
                if (this.v == 0.0f || this.w == 0.0f) {
                    c();
                }
                this.c.getValues(this.i);
                this.i[0] = (this.t / ((float) intrinsicWidth)) * this.a;
                this.i[4] = (this.u / ((float) intrinsicHeight)) * this.a;
                f = this.i[2];
                float f5 = this.i[5];
                a(2, f, this.a * this.v, getImageWidth(), this.r, this.p, intrinsicWidth);
                a(5, f5, this.w * this.a, getImageHeight(), this.s, this.q, intrinsicHeight);
                this.b.setValues(this.i);
            } else {
                this.b.setScale(f, f2);
                this.b.postTranslate(f3 / 2.0f, f4 / 2.0f);
                this.a = 1.0f;
            }
            d();
            setImageMatrix(this.b);
        }
    }

    private float getImageHeight() {
        return this.u * this.a;
    }

    private float getImageWidth() {
        return this.t * this.a;
    }

    private void setState(t tVar) {
        this.d = tVar;
    }

    public void a(float f, float f2, float f3) {
        a(f, f2, f3, this.l);
    }

    public void a(float f, float f2, float f3, ScaleType scaleType) {
        if (this.n) {
            if (scaleType != this.l) {
                setScaleType(scaleType);
            }
            b();
            a((double) f, (float) (this.p / 2), (float) (this.q / 2), true);
            this.b.getValues(this.i);
            this.i[2] = -((getImageWidth() * f2) - (((float) this.p) * 0.5f));
            this.i[5] = -((getImageHeight() * f3) - (((float) this.q) * 0.5f));
            this.b.setValues(this.i);
            d();
            setImageMatrix(this.b);
            return;
        }
        this.o = new u(this, f, f2, f3, scaleType);
    }

    public boolean a() {
        return this.a != 1.0f;
    }

    public void b() {
        this.a = 1.0f;
        f();
    }

    public boolean canScrollHorizontally(int i) {
        this.b.getValues(this.i);
        float f = this.i[2];
        return getImageWidth() < ((float) this.p) ? false : (f < -1.0f || i >= 0) ? (Math.abs(f) + ((float) this.p)) + 1.0f < getImageWidth() || i <= 0 : false;
    }

    public float getCurrentZoom() {
        return this.a;
    }

    public float getMaxZoom() {
        return this.f;
    }

    public float getMinZoom() {
        return this.e;
    }

    public ScaleType getScaleType() {
        return this.l;
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF a = a((float) (this.p / 2), (float) (this.q / 2), true);
        a.x /= (float) intrinsicWidth;
        a.y /= (float) intrinsicHeight;
        return a;
    }

    public RectF getZoomedRect() {
        if (this.l == ScaleType.FIT_XY) {
            throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
        }
        PointF a = a(0.0f, 0.0f, true);
        PointF a2 = a((float) this.p, (float) this.q, true);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        return new RectF(a.x / intrinsicWidth, a.y / intrinsicHeight, a2.x / intrinsicWidth, a2.y / intrinsicHeight);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        c();
    }

    protected void onDraw(Canvas canvas) {
        this.n = true;
        this.m = true;
        if (this.o != null) {
            a(this.o.a, this.o.b, this.o.c, this.o.d);
            this.o = null;
        }
        super.onDraw(canvas);
    }

    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (drawable == null || drawable.getIntrinsicWidth() == 0 || drawable.getIntrinsicHeight() == 0) {
            setMeasuredDimension(0, 0);
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int size = MeasureSpec.getSize(i);
        int mode = MeasureSpec.getMode(i);
        int size2 = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i2);
        this.p = a(mode, size, intrinsicWidth);
        this.q = a(mode2, size2, intrinsicHeight);
        setMeasuredDimension(this.p, this.q);
        f();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.a = bundle.getFloat("saveScale");
            this.i = bundle.getFloatArray("matrix");
            this.c.setValues(this.i);
            this.w = bundle.getFloat("matchViewHeight");
            this.v = bundle.getFloat("matchViewWidth");
            this.s = bundle.getInt("viewHeight");
            this.r = bundle.getInt("viewWidth");
            this.m = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.a);
        bundle.putFloat("matchViewHeight", this.u);
        bundle.putFloat("matchViewWidth", this.t);
        bundle.putInt("viewWidth", this.p);
        bundle.putInt("viewHeight", this.q);
        this.b.getValues(this.i);
        bundle.putFloatArray("matrix", this.i);
        bundle.putBoolean("imageRendered", this.m);
        return bundle;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        c();
        f();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        c();
        f();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        c();
        f();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        c();
        f();
    }

    public void setMaxZoom(float f) {
        this.f = f;
        this.h = 1.25f * this.f;
    }

    public void setMinZoom(float f) {
        this.e = f;
        this.g = 0.75f * this.e;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.z = onDoubleTapListener;
    }

    public void setOnTouchImageViewListener(OnTouchImageViewListener onTouchImageViewListener) {
        this.B = onTouchImageViewListener;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.A = onTouchListener;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType == ScaleType.FIT_START || scaleType == ScaleType.FIT_END) {
            throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
        } else if (scaleType == ScaleType.MATRIX) {
            super.setScaleType(ScaleType.MATRIX);
        } else {
            this.l = scaleType;
            if (this.n) {
                setZoom(this);
            }
        }
    }

    public void setZoom(float f) {
        a(f, 0.5f, 0.5f);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF scrollPosition = touchImageView.getScrollPosition();
        a(touchImageView.getCurrentZoom(), scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
    }
}
