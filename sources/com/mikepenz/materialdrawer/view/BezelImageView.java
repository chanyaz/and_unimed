package com.mikepenz.materialdrawer.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.mikepenz.materialdrawer.l;
import com.mikepenz.materialdrawer.m;
import com.mikepenz.materialdrawer.util.DrawerImageLoader;
import com.mopub.common.Constants;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;

public class BezelImageView extends ImageView {
    private Paint a;
    private Paint b;
    private Rect c;
    private RectF d;
    private Drawable e;
    private boolean f;
    private ColorMatrixColorFilter g;
    private int h;
    private int i;
    private ColorFilter j;
    private boolean k;
    private Bitmap l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private ColorMatrixColorFilter q;
    private ColorFilter r;

    public BezelImageView(Context context) {
        this(context, null);
    }

    public BezelImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezelImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.h = 150;
        this.k = false;
        this.o = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.BezelImageView, i, l.BezelImageView);
        this.e = obtainStyledAttributes.getDrawable(m.BezelImageView_biv_maskDrawable);
        if (this.e != null) {
            this.e.setCallback(this);
        }
        this.f = obtainStyledAttributes.getBoolean(m.BezelImageView_biv_drawCircularShadow, true);
        this.i = obtainStyledAttributes.getColor(m.BezelImageView_biv_selectorOnPress, 0);
        obtainStyledAttributes.recycle();
        this.a = new Paint();
        this.a.setColor(CtaButton.BACKGROUND_COLOR);
        this.b = new Paint();
        this.b.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        this.l = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        this.g = new ColorMatrixColorFilter(colorMatrix);
        if (this.i != 0) {
            this.j = new PorterDuffColorFilter(Color.argb(this.h, Color.red(this.i), Color.green(this.i), Color.blue(this.i)), Mode.SRC_ATOP);
        }
    }

    public void a(boolean z) {
        if (z) {
            this.q = this.g;
            this.r = this.j;
            this.j = null;
            this.g = null;
            return;
        }
        if (this.q != null) {
            this.g = this.q;
        }
        if (this.r != null) {
            this.j = this.r;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (isClickable()) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.p = true;
                    break;
                case 1:
                case 3:
                case 4:
                case 8:
                    this.p = false;
                    break;
            }
            invalidate();
            return super.dispatchTouchEvent(motionEvent);
        }
        this.p = false;
        return super.onTouchEvent(motionEvent);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.e != null && this.e.isStateful()) {
            this.e.setState(getDrawableState());
        }
        if (isDuplicateParentStateEnabled()) {
            ViewCompat.d(this);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.e) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.c != null) {
            int width = this.c.width();
            int height = this.c.height();
            if (width != 0 && height != 0) {
                if (!(this.k && width == this.m && height == this.n && this.p == this.o)) {
                    if (width == this.m && height == this.n) {
                        this.l.eraseColor(0);
                    } else {
                        this.l.recycle();
                        this.l = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                        this.m = width;
                        this.n = height;
                    }
                    Canvas canvas2 = new Canvas(this.l);
                    if (this.e != null) {
                        int save = canvas2.save();
                        this.e.draw(canvas2);
                        if (!this.p) {
                            this.b.setColorFilter(null);
                        } else if (this.j != null) {
                            this.b.setColorFilter(this.j);
                        } else {
                            this.b.setColorFilter(this.g);
                        }
                        canvas2.saveLayer(this.d, this.b, 12);
                        super.onDraw(canvas2);
                        canvas2.restoreToCount(save);
                    } else if (this.p) {
                        int save2 = canvas2.save();
                        canvas2.drawRect(0.0f, 0.0f, (float) this.m, (float) this.n, this.a);
                        if (this.j != null) {
                            this.b.setColorFilter(this.j);
                        } else {
                            this.b.setColorFilter(this.g);
                        }
                        canvas2.saveLayer(this.d, this.b, 12);
                        super.onDraw(canvas2);
                        canvas2.restoreToCount(save2);
                    } else {
                        super.onDraw(canvas2);
                    }
                }
                canvas.drawBitmap(this.l, (float) this.c.left, (float) this.c.top, null);
                this.o = isPressed();
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (VERSION.SDK_INT >= 21 && this.f) {
            setOutlineProvider(new a(this, i, i2));
        }
    }

    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        this.c = new Rect(0, 0, i3 - i, i4 - i2);
        this.d = new RectF(this.c);
        if (this.e != null) {
            this.e.setBounds(this.c);
        }
        if (frame) {
            this.k = false;
        }
        return frame;
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    public void setImageURI(Uri uri) {
        if (Constants.HTTP.equals(uri.getScheme()) || Constants.HTTPS.equals(uri.getScheme())) {
            DrawerImageLoader.a().a(this, uri, null);
        } else {
            super.setImageURI(uri);
        }
    }

    public void setSelectorColor(int i) {
        this.i = i;
        this.j = new PorterDuffColorFilter(Color.argb(this.h, Color.red(this.i), Color.green(this.i), Color.blue(this.i)), Mode.SRC_ATOP);
        invalidate();
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.e || super.verifyDrawable(drawable);
    }
}
