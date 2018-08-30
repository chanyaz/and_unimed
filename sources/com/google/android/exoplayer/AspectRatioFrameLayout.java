package com.google.android.exoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout {
    private float a;

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a != 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f = (this.a / (((float) measuredWidth) / ((float) measuredHeight))) - 1.0f;
            if (Math.abs(f) > 0.01f) {
                if (f > 0.0f) {
                    measuredHeight = (int) (((float) measuredWidth) / this.a);
                } else {
                    measuredWidth = (int) (((float) measuredHeight) * this.a);
                }
                super.onMeasure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
    }

    public void setAspectRatio(float f) {
        if (this.a != f) {
            this.a = f;
            requestLayout();
        }
    }
}
