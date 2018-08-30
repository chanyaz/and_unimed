package uk.co.senab.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import uk.co.senab.photoview.PhotoViewAttacher.OnMatrixChangedListener;
import uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener;
import uk.co.senab.photoview.PhotoViewAttacher.OnViewTapListener;

public class PhotoView extends ImageView implements IPhotoView {
    private final PhotoViewAttacher a;
    private ScaleType b;

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setScaleType(ScaleType.MATRIX);
        this.a = new PhotoViewAttacher(this);
        if (this.b != null) {
            setScaleType(this.b);
            this.b = null;
        }
    }

    public boolean canZoom() {
        return this.a.canZoom();
    }

    public Matrix getDisplayMatrix() {
        return this.a.d();
    }

    public RectF getDisplayRect() {
        return this.a.getDisplayRect();
    }

    @Deprecated
    public float getMaxScale() {
        return getMaximumScale();
    }

    public float getMaximumScale() {
        return this.a.getMaximumScale();
    }

    public float getMediumScale() {
        return this.a.getMediumScale();
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
        return this.a.getMinimumScale();
    }

    public float getScale() {
        return this.a.getScale();
    }

    public ScaleType getScaleType() {
        return this.a.getScaleType();
    }

    protected void onDetachedFromWindow() {
        this.a.a();
        super.onDetachedFromWindow();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.a.setAllowParentInterceptOnEdge(z);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.a.setDisplayMatrix(matrix);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.a != null) {
            this.a.c();
        }
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        if (this.a != null) {
            this.a.c();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.a != null) {
            this.a.c();
        }
    }

    @Deprecated
    public void setMaxScale(float f) {
        setMaximumScale(f);
    }

    public void setMaximumScale(float f) {
        this.a.setMaximumScale(f);
    }

    public void setMediumScale(float f) {
        this.a.setMediumScale(f);
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
        this.a.setMinimumScale(f);
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.a.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.a.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.a.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.a.setOnViewTapListener(onViewTapListener);
    }

    public void setPhotoViewRotation(float f) {
        this.a.setPhotoViewRotation(f);
    }

    public void setScale(float f) {
        this.a.setScale(f);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.a.setScale(f, f2, f3, z);
    }

    public void setScale(float f, boolean z) {
        this.a.setScale(f, z);
    }

    public void setScaleType(ScaleType scaleType) {
        if (this.a != null) {
            this.a.setScaleType(scaleType);
        } else {
            this.b = scaleType;
        }
    }

    public void setZoomable(boolean z) {
        this.a.setZoomable(z);
    }
}
