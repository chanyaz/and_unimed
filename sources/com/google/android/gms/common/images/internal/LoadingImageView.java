package com.google.android.gms.common.images.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.a.e;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.util.p;

public final class LoadingImageView extends ImageView {
    private Uri a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private int g;
    private ClipPathProvider h;
    private OnImageLoadedListener i;
    private int j;
    private float k;

    public interface ClipPathProvider {
        Path getClipPath(int i, int i2);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        this.c = true;
        this.d = false;
        this.e = false;
        this.f = 0;
        this.g = 0;
        this.j = 0;
        this.k = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.LoadingImageView);
        this.j = obtainStyledAttributes.getInt(e.LoadingImageView_imageAspectRatioAdjust, 0);
        this.k = obtainStyledAttributes.getFloat(e.LoadingImageView_imageAspectRatio, 1.0f);
        setCircleCropEnabled(obtainStyledAttributes.getBoolean(e.LoadingImageView_circleCrop, false));
        obtainStyledAttributes.recycle();
    }

    public final int getLoadedNoDataPlaceholderResId() {
        return this.b;
    }

    public final Uri getLoadedUri() {
        return this.a;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.h != null) {
            canvas.clipPath(this.h.getClipPath(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.f != 0) {
            canvas.drawColor(this.f);
        }
    }

    protected final void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        super.onMeasure(i, i2);
        switch (this.j) {
            case 1:
                measuredHeight = getMeasuredHeight();
                i3 = (int) (((float) measuredHeight) * this.k);
                break;
            case 2:
                i3 = getMeasuredWidth();
                measuredHeight = (int) (((float) i3) / this.k);
                break;
            default:
                return;
        }
        setMeasuredDimension(i3, measuredHeight);
    }

    public final void setCircleCropEnabled(boolean z) {
        if (z) {
            this.g |= 1;
        } else {
            this.g &= -2;
        }
    }

    public final void setClipPathProvider(ClipPathProvider clipPathProvider) {
        this.h = clipPathProvider;
        if (!p.d()) {
            setLayerType(1, null);
        }
    }

    public final void setCrossFadeAlwaysEnabled(boolean z) {
        this.d = z;
    }

    public final void setCrossFadeEnabled(boolean z) {
        this.c = z;
    }

    public final void setLoadedNoDataPlaceholderResId(int i) {
        this.b = i;
    }

    public final void setLoadedUri(Uri uri) {
        this.a = uri;
    }

    public final void setOnImageLoadedListener(OnImageLoadedListener onImageLoadedListener) {
        this.i = onImageLoadedListener;
    }

    public final void setTintColor(int i) {
        this.f = i;
        if (this.f != 0) {
            setColorFilter(a.a);
        } else {
            setColorFilter(null);
        }
        invalidate();
    }

    public final void setTintColorId(int i) {
        int i2 = 0;
        if (i > 0) {
            Resources resources = getResources();
            if (resources != null) {
                i2 = resources.getColor(i);
            }
        }
        setTintColor(i2);
    }
}
