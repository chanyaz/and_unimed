package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.annotation.NonNull;
import android.support.transition.Transition.TransitionListener;
import android.view.View;
import android.view.ViewGroup;

class bh extends AnimatorListenerAdapter implements AnimatorPauseListenerCompat, TransitionListener {
    boolean a = false;
    private final View b;
    private final int c;
    private final ViewGroup d;
    private final boolean e;
    private boolean f;

    bh(View view, int i, boolean z) {
        this.b = view;
        this.c = i;
        this.d = (ViewGroup) view.getParent();
        this.e = z;
        a(true);
    }

    private void a() {
        if (!this.a) {
            bb.a(this.b, this.c);
            if (this.d != null) {
                this.d.invalidate();
            }
        }
        a(false);
    }

    private void a(boolean z) {
        if (this.e && this.f != z && this.d != null) {
            this.f = z;
            av.a(this.d, z);
        }
    }

    public void onAnimationCancel(Animator animator) {
        this.a = true;
    }

    public void onAnimationEnd(Animator animator) {
        a();
    }

    public void onAnimationPause(Animator animator) {
        if (!this.a) {
            bb.a(this.b, this.c);
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationResume(Animator animator) {
        if (!this.a) {
            bb.a(this.b, 0);
        }
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onTransitionCancel(@NonNull Transition transition) {
    }

    public void onTransitionEnd(@NonNull Transition transition) {
        a();
        transition.b((TransitionListener) this);
    }

    public void onTransitionPause(@NonNull Transition transition) {
        a(false);
    }

    public void onTransitionResume(@NonNull Transition transition) {
        a(true);
    }

    public void onTransitionStart(@NonNull Transition transition) {
    }
}
