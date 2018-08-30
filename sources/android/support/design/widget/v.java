package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.FloatingActionButtonImpl.AnonymousClass1;

abstract class v extends AnimatorListenerAdapter implements AnimatorUpdateListener {
    private boolean a;
    final /* synthetic */ FloatingActionButtonImpl b;
    private float c;
    private float d;

    private v(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.b = floatingActionButtonImpl;
    }

    /* synthetic */ v(FloatingActionButtonImpl floatingActionButtonImpl, AnonymousClass1 anonymousClass1) {
        this(floatingActionButtonImpl);
    }

    protected abstract float a();

    public void onAnimationEnd(Animator animator) {
        this.b.c.b(this.d);
        this.a = false;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.a) {
            this.c = this.b.c.a();
            this.d = a();
            this.a = true;
        }
        this.b.c.b(this.c + ((this.d - this.c) * valueAnimator.getAnimatedFraction()));
    }
}
