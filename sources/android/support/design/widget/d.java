package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.l;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

@RestrictTo({Scope.LIBRARY_GROUP})
class d extends FrameLayout {
    private OnLayoutChangeListener a;
    private OnAttachStateChangeListener b;

    d(Context context) {
        this(context, null);
    }

    d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.SnackbarLayout);
        if (obtainStyledAttributes.hasValue(l.SnackbarLayout_elevation)) {
            ViewCompat.a((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(l.SnackbarLayout_elevation, 0));
        }
        obtainStyledAttributes.recycle();
        setClickable(true);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.b != null) {
            this.b.onViewAttachedToWindow(this);
        }
        ViewCompat.q(this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.onViewDetachedFromWindow(this);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a != null) {
            this.a.onLayoutChange(this, i, i2, i3, i4);
        }
    }

    void setOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.b = onAttachStateChangeListener;
    }

    void setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
        this.a = onLayoutChangeListener;
    }
}
