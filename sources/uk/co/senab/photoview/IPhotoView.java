package uk.co.senab.photoview;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View.OnLongClickListener;
import android.widget.ImageView.ScaleType;
import uk.co.senab.photoview.PhotoViewAttacher.OnMatrixChangedListener;
import uk.co.senab.photoview.PhotoViewAttacher.OnPhotoTapListener;
import uk.co.senab.photoview.PhotoViewAttacher.OnViewTapListener;

public interface IPhotoView {
    boolean canZoom();

    Matrix getDisplayMatrix();

    RectF getDisplayRect();

    @Deprecated
    float getMaxScale();

    float getMaximumScale();

    float getMediumScale();

    @Deprecated
    float getMidScale();

    @Deprecated
    float getMinScale();

    float getMinimumScale();

    float getScale();

    ScaleType getScaleType();

    void setAllowParentInterceptOnEdge(boolean z);

    boolean setDisplayMatrix(Matrix matrix);

    @Deprecated
    void setMaxScale(float f);

    void setMaximumScale(float f);

    void setMediumScale(float f);

    @Deprecated
    void setMidScale(float f);

    @Deprecated
    void setMinScale(float f);

    void setMinimumScale(float f);

    void setOnLongClickListener(OnLongClickListener onLongClickListener);

    void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener);

    void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener);

    void setOnViewTapListener(OnViewTapListener onViewTapListener);

    void setPhotoViewRotation(float f);

    void setScale(float f);

    void setScale(float f, float f2, float f3, boolean z);

    void setScale(float f, boolean z);

    void setScaleType(ScaleType scaleType);

    void setZoomable(boolean z);
}
