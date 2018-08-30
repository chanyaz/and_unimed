package android.support.v7.widget.helper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.widget.ce;

class b implements AnimatorListener {
    private final ValueAnimator a;
    private float b;
    final float d;
    final float e;
    final float f;
    final float g;
    final ce h;
    final int i;
    final int j;
    public boolean k;
    float l;
    float m;
    boolean n = false;
    boolean o = false;

    b(ce ceVar, int i, int i2, float f, float f2, float f3, float f4) {
        this.i = i2;
        this.j = i;
        this.h = ceVar;
        this.d = f;
        this.e = f2;
        this.f = f3;
        this.g = f4;
        this.a = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.a.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.a(valueAnimator.getAnimatedFraction());
            }
        });
        this.a.setTarget(ceVar.itemView);
        this.a.addListener(this);
        a(0.0f);
    }

    public void a() {
        this.h.setIsRecyclable(false);
        this.a.start();
    }

    public void a(float f) {
        this.b = f;
    }

    public void a(long j) {
        this.a.setDuration(j);
    }

    public void b() {
        this.a.cancel();
    }

    public void c() {
        if (this.d == this.f) {
            this.l = this.h.itemView.getTranslationX();
        } else {
            this.l = this.d + (this.b * (this.f - this.d));
        }
        if (this.e == this.g) {
            this.m = this.h.itemView.getTranslationY();
        } else {
            this.m = this.e + (this.b * (this.g - this.e));
        }
    }

    public void onAnimationCancel(Animator animator) {
        a(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        if (!this.o) {
            this.h.setIsRecyclable(true);
        }
        this.o = true;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }
}
