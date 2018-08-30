package android.support.v7.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class as implements AnimatorUpdateListener {
    final /* synthetic */ FastScroller a;

    private as(FastScroller fastScroller) {
        this.a = fastScroller;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        this.a.k.setAlpha(floatValue);
        this.a.l.setAlpha(floatValue);
        this.a.d();
    }
}
