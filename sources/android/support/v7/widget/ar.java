package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ar extends AnimatorListenerAdapter {
    final /* synthetic */ FastScroller a;
    private boolean b;

    private ar(FastScroller fastScroller) {
        this.a = fastScroller;
        this.b = false;
    }

    public void onAnimationCancel(Animator animator) {
        this.b = true;
    }

    public void onAnimationEnd(Animator animator) {
        if (this.b) {
            this.b = false;
        } else if (((Float) this.a.B.getAnimatedValue()).floatValue() == 0.0f) {
            this.a.C = 0;
            this.a.b(0);
        } else {
            this.a.C = 2;
            this.a.d();
        }
    }
}
