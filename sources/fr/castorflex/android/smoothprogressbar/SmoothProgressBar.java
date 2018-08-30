package fr.castorflex.android.smoothprogressbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import fr.castorflex.android.smoothprogressbar.SmoothProgressDrawable.Callbacks;

public class SmoothProgressBar extends ProgressBar {
    public SmoothProgressBar(Context context) {
        this(context, null);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.spbStyle);
    }

    public SmoothProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            setIndeterminateDrawable(new k(context).a());
            return;
        }
        Interpolator accelerateInterpolator;
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.SmoothProgressBar, i, 0);
        int color = obtainStyledAttributes.getColor(1, resources.getColor(e.spb_default_color));
        int integer = obtainStyledAttributes.getInteger(4, resources.getInteger(g.spb_default_sections_count));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(f.spb_default_stroke_separator_length));
        float dimension = obtainStyledAttributes.getDimension(2, resources.getDimension(f.spb_default_stroke_width));
        float f = obtainStyledAttributes.getFloat(5, Float.parseFloat(resources.getString(h.spb_default_speed)));
        float f2 = obtainStyledAttributes.getFloat(6, f);
        float f3 = obtainStyledAttributes.getFloat(7, f);
        int integer2 = obtainStyledAttributes.getInteger(8, -1);
        boolean z = obtainStyledAttributes.getBoolean(9, resources.getBoolean(d.spb_default_reversed));
        boolean z2 = obtainStyledAttributes.getBoolean(10, resources.getBoolean(d.spb_default_mirror_mode));
        int resourceId = obtainStyledAttributes.getResourceId(11, 0);
        boolean z3 = obtainStyledAttributes.getBoolean(12, resources.getBoolean(d.spb_default_progressiveStart_activated));
        Drawable drawable = obtainStyledAttributes.getDrawable(13);
        boolean z4 = obtainStyledAttributes.getBoolean(14, false);
        boolean z5 = obtainStyledAttributes.getBoolean(15, false);
        obtainStyledAttributes.recycle();
        Interpolator interpolator = null;
        if (integer2 == -1) {
            interpolator = getInterpolator();
        }
        if (interpolator == null) {
            Object accelerateInterpolator2;
            switch (integer2) {
                case 1:
                    accelerateInterpolator2 = new LinearInterpolator();
                    break;
                case 2:
                    accelerateInterpolator2 = new AccelerateDecelerateInterpolator();
                    break;
                case 3:
                    accelerateInterpolator2 = new DecelerateInterpolator();
                    break;
                default:
                    accelerateInterpolator2 = new AccelerateInterpolator();
                    break;
            }
        }
        accelerateInterpolator2 = interpolator;
        int[] iArr = null;
        if (resourceId != 0) {
            iArr = resources.getIntArray(resourceId);
        }
        k d = new k(context).b(f).c(f2).d(f3).a(accelerateInterpolator2).a(integer).b(dimensionPixelSize).a(dimension).a(z).b(z2).c(z3).d(z5);
        if (drawable != null) {
            d.a(drawable);
        }
        if (z4) {
            d.b();
        }
        if (iArr == null || iArr.length <= 0) {
            d.c(color);
        } else {
            d.a(iArr);
        }
        setIndeterminateDrawable(d.a());
    }

    private SmoothProgressDrawable a() {
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof SmoothProgressDrawable)) {
            return (SmoothProgressDrawable) indeterminateDrawable;
        }
        throw new RuntimeException("The drawable is not a SmoothProgressDrawable");
    }

    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isIndeterminate() && (getIndeterminateDrawable() instanceof SmoothProgressDrawable) && !((SmoothProgressDrawable) getIndeterminateDrawable()).isRunning()) {
            getIndeterminateDrawable().draw(canvas);
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        super.setInterpolator(interpolator);
        Drawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null && (indeterminateDrawable instanceof SmoothProgressDrawable)) {
            ((SmoothProgressDrawable) indeterminateDrawable).a(interpolator);
        }
    }

    public void setProgressiveStartActivated(boolean z) {
        a().c(z);
    }

    public void setSmoothProgressDrawableBackgroundDrawable(Drawable drawable) {
        a().a(drawable);
    }

    public void setSmoothProgressDrawableCallbacks(Callbacks callbacks) {
        a().a(callbacks);
    }

    public void setSmoothProgressDrawableColor(int i) {
        a().a(i);
    }

    public void setSmoothProgressDrawableColors(int[] iArr) {
        a().a(iArr);
    }

    public void setSmoothProgressDrawableInterpolator(Interpolator interpolator) {
        a().a(interpolator);
    }

    public void setSmoothProgressDrawableMirrorMode(boolean z) {
        a().b(z);
    }

    public void setSmoothProgressDrawableProgressiveStartSpeed(float f) {
        a().b(f);
    }

    public void setSmoothProgressDrawableProgressiveStopSpeed(float f) {
        a().c(f);
    }

    public void setSmoothProgressDrawableReversed(boolean z) {
        a().a(z);
    }

    public void setSmoothProgressDrawableSectionsCount(int i) {
        a().b(i);
    }

    public void setSmoothProgressDrawableSeparatorLength(int i) {
        a().c(i);
    }

    public void setSmoothProgressDrawableSpeed(float f) {
        a().a(f);
    }

    public void setSmoothProgressDrawableStrokeWidth(float f) {
        a().d(f);
    }

    public void setSmoothProgressDrawableUseGradients(boolean z) {
        a().d(z);
    }
}
