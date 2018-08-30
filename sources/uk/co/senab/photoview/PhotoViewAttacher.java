package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.FloatMath;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import java.lang.ref.WeakReference;
import uk.co.senab.photoview.gestures.OnGestureListener;
import uk.co.senab.photoview.gestures.d;
import uk.co.senab.photoview.log.a;

public class PhotoViewAttacher implements OnDoubleTapListener, OnTouchListener, OnGlobalLayoutListener, IPhotoView, OnGestureListener {
    static final Interpolator a = new AccelerateDecelerateInterpolator();
    private static final boolean b = Log.isLoggable("PhotoViewAttacher", 3);
    private float A = 0.0f;
    private float c = 1.0f;
    private float d = 1.75f;
    private float e = 3.0f;
    private boolean f = true;
    private WeakReference<ImageView> g;
    private GestureDetector h;
    private uk.co.senab.photoview.gestures.GestureDetector i;
    private final Matrix j = new Matrix();
    private final Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final RectF m = new RectF();
    private final float[] n = new float[9];
    private OnMatrixChangedListener o;
    private OnPhotoTapListener p;
    private OnViewTapListener q;
    private OnLongClickListener r;
    private int s;
    private int t;
    private int u;
    private int v;
    private c w;
    private int x = 2;
    private boolean y;
    private ScaleType z = ScaleType.FIT_CENTER;

    /* renamed from: uk.co.senab.photoview.PhotoViewAttacher$2 */
    /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] a = new int[ScaleType.values().length];

        static {
            try {
                a[ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[ScaleType.FIT_END.ordinal()] = 3;
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

    public interface OnMatrixChangedListener {
        void onMatrixChanged(RectF rectF);
    }

    public interface OnPhotoTapListener {
        void onPhotoTap(View view, float f, float f2);
    }

    public interface OnViewTapListener {
        void onViewTap(View view, float f, float f2);
    }

    public PhotoViewAttacher(ImageView imageView) {
        this.g = new WeakReference(imageView);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        b(imageView);
        if (!imageView.isInEditMode()) {
            this.i = d.a(imageView.getContext(), this);
            this.h = new GestureDetector(imageView.getContext(), new SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    if (PhotoViewAttacher.this.r != null) {
                        PhotoViewAttacher.this.r.onLongClick(PhotoViewAttacher.this.b());
                    }
                }
            });
            this.h.setOnDoubleTapListener(this);
            setZoomable(true);
        }
    }

    private float a(Matrix matrix, int i) {
        matrix.getValues(this.n);
        return this.n[i];
    }

    private RectF a(Matrix matrix) {
        ImageView b = b();
        if (b != null) {
            Drawable drawable = b.getDrawable();
            if (drawable != null) {
                this.m.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
                matrix.mapRect(this.m);
                return this.m;
            }
        }
        return null;
    }

    private static void a(float f, float f2, float f3) {
        if (f >= f2) {
            throw new IllegalArgumentException("MinZoom has to be less than MidZoom");
        } else if (f2 >= f3) {
            throw new IllegalArgumentException("MidZoom has to be less than MaxZoom");
        }
    }

    private void a(Drawable drawable) {
        ImageView b = b();
        if (b != null && drawable != null) {
            float c = (float) c(b);
            float d = (float) d(b);
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            this.j.reset();
            float f = c / ((float) intrinsicWidth);
            float f2 = d / ((float) intrinsicHeight);
            if (this.z != ScaleType.CENTER) {
                if (this.z != ScaleType.CENTER_CROP) {
                    if (this.z != ScaleType.CENTER_INSIDE) {
                        RectF rectF = new RectF(0.0f, 0.0f, (float) intrinsicWidth, (float) intrinsicHeight);
                        RectF rectF2 = new RectF(0.0f, 0.0f, c, d);
                        switch (AnonymousClass2.a[this.z.ordinal()]) {
                            case 2:
                                this.j.setRectToRect(rectF, rectF2, ScaleToFit.START);
                                break;
                            case 3:
                                this.j.setRectToRect(rectF, rectF2, ScaleToFit.END);
                                break;
                            case 4:
                                this.j.setRectToRect(rectF, rectF2, ScaleToFit.CENTER);
                                break;
                            case 5:
                                this.j.setRectToRect(rectF, rectF2, ScaleToFit.FILL);
                                break;
                        }
                    }
                    f = Math.min(1.0f, Math.min(f, f2));
                    this.j.postScale(f, f);
                    this.j.postTranslate((c - (((float) intrinsicWidth) * f)) / 2.0f, (d - (((float) intrinsicHeight) * f)) / 2.0f);
                } else {
                    f = Math.max(f, f2);
                    this.j.postScale(f, f);
                    this.j.postTranslate((c - (((float) intrinsicWidth) * f)) / 2.0f, (d - (((float) intrinsicHeight) * f)) / 2.0f);
                }
            } else {
                this.j.postTranslate((c - ((float) intrinsicWidth)) / 2.0f, (d - ((float) intrinsicHeight)) / 2.0f);
            }
            j();
        }
    }

    private static boolean a(ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        switch (AnonymousClass2.a[scaleType.ordinal()]) {
            case 1:
                throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
            default:
                return true;
        }
    }

    private static boolean a(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private void b(Matrix matrix) {
        ImageView b = b();
        if (b != null) {
            h();
            b.setImageMatrix(matrix);
            if (this.o != null) {
                RectF a = a(matrix);
                if (a != null) {
                    this.o.onMatrixChanged(a);
                }
            }
        }
    }

    private static void b(ImageView imageView) {
        if (imageView != null && !(imageView instanceof PhotoView) && !ScaleType.MATRIX.equals(imageView.getScaleType())) {
            imageView.setScaleType(ScaleType.MATRIX);
        }
    }

    private int c(ImageView imageView) {
        return imageView == null ? 0 : (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private int d(ImageView imageView) {
        return imageView == null ? 0 : (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private void f() {
        if (this.w != null) {
            this.w.a();
            this.w = null;
        }
    }

    private void g() {
        if (i()) {
            b(d());
        }
    }

    private void h() {
        ImageView b = b();
        if (b != null && !(b instanceof PhotoView) && !ScaleType.MATRIX.equals(b.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher");
        }
    }

    private boolean i() {
        float f = 0.0f;
        ImageView b = b();
        if (b == null) {
            return false;
        }
        RectF a = a(d());
        if (a == null) {
            return false;
        }
        float height = a.height();
        float width = a.width();
        int d = d(b);
        if (height <= ((float) d)) {
            switch (AnonymousClass2.a[this.z.ordinal()]) {
                case 2:
                    height = -a.top;
                    break;
                case 3:
                    height = (((float) d) - height) - a.top;
                    break;
                default:
                    height = ((((float) d) - height) / 2.0f) - a.top;
                    break;
            }
        }
        height = a.top > 0.0f ? -a.top : a.bottom < ((float) d) ? ((float) d) - a.bottom : 0.0f;
        int c = c(b);
        if (width <= ((float) c)) {
            switch (AnonymousClass2.a[this.z.ordinal()]) {
                case 2:
                    f = -a.left;
                    break;
                case 3:
                    f = (((float) c) - width) - a.left;
                    break;
                default:
                    f = ((((float) c) - width) / 2.0f) - a.left;
                    break;
            }
            this.x = 2;
        } else if (a.left > 0.0f) {
            this.x = 0;
            f = -a.left;
        } else if (a.right < ((float) c)) {
            f = ((float) c) - a.right;
            this.x = 1;
        } else {
            this.x = -1;
        }
        this.l.postTranslate(f, height);
        return true;
    }

    private void j() {
        this.l.reset();
        b(d());
        i();
    }

    public final void a() {
        if (this.g != null) {
            ImageView imageView = (ImageView) this.g.get();
            if (imageView != null) {
                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                imageView.setOnTouchListener(null);
                f();
            }
            if (this.h != null) {
                this.h.setOnDoubleTapListener(null);
            }
            this.o = null;
            this.p = null;
            this.q = null;
            this.g = null;
        }
    }

    public final ImageView b() {
        ImageView imageView = null;
        if (this.g != null) {
            imageView = (ImageView) this.g.get();
        }
        if (imageView == null) {
            a();
            Log.i("PhotoViewAttacher", "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    public final void c() {
        ImageView b = b();
        if (b == null) {
            return;
        }
        if (this.y) {
            b(b);
            a(b.getDrawable());
            return;
        }
        j();
    }

    public final boolean canZoom() {
        return this.y;
    }

    protected Matrix d() {
        this.k.set(this.j);
        this.k.postConcat(this.l);
        return this.k;
    }

    public Matrix getDisplayMatrix() {
        return new Matrix(this.l);
    }

    public final RectF getDisplayRect() {
        i();
        return a(d());
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.e;
    }

    public float getMediumScale() {
        return this.d;
    }

    @Deprecated
    public float getMidScale() {
        return getMediumScale();
    }

    @Deprecated
    public float getMinScale() {
        return getMinimumScale();
    }

    public float getMinimumScale() {
        return this.c;
    }

    public final float getScale() {
        return FloatMath.sqrt(((float) Math.pow((double) a(this.l, 0), 2.0d)) + ((float) Math.pow((double) a(this.l, 3), 2.0d)));
    }

    public final ScaleType getScaleType() {
        return this.z;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        try {
            float scale = getScale();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (scale < this.d) {
                setScale(this.d, x, y, true);
            } else if (scale < this.d || scale >= this.e) {
                setScale(this.c, x, y, true);
            } else {
                setScale(this.e, x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return true;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public final void onDrag(float f, float f2) {
        if (b) {
            a.a().d("PhotoViewAttacher", String.format("onDrag: dx: %.2f. dy: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2)}));
        }
        ImageView b = b();
        this.l.postTranslate(f, f2);
        g();
        if (this.f && !this.i.isScaling()) {
            if (this.x == 2 || ((this.x == 0 && f >= 1.0f) || (this.x == 1 && f <= -1.0f))) {
                ViewParent parent = b.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
        }
    }

    public final void onFling(float f, float f2, float f3, float f4) {
        if (b) {
            a.a().d("PhotoViewAttacher", "onFling. sX: " + f + " sY: " + f2 + " Vx: " + f3 + " Vy: " + f4);
        }
        ImageView b = b();
        this.w = new c(this, b.getContext());
        this.w.a(c(b), d(b), (int) f3, (int) f4);
        b.post(this.w);
    }

    public final void onGlobalLayout() {
        ImageView b = b();
        if (b != null && this.y) {
            int top = b.getTop();
            int right = b.getRight();
            int bottom = b.getBottom();
            int left = b.getLeft();
            if (top != this.s || bottom != this.u || left != this.v || right != this.t) {
                a(b.getDrawable());
                this.s = top;
                this.t = right;
                this.u = bottom;
                this.v = left;
            }
        }
    }

    public final void onScale(float f, float f2, float f3) {
        if (b) {
            a.a().d("PhotoViewAttacher", String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
        }
        if (getScale() < this.e || f < 1.0f) {
            this.l.postScale(f, f, f2, f3);
            g();
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        View b = b();
        if (this.p != null) {
            RectF displayRect = getDisplayRect();
            if (displayRect != null) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (displayRect.contains(x, y)) {
                    this.p.onPhotoTap(b, (x - displayRect.left) / displayRect.width(), (y - displayRect.top) / displayRect.height());
                    return true;
                }
            }
        }
        if (this.q != null) {
            this.q.onViewTap(b, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }

    public final boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
        r9 = this;
        r6 = 0;
        r7 = 1;
        r0 = r9.y;
        if (r0 == 0) goto L_0x003c;
    L_0x0006:
        r0 = r10;
        r0 = (android.widget.ImageView) r0;
        r0 = a(r0);
        if (r0 == 0) goto L_0x003c;
    L_0x000f:
        r8 = r10.getParent();
        r0 = r11.getAction();
        switch(r0) {
            case 0: goto L_0x003d;
            case 1: goto L_0x004f;
            case 2: goto L_0x001a;
            case 3: goto L_0x004f;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = r6;
    L_0x001b:
        r1 = r9.h;
        if (r1 == 0) goto L_0x0028;
    L_0x001f:
        r1 = r9.h;
        r1 = r1.onTouchEvent(r11);
        if (r1 == 0) goto L_0x0028;
    L_0x0027:
        r0 = r7;
    L_0x0028:
        if (r0 != 0) goto L_0x002f;
    L_0x002a:
        if (r8 == 0) goto L_0x002f;
    L_0x002c:
        r8.requestDisallowInterceptTouchEvent(r6);
    L_0x002f:
        r1 = r9.i;
        if (r1 == 0) goto L_0x0078;
    L_0x0033:
        r1 = r9.i;
        r1 = r1.onTouchEvent(r11);
        if (r1 == 0) goto L_0x0078;
    L_0x003b:
        r6 = r7;
    L_0x003c:
        return r6;
    L_0x003d:
        if (r8 == 0) goto L_0x0047;
    L_0x003f:
        r8.requestDisallowInterceptTouchEvent(r7);
    L_0x0042:
        r9.f();
        r0 = r6;
        goto L_0x001b;
    L_0x0047:
        r0 = "PhotoViewAttacher";
        r1 = "onTouch getParent() returned null";
        android.util.Log.i(r0, r1);
        goto L_0x0042;
    L_0x004f:
        r0 = r9.getScale();
        r1 = r9.c;
        r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
        if (r0 >= 0) goto L_0x001a;
    L_0x0059:
        r1 = r9.getDisplayRect();
        if (r1 == 0) goto L_0x001a;
    L_0x005f:
        r0 = new uk.co.senab.photoview.b;
        r2 = r9.getScale();
        r3 = r9.c;
        r4 = r1.centerX();
        r5 = r1.centerY();
        r1 = r9;
        r0.<init>(r1, r2, r3, r4, r5);
        r10.post(r0);
        r0 = r7;
        goto L_0x001b;
    L_0x0078:
        r6 = r0;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: uk.co.senab.photoview.PhotoViewAttacher.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f = z;
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        ImageView b = b();
        if (b == null || b.getDrawable() == null) {
            return false;
        }
        this.l.set(matrix);
        b(d());
        i();
        return true;
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        a(this.c, this.d, f);
        this.e = f;
    }

    public void setMediumScale(float f) {
        a(this.c, f, this.e);
        this.d = f;
    }

    @Deprecated
    public void setMidScale(float f) {
        setMediumScale(f);
    }

    @Deprecated
    public void setMinScale(float f) {
        setMinimumScale(f);
    }

    public void setMinimumScale(float f) {
        a(f, this.d, this.e);
        this.c = f;
    }

    public final void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public final void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.o = onMatrixChangedListener;
    }

    public final void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.p = onPhotoTapListener;
    }

    public final void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.q = onViewTapListener;
    }

    public void setPhotoViewRotation(float f) {
        float f2 = f % 360.0f;
        this.l.postRotate(this.A - f2);
        this.A = f2;
        g();
    }

    public void setScale(float f) {
        setScale(f, false);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        ImageView b = b();
        if (b == null) {
            return;
        }
        if (f < this.c || f > this.e) {
            a.a().i("PhotoViewAttacher", "Scale must be within the range of minScale and maxScale");
        } else if (z) {
            b.post(new b(this, getScale(), f, f2, f3));
        } else {
            this.l.setScale(f, f, f2, f3);
            g();
        }
    }

    public void setScale(float f, boolean z) {
        ImageView b = b();
        if (b != null) {
            setScale(f, (float) (b.getRight() / 2), (float) (b.getBottom() / 2), z);
        }
    }

    public final void setScaleType(ScaleType scaleType) {
        if (a(scaleType) && scaleType != this.z) {
            this.z = scaleType;
            c();
        }
    }

    public final void setZoomable(boolean z) {
        this.y = z;
        c();
    }
}
