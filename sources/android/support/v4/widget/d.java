package android.support.v4.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class d extends ImageView {
    int a;
    private AnimationListener b;

    d(Context context, int i) {
        Drawable shapeDrawable;
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) (1.75f * f);
        int i3 = (int) (0.0f * f);
        this.a = (int) (3.5f * f);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.a((View) this, f * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new e(this, this.a));
            setLayerType(1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.a, (float) i3, (float) i2, 503316480);
            int i4 = this.a;
            setPadding(i4, i4, i4, i4);
        }
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.a((View) this, shapeDrawable);
    }

    private boolean a() {
        return VERSION.SDK_INT >= 21;
    }

    public void a(AnimationListener animationListener) {
        this.b = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.b != null) {
            this.b.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.b != null) {
            this.b.onAnimationStart(getAnimation());
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.a * 2), getMeasuredHeight() + (this.a * 2));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
